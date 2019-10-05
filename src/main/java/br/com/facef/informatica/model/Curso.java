package br.com.facef.informatica.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "materias")
public class Curso implements Serializable {

    private static final long serialVersionUID = -3404326657727820330L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;

    @ManyToMany
    @JoinTable(name = "materias_curso",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "materia_id"))
    private List<Materia> materias;

    @OneToMany(mappedBy = "curso")
    private Set<Turma> turmas;

    public Curso() {
    }

    public Curso(int id, String nome, String descricao, List<Materia> materias, Set<Turma> turmas) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.materias = materias;
        this.turmas = turmas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public Set<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(Set<Turma> turmas) {
        this.turmas = turmas;
    }
}
