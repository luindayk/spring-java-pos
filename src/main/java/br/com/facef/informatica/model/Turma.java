package br.com.facef.informatica.model;

import br.com.facef.informatica.utils.Periodo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "turmas")
public class Turma implements Serializable {

    private static final long serialVersionUID = 6611624131850261988L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private Periodo periodo;

    @ManyToMany(mappedBy = "turmas")
    private List<Aluno> alunos;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    public Turma() {
    }

    public Turma(int id, String nome, Periodo periodo, List<Aluno> alunos, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.periodo = periodo;
        this.alunos = alunos;
        this.curso = curso;
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

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
