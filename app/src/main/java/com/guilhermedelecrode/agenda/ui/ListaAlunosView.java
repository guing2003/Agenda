package com.guilhermedelecrode.agenda.ui;

import android.content.Context;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;

import com.guilhermedelecrode.agenda.dao.AlunoDAO;
import com.guilhermedelecrode.agenda.model.Aluno;
import com.guilhermedelecrode.agenda.ui.adapter.ListaAlunosAdapter;

public class ListaAlunosView {

    private AlunoDAO dao = new AlunoDAO();
    private final ListaAlunosAdapter adapter;
    private final Context context;

    public ListaAlunosView(Context context) {
        this.context = context;
        this.adapter = new ListaAlunosAdapter(this.context);
        this.dao = new AlunoDAO();
    }

    public void confirmaRemocaoAluno(final MenuItem item) {
        new AlertDialog
                .Builder(context)
                .setTitle("Removendo Aluno!")
                .setMessage("Confirma a remoção do aluno?")
                .setPositiveButton("Sim", (dialog, which) -> {
                    AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

                    Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
                    remove(alunoEscolhido);
                })
                .setNegativeButton("Não", null)
                .show();
    }

    public void atualizaAluno() {
        adapter.atualiza(dao.todos());
    }

    private void remove(Aluno aluno) {
        dao.remove(aluno);
        adapter.remove(aluno);
    }

    public void configuraAdpter(ListView listaDeAlunos) {

        listaDeAlunos.setAdapter(adapter);
    }
}
