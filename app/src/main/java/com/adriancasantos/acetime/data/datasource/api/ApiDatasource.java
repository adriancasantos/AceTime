package com.adriancasantos.acetime.data.datasource.api;

import com.adriancasantos.acetime.data.CommonCallback;
import com.adriancasantos.acetime.data.model.PartidoData;
import com.adriancasantos.acetime.data.model.MetaPlayer;

public interface ApiDatasource {

    void getPartidos(CommonCallback<PartidoData> callback);

    void getPlayer(CommonCallback<MetaPlayer> playerCallback, String playerId);
}
