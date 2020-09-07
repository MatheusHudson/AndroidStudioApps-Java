package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jo(View view) {
        opcaoSelecionada("pedra");
    }

    public void ken(View view) {
        opcaoSelecionada("papel");
    }

    public void po(View view) {
        opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcao) {
        TextView textResult = findViewById(R.id.textResult);
        ImageView imageApp = findViewById(R.id.appAction);
        int a = new Random().nextInt(3);
        String[] stringOption = {"pedra", "papel", "tesoura"};
        String appOption = stringOption[a];

        switch (appOption) {
            case "pedra" :
                imageApp.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                imageApp.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                imageApp.setImageResource(R.drawable.tesoura);
                break;
        }
        if (
                (appOption=="pedra" && opcao=="tesoura") ||
                        (appOption=="papel" && opcao=="pedra") ||
                        (appOption=="tesoura" && opcao=="papel")
        ){//App ganhador
            textResult.setText("Você perdeu :( ");
        }else if (
                (opcao=="pedra" && appOption=="tesoura") ||
                        (opcao=="papel" && appOption=="pedra") ||
                        (opcao=="tesoura" && appOption=="papel")
        ){//Usuario ganhador
            textResult.setText("Você ganhou :) ");
        }else {//Empate
            textResult.setText("Empatamos ;) ");
        }

    }


}