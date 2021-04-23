package com.cestadefrutas.mega.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;

import com.cestadefrutas.mega.R;

import java.util.ArrayList;

public class ThirdQuestion extends AppCompatActivity {

    private int quantidadeCelulares = 0;
    private Button third_btnNext;
    private ArrayList<Integer> quantidades = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_question);
        initializeComponents();

        Intent i = getIntent();
        quantidades = i.getIntegerArrayListExtra("quantidades");

        third_btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ThirdQuestion.this, FourthQuestion.class);
                quantidades.add(quantidadeCelulares);
                i.putIntegerArrayListExtra("quantidades", quantidades);
                startActivity(i);
                finish();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
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
                    showDialog();
                }
                break;
        }
    }

    private void initializeComponents() {
        third_btnNext = findViewById(R.id.third_btnNext);
    }

    private void showDialog() {
        final Dialog d = new Dialog(ThirdQuestion.this);
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
                quantidadeCelulares = np.getValue();
                d.dismiss();
            }
        });
        d.show();
    }
}