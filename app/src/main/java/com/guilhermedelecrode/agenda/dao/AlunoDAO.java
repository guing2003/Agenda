package com.guilhermedelecrode.agenda.dao;

import com.guilhermedelecrode.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

    public void salva(Aluno aluno) {
        alunos.add(aluno);
    }
}
