package com.adriancasantos.acetime.data.model;

import androidx.annotation.Nullable;
import com.google.gson.annotations.SerializedName;

public class Encuentro{

    public String id;
    public String status;
    public String title;
    public String home_id;
    public String home_player;
    public String away_id;
    public String away_player;
    public String date;
    public String court;
    public String round_id;
    public String round_name;

    @Nullable
    @SerializedName("result")
    public Marcador marcador;

    public InfoJugador home;
    public InfoJugador away;

    public Encuentro(String id, String status, String title, String home_id, String home_player,
            String away_id, String away_player, String date, String court, String round_id,
            String round_name, @Nullable Marcador marcador, InfoJugador home, InfoJugador away) {
        this.id = id;
        this.status = status;
        this.title = title;
        this.home_id = home_id;
        this.home_player = home_player;
        this.away_id = away_id;
        this.away_player = away_player;
        this.date = date;
        this.court = court;
        this.round_id = round_id;
        this.round_name = round_name;
        this.marcador = marcador;
        this.home = home;
        this.away = away;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHome_id() {
        return home_id;
    }

    public void setHome_id(String home_id) {
        this.home_id = home_id;
    }

    public String getHome_player() {
        return home_player;
    }

    public void setHome_player(String home_player) {
        this.home_player = home_player;
    }

    public String getAway_id() {
        return away_id;
    }

    public void setAway_id(String away_id) {
        this.away_id = away_id;
    }

    public String getAway_player() {
        return away_player;
    }

    public void setAway_player(String away_player) {
        this.away_player = away_player;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public String getRound_id() {
        return round_id;
    }

    public void setRound_id(String round_id) {
        this.round_id = round_id;
    }

    public String getRound_name() {
        return round_name;
    }

    public void setRound_name(String round_name) {
        this.round_name = round_name;
    }

    @Nullable
    public Marcador getMarcador() {
        return marcador;
    }

    public void setMarcador(@Nullable Marcador marcador) {
        this.marcador = marcador;
    }

    public InfoJugador getHome() {
        return home;
    }

    public void setHome(InfoJugador home) {
        this.home = home;
    }

    public InfoJugador getAway() {
        return away;
    }

    public void setAway(InfoJugador away) {
        this.away = away;
    }
}