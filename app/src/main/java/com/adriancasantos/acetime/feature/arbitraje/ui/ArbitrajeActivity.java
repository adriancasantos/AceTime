package com.adriancasantos.acetime.feature.arbitraje.ui;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.adriancasantos.acetime.R;

import com.adriancasantos.acetime.feature.arbitraje.model.Arbitraje;
import com.adriancasantos.acetime.feature.arbitraje.viewmodel.ArbitrajeViewModel;
import com.adriancasantos.acetime.feature.partidos.model.Partido;

public class ArbitrajeActivity extends AppCompatActivity implements ArbitrajeView{

    //Declaración de variables
    public static final String EXTRA_PARTIDO_ARBITRAJE = "EXTRA_PARTIDO_ARBITRAJE";
    private Partido partido;
    private ArbitrajeViewModel viewModel;
    private TextView tvJugador1Tabla, tvJugador2tabla, tvAce1, tvAce2, tvDobleFalta1,
            tvDobleFalta2, tvWinner1, tvWinner2, tvUnforcedError1, tvUnforcedError2, tvNetPoint1,
            tvNetPoint2,
            tvBreakPoint1, tvBreakPoint2;
    private Button btnJugador1, btnJugador2, btnAce, btnDobleFalta, btnWinner, btnUnforced,
            btnNetPoint, btnBreakPoint, btnGuardarPartido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_arbitraje);
        partido = (Partido) getIntent().getSerializableExtra(EXTRA_PARTIDO_ARBITRAJE);
        viewModel = new ArbitrajeViewModel(this,this);
        asignarVariables();

        btnJugador1.setText(partido.getJugador1());
        btnJugador2.setText(partido.getJugador2());

        rellenarTabla();
    }


    public void rellenarTabla() {

        tvJugador1Tabla.setText(partido.getJugador1());
        tvJugador2tabla.setText(partido.getJugador2());

        btnJugador1.setOnClickListener(v -> {
            btnJugador1.setBackgroundColor(getResources().getColor(R.color.yellow,getTheme()));
            btnJugador1.setTextColor(getResources().getColor(R.color.black,getTheme()));
            btnJugador2.setBackgroundColor(getResources().getColor(R.color.grey,getTheme()));
            btnJugador2.setTextColor(getResources().getColor(R.color.white,getTheme()));
            comportamientoBoton(btnAce, tvAce1);
            comportamientoBoton(btnDobleFalta, tvDobleFalta1);
            comportamientoBoton(btnWinner, tvWinner1);
            comportamientoBoton(btnUnforced, tvUnforcedError1);
            comportamientoBoton(btnNetPoint, tvNetPoint1);
            comportamientoBoton(btnBreakPoint, tvBreakPoint1);
        });

        btnJugador2.setOnClickListener(v -> {
            btnJugador2.setBackgroundColor(getResources().getColor(R.color.yellow,getTheme()));
            btnJugador2.setTextColor(getResources().getColor(R.color.black,getTheme()));
            btnJugador1.setBackgroundColor(getResources().getColor(R.color.grey,getTheme()));
            btnJugador1.setTextColor(getResources().getColor(R.color.white,getTheme()));
            comportamientoBoton(btnAce, tvAce2);
            comportamientoBoton(btnDobleFalta, tvDobleFalta2);
            comportamientoBoton(btnWinner, tvWinner2);
            comportamientoBoton(btnUnforced, tvUnforcedError2);
            comportamientoBoton(btnNetPoint, tvNetPoint2);
            comportamientoBoton(btnBreakPoint, tvBreakPoint2);
        });

        btnGuardarPartido.setOnClickListener(v -> {
            viewModel.guardarDatos(
                    new Arbitraje(
                            null,
                            tvAce1.getText().toString(),
                            tvAce2.getText().toString(),
                            tvDobleFalta1.getText().toString(),
                            tvDobleFalta2.getText().toString(),
                            tvWinner1.getText().toString(),
                            tvWinner2.getText().toString(),
                            tvUnforcedError1.getText().toString(),
                            tvUnforcedError2.getText().toString(),
                            tvNetPoint1.getText().toString(),
                            tvNetPoint2.getText().toString(),
                            tvBreakPoint1.getText().toString(),
                            tvBreakPoint2.getText().toString(),
                            partido.getJugador1(),
                            partido.getJugador2(),
                            partido.getFecha(),
                            partido.getTorneo()

                    )
            );
        });

    }

    public void comportamientoBoton(Button boton, TextView textView) {

        boton.setOnClickListener(v -> {
            int numero = Integer.parseInt(textView.getText().toString());
            numero++;
            textView.setText(String.valueOf(numero));
        });

    }

    public void asignarVariables() {

        //Variables del layout
        tvJugador1Tabla = findViewById(R.id.tvJugador1Tabla);
        tvJugador2tabla = findViewById(R.id.tvJugador2Tabla);
        tvAce1 = findViewById(R.id.tvAce1);
        tvAce2 = findViewById(R.id.tvAce2);
        tvDobleFalta1 = findViewById(R.id.tvDobleFalta1);
        tvDobleFalta2 = findViewById(R.id.tvDobleFalta2);
        tvWinner1 = findViewById(R.id.tvWinner1);
        tvWinner2 = findViewById(R.id.tvWinner2);
        tvUnforcedError1 = findViewById(R.id.tvUnforced1);
        tvUnforcedError2 = findViewById(R.id.tvUnforced2);
        tvNetPoint1 = findViewById(R.id.tvNet1);
        tvNetPoint2 = findViewById(R.id.tvNet2);
        tvBreakPoint1 = findViewById(R.id.tvBreak1);
        tvBreakPoint2 = findViewById(R.id.tvBreak2);
        btnAce = findViewById(R.id.btnAce);
        btnDobleFalta = findViewById(R.id.btnDobleFalta);
        btnWinner = findViewById(R.id.btnWinner);
        btnUnforced = findViewById(R.id.btnUnforced);
        btnNetPoint = findViewById(R.id.btnNet);
        btnBreakPoint = findViewById(R.id.btnBreak);
        btnJugador1 = findViewById(R.id.btnJugador1);
        btnJugador2 = findViewById(R.id.btnJugador2);
        btnGuardarPartido = findViewById(R.id.btnGuardarArbitraje);
    }

    public static Intent getArbitrajeActivityIntent(Context fromContext, Partido partido) {
        return new Intent(fromContext, ArbitrajeActivity.class).putExtra(EXTRA_PARTIDO_ARBITRAJE,
                partido);
    }

    @Override
    public void cerrarActivity() {
        Toast.makeText(getApplicationContext(), "Arbitraje guardado con éxito", Toast.LENGTH_SHORT).show();
        finish();
    }
}