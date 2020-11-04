package com.example.minhasanatoes;

import android.os.Bundle;

import com.example.minhasanatoes.classes.AnotacoesPreferencias;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private AnotacoesPreferencias preferencias;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferencias = new AnotacoesPreferencias(getApplicationContext());
        editText = findViewById(R.id.editAnatocao);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoRecuperado = editText.getText().toString();

                if(textoRecuperado.equals("")){
                    Snackbar.make(view, "Preencha sua Anatoção", Snackbar.LENGTH_LONG).show();
                }else {
                    preferencias.salvarAntaocao(textoRecuperado);
                    Snackbar.make(view, "Anotação salva!", Snackbar.LENGTH_LONG).show();
                }

            }
        });

        //Recuperar antação
        String anotacao = preferencias.recuperarAnatocao();
        if(!anotacao.equals("")) {
            editText.setText(anotacao);
            }

    }


}