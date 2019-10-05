package br.com.facef.informatica.controller;

import br.com.facef.informatica.business.CursoBusiness;
import br.com.facef.informatica.business.MateriaBusiness;
import br.com.facef.informatica.exception.impl.CustomBadRequestException;
import br.com.facef.informatica.exception.impl.CustomNotFoundException;
import br.com.facef.informatica.model.Curso;
import br.com.facef.informatica.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cursos")
public class CursoController {

    private CursoBusiness cursoBusiness;

    @Autowired
    public CursoController(CursoBusiness cursoBusiness) {
        this.cursoBusiness = cursoBusiness;
    }

    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        return ResponseEntity.ok().body(cursoBusiness.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> find(@PathVariable int id) {
        Curso c = cursoBusiness.find(id);

        if (c == null) {
            throw new CustomNotFoundException("Curso informado não foi encontrado");
        }

        return ResponseEntity.ok().body(cursoBusiness.find(id));
    }

    @PostMapping
    public ResponseEntity<Curso> create(@RequestBody Curso curso) {
        if (curso.getId() != 0) {
            throw new CustomBadRequestException("Campo ID não deve ser enviado para esta requisição");
        }

        return ResponseEntity.ok().body(cursoBusiness.create(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@RequestBody Curso curso, int id) {
        Curso c = cursoBusiness.find(id);

        if (c == null) {
            throw new CustomNotFoundException("Curso informado não foi encontrado");
        }

        return ResponseEntity.ok().body(cursoBusiness.update(curso));
    }

    public ResponseEntity<String> delete(@RequestBody Curso curso) {
        Curso c = cursoBusiness.find(curso.getId());

        if (c == null) {
            throw new CustomNotFoundException("Curso informado não foi encontrado");
        }

        cursoBusiness.delete(curso);

        return ResponseEntity.ok().build();
    }
}