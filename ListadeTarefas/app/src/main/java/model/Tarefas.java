package model;

import java.io.Serializable;

public class Tarefas implements Serializable {
    private  Long id;
    private String tarefa;

    public  Tarefas(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public  Tarefas(String tarefa) {
        this.tarefa = tarefa;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }
}
