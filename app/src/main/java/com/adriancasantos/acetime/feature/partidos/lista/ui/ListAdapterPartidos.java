package com.adriancasantos.acetime.feature.partidos.lista.ui;

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
import com.adriancasantos.acetime.feature.partidos.model.Partido;
import java.util.ArrayList;
import java.util.List;

public class ListAdapterPartidos extends RecyclerView.Adapter<ListAdapterPartidos.ViewHolder> {

    private List<Partido> partidos;
    private LayoutInflater inflater;
    private Context context;

    private OnItemClickListener listener;

    public ListAdapterPartidos(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.partidos = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return partidos.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ListAdapterPartidos.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_element_partido, parent, false);
        return new ListAdapterPartidos.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapterPartidos.ViewHolder holder, final int position) {
        holder.bindData(partidos.get(position));
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imagen;
        TextView titulo, subtitulo, fecha, estadio;

        ViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.titulo);
            imagen = itemView.findViewById(R.id.image_view);
            subtitulo = itemView.findViewById(R.id.subtitulo);
            fecha = itemView.findViewById(R.id.fecha);
            estadio = itemView.findViewById(R.id.estadio);
            itemView.setOnClickListener((view -> {
                if (listener != null) {
                    listener.onItemClick(partidos.get(getAdapterPosition()));
                }
            }));
        }

        void bindData(@NonNull final Partido partido) {
            imagen.setImageResource(partido.getImagenPartido());
            titulo.setText(partido.getJugador1() + " vs " + partido.getJugador2());
            subtitulo.setText(partido.getTorneo());
            fecha.setText(partido.getFecha().substring(0, 10));
            estadio.setText(partido.getEstadio());
        }
    }
}