package com.adriancasantos.acetime.feature.jugador.viewmodel;

import androidx.lifecycle.ViewModel;
import com.adriancasantos.acetime.data.CommonCallback;
import com.adriancasantos.acetime.data.repository.jugador.JugadorRepository;
import com.adriancasantos.acetime.feature.jugador.model.Jugador;
import com.adriancasantos.acetime.feature.jugador.ui.JugadorView;

public class JugadorViewModel extends ViewModel {

    JugadorView view;
    public JugadorViewModel(JugadorView vista) {

        this.view = vista;
    }


    public void dameInfo(String jugadorId) {
        JugadorRepository repository = new JugadorRepository();

        repository.dameInfoJugador(
                new CommonCallback<Jugador>() {
                    @Override
                    public void onSuccess(Jugador data) {
                        System.out.println("todo bien el jugador es:" + data.nombreCompleto);
                        view.informacionLista(data);
                    }

                    @Override
                    public void onError(Throwable error) {

                    }
                },
                jugadorId);

    }
}
