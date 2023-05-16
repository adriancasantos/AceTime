package com.adriancasantos.acetime.data.model;

import androidx.annotation.Nullable;
import com.google.gson.annotations.SerializedName;

public class InfoJugador {

    public String full_name;
    public String country;
    public String ranking;

    @Nullable
    @SerializedName("ranking_movement")
    private String rankingMovement;
    @Nullable
    @SerializedName("ranking_points")
    private int rankingPoints;
    @Nullable
    @SerializedName("race_ranking")
    private int raceRanking;
    @Nullable
    @SerializedName("race_movement")
    private String raceMovement;
    @Nullable
    @SerializedName("race_points")
    private int racePoints;

    public InfoJugador(String full_name, String country, String ranking,
            @Nullable String rankingMovement, int rankingPoints, int raceRanking,
            @Nullable String raceMovement, int racePoints) {
        this.full_name = full_name;
        this.country = country;
        this.ranking = ranking;
        this.rankingMovement = rankingMovement;
        this.rankingPoints = rankingPoints;
        this.raceRanking = raceRanking;
        this.raceMovement = raceMovement;
        this.racePoints = racePoints;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
