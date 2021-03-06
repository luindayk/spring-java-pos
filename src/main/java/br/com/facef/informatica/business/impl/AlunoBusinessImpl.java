package br.com.facef.informatica.business.impl;

import br.com.facef.informatica.business.AlunoBusiness;
import br.com.facef.informatica.model.Aluno;
import br.com.facef.informatica.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
    public List<Aluno> findAll(Pageable pageable, String nome) {
        Aluno a = new Aluno();

        if (nome != null) {
            a.setNome(nome);
        }

        ExampleMatcher ignoringExampleMatcher = ExampleMatcher.matchingAny()
                .withMatcher("nome", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withIgnorePaths("id");

        return alunoRepository.findAll(Example.of(a, ignoringExampleMatcher), pageable).getContent();
    }

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
        Aluno a = this.find(aluno.getId());
        if (aluno.getNome() != null) {
            a.setNome(aluno.getNome());
        }

        if (aluno.getTurmas() != null) {
            a.setTurmas(aluno.getTurmas());
        }

        return alunoRepository.save(a);
    }

    @Override
    public void delete(int id) {
        alunoRepository.deleteById(id);
    }
}
