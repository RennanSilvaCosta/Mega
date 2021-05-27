package com.cestadefrutas.mega.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cestadefrutas.mega.R;
import com.cestadefrutas.mega.adapter.AdapterAnswer;
import com.cestadefrutas.mega.adapter.AdapterPerfil;
import com.cestadefrutas.mega.model.Answer;
import com.cestadefrutas.mega.util.Constantes;
import com.github.islamkhsh.CardSliderViewPager;
import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

import java.util.ArrayList;
import java.util.List;

public class ResultScreen extends AppCompatActivity {

    private ArrayList<Integer> quantidades = new ArrayList<>();
    private ArrayList<String> perfis = new ArrayList<>();
    private TickerView tickerView;
    private Button btnReiniciar;
    private TextView txtNotFound;
    private List<Answer> listaResposta = new ArrayList<>();
    private RecyclerView recyclerViewRespostas;
    private AdapterAnswer adapterAnswer;

    int televisao, videoGame, celular, computador, maquina, comodo, andar, total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        initializeComponents();
        tickerView.setCharacterLists(TickerUtils.provideNumberList());

        Intent i = getIntent();
        quantidades = i.getIntegerArrayListExtra("quantidades");
        perfis = i.getStringArrayListExtra("perfis");

        setMegaToPerfil();

        populateVariablesFromListQuantity();

        populateListForRecyclerView();

        initializeCardSlider();
        initializeRecycler();

        tickerView.setText(String.valueOf(total));

        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultScreen.this, Questions.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void populateVariablesFromListQuantity() {
        //A quantidade de cada aparelho está fortemente ligado ao indice da lista
        televisao = quantidades.get(0);
        videoGame = quantidades.get(1);
        celular = quantidades.get(2);
        computador = quantidades.get(3);
        maquina = quantidades.get(4);
        comodo = quantidades.get(5);
        andar = quantidades.get(6);

        if (televisao == 0 && videoGame == 0 && celular == 0 && computador == 0 && maquina == 0) {
            txtNotFound.setVisibility(View.VISIBLE);
        }
    }

    private void populateListForRecyclerView() {
        if (comodo > 6 || andar > 1) {
            Answer resposta = new Answer();
            resposta.setKey("roteador");
            resposta.setValue(comodo);
            resposta.setSecondValue(andar);
            listaResposta.add(resposta);
        }
        if (televisao > 0) {
            Answer resposta = new Answer();
            resposta.setKey("televisao");
            resposta.setValue(televisao);
            total += televisao * Constantes.QUANTIDADE_MEGA_PARA_TELEVISAO;
            listaResposta.add(resposta);
        }
        if (videoGame > 0) {
            Answer resposta = new Answer();
            resposta.setKey("videoGame");
            resposta.setValue(videoGame);
            total += videoGame * Constantes.QUANTIDADE_MEGA_PARA_VIDEOGAME;
            listaResposta.add(resposta);
        }
        if (celular > 0) {
            Answer resposta = new Answer();
            resposta.setKey("celular");
            resposta.setValue(celular);
            total += celular * Constantes.QUANTIDADE_MEGA_PARA_CELULAR;
            listaResposta.add(resposta);
        }
        if (computador > 0) {
            Answer resposta = new Answer();
            resposta.setKey("computador");
            resposta.setValue(computador);
            total += computador * Constantes.QUANTIDADE_MEGA_PARA_COMPUTADOR;
            listaResposta.add(resposta);
        }
        if (maquina > 0) {
            Answer resposta = new Answer();
            resposta.setKey("maquina");
            resposta.setValue(maquina);
            total += maquina * Constantes.QUANTIDADE_MEGA_PARA_MAQUINA;
            listaResposta.add(resposta);
        }
    }

    private void setMegaToPerfil() {
        for (String perfil : perfis) {
            if (perfil.equals("Comerciante")) {
                total += Constantes.QUANTIDADE_MEGA_PARA_COMERCIANTE;
            } else if (perfil.equals("Gamer")) {
                total += Constantes.QUANTIDADE_MEGA_PARA_GAMES;
            } else if (perfil.equals("Streming")) {
                total += Constantes.QUANTIDADE_MEGA_PARA_STREMING;
            } else if (perfil.equals("Stremer")) {
                total += Constantes.QUANTIDADE_MEGA_PARA_STREMAR;
            } else if (perfil.equals("Home Office")) {
                total += Constantes.QUANTIDADE_MEGA_PARA_HOMEOFFICE;
            } else if (perfil.equals("Redes Sociais")) {
                total += Constantes.QUANTIDADE_MEGA_PARA_REDE_SOCIAIS;
            } else if (perfil.equals("Estudante")) {
                total += Constantes.QUANTIDADE_MEGA_PARA_ESTUDANTE;
            }
        }
    }

    private void initializeComponents() {
        txtNotFound = findViewById(R.id.txtNotFound);
        btnReiniciar = findViewById(R.id.btnReiniciar);
        tickerView = findViewById(R.id.txtResult);
        tickerView.setAnimationDuration(1500);
        recyclerViewRespostas = findViewById(R.id.recyclerViewRespostas);
    }

    private void initializeCardSlider() {
        CardSliderViewPager cardSliderViewPager = findViewById(R.id.cardSlider);
        AdapterPerfil adapter = new AdapterPerfil(perfis);
        cardSliderViewPager.setAdapter(adapter);
    }

    private void initializeRecycler() {
        adapterAnswer = new AdapterAnswer(listaResposta, this);
        recyclerViewRespostas.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewRespostas.setHasFixedSize(true);
        recyclerViewRespostas.setMinimumHeight(300);
        recyclerViewRespostas.setAdapter(adapterAnswer);
    }
}