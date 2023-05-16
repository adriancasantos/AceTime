package com.adriancasantos.acetime.data.datasource.api;

import com.adriancasantos.acetime.data.CommonCallback;
import com.adriancasantos.acetime.data.model.PartidoData;
import com.adriancasantos.acetime.data.model.Encuentro;
import com.adriancasantos.acetime.data.model.MetaPlayer;
import com.adriancasantos.acetime.data.model.ResultPartidos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiDatasourceImpl implements ApiDatasource {

    private ApiService apiService;
    private Retrofit retrofit;

    public ApiDatasourceImpl() {

        // Configuración de OkHttpClient y Retrofit para realizar las solicitudes a la API

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient().newBuilder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(chain -> {
                    Request request = chain.request().newBuilder()
                            .addHeader("content-type", "application/json")
                            .addHeader("X-RapidAPI-Key",
                                    "0b5e8eed96msh3e0b01661770979p10d1fajsn2b242ac06131")
                            .addHeader("X-RapidAPI-Host", "tennis-live-data.p.rapidapi.com")
                            .build();
                    return chain.proceed(request);
                })
                .build();

        // Configuración de Retrofit con la URL base y el cliente OkHttpClient

        retrofit = new Retrofit.Builder()
                .baseUrl("https://tennis-live-data.p.rapidapi.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    @Override
    public void getPartidos(CommonCallback<PartidoData> callback) {

        // Obtener los partidos de la API

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String todayDate = dateFormat.format(calendar.getTime());
        Call<PartidoData> call = apiService.getPartidos(todayDate);
        call.enqueue(new Callback<PartidoData>() {

            @Override
            public void onResponse(Call<PartidoData> call, Response<PartidoData> response) {
                callback.onSuccess(response.body());
                for (ResultPartidos resultPartido : response.body().results) {
                    for (Encuentro encuentro : resultPartido.matches) {
                        System.out.println("Jugador 1 es: " + encuentro.home_player);
                        System.out.println("Jugador 2 es: " + encuentro.away_player);
                        System.out.println("................................................");
                    }
                }
            }

            @Override
            public void onFailure(Call<PartidoData> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    @Override
    public void getPlayer(CommonCallback<MetaPlayer> playerCallback, String playerId) {

        // Obtener información de un jugador específico de la API

        Call<MetaPlayer> call = apiService.getPlayer(playerId);

        call.enqueue(new Callback<MetaPlayer>() {
            @Override
            public void onResponse(Call<MetaPlayer> call, Response<MetaPlayer> response) {
                playerCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<MetaPlayer> call, Throwable t)
            {
                playerCallback.onError(t);
            }
        });
    }
}
