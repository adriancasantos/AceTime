package com.adriancasantos.acetime.feature.arbitrajes.detalle.ui;

import android.os.Bundle;

import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.adriancasantos.acetime.R;
import com.adriancasantos.acetime.feature.arbitraje.model.Arbitraje;
import com.adriancasantos.acetime.feature.arbitrajes.detalle.viewmodel.ArbitrajeViewModel;

import java.io.Serializable;

public class FragmentArbitraje extends Fragment implements ArbitrajeView {

    private static final String ARG_PARAM1 = "param1";

    private ArbitrajeViewModel viewModel;

    TextView tvFecha, tvTorneo, tvNombreJ1, tvNombreJ2, tvAces, tvDoblesFaltas, tvWinners,
            tvErroresNoForzados, tvNetPoints, tvBreakPoints;
    EditText etAcesJ1, etAcesJ2, etDoblesFaltasJ1, etDoblesFaltasJ2, etWinnersJ1, etWinnersJ2,
            etErroresNoForzadosJ1, etErroresNoForzadosJ2, etNetPointsJ1, etNetPointsJ2,
            etBreakPointsJ1, etBreakPointsJ2;
    Button btnActualizar, btnGuardar;

    public FragmentArbitraje() {
    }

    ;


    public static FragmentArbitraje newInstance(Arbitraje param1) {
        FragmentArbitraje fragment = new FragmentArbitraje();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            viewModel = new ArbitrajeViewModel(getContext(), this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_arbitraje, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvFecha = view.findViewById(R.id.tvFecha);
        tvTorneo = view.findViewById(R.id.tvTorneo);
        tvNombreJ1 = view.findViewById(R.id.tvNombreJ1);
        tvNombreJ2 = view.findViewById(R.id.tvNombreJ2);
        tvAces = view.findViewById(R.id.tvAces);
        tvDoblesFaltas = view.findViewById(R.id.tvDoblesFaltas);
        tvWinners = view.findViewById(R.id.tvWinners);
        tvErroresNoForzados = view.findViewById(R.id.tvErroresNoForzados);
        tvNetPoints = view.findViewById(R.id.tvNetPoints);
        tvBreakPoints = view.findViewById(R.id.tvBreakPoints);
        etAcesJ1 = view.findViewById(R.id.etAcesJ1);
        etAcesJ2 = view.findViewById(R.id.etAcesJ2);
        etDoblesFaltasJ1 = view.findViewById(R.id.etDoblesFaltasJ1);
        etDoblesFaltasJ2 = view.findViewById(R.id.etDoblesFaltasJ2);
        etWinnersJ1 = view.findViewById(R.id.etWinnersJ1);
        etWinnersJ2 = view.findViewById(R.id.etWinnersJ2);
        etErroresNoForzadosJ1 = view.findViewById(R.id.etErroresNoForzadosJ1);
        etErroresNoForzadosJ2 = view.findViewById(R.id.etErroresNoForzadosJ2);
        etNetPointsJ1 = view.findViewById(R.id.etNetPointsJ1);
        etNetPointsJ2 = view.findViewById(R.id.etNetPointsJ2);
        etBreakPointsJ1 = view.findViewById(R.id.etBreakPointsJ1);
        etBreakPointsJ2 = view.findViewById(R.id.etBreakPointsJ2);

        btnActualizar = view.findViewById(R.id.btnActualizar);
        // El botón actualizar cambia a enabled todos los campos cuando se pulsa
        btnActualizar.setOnClickListener(v -> {
            setInputsEnabled(true);
        });

        btnGuardar = view.findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(v -> viewModel.actualizarArbitraje(new Arbitraje(

                null,
                etAcesJ1.getText().toString(),
                etAcesJ2.getText().toString(),
                etDoblesFaltasJ1.getText().toString(),
                etDoblesFaltasJ2.getText().toString(),
                etWinnersJ1.getText().toString(),
                etWinnersJ2.getText().toString(),
                etErroresNoForzadosJ1.getText().toString(),
                etErroresNoForzadosJ2.getText().toString(),
                etNetPointsJ1.getText().toString(),
                etNetPointsJ2.getText().toString(),
                etBreakPointsJ1.getText().toString(),
                etBreakPointsJ2.getText().toString(),
                tvNombreJ1.getText().toString(),
                tvNombreJ2.getText().toString(),
                tvFecha.getText().toString(),
                tvTorneo.getText().toString()
        )));

        viewModel.onViewCreated((Arbitraje) getArguments().getSerializable(ARG_PARAM1));
    }


    @Override
    public void muestraArbitraje(Arbitraje arbitraje) {

        tvFecha.setText(arbitraje.getFechaPartido().substring(0, 10));
        tvTorneo.setText(arbitraje.getTorneo());
        tvNombreJ1.setText(arbitraje.getNombreJ1());
        tvNombreJ2.setText(arbitraje.getNombreJ2());
        etAcesJ1.setText(arbitraje.getAcesJ1());
        etAcesJ2.setText(arbitraje.getAcesJ2());
        etDoblesFaltasJ1.setText(arbitraje.getDobleFaltaJ1());
        etDoblesFaltasJ2.setText(arbitraje.getDobleFaltaJ2());
        etWinnersJ1.setText(arbitraje.getWinnerJ1());
        etWinnersJ2.setText(arbitraje.getWinnerJ2());
        etErroresNoForzadosJ1.setText(arbitraje.getErroresNFJ1());
        etErroresNoForzadosJ2.setText(arbitraje.getErroresNFJ2());
        etNetPointsJ1.setText(arbitraje.getNetJ1());
        etNetPointsJ2.setText(arbitraje.getNetJ2());
        etBreakPointsJ1.setText(arbitraje.getBreakJ1());
        etBreakPointsJ2.setText(arbitraje.getBreakJ2());
    }

    @Override
    public void guardadoCorrecto() {
        Toast.makeText(requireContext(), "Guardado Correcto", Toast.LENGTH_SHORT).show();
        setInputsEnabled(false);
    }

    private void setInputsEnabled(Boolean isEnabled) {
        etAcesJ1.setEnabled(isEnabled);
        etAcesJ2.setEnabled(isEnabled);
        etDoblesFaltasJ1.setEnabled(isEnabled);
        etDoblesFaltasJ2.setEnabled(isEnabled);
        etWinnersJ1.setEnabled(isEnabled);
        etWinnersJ2.setEnabled(isEnabled);
        etErroresNoForzadosJ1.setEnabled(isEnabled);
        etErroresNoForzadosJ2.setEnabled(isEnabled);
        etNetPointsJ1.setEnabled(isEnabled);
        etNetPointsJ2.setEnabled(isEnabled);
        etBreakPointsJ1.setEnabled(isEnabled);
        etBreakPointsJ2.setEnabled(isEnabled);
    }
}