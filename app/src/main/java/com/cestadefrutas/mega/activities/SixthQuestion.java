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

public class SixthQuestion extends AppCompatActivity {

    private Button sixth_btnNext;
    private int quantidadeComodos =1;
    private ArrayList<Integer> quantidades = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth_question);
        initializeComponents();

        Intent i = getIntent();
        quantidades = i.getIntegerArrayListExtra("quantidades");

        sixth_btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SixthQuestion.this, SeventhQuestion.class);
                quantidades.add(quantidadeComodos);
                i.putIntegerArrayListExtra("quantidades", quantidades);
                startActivity(i);
                finish();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
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
                    showDialog();
                }
                break;
        }
    }

    private void initializeComponents() {
        sixth_btnNext = findViewById(R.id.sixth_btnNext);
    }

    private void showDialog() {
        final Dialog d = new Dialog(SixthQuestion.this);
        d.setTitle("NumberPicker");
        d.setContentView(R.layout.dialog);
        Button b1 = (Button) d.findViewById(R.id.button1);
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
        np.setMaxValue(100);
        np.setMinValue(5);
        np.setWrapSelectorWheel(false);
        //np.setOnValueChangedListener(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantidadeComodos = np.getValue();
                d.dismiss();
            }
        });
        d.show();
    }
}