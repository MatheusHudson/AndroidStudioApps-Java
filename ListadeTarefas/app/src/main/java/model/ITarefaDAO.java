package model;

import java.util.List;

public interface ITarefaDAO {
    public boolean salvar(Tarefas tarefas);
    public boolean atualizar(Tarefas tarefas);
    public  boolean deletar(Tarefas tarefas);
    public List<Tarefas> listar();

}
