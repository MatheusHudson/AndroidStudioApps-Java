package com.example.frasedodia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public class array {

    }

    public void mudarFrase(View view) {
        String frases[] = {"Seja estranho. Seja aleatório. Seja quem você é. Porque você nunca sabe quem amaria a pessoa que você esconde.",
                "A vida é um caos aleatório,ordenada pelo tempo.",
                "A verdade, é que dói lembrar dela.",
                "O aleatório não existe, nosso cérebro sempre toma decisões mesmo que ocultas.",
                "Um ato aleatório de bondade, por menor que seja, pode ter um tremendo impacto na vida de outra pessoa.",
                "Faça a pessoa que você gosta se sentir especial ao invés de só mais uma.",
                "Cada instante é sempre.",
                "O universo não é aleatório. As coisas acontecem porque as pessoas querem assim.",
                "No mundo do aleatório a ordem é não se preocupar."};
        TextView frase = findViewById(R.id.frases);
        int a = new Random().nextInt(frases.length);
        frase.setText(frases[a]);



    }



}