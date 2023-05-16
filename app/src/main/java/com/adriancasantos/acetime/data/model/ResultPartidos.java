package com.adriancasantos.acetime.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ResultPartidos {

    @SerializedName("tournament")
    public Torneo tournament;
    @SerializedName("matches")
    public List<Encuentro> matches;

}
