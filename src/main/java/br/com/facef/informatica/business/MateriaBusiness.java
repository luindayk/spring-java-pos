package br.com.facef.informatica.business;

import br.com.facef.informatica.model.Materia;

import java.util.List;

public interface MateriaBusiness {

    List<Materia> findAll();
    Materia find(int id);
    Materia create(Materia professor);
    Materia update(Materia professor);
    void delete(Materia professor);
}
