package com.adriancasantos.acetime.data.repository.partidos;

import com.adriancasantos.acetime.data.CommonCallback;
import com.adriancasantos.acetime.feature.partidos.model.Partido;
import java.util.List;

public interface PartidosInterface {
    void getPartidos(CommonCallback<List<Partido>> callback);

}
