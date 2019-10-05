package br.com.facef.informatica.business;

import br.com.facef.informatica.model.Professor;

import java.util.List;

public interface ProfessorBusiness {

    List<Professor> findAll();
    Professor find(int id);
    Professor create(Professor professor);
    Professor update(Professor professor);
    void delete(Professor professor);
}
