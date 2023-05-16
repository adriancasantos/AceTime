package com.adriancasantos.acetime.feature.partidos.lista.viewmodel;

import androidx.lifecycle.ViewModel;
import com.adriancasantos.acetime.R;
import com.adriancasantos.acetime.data.CommonCallback;
import com.adriancasantos.acetime.data.repository.partidos.PartidosRepository;
import com.adriancasantos.acetime.feature.partidos.lista.ui.PartidosView;
import com.adriancasantos.acetime.feature.partidos.model.Partido;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PartidosViewModel extends ViewModel {
    PartidosView vista;
    ArrayList<Integer> imagenesPartido = new ArrayList<>();

    public PartidosViewModel(PartidosView vista) {
        this.vista = vista;
        imagenesPartido.add(R.drawable.partido2);
        imagenesPartido.add(R.drawable.partido3);
        imagenesPartido.add(R.drawable.partido4);
        imagenesPartido.add(R.drawable.partido5);
        imagenesPartido.add(R.drawable.partido6);
        imagenesPartido.add(R.drawable.partido7);
        imagenesPartido.add(R.drawable.partido8);
        imagenesPartido.add(R.drawable.partido9);
        imagenesPartido.add(R.drawable.partido10);
    }

    public void damePartidos() {
        PartidosRepository repository = new PartidosRepository();
        Random rand = new Random();
        repository.getPartidos(new CommonCallback<List<Partido>>() {
            @Override
            public void onSuccess(List<Partido> data) {
                data.forEach(partido ->
                        partido.setImagenPartido(
                                imagenesPartido.get(rand.nextInt(8) + 1)
                        ));
                vista.partidosListos(data);
            }

            @Override
            public void onError(Throwable error) {
                // TODO muestra errores
            }
        });
    }

}
