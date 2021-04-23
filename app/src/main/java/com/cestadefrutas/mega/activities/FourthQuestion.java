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

public class FourthQuestion extends AppCompatActivity {

    private int quantidadeComputadores = 0;
    private Button fourth_btn;
    private ArrayList<Integer> quantidades = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_question);
        initializeComponents();

        Intent i = getIntent();
        quantidades = i.getIntegerArrayListExtra("quantidades");

        fourth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FourthQuestion.this, FifhtQuestion.class);
                quantidades.add(quantidadeComputadores);
                i.putIntegerArrayListExtra("quantidades", quantidades);
                startActivity(i);
                finish();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
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
                    showDialog();
                }
                break;
        }
    }

    private void initializeComponents() {
        fourth_btn = findViewById(R.id.fourth_btnNext);
    }

    private void showDialog() {
        final Dialog d = new Dialog(FourthQuestion.this);
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
                quantidadeComputadores = np.getValue();
                d.dismiss();
            }
        });
        d.show();
    }

}