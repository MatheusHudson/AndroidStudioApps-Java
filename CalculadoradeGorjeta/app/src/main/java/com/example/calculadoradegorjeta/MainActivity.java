package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintsChangedListener;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText gorjetaDefinida;
    private TextView gorjetaValor, gorjetaTotal, textPorcentagem;
    private SeekBar seekGorjeta;
    private double progresso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gorjetaDefinida = findViewById(R.id.gorjetaDefinida);
        gorjetaTotal = findViewById(R.id.totalGorjeta);
        gorjetaValor = findViewById(R.id.gorjetaValor);
        seekGorjeta = findViewById(R.id.seekGorjeta);
        textPorcentagem = findViewById(R.id.textPorcentagem);

        seekGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progresso = i;
                textPorcentagem.setText(Math.round(progresso) + "%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                calculo();
            }
        });


    }
    public Double formatarCasasDecimais(Double valor) {
        DecimalFormat formato = new DecimalFormat("#.##");
        return Double.valueOf(formato.format(valor));

    }


    public void calculo() {

        String gorjeta = gorjetaDefinida.getText().toString();

        if (gorjeta == null || gorjeta.equals("")) {
            Toast.makeText(
                    getApplicationContext(),
                    "Defina o valor da Gorjeta",
                    Toast.LENGTH_LONG
            ).show();
        } else {
            Double gorjetaDefinidaCalc = Double.parseDouble(gorjeta);
            Double gorjetaCalculada = formatarCasasDecimais(gorjetaDefinidaCalc * (progresso / 100));
            gorjetaValor.setText("R$ " + gorjetaCalculada);
            gorjetaTotal.setText("R$ " + formatarCasasDecimais(gorjetaDefinidaCalc + gorjetaCalculada));
        }


    }


}