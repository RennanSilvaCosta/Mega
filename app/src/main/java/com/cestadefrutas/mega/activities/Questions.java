package com.cestadefrutas.mega.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.cestadefrutas.mega.R;
import com.cestadefrutas.mega.util.Constantes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Questions extends AppCompatActivity {

    private Button btnNext;
    private ArrayList<Integer> quantidades = new ArrayList<>();
    private int quantidadeTelevisao = 0, quantidadeVideogames = 0, quantidadeCelulares = 0, quantidadeComputadores = 0, quantidadeMaquinas = 0, quantidadeComodos = 0, quantidadeAndares = 0;
    private ArrayList<String> perfis = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        initializeComponents();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popularListQuantidade();
                Intent i = new Intent(Questions.this, ResultScreen.class);
                i.putIntegerArrayListExtra("quantidades", quantidades);
                i.putStringArrayListExtra("perfis", perfis);
                startActivity(i);
                finish();
            }
        });
    }

    private void popularListQuantidade() {
        quantidades.add(quantidadeTelevisao);
        quantidades.add(quantidadeVideogames);
        quantidades.add(quantidadeCelulares);
        quantidades.add(quantidadeComputadores);
        quantidades.add(quantidadeMaquinas);
        quantidades.add(quantidadeComodos);
        quantidades.add(quantidadeAndares);
    }

    private void initializeComponents() {
        btnNext = findViewById(R.id.btnCalcular);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.first_qtd0:
                if (checked) {
                    quantidadeTelevisao = 0;
                }
                break;
            case R.id.first_qtd1:
                if (checked) {
                    quantidadeTelevisao = 1;
                }
                break;
            case R.id.first_qtd2:
                if (checked) {
                    quantidadeTelevisao = 2;
                }
                break;
            case R.id.first_qtd3:
                if (checked) {
                    quantidadeTelevisao = 3;
                }
                break;
            case R.id.first_qtdMais3:
                if (checked) {
                    showDialog("televisao");
                }
                break;
            case R.id.second_qtd0:
                if (checked) {
                    quantidadeVideogames = 0;
                }
                break;
            case R.id.second_qtd1:
                if (checked) {
                    quantidadeVideogames = 1;
                }
                break;
            case R.id.second_qtd2:
                if (checked) {
                    quantidadeVideogames = 2;
                }
                break;
            case R.id.second_qtd3:
                if (checked) {
                    quantidadeVideogames = 3;
                }
                break;
            case R.id.second_qtdMais3:
                if (checked) {
                    showDialog("videogame");
                }
                break;
            case R.id.third_qtd0:
                if (checked) {
                    quantidadeCelulares = 0;
                }
                break;
            case R.id.third_qtd1:
                if (checked) {
                    quantidadeCelulares = 1;
                }
                break;
            case R.id.third_qtd2:
                if (checked) {
                    quantidadeCelulares = 2;
                }
                break;
            case R.id.third_qtd3:
                if (checked) {
                    quantidadeCelulares = 3;
                }
                break;
            case R.id.third_qtdMais3:
                if (checked) {
                    showDialog("celular");
                }
                break;
            case R.id.fourth_qtd0:
                if (checked) {
                    quantidadeComputadores = 0;
                }
                break;
            case R.id.fourth_qtd1:
                if (checked) {
                    quantidadeComputadores = 1;
                }
                break;
            case R.id.fourth_qtd2:
                if (checked) {
                    quantidadeComputadores = 2;
                }
                break;
            case R.id.fourth_qtd3:
                if (checked) {
                    quantidadeComputadores = 3;
                }
                break;
            case R.id.fourth_qtdMais3:
                if (checked) {
                    showDialog("computador");
                }
                break;
            case R.id.fifth_qtd0:
                if (checked) {
                    quantidadeMaquinas = 0;
                }
                break;
            case R.id.fifth_qtd1:
                if (checked) {
                    quantidadeMaquinas = 1;
                }
                break;
            case R.id.fifth_qtd2:
                if (checked) {
                    quantidadeMaquinas = 2;
                }
                break;
            case R.id.fifth_qtd3:
                if (checked) {
                    quantidadeMaquinas = 3;
                }
                break;
            case R.id.fifth_qtdMais3:
                if (checked) {
                    showDialog("maquina");
                }
                break;
            case R.id.sixth_qtd1:
                if (checked) {
                    quantidadeComodos = 1;
                }
                break;
            case R.id.sixth_qtd2:
                if (checked) {
                    quantidadeComodos = 2;
                }
                break;
            case R.id.sixth_qtd3:
                if (checked) {
                    quantidadeComodos = 3;
                }
                break;
            case R.id.sixth_qtd4:
                if (checked) {
                    quantidadeComodos = 4;
                }
                break;
            case R.id.sixth_qtdMais4:
                if (checked) {
                    showDialog("comodo");
                }
                break;
            case R.id.seventh_qtd1:
                if (checked) {
                    quantidadeAndares = 1;
                }
                break;
            case R.id.seventh_qtd2:
                if (checked) {
                    quantidadeAndares = 2;
                }
                break;
            case R.id.seventh_qtd3:
                if (checked) {
                    quantidadeAndares = 3;
                }
                break;
            case R.id.seventh_qtdMais3:
                if (checked) {
                    showDialog("andar");
                }
                break;
        }
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkbox_homeoffice:
                if (checked) {
                    perfis.add(Constantes.PERFIL_HOMEOFFICE);
                } else {
                    perfis.remove(perfis.indexOf(Constantes.PERFIL_HOMEOFFICE));
                }
                break;
            case R.id.checkbox_gamer:
                if (checked) {
                    perfis.add(Constantes.PERFIL_GAMER);
                } else {
                    perfis.remove(perfis.indexOf(Constantes.PERFIL_GAMER));
                }
                break;
            case R.id.checkbox_streming:
                if (checked) {
                    perfis.add(Constantes.PERFIL_STREMING);

                } else {
                    perfis.remove(perfis.indexOf(Constantes.PERFIL_STREMING));
                }
                break;
            case R.id.checkbox_stremer:
                if (checked) {
                    perfis.add(Constantes.PERFIL_STREMER);
                } else {
                    perfis.remove(perfis.indexOf(Constantes.PERFIL_STREMER));
                }
                break;
            case R.id.checkbox_comercio:
                if (checked) {
                    perfis.add(Constantes.PERFIL_COMERCIANTE);
                } else {
                    perfis.remove(perfis.indexOf(Constantes.PERFIL_COMERCIANTE));
                }
                break;
            case R.id.checkbox_redes_sociais:
                if (checked) {
                    perfis.add(Constantes.PERFIL_REDE_SOCIAIS);
                } else {
                    perfis.remove(perfis.indexOf(Constantes.PERFIL_REDE_SOCIAIS));
                }
                break;
            case R.id.checkbox_estudante:
                if (checked) {
                    perfis.add(Constantes.PERFIL_ESTUDANTE);
                } else {
                    perfis.remove(perfis.indexOf(Constantes.PERFIL_ESTUDANTE));
                }
                break;
        }
    }

    private void showDialog(String device) {
        final Dialog d = new Dialog(Questions.this);
        d.setTitle("NumberPicker");
        d.setContentView(R.layout.dialog);
        Button b1 = (Button) d.findViewById(R.id.button1);
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
        np.setMaxValue(100);
        np.setMinValue(4);
        np.setWrapSelectorWheel(false);
        //np.setOnValueChangedListener(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (device.equals("televisao")) {
                    quantidadeTelevisao = np.getValue();
                    d.dismiss();
                } else if (device.equals("videogame")) {
                    quantidadeVideogames = np.getValue();
                    d.dismiss();
                } else if (device.equals("celular")) {
                    quantidadeCelulares = np.getValue();
                    d.dismiss();
                } else if (device.equals("computador")) {
                    quantidadeComputadores = np.getValue();
                    d.dismiss();
                } else if (device.equals("maquina")) {
                    quantidadeMaquinas = np.getValue();
                    d.dismiss();
                } else if (device.equals("comodo")) {
                    quantidadeComodos = np.getValue();
                    d.dismiss();
                } else if (device.equals("andar")) {
                    quantidadeAndares = np.getValue();
                    d.dismiss();
                }
            }
        });
        d.show();
    }

}