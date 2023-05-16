package com.adriancasantos.acetime.feature.partidos.detalle.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.adriancasantos.acetime.R;
import com.adriancasantos.acetime.feature.arbitraje.ui.ArbitrajeActivity;
import com.adriancasantos.acetime.feature.jugador.ui.JugadorActivity;
import com.adriancasantos.acetime.feature.partidos.detalle.viewmodel.PartidoViewModel;
import com.adriancasantos.acetime.feature.partidos.model.Partido;

public class FragmentPartido extends Fragment implements PartidoView {

    private static final String ARG_PARAM1 = "param1";
    private PartidoViewModel viewModel;

    TextView txtNombreJugador1, txtNombreJugador2, marcador1, marcador2, nombreP1, nombreP2;
    ImageView imagePartido, imageJugador1, imageJugador2;


    public FragmentPartido() {}

    public static FragmentPartido newInstance(Partido param1) {
        FragmentPartido fragment = new FragmentPartido();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            viewModel = new PartidoViewModel(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_partido, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button verJugador1 = view.findViewById(R.id.btnVerJugador1);
        verJugador1.setOnClickListener(v -> viewModel.verJugador1());

        Button verJugador2 = view.findViewById(R.id.btnVerJugador2);
        verJugador2.setOnClickListener(v -> viewModel.VerJugador2());

        Button botonArbitrar = view.findViewById(R.id.btnArbitrar);
        botonArbitrar.setOnClickListener(v -> viewModel.arbitrar());

        imageJugador1 = view.findViewById(R.id.imageJugador1);
        imageJugador2 = view.findViewById(R.id.imageJugador2);
        txtNombreJugador1 = view.findViewById(R.id.txtNombreJugador1);
        txtNombreJugador2 = view.findViewById(R.id.txtNombreJugador2);
        marcador1 = view.findViewById(R.id.puntuacionJ1);
        marcador2 = view.findViewById(R.id.puntuacionJ2);
        imagePartido = view.findViewById(R.id.imagePartido);
        nombreP1 = view.findViewById(R.id.nombrePuntuacion1);
        nombreP2 = view.findViewById(R.id.nombrePuntuacion2);

        viewModel.onViewCreated((Partido) getArguments().getSerializable(ARG_PARAM1));
    }

    @Override
    public void navegaDetalleJugador(String jugadorID) {
        requireContext().startActivity(
                JugadorActivity.getJugadorActivityIntent(requireContext(), jugadorID));
    }

    @Override
    public void navegaArbitraje(Partido partido) {
        requireContext().startActivity(
                ArbitrajeActivity.getArbitrajeActivityIntent(requireContext(), partido)
        );
    }

    @Override
    public void muestraPartido(Partido partido) {
        if (partido.getImagenPartido() != null) {
            imagePartido.setImageResource(partido.getImagenPartido());
        }
        txtNombreJugador1.setText(partido.getJugador1());
        txtNombreJugador2.setText(partido.getJugador2());
        marcador1.setText(partido.getResultadoJ1());
        marcador2.setText(partido.getResultadoJ2());
        nombreP1.setText(getString(R.string.marcador, partido.getJugador1()));
        nombreP2.setText(getString(R.string.marcador, partido.getJugador2()));
    }

    @Override
    public void muestraImagenJ1(Integer imagen) {
        imageJugador1.setImageResource(imagen);
    }

    @Override
    public void muestraImagenJ2(Integer imagen) {
        imageJugador2.setImageResource(imagen);
    }
}