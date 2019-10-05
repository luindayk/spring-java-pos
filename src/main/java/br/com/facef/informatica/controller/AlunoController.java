package br.com.facef.informatica.controller;

import br.com.facef.informatica.business.AlunoBusiness;
import br.com.facef.informatica.exception.Response;
import br.com.facef.informatica.exception.impl.CustomBadRequestException;
import br.com.facef.informatica.exception.impl.CustomNotFoundException;
import br.com.facef.informatica.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/alunos")
public class AlunoController {

    private AlunoBusiness alunoBusiness;

    @Autowired
    public AlunoController(AlunoBusiness alunoBusiness) {
        this.alunoBusiness = alunoBusiness;
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll(@PageableDefault(size = 10)Pageable pageable) {
        return ResponseEntity.ok().body(alunoBusiness.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> find(@PathVariable int id) {
        Aluno a = alunoBusiness.find(id);

        if (a == null) {
            throw new CustomNotFoundException("Aluno informado não foi encontrado");
        }

        return ResponseEntity.ok().body(a);
    }

    @PostMapping
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno) {
        if (aluno.getId() != 0) {
            throw new CustomBadRequestException("Campo ID não deve ser enviado para esta requisição");
        }

        return ResponseEntity.ok().body(alunoBusiness.create(aluno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@RequestBody Aluno aluno, @PathVariable int id) {
        Aluno a = alunoBusiness.find(id);

        if (a == null) {
            throw new CustomBadRequestException("Aluno informado não foi encontrado");
        }

        return ResponseEntity.ok().body(alunoBusiness.update(aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        Aluno a = alunoBusiness.find(id);
        if (a == null) {
            throw new CustomBadRequestException("Aluno informado não foi encontrado");
        }
        alunoBusiness.delete(a);
        return ResponseEntity.ok().build();
    }
}
