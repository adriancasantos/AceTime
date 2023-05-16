package com.adriancasantos.acetime.feature.perfil.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.adriancasantos.acetime.MainActivity;
import com.adriancasantos.acetime.R;
import com.adriancasantos.acetime.data.model.Usuario;
import com.adriancasantos.acetime.feature.perfil.viewmodel.PerfilViewModel;


public class FragmentPerfil extends Fragment implements PerfilView {

    PerfilViewModel viewModel;
    ImageButton imageButtonUsuario, imageButtonNombre, imageButtonApellidos, imageButtonEmail;
    EditText editTextUsuario, editTextNombre, editTextApellidos, editTextEmail;
    Button buttonGuardar, buttonEliminar, buttonLogout;

    public FragmentPerfil(Integer userID) {
        // Required empty public constructor
        viewModel = new PerfilViewModel(userID, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editTextUsuario = view.findViewById(R.id.editTextUsuario);
        editTextNombre = view.findViewById(R.id.editTextNombre);
        editTextApellidos = view.findViewById(R.id.editTextApellidos);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        imageButtonUsuario = view.findViewById(R.id.imageButtonUsuario);
        imageButtonNombre = view.findViewById(R.id.imageButtonNombre);
        imageButtonApellidos = view.findViewById(R.id.imageButtonApellidos);
        imageButtonEmail = view.findViewById(R.id.imageButtonEmail);
        buttonGuardar = view.findViewById(R.id.buttonGuardar);
        buttonLogout = view.findViewById(R.id.buttonCerrarSesion);
        buttonEliminar = view.findViewById(R.id.buttonEliminarCuenta);

        viewModel.onViewCreated(requireContext());
        viewModel.getUsuarioInfo();


        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonSeleccionado(v);
            }
        };

        imageButtonUsuario.setOnClickListener(clickListener);
        imageButtonNombre.setOnClickListener(clickListener);
        imageButtonApellidos.setOnClickListener(clickListener);
        imageButtonEmail.setOnClickListener(clickListener);


        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.editarUsuario(editTextUsuario, editTextNombre, editTextApellidos, editTextEmail, view);
        }
        });

        buttonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.eliminarUsuario(view);
            }
        });

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogout();
            }
        });

    }

    @Override
    public void mostrarUsuario(Usuario usuario) {

        editTextUsuario.setText(usuario.getUsername());
        editTextUsuario.setEnabled(false);
        editTextNombre.setText(usuario.getNombre());
        editTextNombre.setEnabled(false);
        editTextApellidos.setText(usuario.getApellido());
        editTextApellidos.setEnabled(false);
        editTextEmail.setText(usuario.getEmail());
        editTextEmail.setEnabled(false);

    }

    @Override
    public void onLogout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Logout");
        builder.setMessage("¿Estás seguro de que quieres cerrar sesión?");
        builder.setPositiveButton("Sí", (dialog, which) -> {
            // Eliminar las preferencias compartidas al cerrar sesión
            SharedPreferences preferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.apply();

            Intent intent = new Intent(requireContext(), MainActivity.class);
            startActivity(intent);
            requireActivity().finish();
        });
        builder.setNegativeButton("No", (dialog, which) -> {
            dialog.dismiss();
        });
        Dialog dialog = builder.create();

        dialog.show();

    }


    public void imageButtonSeleccionado (View view) {
        switch (view.getId()) {
            case R.id.imageButtonUsuario:
                editTextUsuario.setEnabled(true);
                break;
            case R.id.imageButtonNombre:
                editTextNombre.setEnabled(true);
                break;
            case R.id.imageButtonApellidos:
                editTextApellidos.setEnabled(true);
                break;
            case R.id.imageButtonEmail:
                editTextEmail.setEnabled(true);
                break;
        }
    }
}