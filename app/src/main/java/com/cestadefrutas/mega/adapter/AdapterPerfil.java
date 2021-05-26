package com.cestadefrutas.mega.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cestadefrutas.mega.R;
import com.github.islamkhsh.CardSliderAdapter;

import java.util.List;

import static com.cestadefrutas.mega.util.Constantes.QUANTIDADE_MEGA_PARA_COMERCIANTE;
import static com.cestadefrutas.mega.util.Constantes.QUANTIDADE_MEGA_PARA_ESTUDANTE;
import static com.cestadefrutas.mega.util.Constantes.QUANTIDADE_MEGA_PARA_GAMES;
import static com.cestadefrutas.mega.util.Constantes.QUANTIDADE_MEGA_PARA_HOMEOFFICE;
import static com.cestadefrutas.mega.util.Constantes.QUANTIDADE_MEGA_PARA_REDE_SOCIAIS;
import static com.cestadefrutas.mega.util.Constantes.QUANTIDADE_MEGA_PARA_STREMAR;
import static com.cestadefrutas.mega.util.Constantes.QUANTIDADE_MEGA_PARA_STREMING;

public class AdapterPerfil extends CardSliderAdapter<AdapterPerfil.MovieViewHolder> {

    private List<String> perfils;

    public AdapterPerfil(List<String> perfis) {
        this.perfils = perfis;
    }

    @Override
    public int getItemCount() {
        return perfils.size();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_perfil, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void bindVH(MovieViewHolder movieViewHolder, int i) {
        String perfil = perfils.get(i);
        movieViewHolder.txtResume.setText(perfil);
        if (perfil.equals("Comerciante")) {
            movieViewHolder.img.setImageResource(R.drawable.ic_perfil_comerciante);
            movieViewHolder.txtDescricao.setText("Para o seu comercio recomendamos " + QUANTIDADE_MEGA_PARA_COMERCIANTE + " Megas");
        } else if (perfil.equals("Gamer")) {
            movieViewHolder.img.setImageResource(R.drawable.ic_perfil_gamer);
            movieViewHolder.txtDescricao.setText("Para os seus games recomendamos " + QUANTIDADE_MEGA_PARA_GAMES + " Megas");
        } else if (perfil.equals("Streming")) {
            movieViewHolder.img.setImageResource(R.drawable.ic_perfil_streming);
            movieViewHolder.txtDescricao.setText("Para suas lives recomendamos " + QUANTIDADE_MEGA_PARA_STREMING + " Megas");
        } else if (perfil.equals("Stremer")) {
            movieViewHolder.img.setImageResource(R.drawable.ic_perfil_streamer);
            movieViewHolder.txtDescricao.setText("Para fazer suas lives recomendamos " + QUANTIDADE_MEGA_PARA_STREMAR + " Megas");
        } else if (perfil.equals("Home Office")) {
            movieViewHolder.img.setImageResource(R.drawable.ic_perfil_homeoffice);
            movieViewHolder.txtDescricao.setText("Para o seu Home Office recomendamos " + QUANTIDADE_MEGA_PARA_HOMEOFFICE + " Megas");
        } else if (perfil.equals("Redes Sociais")) {
            movieViewHolder.img.setImageResource(R.drawable.ic_perfil_redes_sociais);
            movieViewHolder.txtDescricao.setText("Para suas redes socias recomendamos " + QUANTIDADE_MEGA_PARA_REDE_SOCIAIS + " Megas");
        } else if (perfil.equals("Estudante")) {
            movieViewHolder.img.setImageResource(R.drawable.ic_perfil_estudante);
            movieViewHolder.txtDescricao.setText("Para seus estudos recomendamos " +   QUANTIDADE_MEGA_PARA_ESTUDANTE + " Megas");
        }
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView txtResume, txtDescricao;
        ImageView img;

        public MovieViewHolder(View view) {
            super(view);
            txtResume = view.findViewById(R.id.txtPerfil);
            img = view.findViewById(R.id.img);
            txtDescricao = view.findViewById(R.id.txtDescricao);
        }

    }
}
