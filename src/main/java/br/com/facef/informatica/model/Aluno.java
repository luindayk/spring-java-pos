package br.com.facef.informatica.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "alunos")
public class Aluno implements Serializable {

    private static final long serialVersionUID = 5294040468784347421L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @OneToMany(mappedBy = "aluno")
    private Set<Turma> turma;

    public Aluno() {
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

    public Set<Turma> getTurma() {
        return turma;
    }

    public void setTurma(Set<Turma> turma) {
        this.turma = turma;
    }
}
