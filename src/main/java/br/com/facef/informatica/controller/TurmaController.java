package br.com.facef.informatica.controller;

import br.com.facef.informatica.business.CursoBusiness;
import br.com.facef.informatica.business.ProfessorBusiness;
import br.com.facef.informatica.business.TurmaBusiness;
import br.com.facef.informatica.exception.impl.CustomBadRequestException;
import br.com.facef.informatica.exception.impl.CustomNotFoundException;
import br.com.facef.informatica.model.Curso;
import br.com.facef.informatica.model.Professor;
import br.com.facef.informatica.model.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/turmas")
public class TurmaController {

    private TurmaBusiness turmaBusiness;
    private CursoBusiness cursoBusiness;

    @Autowired
    public TurmaController(TurmaBusiness turmaBusiness, CursoBusiness cursoBusiness) {
        this.turmaBusiness = turmaBusiness;
        this.cursoBusiness = cursoBusiness;
    }

    @GetMapping
    public ResponseEntity<List<Turma>> findAll(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        return ResponseEntity.ok().body(turmaBusiness.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> find(@PathVariable int id) {
        turmaExists(id);
        Turma t = turmaBusiness.find(id);

        return ResponseEntity.ok().body(t);
    }

    @PostMapping
    public ResponseEntity<Turma> create(@RequestBody Turma turma) {
        if (turma.getId() != 0) {
            throw new CustomBadRequestException("Campo ID não deve ser enviado para esta requisição");
        }

        Curso oc = cursoBusiness.find(turma.getCurso().getId());

        if (oc.equals(Optional.empty())) {
            throw new CustomNotFoundException("Turma " + turma.getCurso().getId() + " informada não existe!");
        }

        turma.setCurso(oc);

        return ResponseEntity.status(HttpStatus.CREATED).body(turmaBusiness.create(turma));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> update(@RequestBody Turma turma, int id) {
        turmaExists(id);
        turma.setId(id);

        turmaBusiness.update(turma);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@RequestBody int id) {
        turmaExists(id);
        turmaBusiness.delete(id);

        return ResponseEntity.ok().build();
    }

    private void turmaExists(int id) {
        if (turmaBusiness.find(id) == null) {
            throw new CustomNotFoundException("Matéria informada não foi encontrada");
        }
    }
}
