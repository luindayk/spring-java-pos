package br.com.facef.informatica.controller;

import br.com.facef.informatica.business.CursoBusiness;
import br.com.facef.informatica.business.MateriaBusiness;
import br.com.facef.informatica.exception.impl.CustomBadRequestException;
import br.com.facef.informatica.exception.impl.CustomNotFoundException;
import br.com.facef.informatica.model.Curso;
import br.com.facef.informatica.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/cursos")
public class CursoController {

    private CursoBusiness cursoBusiness;

    @Autowired
    public CursoController(CursoBusiness cursoBusiness) {
        this.cursoBusiness = cursoBusiness;
    }

    @GetMapping
    public ResponseEntity<List<Curso>> findAll(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        return ResponseEntity.ok().body(cursoBusiness.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> find(@PathVariable int id) {
        cursoExists(id);
        Curso c = cursoBusiness.find(id);

        return ResponseEntity.ok().body(c);
    }

    @PostMapping
    public ResponseEntity<Curso> create(@RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoBusiness.create(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@RequestBody Curso curso, int id) {
        cursoExists(id);
        curso.setId(id);

        cursoBusiness.update(curso);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@RequestBody int id) {
        cursoExists(id);
        cursoBusiness.delete(id);

        return ResponseEntity.ok().build();
    }

    private void cursoExists(int id) {
        if (cursoBusiness.find(id) == null) {
            throw new CustomNotFoundException("Curso informado não foi encontrado");
        }
    }
}
