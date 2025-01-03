package com.guilhermedelecrode.agenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.guilhermedelecrode.agenda.R;
import com.guilhermedelecrode.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class ListaAlunosAdapter extends BaseAdapter {

    private final List<Aluno> alunos = new ArrayList<>();
    private final Context context;

    public ListaAlunosAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() { // Quantidade de elementos do adapter
        return alunos.size();
    }

    @Override
    public Aluno getItem(int position) {// Retorna o elemento pela posição
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {//Retorna o id do elemento pela posição
        return alunos.get(position).getId(); //Caso não tenha id Mantenha com o : 0
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {//Cria a view para cada elemento
        View viewCriada = criaView(viewGroup);

        Aluno alunoDevolvido = alunos.get(position);
        vinculaInformacoes(viewCriada, alunoDevolvido);

        return viewCriada;
    }

    private static void vinculaInformacoes(View view, Aluno aluno) {
        TextView nome = view.findViewById(R.id.item_aluno_nome);
        nome.setText(aluno.getNome());
        TextView telefone = view.findViewById(R.id.item_aluno_telefone);
        telefone.setText(aluno.getTelefone());
    }

    private View criaView(ViewGroup viewGroup) {
        return LayoutInflater
                .from(context)
                .inflate(R.layout.item_aluno, viewGroup, false);
    }

    public void atualiza(List<Aluno> alunos){
        this.alunos.clear();
        this.alunos.addAll(alunos);
        notifyDataSetChanged();
    }

    public void remove(Aluno aluno) {
        alunos.remove(aluno);
        notifyDataSetChanged();
    }
}
