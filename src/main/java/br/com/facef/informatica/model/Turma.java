package br.com.facef.informatica.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "turmas")
public class Turma implements Serializable {

    private static final long serialVersionUID = 6611624131850261988L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private br.com.facef.informatica.utils.Turma turma;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    public Turma() {
    }

    public Turma(int id, String nome, br.com.facef.informatica.utils.Turma turma) {
        this.id = id;
        this.nome = nome;
        this.turma = turma;
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

    public br.com.facef.informatica.utils.Turma getTurma() {
        return turma;
    }

    public void setTurma(br.com.facef.informatica.utils.Turma turma) {
        this.turma = turma;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
