package br.com.facef.informatica.controller;

import br.com.facef.informatica.business.ProfessorBusiness;
import br.com.facef.informatica.exception.impl.CustomBadRequestException;
import br.com.facef.informatica.exception.impl.CustomNotFoundException;
import br.com.facef.informatica.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/professores")
public class ProfessorController {

    private ProfessorBusiness professorBusiness;

    @Autowired
    public ProfessorController(ProfessorBusiness professorBusiness) {
        this.professorBusiness = professorBusiness;
    }

    @GetMapping
    public ResponseEntity<List<Professor>> findAll(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        return ResponseEntity.ok().body(professorBusiness.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> find(@PathVariable int id) {
        professorExists(id);
        Professor p = professorBusiness.find(id);
        return ResponseEntity.ok().body(p);
    }

    @PostMapping
    public ResponseEntity<Professor> create(@RequestBody Professor professor) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(professorBusiness.create(professor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Professor professor, @PathVariable int id) {
        professorExists(id);
        professor.setId(id);
        professorBusiness.update(professor);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        professorExists(id);
        professorBusiness.delete(id);
        return ResponseEntity.ok().build();
    }

    private void professorExists(int id) {
        if (professorBusiness.find(id) == null)
            throw new CustomNotFoundException("Professor informado não foi encontrado");
    }
}
