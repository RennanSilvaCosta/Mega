package com.cestadefrutas.mega.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cestadefrutas.mega.R;
import com.cestadefrutas.mega.model.Answer;
import com.cestadefrutas.mega.util.Constantes;

import java.util.List;

public class AdapterAnswer extends RecyclerView.Adapter<AdapterAnswer.MyViewHolder> {

    Context context;
    List<Answer> respostas;

    public AdapterAnswer(List<Answer> respostas, Context context) {
        this.respostas = respostas;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_answer, parent, false);
        return new AdapterAnswer.MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Answer resposta = respostas.get(position);
        if (resposta.getKey().equals("televisao")) {
            holder.txtQuantidade.setText("Quantidade de televisões informada: " + resposta.getValue());
            holder.txtMega.setText("Quantidade de megas sugerido: " + (resposta.getValue() * Constantes.QUANTIDADE_MEGA_PARA_TELEVISAO));
            holder.imgKey.setImageResource(R.drawable.icon_smarttv);
        } else if (resposta.getKey().equals("videoGame")) {
            holder.txtQuantidade.setText("Quantidade de video games informada: " + resposta.getValue());
            holder.txtMega.setText("Quantidade de megas sugerido: " + (resposta.getValue() * Constantes.QUANTIDADE_MEGA_PARA_VIDEOGAME));
            holder.imgKey.setImageResource(R.drawable.icon_controle_videogame);
        } else if (resposta.getKey().equals("celular")) {
            holder.txtQuantidade.setText("Quantidade de celulares informada: " + resposta.getValue());
            holder.txtMega.setText("Quantidade de megas sugerido: " + (resposta.getValue() * Constantes.QUANTIDADE_MEGA_PARA_CELULAR));
            holder.imgKey.setImageResource(R.drawable.icon_smartphone);
        } else if (resposta.getKey().equals("computador")) {
            holder.txtQuantidade.setText("Quantidade de computadores informada: " + resposta.getValue());
            holder.txtMega.setText("Quantidade de megas sugerido: " + (resposta.getValue() * Constantes.QUANTIDADE_MEGA_PARA_COMPUTADOR));
            holder.imgKey.setImageResource(R.drawable.icon_computador);
        } else if (resposta.getKey().equals("maquina")) {
            holder.txtQuantidade.setText("Quantidade de maquininhas informada: " + resposta.getValue());
            holder.txtMega.setText("Quantidade de megas sugerido: " + (resposta.getValue() * Constantes.QUANTIDADE_MEGA_PARA_MAQUINA));
            holder.imgKey.setImageResource(R.drawable.icon_maquininha);
        } else if (resposta.getKey().equals("roteador")) {
            holder.txtQuantidade.setText("Um roteador adicional pode ser necessário!");
            holder.txtMega.setText("Comodos: " + resposta.getValue() + " Andares: " + resposta.getSecondValue());
            holder.imgKey.setImageResource(R.drawable.icon_roteador);
        }
    }

    @Override
    public int getItemCount() {
        return respostas.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtQuantidade, txtMega;
        ImageView imgKey;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtQuantidade = itemView.findViewById(R.id.txtQuantidade);
            txtMega = itemView.findViewById(R.id.txtMega);
            imgKey = itemView.findViewById(R.id.imgKey);
        }
    }
}
