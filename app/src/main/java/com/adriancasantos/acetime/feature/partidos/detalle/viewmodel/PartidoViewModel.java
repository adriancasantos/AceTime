package com.adriancasantos.acetime.feature.partidos.detalle.viewmodel;

import androidx.lifecycle.ViewModel;

import com.adriancasantos.acetime.R;
import com.adriancasantos.acetime.feature.partidos.detalle.ui.PartidoView;

import com.adriancasantos.acetime.feature.partidos.model.Partido;
import java.util.ArrayList;
import java.util.Random;

public class PartidoViewModel extends ViewModel {

    private Partido partido;
    PartidoView vista;
    ArrayList<Integer> imagenesJugador = new ArrayList<>();

    public void onViewCreated(Partido partidoRecibido) {
        this.partido = partidoRecibido;
        vista.muestraPartido(partido);
        generaImagenesJugador();
    }

    public void verJugador1() {
        vista.navegaDetalleJugador(partido.getIdJugador1());
    }

    public void VerJugador2() {
        vista.navegaDetalleJugador(partido.getIdJugador2());
    }

    public void arbitrar() {
        vista.navegaArbitraje(partido);
    }

    public PartidoViewModel(PartidoView vista) {
        this.vista = vista;
        imagenesJugador.add(R.drawable.jugador1);
        imagenesJugador.add(R.drawable.jugador2);
        imagenesJugador.add(R.drawable.jugador3);
        imagenesJugador.add(R.drawable.jugador4);
        imagenesJugador.add(R.drawable.jugador5);
        imagenesJugador.add(R.drawable.jugador6);
        imagenesJugador.add(R.drawable.jugador7);
        imagenesJugador.add(R.drawable.jugador8);
        imagenesJugador.add(R.drawable.jugador9);
        imagenesJugador.add(R.drawable.jugador10);
    }


    private void generaImagenesJugador() {
        Random rand = new Random();
        Integer imagen1 = rand.nextInt(9) + 1;
        Integer imagen2 = rand.nextInt(9) + 1;

        while (imagen1.equals(imagen2)) {
            imagen2 = rand.nextInt(9) + 1;
        }
        vista.muestraImagenJ1(imagenesJugador.get(imagen1));
        vista.muestraImagenJ2(imagenesJugador.get(imagen2));
    }
    

}
