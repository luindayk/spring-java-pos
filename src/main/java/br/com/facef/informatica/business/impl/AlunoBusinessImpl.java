package br.com.facef.informatica.business.impl;

import br.com.facef.informatica.business.AlunoBusiness;
import br.com.facef.informatica.model.Aluno;
import br.com.facef.informatica.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoBusinessImpl implements AlunoBusiness {

    private AlunoRepository alunoRepository;

    @Autowired
    public AlunoBusinessImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public List<Aluno> findAll(Example<Aluno> aluno, Pageable pageable) {return alunoRepository.findAll(aluno, pageable).getContent();}

    @Override
    public Aluno find(int id) {
        return alunoRepository.findById(id).get();
    }

    @Override
    public Aluno create(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno update(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public void delete(Aluno aluno) {
        alunoRepository.delete(aluno);
    }
}
