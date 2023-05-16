package com.adriancasantos.acetime.data.repository.jugador;

import com.adriancasantos.acetime.data.CommonCallback;
import com.adriancasantos.acetime.data.datasource.api.ApiDatasource;
import com.adriancasantos.acetime.data.datasource.api.ApiDatasourceImpl;
import com.adriancasantos.acetime.data.model.InfoJugador;
import com.adriancasantos.acetime.data.model.MetaPlayer;
import com.adriancasantos.acetime.feature.jugador.model.Jugador;

public class JugadorRepository implements JugadorRepositoryInterface {

    ApiDatasource datasource;

    public JugadorRepository() {

        datasource = new ApiDatasourceImpl();
    }

    @Override
    public void dameInfoJugador(CommonCallback<Jugador> callback, String playerId) {

        datasource.getPlayer(
                new CommonCallback<MetaPlayer>() {
                    @Override
                    public void onSuccess(MetaPlayer data) {
                        InfoJugador info = data.getResultsPlayer().getInfoJugador();
                        Jugador jugador = new Jugador(
                              info.full_name,
                               info.country,
                               info.ranking,
                               info.getRankingMovement(),
                               info.getRankingPoints(),
                               info.getRaceRanking(),
                               info.getRaceMovement(),
                               info.getRacePoints()
                        );
                        callback.onSuccess(jugador);
                    }

                    @Override
                    public void onError(Throwable error) {

                        callback.onError(error);
                    }
                },
                playerId
        );
    }
}
