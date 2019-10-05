package br.com.facef.informatica.business;

import br.com.facef.informatica.model.Aluno;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AlunoBusiness {

    List<Aluno> findAll(Pageable pageable);
    Aluno find(int id);
    Aluno create(Aluno aluno);
    Aluno update(Aluno aluno);
    void delete(Aluno aluno);
}
