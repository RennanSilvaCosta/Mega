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

public class FifhtQuestion extends AppCompatActivity {

    int quantidadeMaquinas = 0;
    private Button fifth_btn;
    ArrayList<Integer> quantidades = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifht_question);
        initializeComponents();

        Intent i = getIntent();
        quantidades = i.getIntegerArrayListExtra("quantidades");

        fifth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FifhtQuestion.this, SixthQuestion.class);
                quantidades.add(quantidadeMaquinas);
                i.putIntegerArrayListExtra("quantidades", quantidades);
                startActivity(i);
                finish();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
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
                    showDialog();
                }
                break;
        }
    }

    private void initializeComponents() {
        fifth_btn = findViewById(R.id.fifth_btnNext);
    }

    private void showDialog() {
        final Dialog d = new Dialog(FifhtQuestion.this);
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
                quantidadeMaquinas = np.getValue();
                d.dismiss();
            }
        });
        d.show();
    }
}