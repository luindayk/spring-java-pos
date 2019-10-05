package br.com.facef.informatica.business.impl;

import br.com.facef.informatica.business.ProfessorBusiness;
import br.com.facef.informatica.model.Professor;
import br.com.facef.informatica.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProfessorBusinessImpl implements ProfessorBusiness {

    private ProfessorRepository professorRepository;

    @Autowired
    public ProfessorBusinessImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @Override
    public Professor find(int id) {
        return professorRepository.getOne(id);
    }

    @Override
    public Professor create(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Professor update(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public void delete(Professor professor) {
        professorRepository.delete(professor);
    }
}
