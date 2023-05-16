package com.adriancasantos.acetime.data.model;

import com.google.gson.annotations.SerializedName;

public class MetaPlayer {
    @SerializedName("results")
    public ResultsPlayer resultsPlayer;


    public MetaPlayer(ResultsPlayer resultsPlayer) {
        this.resultsPlayer = resultsPlayer;
    }

    public ResultsPlayer getResultsPlayer() {
        return resultsPlayer;
    }

    public void setResultsPlayer(ResultsPlayer resultsPlayer) {
        this.resultsPlayer = resultsPlayer;
    }
}

