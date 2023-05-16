package com.adriancasantos.acetime.feature.arbitraje.viewmodel;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.adriancasantos.acetime.data.datasource.database.AdminSQLiteOpenHelper;
import com.adriancasantos.acetime.feature.arbitraje.model.Arbitraje;
import com.adriancasantos.acetime.feature.arbitraje.ui.ArbitrajeView;

public class ArbitrajeViewModel extends ViewModel {

    ArbitrajeView view;
    AdminSQLiteOpenHelper admin;

    public ArbitrajeViewModel(ArbitrajeView view ,Context context){
        this.view = view;
        this.admin = new AdminSQLiteOpenHelper(context);
    }

    public void guardarDatos(Arbitraje arbitraje) {
        //this.arbitraje = arbitraje;
        if(admin.insertarArbitraje(arbitraje)) view.cerrarActivity();

    }
}
