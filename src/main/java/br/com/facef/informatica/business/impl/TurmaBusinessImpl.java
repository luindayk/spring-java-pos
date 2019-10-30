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
    public Turma find(int id) {
        return turmaRepository.findById(id).get();
    }

    @Override
    public Turma create(Turma turma) {
        return turmaRepository.save(turma);
    }

    @Override
    public Turma update(Turma turma) {
        Turma t = this.find(turma.getId());

        if (turma.getNome() != null) {
            t.setNome(turma.getNome());
        }

        if (turma.getAlunos() != null) {
            t.setAlunos(turma.getAlunos());
        }

        if (turma.getCurso() != null) {
            t.setCurso(turma.getCurso());
        }

        if (turma.getPeriodo() != null) {
            t.setPeriodo(turma.getPeriodo());
        }

        return turmaRepository.save(t);
    }

    @Override
    public void delete(int id) {
        turmaRepository.deleteById(id);
    }
}
