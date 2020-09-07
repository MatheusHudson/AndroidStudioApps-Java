package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText gasolinaCampo, alcoolCampo;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gasolinaCampo = findViewById(R.id.gasolina);
        alcoolCampo = findViewById(R.id.alcool);
        result = findViewById(R.id.result);

    }

    public void calculoGasolinaVsAlcool(View view) {
        String gasolina =  gasolinaCampo.getText().toString();
        String alcool =  alcoolCampo.getText().toString();





        if (verificarCampos(alcool,gasolina) && (Double.parseDouble(alcool) / Double.parseDouble(gasolina))  >= 0.70){
            result.setText("Melhor usar gasolina!");
        } else if (verificarCampos(alcool,gasolina)){
            result.setText("Melhor usar alcool!");
        }

    }

    public boolean verificarCampos(String alcool, String gasolina) {
        boolean campo = true;
        if(alcool == null || alcool.equals("")  ) {
            campo = false;
            result.setText("Preencha o campo do alcool !!");
        } else if(gasolina == null || gasolina.equals("")) {
            result.setText("Preencha o campo da gasolina !!");
            campo = false;
        }

        return campo;
    }

}