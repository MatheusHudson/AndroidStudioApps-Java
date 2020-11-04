package com.example.listadetarefas;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

import model.TarefaDAO;
import model.Tarefas;

public class AdicionarTarefas extends AppCompatActivity {
    private EditText editTarefas;
    private View view;
    private Tarefas tarefasAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTarefas = findViewById(R.id.textTarefas);
        view=  findViewById(R.id.adicionarTarefasView);


        // Recuperar tarefa, caso seja edição
        tarefasAtual = (Tarefas) getIntent().getSerializableExtra("tarefaSelecionada");

        // Configurar caixa de texto
        if (tarefasAtual != null) {
            editTarefas.setText(tarefasAtual.getTarefa());
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.ok:
                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
               if(tarefasAtual != null) {
                    String nomeTarefa = editTarefas.getText().toString();
                    if( !nomeTarefa.isEmpty()) {
                        Tarefas tarefas = new Tarefas();
                        tarefas.setTarefa(nomeTarefa);
                        tarefas.setId(tarefasAtual.getId());

                        // Atualizar Banco de dados
                        if(tarefaDAO.atualizar(tarefas)) {
                            Toast.makeText(getApplicationContext(), "Sucesso ao Salvar!", Toast.LENGTH_LONG).show();
                            finish();
                        } else {
                            Snackbar.make(view, "Erro ao atualizar uma tarefa!", Snackbar.LENGTH_LONG ).show();
                        }


                    }
               } else {
                   if (!editTarefas.getText().toString().isEmpty()) {
                       Tarefas tarefa = new Tarefas(editTarefas.getText().toString());
                       if( tarefaDAO.salvar(tarefa)) {
                           Toast.makeText(getApplicationContext(), "Sucesso ao Salvar!", Toast.LENGTH_LONG).show();
                       }
                       finish();
                   } else {
                       Snackbar.make(view, "Preencha uma tarefa!", Snackbar.LENGTH_LONG ).show();
                   }
               }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
