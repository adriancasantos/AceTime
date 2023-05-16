package com.adriancasantos.acetime.feature.arbitrajes.lista.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.adriancasantos.acetime.R;
import com.adriancasantos.acetime.feature.arbitraje.model.Arbitraje;
import java.util.ArrayList;
import java.util.List;

public class ListAdapterArbitrajes extends RecyclerView.Adapter<ListAdapterArbitrajes.ViewHolder> {

    private List<Arbitraje> arbitrajes;
    private LayoutInflater inflater;
    private Context context;

    private OnItemClickListener listener;
    private OnItemClickListener deleteListener;

    public ListAdapterArbitrajes(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.arbitrajes = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return arbitrajes.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setOnItemDeleteClickListener(OnItemClickListener deleteListener) {
        this.deleteListener = deleteListener;
    }

    @Override
    public ListAdapterArbitrajes.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_element_arbitraje, parent, false);
        return new ListAdapterArbitrajes.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapterArbitrajes.ViewHolder holder,
            final int position) {
        holder.bindData(arbitrajes.get(position));
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setArbitrajes(List<Arbitraje> arbitrajes) {
        this.arbitrajes = arbitrajes;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titulo, fecha, torneo;
        ImageView btnEliminar;

        ViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.titulo);
            fecha = itemView.findViewById(R.id.fecha);
            torneo = itemView.findViewById(R.id.torneo);
            btnEliminar = itemView.findViewById(R.id.btnEliminar);

            itemView.setOnClickListener(view -> {
                if (listener != null) {
                    listener.onItemClick(arbitrajes.get(getAdapterPosition()));
                }
            });
            btnEliminar.setOnClickListener(view ->
            {
                if (deleteListener != null) {
                    deleteListener.onItemClick(arbitrajes.get(getAdapterPosition()));
                }
            });

        }

        void bindData(@NonNull final Arbitraje arbitraje) {
            titulo.setText(arbitraje.getNombreJ1() + " vs " + arbitraje.getNombreJ2());
            fecha.setText(arbitraje.getFechaPartido().substring(0, 10));
            torneo.setText(arbitraje.getTorneo());
        }
    }
}
