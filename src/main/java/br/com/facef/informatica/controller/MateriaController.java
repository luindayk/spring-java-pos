package br.com.facef.informatica.controller;

import br.com.facef.informatica.business.MateriaBusiness;
import br.com.facef.informatica.exception.impl.CustomBadRequestException;
import br.com.facef.informatica.exception.impl.CustomNotFoundException;
import br.com.facef.informatica.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<List<Materia>> findAll(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok().body(materiaBusiness.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> find(@PathVariable int id) {
        Materia m = materiaBusiness.find(id);

        if (m == null) {
            throw new CustomNotFoundException("Matéria informada não foi encontrada");
        }

        return ResponseEntity.ok().body(materiaBusiness.find(id));
    }

    @PostMapping
    public ResponseEntity<Materia> create(@RequestBody Materia materia) {
        if (materia.getId() != 0) {
            throw new CustomBadRequestException("Campo ID não deve ser enviado para esta requisição");
        }

        return ResponseEntity.ok().body(materiaBusiness.create(materia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materia> update(@RequestBody Materia materia, int id) {
        Materia m = materiaBusiness.find(id);

        if (m == null) {
            throw new CustomNotFoundException("Matéria informada não foi encontrada");
        }

        return ResponseEntity.ok().body(materiaBusiness.update(materia));
    }

    public ResponseEntity<String> delete(@RequestBody Materia materia) {
        Materia m = materiaBusiness.find(materia.getId());

        if (m == null) {
            throw new CustomNotFoundException("Matéria informada não foi encontrada");
        }

        materiaBusiness.delete(materia);

        return ResponseEntity.ok().build();
    }
}
