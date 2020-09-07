package com.example.cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.cardview.R;
import com.example.cardview.adapter.Adapter;
import com.example.cardview.model.Postagens;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagens> listaPostagens = new ArrayList<>();
    private ImageView imagemPostagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerView);
        imagemPostagem = findViewById(R.id.imagemPostagem);
        //Postagens
        criarPostagens();


        //Configurar adapter
        Adapter adapter = new com.example.cardview.adapter.Adapter(listaPostagens);


        //Define Layout

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        recyclerPostagem.setLayoutManager(layoutManager);
        recyclerPostagem.setHasFixedSize(true);
        recyclerPostagem.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        //define adapter

        recyclerPostagem.setAdapter(adapter);


    }


    public void criarPostagens() {

        Postagens postagem = new Postagens("Matheus Hudson", "Agora Mesmo", "#viagemExcelente", R.drawable.imagem1);
        this.listaPostagens.add(postagem);

        postagem = new Postagens("Matheus Hudson", "Dois Dias", "Foto tirado pelo Galaxy S10", R.drawable.imagem2);
        this.listaPostagens.add(postagem);

        postagem = new Postagens("Matheus Hudson", "Três Dias", "Excelente paisagem", R.drawable.imagem3);
        this.listaPostagens.add(postagem);

        postagem = new Postagens("Matheus Hudson", "Quatro Dias", "#fotodequalidade", R.drawable.imagem4);
        this.listaPostagens.add(postagem);

    }


}