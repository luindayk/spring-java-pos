package br.com.facef.informatica.business.impl;

import br.com.facef.informatica.business.MateriaBusiness;
import br.com.facef.informatica.model.Materia;
import br.com.facef.informatica.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaBusinessImpl implements MateriaBusiness {

    private MateriaRepository materiaRepository;

    @Autowired
    public MateriaBusinessImpl(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    @Override
    public List<Materia> findAll(Pageable pageable) {
        return materiaRepository.findAll(pageable).getContent();
    }

    @Override
    public Materia find(int id) {
        return materiaRepository.getOne(id);
    }

    @Override
    public Materia create(Materia materia) {
        return materiaRepository.save(materia);
    }

    @Override
    public Materia update(Materia materia) {
        return materiaRepository.save(materia);
    }

    @Override
    public void delete(Materia materia) {
        materiaRepository.delete(materia);
    }
}
