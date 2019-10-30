package br.com.facef.informatica.business;

import br.com.facef.informatica.model.Professor;
import br.com.facef.informatica.model.Turma;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TurmaBusiness {

    List<Turma> findAll(Pageable pageable);
    Turma find(int id);
    Turma create(Turma turma);
    Turma update(Turma turma);
    void delete(int id);
}
