package br.com.facef.informatica.business.impl;

import br.com.facef.informatica.business.CursoBusiness;
import br.com.facef.informatica.model.Curso;
import br.com.facef.informatica.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoBusinessImpl implements CursoBusiness {

    private CursoRepository cursoRepository;

    @Autowired
    public CursoBusinessImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso find(int id) {
        return cursoRepository.getOne(id);
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
