package com.cestadefrutas.mega.activities;

import androidx.appcompat.app.AppCompatActivity;
import com.cestadefrutas.mega.R;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;

import java.util.ArrayList;

public class SeventhQuestion extends AppCompatActivity {

    private Button seventh_btnNext;
    private int quantidadeAndares =1;
    private ArrayList<Integer> quantidades = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh_question);
        initializeComponents();

        Intent i = getIntent();
        quantidades = i.getIntegerArrayListExtra("quantidades");

        seventh_btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SeventhQuestion.this, EighthQuestion.class);
                quantidades.add(quantidadeAndares);
                i.putIntegerArrayListExtra("quantidades", quantidades);
                startActivity(i);
                finish();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
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
                    showDialog();
                }
                break;
        }
    }

    private void initializeComponents() {
        seventh_btnNext = findViewById(R.id.seventh_btnNext);
    }

    private void showDialog() {
        final Dialog d = new Dialog(SeventhQuestion.this);
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
                quantidadeAndares = np.getValue();
                d.dismiss();
            }
        });
        d.show();
    }

}