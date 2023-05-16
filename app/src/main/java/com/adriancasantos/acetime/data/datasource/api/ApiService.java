package com.adriancasantos.acetime.data.datasource.api;

import com.adriancasantos.acetime.data.model.PartidoData;
import com.adriancasantos.acetime.data.model.MetaPlayer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("matches-by-date/{date}")

    Call<PartidoData> getPartidos(@Path("date") String date);

    @GET("player/{playerId}")

    Call<MetaPlayer> getPlayer(@Path("playerId") String playerId);
}
