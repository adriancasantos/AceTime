package com.adriancasantos.acetime.controller;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.FileProvider;
import java.io.File;

public class ControladorLogin {

    public String rutaImagenPerfil = "";

    public void selectImage(Activity activity) {

        // Opciones que se mostrarán en el diálogo

        final CharSequence[] options = {"Tomar foto", "Elegir de la galería", "Cancelar"};
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Elige una opción");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                // Acciones correspondientes a cada opción seleccionada

                if (options[i].equals("Tomar foto")) {
                    abrirCamara(activity);
                } else if (options[i].equals("Elegir de la galería")) {
                    abrirGaleria(activity);
                } else if (options[i].equals("Cancelar")) {
                    dialogInterface.dismiss();
                }
            }

        });

        builder.show();
    }


    private void abrirCamara(Activity activity) {

        // Intent para abrir la cámara y tomar una foto

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File foto = new File(activity.getExternalFilesDir(null), "foto.jpg");
        Uri fotoUri = FileProvider.getUriForFile(activity,
                activity.getPackageName() + ".fileprovider", foto);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fotoUri);
        rutaImagenPerfil = foto.getAbsolutePath();
        activity.startActivityForResult(intent, 1234);
    }

    private void abrirGaleria(Activity activity) {

        // Intent para abrir la galería y seleccionar una imagen

        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        activity.startActivityForResult(intent.createChooser(intent, "Selecciona la aplicación"),
                10);
    }

}
