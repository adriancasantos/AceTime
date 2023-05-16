package com.adriancasantos.acetime.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PartidoData {

    @SerializedName("meta")
    public final Meta meta;
    @SerializedName("results")
    public final List<ResultPartidos> results;



    public PartidoData(Meta meta, List<ResultPartidos> results) {
        this.meta = meta;
        this.results = results;
    }
}

