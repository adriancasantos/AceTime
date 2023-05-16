package com.adriancasantos.acetime.data.repository.partidos;

import androidx.annotation.Nullable;

import com.adriancasantos.acetime.data.CommonCallback;
import com.adriancasantos.acetime.data.model.Marcador;
import com.adriancasantos.acetime.data.model.PartidoData;
import com.adriancasantos.acetime.data.datasource.api.ApiDatasource;
import com.adriancasantos.acetime.data.datasource.api.ApiDatasourceImpl;
import com.adriancasantos.acetime.data.model.Encuentro;
import com.adriancasantos.acetime.data.model.ResultPartidos;
import com.adriancasantos.acetime.feature.partidos.model.Partido;
import java.util.ArrayList;
import java.util.List;

public class PartidosRepository implements PartidosInterface {

    ApiDatasource apiDatasource;
    private final String espacio = "    ";

    public PartidosRepository() {
        apiDatasource = new ApiDatasourceImpl();
    }

    @Override
    public void getPartidos(CommonCallback<List<Partido>> callback) {
        List<Partido> partidos = new ArrayList<Partido>();
        apiDatasource.getPartidos(new CommonCallback<PartidoData>() {
            @Override
            public void onSuccess(PartidoData data) {
                for (ResultPartidos result : data.results) {
                    for (Encuentro encuentro : result.matches) {
                        partidos.add(new Partido(
                                false,
                                null,
                                encuentro.home_player,
                                encuentro.away_player,
                                result.tournament.getName(),
                                encuentro.date,
                                encuentro.home_id,
                                encuentro.away_id,
                                encuentro.court,
                                getResultadoJ1(encuentro.marcador),
                                getResultadoJ2(encuentro.marcador)
                        ));
                    }
                }
                callback.onSuccess(partidos);
            }

            @Override
            public void onError(Throwable error) {
                callback.onError(error);
            }
        });
    }


    private @Nullable String getResultadoJ1(Marcador marcador) {
        if(marcador != null) {
            String marcadorJ1 = "";
            String aux = "";
            if(marcador.home_set1 != null) {
                aux = espacio + marcador.home_set1;
                marcadorJ1 = marcadorJ1.concat(aux);
            }
            if(marcador.home_set2 != null) {
                aux = espacio + marcador.home_set2;
                marcadorJ1 = marcadorJ1.concat(aux);
            }
            if(marcador.home_set3 != null) {
                aux = espacio + marcador.home_set3;
                marcadorJ1 = marcadorJ1.concat(aux);
            }
            if(marcador.home_set4 != null) {
                aux = espacio + marcador.home_set4;
                marcadorJ1 = marcadorJ1.concat(aux);
            }
            if(marcador.home_set5 != null) {
                aux = espacio + marcador.home_set5;
                marcadorJ1 = marcadorJ1.concat(aux);
            }
            return marcadorJ1;

        } else return null;
    }
    private @Nullable String getResultadoJ2(Marcador marcador) {
        if(marcador != null) {
            String marcadorJ2 = "";
            String aux2 = "";
            if(marcador.away_set1 != null) {
                aux2 = espacio + marcador.away_set1;
                marcadorJ2 = marcadorJ2.concat(aux2);
            }
            if(marcador.away_set2 != null) {
                aux2 = espacio + marcador.away_set2;
                marcadorJ2 = marcadorJ2.concat(aux2);
            }
            if(marcador.away_set3 != null) {
                aux2 = espacio + marcador.away_set3;
                marcadorJ2 = marcadorJ2.concat(aux2);
            }
            if(marcador.away_set4 != null) {
                aux2 = espacio + marcador.away_set4;
                marcadorJ2 = marcadorJ2.concat(aux2);
            }
            if(marcador.away_set5 != null) {
                aux2 = espacio + marcador.away_set5;
                marcadorJ2 = marcadorJ2.concat(aux2);
            }
            return marcadorJ2;

        } else return null;
    }
}
