package com.adriancasantos.acetime.feature.partidos.model;

import androidx.annotation.Nullable;
import java.io.Serializable;

public class Partido implements Serializable {

    private boolean favorito;
    @Nullable
    private Integer imagenPartido;
    private String jugador1;
    private String jugador2;
    private String torneo;
    private String fecha;

    private String idJugador1;
    private String idJugador2;

    private String estadio;

    @Nullable
    private String resultadoJ1;

    @Nullable
    private String resultadoJ2;

    public Partido(boolean favorito, @Nullable Integer imagenPartido, String jugador1,
            String jugador2,
            String torneo, String fecha, String idJugador1, String idJugador2, String estadio,
            @Nullable String resultadoJ1, @Nullable String resultadoJ2) {
        this.favorito = favorito;
        this.imagenPartido = imagenPartido;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.torneo = torneo;
        this.fecha = fecha;
        this.idJugador1 = idJugador1;
        this.idJugador2 = idJugador2;
        this.estadio = estadio;
        this.resultadoJ1 = resultadoJ1;
        this.resultadoJ2 = resultadoJ2;
    }


    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    @Nullable
    public Integer getImagenPartido() {
        return imagenPartido;
    }

    public void setImagenPartido(@Nullable Integer imagenPartido) {
        this.imagenPartido = imagenPartido;
    }

    public String getJugador1() {
        return jugador1;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    public String getTorneo() {
        return torneo;
    }

    public void setTorneo(String torneo) {
        this.torneo = torneo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdJugador1() {
        return idJugador1;
    }

    public void setIdJugador1(String idJugador1) {
        this.idJugador1 = idJugador1;
    }

    public String getIdJugador2() {
        return idJugador2;
    }

    public void setIdJugador2(String idJugador2) {
        this.idJugador2 = idJugador2;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    @Nullable
    public String getResultadoJ1() {
        return resultadoJ1;
    }

    public void setResultadoJ1(@Nullable String resultadoJ1) {
        this.resultadoJ1 = resultadoJ1;
    }

    @Nullable
    public String getResultadoJ2() {
        return resultadoJ2;
    }

    public void setResultadoJ2(@Nullable String resultadoJ2) {
        this.resultadoJ2 = resultadoJ2;
    }
}
