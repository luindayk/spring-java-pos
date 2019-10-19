package br.com.facef.informatica.business.impl;

import br.com.facef.informatica.business.ProfessorBusiness;
import br.com.facef.informatica.business.TurmaBusiness;
import br.com.facef.informatica.model.Professor;
import br.com.facef.informatica.model.Turma;
import br.com.facef.informatica.repository.ProfessorRepository;
import br.com.facef.informatica.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaBusinessImpl implements TurmaBusiness {

    private TurmaRepository turmaRepository;

    @Autowired
    public TurmaBusinessImpl(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    @Override
    public List<Turma> findAll(Pageable pageable) {
        return turmaRepository.findAll(pageable).getContent();
    }

    @Override
    public Optional<Turma> find(int id) {
        return turmaRepository.findById(id);
    }

    @Override
    public Turma create(Turma turma) {
        return turmaRepository.save(turma);
    }

    @Override
    public Turma update(Turma turma) {
        return turmaRepository.save(turma);
    }

    @Override
    public void delete(Turma turma) {
        turmaRepository.delete(turma);
    }
}
