package com.adriancasantos.acetime.feature.arbitrajes.detalle.ui;

import com.adriancasantos.acetime.feature.arbitraje.model.Arbitraje;
import com.adriancasantos.acetime.feature.partidos.model.Partido;

public interface ArbitrajeView {

    void muestraArbitraje (Arbitraje arbitraje);
    void guardadoCorrecto();
}
