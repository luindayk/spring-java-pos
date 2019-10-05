package br.com.facef.informatica.repository;

import br.com.facef.informatica.model.Professor;
import br.com.facef.informatica.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {
}
