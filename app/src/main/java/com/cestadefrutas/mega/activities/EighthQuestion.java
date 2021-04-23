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

public class EighthQuestion extends AppCompatActivity {

    private Button eighth_btnNext;
    private String perfil = "Casual";
    private ArrayList<Integer> quantidades = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eighth_question);

        initializeComponents();

        Intent i = getIntent();
        quantidades = i.getIntegerArrayListExtra("quantidades");

        eighth_btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EighthQuestion.this, ResultScreen.class);
                i.putIntegerArrayListExtra("quantidades", quantidades);
                i.putExtra("perfil", perfil);
                startActivity(i);
                finish();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.first_alternative:
                if (checked) {
                    perfil = "Home Office";
                }
                break;
            case R.id.second_alternative:
                if (checked) {
                    perfil = "Gamer";
                }
                break;
            case R.id.third_alternative:
                if (checked) {
                    perfil = "Casual";
                }
                break;
            case R.id.fourth_alternative:
                if (checked) {
                    perfil = "Stremer";
                }
                break;
            case R.id.fifth_alternative:
                if (checked) {
                    perfil = "Comerciante";
                }
                break;
        }
    }

    private void initializeComponents() {
        eighth_btnNext = findViewById(R.id.eighth_btnNext);
    }

}