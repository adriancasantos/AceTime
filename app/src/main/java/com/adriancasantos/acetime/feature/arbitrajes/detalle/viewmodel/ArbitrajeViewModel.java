package com.adriancasantos.acetime.feature.arbitrajes.detalle.viewmodel;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.adriancasantos.acetime.data.datasource.database.AdminSQLiteOpenHelper;
import com.adriancasantos.acetime.feature.arbitraje.model.Arbitraje;
import com.adriancasantos.acetime.feature.arbitrajes.detalle.ui.ArbitrajeView;
import com.adriancasantos.acetime.feature.arbitrajes.detalle.ui.FragmentArbitraje;

public class ArbitrajeViewModel extends ViewModel {

    private Arbitraje arbitraje;
    ArbitrajeView vista;
    AdminSQLiteOpenHelper admin;

    public void onViewCreated(Arbitraje arbitrajeRecibido) {
        this.arbitraje = arbitrajeRecibido;
        vista.muestraArbitraje(arbitraje);

    }

    public ArbitrajeViewModel(Context context, ArbitrajeView vista) {
        this.vista = vista;
        admin = new AdminSQLiteOpenHelper(context);
    }


    public void actualizarArbitraje(Arbitraje arbitraje) {
        arbitraje.setId(this.arbitraje.getId());
        boolean result = admin.editarArbitraje(arbitraje);
        if (result) vista.guardadoCorrecto();
    }

}
