package com.adriancasantos.acetime.feature.jugador.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.adriancasantos.acetime.R;
import com.adriancasantos.acetime.feature.jugador.model.Jugador;
import com.adriancasantos.acetime.feature.jugador.viewmodel.JugadorViewModel;

public class JugadorActivity extends AppCompatActivity implements JugadorView {

    JugadorViewModel viewModel;
    String jugadorId;

    TextView nombre, pais, ranking, rankingMovement, rankingPoints, raceRanking, raceMovement,
            racePoints;
    public static final String EXTRA_PLAYER_ID = "playerID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugador);
        nombre = findViewById(R.id.txtNombreJugador);
        pais = findViewById(R.id.txtpais);
        ranking = findViewById(R.id.txtRanking);
        rankingMovement = findViewById(R.id.txtRankingMovement);
        rankingPoints = findViewById(R.id.txtRankingPoints);
        raceRanking = findViewById(R.id.txtRaceRanking);
        raceMovement = findViewById(R.id.txtRaceMovement);
        racePoints = findViewById(R.id.txtRacePoints);

        viewModel = new JugadorViewModel(this);
        jugadorId = getIntent().getStringExtra(EXTRA_PLAYER_ID);
        viewModel.dameInfo(jugadorId);
    }


    @Override
    public void informacionLista(Jugador jugador) {
        nombre.setText(jugador.nombreCompleto);
        pais.setText(jugador.pais);
        ranking.setText(getString(R.string.ranking, jugador.ranking));
        if (jugador.getRankingMovement() != null) {
            rankingMovement.setText(
                    getString(R.string.rankingMovement, jugador.getRankingMovement())
            );
        }
        rankingPoints.setText(getString(R.string.rankingPoints,jugador.getRankingPoints()));
        raceRanking.setText(getString(R.string.raceRanking, jugador.getRaceRanking()));
        if(jugador.getRaceMovement() != null){
            raceMovement.setText(getString(R.string.raceMovements,jugador.getRaceMovement()));
        }
        racePoints.setText(getString(R.string.racePoints,jugador.getRacePoints()));
    }

    public static Intent getJugadorActivityIntent(Context fromContext, String jugadorId) {
        return new Intent(fromContext, JugadorActivity.class).putExtra(EXTRA_PLAYER_ID, jugadorId);
    }


}