package br.com.facef.informatica.controller;

import br.com.facef.informatica.business.ProfessorBusiness;
import br.com.facef.informatica.business.TurmaBusiness;
import br.com.facef.informatica.exception.impl.CustomBadRequestException;
import br.com.facef.informatica.exception.impl.CustomNotFoundException;
import br.com.facef.informatica.model.Professor;
import br.com.facef.informatica.model.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/turmas")
public class TurmaController {

    private TurmaBusiness turmaBusiness;

    @Autowired
    public TurmaController(TurmaBusiness turmaBusiness) {
        this.turmaBusiness = turmaBusiness;
    }

    @GetMapping
    public ResponseEntity<List<Turma>> findAll() {
        return ResponseEntity.ok().body(turmaBusiness.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> find(@PathVariable int id) {
        Turma t = turmaBusiness.find(id);

        if (t == null) {
            throw new CustomNotFoundException("Turma informada não foi encontrada");
        }

        return ResponseEntity.ok().body(turmaBusiness.find(id));
    }

    @PostMapping
    public ResponseEntity<Turma> create(@RequestBody Turma turma) {
        if (turma.getId() != 0) {
            throw new CustomBadRequestException("Campo ID não deve ser enviado para esta requisição");
        }

        return ResponseEntity.ok().body(turmaBusiness.create(turma));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> update(@RequestBody Turma turma, int id) {
        Turma t = turmaBusiness.find(id);

        if (t == null) {
            throw new CustomNotFoundException("Turma informada não foi encontrada");
        }

        return ResponseEntity.ok().body(turmaBusiness.update(turma));
    }

    public ResponseEntity<String> delete(@RequestBody Turma turma) {
        Turma t = turmaBusiness.find(turma.getId());

        if (t == null) {
            throw new CustomNotFoundException("Turma informada não foi encontrada");
        }

        turmaBusiness.delete(turma);

        return ResponseEntity.ok().build();
    }
}
