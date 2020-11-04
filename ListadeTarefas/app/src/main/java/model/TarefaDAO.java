package model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TarefaDAO implements  ITarefaDAO {
    private SQLiteDatabase escreve;
    private SQLiteDatabase ler;

    public TarefaDAO(Context context) {
        DbHelper dbHelper =  new DbHelper(context);
        escreve = dbHelper.getWritableDatabase();
        ler = dbHelper.getReadableDatabase();

    }

    @Override
    public boolean salvar(Tarefas tarefas) {
        ContentValues cv = new ContentValues();
        cv.put("nome", tarefas.getTarefa());

        try {
            escreve.insert(DbHelper.TABELA_TAREFAS, null,cv);
            Log.i("Info", "Sucesso ao salvar tarefa");

        }catch (Exception e) {
            Log.i("Info", "Erro ao salvar tarefa");
            return false;
        }
        return true;
    }

    @Override
    public boolean atualizar(Tarefas tarefas) {
        ContentValues cv = new ContentValues();
        cv.put("nome", tarefas.getTarefa());
        try {
            String[] args = {tarefas.getId().toString()};
            escreve.update(DbHelper.TABELA_TAREFAS,cv,"id=?", args );

            Log.i("Info", "Sucesso ao atualizar tarefa");

        }catch (Exception e) {
            Log.i("Info", "Erro ao atualizar tarefa");
            return false;
        }


        return true;
    }

    @Override
    public boolean deletar(Tarefas tarefas) {
        String[] arg = {tarefas.getId().toString()};

        try {
            escreve.delete(DbHelper.TABELA_TAREFAS, "id=?", arg);
            Log.i("Info", "Sucesso ao deletar tarefa");

        }catch (Exception e) {
            Log.i("Info", "Erro ao deletar tarefa");
            return false;
        }


        return true;
    }

    @Override
    public List<Tarefas> listar() {
         List<Tarefas> lisTarefas  = new ArrayList<>();
         String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " ;";
         Cursor c = ler.rawQuery(sql, null);
        while(c.moveToNext()) {
            Tarefas tarefas =  new Tarefas();

            Long id = c.getLong(c.getColumnIndex("id"));
            String nomeTarefa = c.getString(c.getColumnIndex("nome"));

            tarefas.setId(id);
            tarefas.setTarefa(nomeTarefa);

            lisTarefas.add(tarefas);

        }
        return  lisTarefas;
    }
}
