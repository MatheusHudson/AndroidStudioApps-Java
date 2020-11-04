package com.example.minhasanatoes.classes;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacoesPreferencias {
    private  Context context;
    private SharedPreferences preferences;
    private final String NOME_ARQUIVO = "anotacao.preferencias";
    private SharedPreferences.Editor editor;
    private final String CHAVE_NOME = "nome";

    public  AnotacoesPreferencias (Context c) {
            this.context = c;
            preferences = context.getSharedPreferences(NOME_ARQUIVO, 0);
            editor = preferences.edit();

    }

    public void salvarAntaocao(String anotacao) {
        editor.putString(CHAVE_NOME, anotacao );
        editor.commit();

    }

    public String recuperarAnatocao() {
        return preferences.getString(CHAVE_NOME, "");
    }

}
