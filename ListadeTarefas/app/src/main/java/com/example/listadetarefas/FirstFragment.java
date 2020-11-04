package com.example.listadetarefas;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import model.RecyclerItemClickListener;
import model.TarefaDAO;
import model.Tarefas;


public class FirstFragment extends Fragment {

    private Context context;
    private View view;
    private RecyclerView recyclerView;
    private List<Tarefas> listaTarefas = new ArrayList<>();
    private Tarefas tarefasSelecionada;
    private Adapter adapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_first, container, false);
        //Listagem de tarefas
        recyclerView = view.findViewById(R.id.recyclerView);


        //Configurar adapter


        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayout.VERTICAL));

        //evento de click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        context,
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onLongItemClick(View view, int position) {

                                tarefasSelecionada = listaTarefas.get(position);


                                AlertDialog.Builder dialog = new AlertDialog.Builder(context);

                                dialog.setTitle("Confirmar Exclusão");
                                dialog.setMessage("Deseja excluir a tarefa: " + tarefasSelecionada.getTarefa() + " ?");

                                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        TarefaDAO tarefaDAO = new TarefaDAO(context);
                                        if (tarefaDAO.deletar(tarefasSelecionada)) {
                                            carregarListaTarefas();
                                            Toast.makeText(context, "Sucesso ao deletar!", Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(context, "Erro  ao deletar!", Toast.LENGTH_LONG).show();
                                        }

                                    }
                                });
                                dialog.setNegativeButton("Não", null);
                                dialog.create();
                                dialog.show();
                            }


                            @Override
                            public void onItemClick(View view, int position) {

                                Tarefas tarefasSelecionada = listaTarefas.get(position);
                                // Enviar tarefa para tela Adicionar Tarefa

                                Intent intent = new Intent(getActivity(), AdicionarTarefas.class);
                                intent.putExtra("tarefaSelecionada", tarefasSelecionada);
                                startActivity(intent);


                            }


                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                            }
                        }
                )

        );
        return view;

    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);

    }

    @SuppressLint("ResourceType")
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        FloatingActionButton fab = view.findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_adicionarTarefas);

            }
        });


    }

    public void listaString() {

        TarefaDAO tarefaDAO = new TarefaDAO(context);

        listaTarefas = tarefaDAO.listar();


    }

    @Override
    public void onStart() {
        super.onStart();
        carregarListaTarefas();


    }

    public void carregarListaTarefas() {
        listaString();
        adapter = new Adapter(listaTarefas);
        recyclerView.setAdapter(adapter);
    }

}

