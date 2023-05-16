package com.adriancasantos.acetime.feature.partidos.lista.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adriancasantos.acetime.NavigationInterface;
import com.adriancasantos.acetime.R;
import com.adriancasantos.acetime.feature.partidos.detalle.ui.FragmentPartido;
import com.adriancasantos.acetime.feature.partidos.lista.viewmodel.PartidosViewModel;
import com.adriancasantos.acetime.feature.partidos.model.Partido;
import java.util.ArrayList;
import java.util.List;

public class FragmentPartidos extends Fragment implements PartidosView {

    ListAdapterPartidos listAdapter;
    ArrayList<Partido> partidos;
    NavigationInterface callback;
    PartidosViewModel viewModel;

    public FragmentPartidos(NavigationInterface cb) {
        this.callback = cb;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_partidos, container, false);
        listAdapter = new ListAdapterPartidos(getActivity());
        listAdapter.setOnItemClickListener(partido -> {
            callback.navigateToFragment(FragmentPartido.newInstance(partido));

        });
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.RecycleViewPartidos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(listAdapter);
        viewModel = new PartidosViewModel(this);
        viewModel.damePartidos();
    }

    @Override
    public void partidosListos(List<Partido> partidos) {

        listAdapter.setPartidos(partidos);
    }
}