package com.adriancasantos.acetime.feature.partidos.detalle.ui;

import com.adriancasantos.acetime.feature.partidos.model.Partido;

public interface PartidoView {

    void muestraPartido (Partido partido);
    void navegaDetalleJugador(String jugadorID);
    void navegaArbitraje(Partido partido);
    void muestraImagenJ1(Integer imagen);
    void muestraImagenJ2(Integer imagen);
}
