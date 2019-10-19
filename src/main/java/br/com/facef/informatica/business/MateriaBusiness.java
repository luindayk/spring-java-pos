package br.com.facef.informatica.business;

import br.com.facef.informatica.model.Materia;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MateriaBusiness {

    List<Materia> findAll(Pageable pageable);
    Materia find(int id);
    Materia create(Materia professor);
    Materia update(Materia professor);
    void delete(Materia professor);
}
