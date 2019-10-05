package br.com.facef.informatica.business;

import br.com.facef.informatica.model.Professor;
import br.com.facef.informatica.model.Turma;

import java.util.List;

public interface TurmaBusiness {

    List<Turma> findAll();
    Turma find(int id);
    Turma create(Turma turma);
    Turma update(Turma turma);
    void delete(Turma turma);
}
