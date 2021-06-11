package com.sheyla.agenda.DAO;

import com.sheyla.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();


    public void salva(Aluno aluno) {
        alunos.add(aluno);
    }

    public static List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
}
