package br.com.facef.informatica.business;

import br.com.facef.informatica.model.Curso;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CursoBusiness {

    List<Curso> findAll(Pageable pageable);
    Optional<Curso> find(int id);
    Curso create(Curso professor);
    Curso update(Curso professor);
    void delete(Curso professor);
}
