package com.adriancasantos.acetime.feature.perfil.viewmodel;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import androidx.lifecycle.ViewModel;

import com.adriancasantos.acetime.MainActivity;
import com.adriancasantos.acetime.data.datasource.database.AdminSQLiteOpenHelper;
import com.adriancasantos.acetime.data.datasource.database.AdminSQLiteOpenInterface;
import com.adriancasantos.acetime.data.model.Usuario;
import com.adriancasantos.acetime.feature.perfil.ui.PerfilView;

public class PerfilViewModel extends ViewModel {

    Usuario usuario;
    Integer userID;
    PerfilView view;
    AdminSQLiteOpenInterface admin;

    public PerfilViewModel(Integer userID, PerfilView view) {
        this.userID = userID;
        this.view = view;
    }
    public void onViewCreated(Context context) {
        this.admin = new AdminSQLiteOpenHelper(context);
    }

    public void getUsuarioInfo() {
       usuario = admin.getUsuarioById(userID);
       view.mostrarUsuario(usuario);
    }

    public void eliminarUsuario(View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setTitle("Confirmar");
        builder.setMessage("¿Estás seguro de que quieres eliminar tu cuenta?");
        builder.setPositiveButton("Sí", (dialog, which) -> {

            usuario = admin.getUsuarioById(userID);
            admin.eliminarUsuario(usuario.getId());
            Intent intent = new Intent(v.getContext(), MainActivity.class);
            v.getContext().startActivity(intent);

            dialog.dismiss();
        });

        builder.setNegativeButton("No", (dialog, which) -> {
            dialog.dismiss();
        });

        AlertDialog alert = builder.create();

        alert.show();



    }

    public void editarUsuario(EditText editTextUsuario, EditText editTextNombre, EditText editTextApellidos, EditText editTextEmail, View v) {


        usuario = new Usuario(
                userID,
                editTextUsuario.getText().toString(),
                usuario.getPassword(),
                editTextNombre.getText().toString(),
                editTextApellidos.getText().toString(),
                editTextEmail.getText().toString()
        );

        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setTitle("Confirmar");
        builder.setMessage("¿Estás seguro de que quieres guardar los cambios?");
        builder.setPositiveButton("Sí", (dialog, which) -> {

            admin.editarUsuario(usuario);
            view.mostrarUsuario(usuario);

            dialog.dismiss();
        });

        builder.setNegativeButton("No", (dialog, which) -> {
            dialog.dismiss();
        });

        AlertDialog alert = builder.create();

        alert.show();






    }


}
