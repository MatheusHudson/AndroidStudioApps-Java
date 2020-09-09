package com.example.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    private ImageView imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        imagem = findViewById(R.id.imagem);


        Bundle dados = getIntent().getExtras();
        int numeroA = dados.getInt("numeroAleatorio");


        if(numeroA == 0) {
            imagem.setImageResource(R.drawable.moeda_cara);
        } else {
            imagem.setImageResource(R.drawable.moeda_coroa);
        }


    }


    public void botaoVoltar(View view) {
        finish();
    }

}