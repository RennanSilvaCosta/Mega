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

public class SecondQuestion extends AppCompatActivity {

    private Button second_btnNext;
    private int quantidadeVideogames =0;
    private ArrayList<Integer> quantidades = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);

        initializeComponents();

        Intent intent = getIntent();
        quantidades = intent.getIntegerArrayListExtra("quantidades");

        second_btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondQuestion.this, ThirdQuestion.class);
                quantidades.add(quantidadeVideogames);
                intent.putIntegerArrayListExtra("quantidades", quantidades);
                startActivity(intent);
                finish();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.second_qtd:
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
                    showDialog();
                }
                break;
        }
    }

    private void initializeComponents() {
        second_btnNext = findViewById(R.id.second_btnNext);
    }

    private void showDialog() {
        final Dialog d = new Dialog(SecondQuestion.this);
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
                quantidadeVideogames = np.getValue();
                d.dismiss();
            }
        });
        d.show();
    }

}