package br.com.facef.informatica.controller;

import br.com.facef.informatica.business.MateriaBusiness;
import br.com.facef.informatica.exception.impl.CustomBadRequestException;
import br.com.facef.informatica.exception.impl.CustomNotFoundException;
import br.com.facef.informatica.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/materias")
public class MateriaController {

    private MateriaBusiness materiaBusiness;

    @Autowired
    public MateriaController(MateriaBusiness materiaBusiness) {
        this.materiaBusiness = materiaBusiness;
    }

    @GetMapping
    public ResponseEntity<List<Materia>> findAll(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        return ResponseEntity.ok().body(materiaBusiness.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> find(@PathVariable int id) {
        materiaExists(id);
        Materia m = materiaBusiness.find(id);

        return ResponseEntity.ok().body(m);
    }

    @PostMapping
    public ResponseEntity<Materia> create(@RequestBody Materia materia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(materiaBusiness.create(materia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materia> update(@RequestBody Materia materia, int id) {
        materiaExists(id);
        materia.setId(id);

        materiaBusiness.update(materia);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@RequestBody int id) {
        materiaExists(id);
        materiaBusiness.delete(id);

        return ResponseEntity.ok().build();
    }

    private void materiaExists(int id) {
        if (materiaBusiness.find(id) == null) {
            throw new CustomNotFoundException("Matéria informada não foi encontrada");
        }
    }
}
