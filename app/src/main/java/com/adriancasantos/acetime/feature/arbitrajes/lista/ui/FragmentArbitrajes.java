package com.adriancasantos.acetime.feature.arbitrajes.lista.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adriancasantos.acetime.NavigationInterface;
import com.adriancasantos.acetime.R;
import com.adriancasantos.acetime.feature.arbitraje.model.Arbitraje;
import com.adriancasantos.acetime.feature.arbitrajes.detalle.ui.FragmentArbitraje;
import com.adriancasantos.acetime.feature.arbitrajes.lista.viewmodel.ArbitrajesViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentArbitrajes extends Fragment implements ArbitrajesView {

    ListAdapterArbitrajes listAdapterArbitrajes;
    ArrayList<Arbitraje> arbitrajes;
    NavigationInterface callback;
    ArbitrajesViewModel viewModel;

    public FragmentArbitrajes(NavigationInterface cb) {this.callback =cb;}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_arbitrajes, container, false);
        listAdapterArbitrajes = new ListAdapterArbitrajes(getActivity());
        listAdapterArbitrajes.setOnItemClickListener(arbitraje -> {
            callback.navigateToFragment(FragmentArbitraje.newInstance(arbitraje));

        });
        listAdapterArbitrajes.setOnItemDeleteClickListener(arbitraje -> viewModel.eliminaArbitraje(arbitraje));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.RecycleViewArbitrajes);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(listAdapterArbitrajes);
        viewModel = new ArbitrajesViewModel(this, getActivity().getApplicationContext());
        viewModel.dameArbitrajes();
    }

    @Override
    public void arbitrajesListos(List<Arbitraje> arbitrajes) {

        listAdapterArbitrajes.setArbitrajes(arbitrajes);


    }


}