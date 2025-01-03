package com.guilhermedelecrode.agenda;

import android.app.Application;

import com.guilhermedelecrode.agenda.dao.AlunoDAO;
import com.guilhermedelecrode.agenda.model.Aluno;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        criaAlunoTeste();
    }

    private static void criaAlunoTeste() {
        AlunoDAO dao = new AlunoDAO();
        //Apenas de teste
        dao.salva(new Aluno("Guilherme", "11976467207", "gui@gmail.com"));
        dao.salva(new Aluno("Vitoria", "11976467207", "vih@gmail.com"));
    }
}
