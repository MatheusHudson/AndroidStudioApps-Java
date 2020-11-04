package com.example.listadetarefas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import model.Tarefas;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<Tarefas> listaString;


    public Adapter(List<Tarefas> lista) {

        this.listaString = lista;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {
        Tarefas tarefas = listaString.get(position);
        holder.stringDalista.setText(tarefas.getTarefa());


    }

    @Override
    public int getItemCount() {
        return this.listaString.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView stringDalista;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            stringDalista = itemView.findViewById(R.id.textView);

        }

    }

}
