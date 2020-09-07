package activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

import adapter.Adapter;
import model.Filme;
import model.RecyclerItemClickListener;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        //Listagem de filmes
        criarFilmes();


        //Configurar adapter
        Adapter adapter = new Adapter(listaFilmes);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //evento de click
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);

                            Toast.makeText(
                                    getApplicationContext(),
                                    "Item pressionado: " + filme.getTituloFilme(),
                                    Toast.LENGTH_LONG
                            ).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Click Longo: " + filme.getTituloFilme(),
                                    Toast.LENGTH_LONG
                            ).show();
                        }

                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        }
                    }
            )

        );


    }

    public void criarFilmes() {
        Filme filme = new Filme("Homen Aranha", "Aventura", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Liga da Justiça", "Aventura", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("It - A Coisa", "Terror/Drama", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Velozes e Furiosos", "Aventura", "2012");
        this.listaFilmes.add(filme);

        filme = new Filme("Need for Speed", "Aventura", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("O Senhor dos Anéis", "Aventura", "2001");
        this.listaFilmes.add(filme);

        filme = new Filme("Invocação do mal", "Terror", "2013");
        this.listaFilmes.add(filme);

        filme = new Filme("Vingadores", "Aventura", "2012");
        this.listaFilmes.add(filme);

        filme = new Filme("Coringa", "Aventura", "2013");
        this.listaFilmes.add(filme);

        filme = new Filme("Batman o Cavaleiro das Trevas", "Aventura", "2012");
        this.listaFilmes.add(filme);

        filme = new Filme("Hobbit", "Aventura", "2018");
        this.listaFilmes.add(filme);

        filme = new Filme("Guardiões da Galaxia", "Aventura", "2014");
        this.listaFilmes.add(filme);

    }


}