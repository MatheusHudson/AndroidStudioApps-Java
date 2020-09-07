package com.example.cardview.model;

import android.media.Image;
import android.widget.ImageView;

public class Postagens {
   private String postagemTitulo, postagemHorario, postagemComentario;
   private int postagemImagem;



    public Postagens(String postagemTitulo, String postagemHorario, String postagemComentario, int postagemImagem) {
        this.postagemTitulo = postagemTitulo;
        this.postagemHorario = postagemHorario;
        this.postagemComentario = postagemComentario;
        this.postagemImagem = postagemImagem;
    }




    public String getPostagemTitulo() {
        return postagemTitulo;
    }

    public void setPostagemTitulo(String postagemTitulo) {
        this.postagemTitulo = postagemTitulo;
    }

    public String getPostagemHorario() {
        return postagemHorario;
    }

    public void setPostagemHorario(String postagemHorario) {
        this.postagemHorario = postagemHorario;
    }

    public String getPostagemComentario() {
        return postagemComentario;
    }

    public void setPostagemComentario(String postagemComentario) {
        this.postagemComentario = postagemComentario;
    }

    public int getPostagemImagem() {
        return postagemImagem;
    }

    public void setPostagemImagem(int postagemImagem) {
        this.postagemImagem = postagemImagem;
    }
}
