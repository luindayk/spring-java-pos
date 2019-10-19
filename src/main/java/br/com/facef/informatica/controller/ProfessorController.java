package br.com.facef.informatica.controller;

import br.com.facef.informatica.business.ProfessorBusiness;
import br.com.facef.informatica.exception.impl.CustomBadRequestException;
import br.com.facef.informatica.exception.impl.CustomNotFoundException;
import br.com.facef.informatica.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<List<Professor>> findAll(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok().body(professorBusiness.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> find(@PathVariable int id) {
        Professor p = professorBusiness.find(id);

        if (p == null) {
            throw new CustomNotFoundException("Professor informado não foi encontrado");
        }

        return ResponseEntity.ok().body(p);
    }

    @PostMapping
    public ResponseEntity<Professor> create(@RequestBody Professor professor) {
        if (professor.getId() != 0) {
            throw new CustomBadRequestException("Campo ID não deve ser enviado para esta requisição");
        }

        return ResponseEntity.ok().body(professorBusiness.create(professor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> update(@RequestBody Professor professor, int id) {
        Professor p = professorBusiness.find(id);

        if (p == null) {
            throw new CustomNotFoundException("Professor informado não foi encontrado");
        }

        return ResponseEntity.ok().body(professorBusiness.update(professor));
    }

    public ResponseEntity<String> delete(@RequestBody Professor professor) {
        Professor p = professorBusiness.find(professor.getId());

        if (p == null) {
            throw new CustomNotFoundException("Professor informado não foi encontrado");
        }

        professorBusiness.delete(professor);

        return ResponseEntity.ok().build();
    }
}
