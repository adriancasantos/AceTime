package com.adriancasantos.acetime.feature.arbitrajes.lista.viewmodel;

import android.app.AlertDialog;
import android.content.Context;

import com.adriancasantos.acetime.data.datasource.database.AdminSQLiteOpenHelper;
import com.adriancasantos.acetime.feature.arbitraje.model.Arbitraje;
import com.adriancasantos.acetime.feature.arbitrajes.lista.ui.ArbitrajesView;

import java.util.ArrayList;

public class ArbitrajesViewModel {

    ArbitrajesView vista;
    AdminSQLiteOpenHelper admin;

    public ArbitrajesViewModel (ArbitrajesView vista, Context ctx) {
        this.vista = vista;
        admin = new AdminSQLiteOpenHelper(ctx);
    }


    public void dameArbitrajes() {
        ArrayList<Arbitraje> data = admin.selectArbitrajes();
        vista.arbitrajesListos(data);
    }

    public void eliminaArbitraje(Arbitraje arbitraje){


        if(admin.eliminarArbritraje(arbitraje.getId())) {
            dameArbitrajes();
        }
    }


}
