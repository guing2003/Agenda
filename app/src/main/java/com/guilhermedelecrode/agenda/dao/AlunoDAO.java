package com.guilhermedelecrode.agenda.dao;

import androidx.annotation.Nullable;

import com.guilhermedelecrode.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();

    private static int  contadorDeIds = 1;

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

    public void salva(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        atualizaIds();
    }

    private static void atualizaIds() {
        contadorDeIds++;
    }

    public void edita(Aluno aluno){
        Aluno alunoEncontrado = null;
        for (Aluno a: alunos) {
            if(a.getId() == aluno.getId()){
                alunoEncontrado = a;
            }
            if(alunoEncontrado != null){
                int positionAluno = alunos.indexOf(alunoEncontrado);
                alunos.set(positionAluno, aluno);
            }
        }
    }

    @Nullable
    private Aluno buscaAlunoPeloId(Aluno aluno) {
        for (Aluno a :
                alunos) {
            if (a.getId() == aluno.getId()) {
                return a;
            }
        }
        return null;
    }

    public void remove(Aluno aluno) {
        Aluno alunoDevolvido = buscaAlunoPeloId(aluno);
        if(alunoDevolvido != null){
            alunos.remove(alunoDevolvido);
        }
    }
}
