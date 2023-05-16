package com.adriancasantos.acetime.data.repository.jugador;

import com.adriancasantos.acetime.data.CommonCallback;
import com.adriancasantos.acetime.feature.jugador.model.Jugador;

public interface JugadorRepositoryInterface {

    void dameInfoJugador(CommonCallback<Jugador> callback, String playerId);
}
