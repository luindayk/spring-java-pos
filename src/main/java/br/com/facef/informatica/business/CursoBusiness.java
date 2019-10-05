package br.com.facef.informatica.business;

import br.com.facef.informatica.model.Curso;

import java.util.List;

public interface CursoBusiness {

    List<Curso> findAll();
    Curso find(int id);
    Curso create(Curso professor);
    Curso update(Curso professor);
    void delete(Curso professor);
}
