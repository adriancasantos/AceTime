package com.adriancasantos.acetime.data.model;

import com.google.gson.annotations.SerializedName;

public class ResultsPlayer {

    @SerializedName("player")
    public InfoJugador infoJugador;

    public ResultsPlayer(InfoJugador infoJugador) {
        this.infoJugador = infoJugador;
    }

    public InfoJugador getInfoJugador() {
        return infoJugador;
    }

    public void setInfoJugador(InfoJugador infoJugador) {
        this.infoJugador = infoJugador;
    }
}
