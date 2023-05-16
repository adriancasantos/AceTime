package com.adriancasantos.acetime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.adriancasantos.acetime.controller.ControladorLogin;
import com.adriancasantos.acetime.data.datasource.database.AdminSQLiteOpenHelper;
import com.adriancasantos.acetime.data.model.Usuario;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    EditText username, password, reg_username, reg_password,
            reg_firstName, reg_lastName, reg_email, reg_confirmemail, reg_image;
    Button login, signUp, reg_register;
    TextInputLayout txtInLayoutUsername, txtInLayoutPassword, txtInLayoutRegPassword;
    CheckBox rememberMe;
    ControladorLogin controladorLogin;
    AdminSQLiteOpenHelper admin;
    private boolean rememberMeChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        admin = new AdminSQLiteOpenHelper(this);
        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        login = findViewById(R.id.btnLogin);
        signUp = findViewById(R.id.btnRegistro);
        txtInLayoutUsername = findViewById(R.id.txtInLayoutUsername);
        txtInLayoutPassword = findViewById(R.id.txtInLayoutPassword);
        rememberMe = findViewById(R.id.cbRecuerdame);

        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        rememberMeChecked = preferences.getBoolean("rememberMeChecked", false);
        rememberMe.setChecked(rememberMeChecked);

        if (rememberMeChecked) {
            String savedUsername = preferences.getString("username", "");
            String savedPassword = preferences.getString("password", "");

            if (!savedUsername.isEmpty() && !savedPassword.isEmpty()) {
                // Intenta iniciar sesión automáticamente con las credenciales guardadas
                if (admin.login(savedUsername, savedPassword) == 1) {
                    Usuario usuarioLogueado = admin.getUsuario(savedUsername, savedPassword);
                    Intent intent = NavigationActivity.getNavigationActivityIntent(MainActivity.this, usuarioLogueado.getId());
                    startActivity(intent);
                    finish();
                }
            }
        }


        rememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rememberMeChecked = isChecked;
            }
        });

        ClickLogin();

        // Botón SignUp para mostrar la página de registro
        signUp.setOnClickListener(view -> ClickRegistro());
    }

    // Método para iniciar sesión
    private void ClickLogin() {
        login.setOnClickListener(view -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();

            if (username.getText().toString().trim().isEmpty() || password.getText().toString().trim().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Por favor, rellene todos los campos", Toast.LENGTH_SHORT).show();
            } else if (admin.login(user, pass) == 1) {
                Usuario usuarioLogueado = admin.getUsuario(user, pass);
                Intent intent = NavigationActivity.getNavigationActivityIntent(MainActivity.this, usuarioLogueado.getId());
                if (rememberMeChecked) {
                    // Guardar las credenciales del usuario en SharedPreferences
                    SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username", user);
                    editor.putString("password", pass);
                    editor.putBoolean("rememberMeChecked", true);
                    editor.apply();
                }
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("el resultcode es:" + resultCode);
        System.out.println("el requestcode es:" + requestCode);
        if (requestCode == 10) {
            System.out.println("la data es " + data.getData().toString());
        }
    }

    // Método para abrir la página de registro
    private void ClickRegistro() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.register, null);
        dialog.setView(dialogView);

        reg_username = dialogView.findViewById(R.id.reg_username);
        reg_password = dialogView.findViewById(R.id.reg_password);
        reg_firstName = dialogView.findViewById(R.id.reg_nombre);
        reg_lastName = dialogView.findViewById(R.id.reg_apellidos);
        reg_email = dialogView.findViewById(R.id.reg_email);
        reg_confirmemail = dialogView.findViewById(R.id.reg_confirmemail);
        reg_image = dialogView.findViewById(R.id.reg_image);
        reg_register = dialogView.findViewById(R.id.reg_register);
        txtInLayoutRegPassword = dialogView.findViewById(R.id.txtInLayoutRegPassword);

        //Elegir imagen de perfil
        reg_image.setOnClickListener(view -> {
            controladorLogin = new ControladorLogin();
            controladorLogin.selectImage(MainActivity.this);
            reg_image.setText(controladorLogin.rutaImagenPerfil);
            System.out.println(controladorLogin.rutaImagenPerfil);
        });

        reg_register.setOnClickListener(view -> {
            Usuario usuario = new Usuario();
            usuario.setUsername(reg_username.getText().toString().trim());
            usuario.setPassword(reg_password.getText().toString().trim());
            usuario.setNombre(reg_firstName.getText().toString().trim());
            usuario.setApellido(reg_lastName.getText().toString().trim());
            usuario.setEmail(reg_email.getText().toString().trim());

            if (reg_username.getText().toString().trim().isEmpty() || reg_password.getText().toString().trim().isEmpty()
                    || reg_firstName.getText().toString().trim().isEmpty() || reg_lastName.getText().toString().trim().isEmpty()
                    || reg_email.getText().toString().trim().isEmpty() || reg_confirmemail.getText().toString().trim().isEmpty()) {
                Snackbar snackbar = Snackbar.make(view, "Por favor, rellene estos campos", Snackbar.LENGTH_LONG);
                View snackbarView = snackbar.getView();
                snackbarView.setBackgroundColor(getResources().getColor(R.color.red));
                snackbar.show();
            } else if (!validarMail(reg_email.getText().toString().trim())) {
                Snackbar snackbar = Snackbar.make(view, "El correo electrónico no es válido", Snackbar.LENGTH_LONG);
                View snackbarView = snackbar.getView();
                snackbarView.setBackgroundColor(getResources().getColor(R.color.red));
                snackbar.show();
            } else if (!reg_email.getText().toString().trim().equals(reg_confirmemail.getText().toString().trim())) {
                Snackbar snackbar = Snackbar.make(view, "Los correos electrónicos no coinciden", Snackbar.LENGTH_LONG);
                View snackbarView = snackbar.getView();
                snackbarView.setBackgroundColor(getResources().getColor(R.color.red));
                snackbar.show();
            } else if (!validarPassword(reg_password.getText().toString().trim())) {
                Snackbar snackbar = Snackbar.make(view, "La contraseña no es válida", Snackbar.LENGTH_LONG);
                View snackbarView = snackbar.getView();
                snackbarView.setBackgroundColor(getResources().getColor(R.color.red));
                snackbar.show();
            } else if (admin.insertarUsuario(usuario)) {
                Snackbar snackbar = Snackbar.make(view, "Usuario registrado correctamente", Snackbar.LENGTH_LONG);
                View snackbarView = snackbar.getView();
                snackbarView.setBackgroundColor(getResources().getColor(R.color.yellow));
                snackbar.show();
                dialogView.setVisibility(View.GONE);
            } else {
                Snackbar snackbar = Snackbar.make(view, "El usuario ya existe", Snackbar.LENGTH_LONG);
                View snackbarView = snackbar.getView();
                snackbarView.setBackgroundColor(getResources().getColor(R.color.red));
                snackbar.show();
            }
        });

        dialog.show();
    }

    private boolean validarMail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }

    private boolean validarPassword(String password) {
        if (password.isEmpty()) {
            txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(false);
            reg_password.setError("Por favor complete este campo");
            return false;
        } else if (password.length() < 8) {
            txtInLayoutRegPassword.setEndIconMode(TextInputLayout.END_ICON_PASSWORD_TOGGLE);
            reg_password.setError("La contraseña debe tener al menos 8 caracteres");
            return false;
        } else if (!password.matches(".*\\d.*")) {
            txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(false);
            reg_password.setError("La contraseña debe contener al menos un número");
            return false;
        } else if (!password.matches(".*[A-Z].*")) {
            txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(false);
            reg_password.setError("La contraseña debe contener al menos una letra mayúscula");
            return false;
        } else if (!password.matches(".*[a-z].*")) {
            txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(false);
            reg_password.setError("La contraseña debe contener al menos una letra minúscula");
            return false;
        } else {
            txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(true);
            reg_password.setError(null);
            return true;
        }
    }
}

