package br.com.facef.informatica.business.impl;

import br.com.facef.informatica.business.CursoBusiness;
import br.com.facef.informatica.model.Curso;
import br.com.facef.informatica.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoBusinessImpl implements CursoBusiness {

    private CursoRepository cursoRepository;

    @Autowired
    public CursoBusinessImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> findAll(Pageable pageable) {
        return cursoRepository.findAll(pageable).getContent();
    }

    @Override
    public Optional<Curso> find(int id) {
        return cursoRepository.findById(id);
    }

    @Override
    public Curso create(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso update(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public void delete(Curso curso) {
        cursoRepository.delete(curso);
    }
}
