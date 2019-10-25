package br.com.facef.informatica.business.impl;

import br.com.facef.informatica.business.ProfessorBusiness;
import br.com.facef.informatica.model.Professor;
import br.com.facef.informatica.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorBusinessImpl implements ProfessorBusiness {

    private ProfessorRepository professorRepository;

    @Autowired
    public ProfessorBusinessImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public List<Professor> findAll(Pageable pageable) {
        return professorRepository.findAll(pageable).getContent();
    }

    @Override
    public Professor find(int id) {
        return professorRepository.findById(id).get();
    }

    @Override
    public Professor create(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Professor update(Professor professor) {
        Professor p = this.find(professor.getId());
        if (professor.getNome() != null)
            p.setNome(professor.getNome());

        if (professor.getEspecializacao() != null)
            p.setEspecializacao(professor.getEspecializacao());

        return professorRepository.save(p);
    }

    @Override
    public void delete(int id) {
        professorRepository.deleteById(id);
    }
}
