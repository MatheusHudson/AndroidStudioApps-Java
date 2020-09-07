package com.example.cardview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardview.R;
import com.example.cardview.model.Postagens;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Postagens> listaPostagens;


    public Adapter(List<Postagens> lista){
        this.listaPostagens = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter, parent, false
        );

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Postagens postagens = listaPostagens.get(position);
        holder.tituloPostagem.setText(postagens.getPostagemTitulo());
        holder.textoHorario.setText(postagens.getPostagemHorario());
        holder.textoComentario.setText(postagens.getPostagemComentario());
        holder.imagemPostagem.setImageResource(postagens.getPostagemImagem());

    }

    @Override
    public int getItemCount() {
        return listaPostagens.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {

         private TextView tituloPostagem,textoHorario, textoComentario;
         private ImageView imagemPostagem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tituloPostagem = itemView.findViewById(R.id.textTitulo);
            textoHorario = itemView.findViewById(R.id.textHorario);
            textoComentario = itemView.findViewById(R.id.textComentario);
            imagemPostagem = itemView.findViewById(R.id.imagemPostagem);

        }
    }




}
