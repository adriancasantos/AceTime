package com.adriancasantos.acetime.feature.jugador.model;

import androidx.annotation.Nullable;

public class Jugador {


    public String nombreCompleto;
    public String pais;
    public String ranking;

    @Nullable
    private String rankingMovement;
    @Nullable
    private int rankingPoints;
    @Nullable
    private int raceRanking;
    @Nullable
    private String raceMovement;
    @Nullable
    private int racePoints;

    public Jugador(String nombreCompleto, String pais, String ranking,
            @Nullable String rankingMovement,
            int rankingPoints, int raceRanking, @Nullable String raceMovement, int racePoints) {
        this.nombreCompleto = nombreCompleto;
        this.pais = pais;
        this.ranking = ranking;
        this.rankingMovement = rankingMovement;
        this.rankingPoints = rankingPoints;
        this.raceRanking = raceRanking;
        this.raceMovement = raceMovement;
        this.racePoints = racePoints;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    @Nullable
    public String getRankingMovement() {
        return rankingMovement;
    }

    public void setRankingMovement(@Nullable String rankingMovement) {
        this.rankingMovement = rankingMovement;
    }

    public int getRankingPoints() {
        return rankingPoints;
    }

    public void setRankingPoints(int rankingPoints) {
        this.rankingPoints = rankingPoints;
    }

    public int getRaceRanking() {
        return raceRanking;
    }

    public void setRaceRanking(int raceRanking) {
        this.raceRanking = raceRanking;
    }

    @Nullable
    public String getRaceMovement() {
        return raceMovement;
    }

    public void setRaceMovement(@Nullable String raceMovement) {
        this.raceMovement = raceMovement;
    }

    public int getRacePoints() {
        return racePoints;
    }

    public void setRacePoints(int racePoints) {
        this.racePoints = racePoints;
    }
}
