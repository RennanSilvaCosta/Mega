package com.cestadefrutas.mega.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.cestadefrutas.mega.R;

import java.util.ArrayList;

public class FirstQuestion extends AppCompatActivity {

    private Button btnNext;
    private ArrayList<Integer> quantidades = new ArrayList<>();
    private int quantidadeTelevisao = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);
        initializeComponents();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FirstQuestion.this, SecondQuestion.class);
                quantidades.add(quantidadeTelevisao);
                i.putIntegerArrayListExtra("quantidades", quantidades);
                startActivity(i);
                finish();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.first_qtd0:
                if (checked) {
                    quantidadeTelevisao = 0;
                    System.out.println("teste!");
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
                    showDialog();
                }
                break;
        }
    }

    private void initializeComponents() {
        btnNext = findViewById(R.id.btnNext);
    }

    private void showDialog() {
        final Dialog d = new Dialog(FirstQuestion.this);
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
                quantidadeTelevisao = np.getValue();
                d.dismiss();
            }
        });
        d.show();
    }
}