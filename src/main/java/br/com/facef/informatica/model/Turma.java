package br.com.facef.informatica.model;

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
    private br.com.facef.informatica.utils.Turma turma;

    @ManyToMany(mappedBy = "turmas")
    private List<Aluno> alunos;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    public Turma() {
    }

    public Turma(int id, String nome, br.com.facef.informatica.utils.Turma turma, List<Aluno> alunos, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.turma = turma;
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

    public br.com.facef.informatica.utils.Turma getTurma() {
        return turma;
    }

    public void setTurma(br.com.facef.informatica.utils.Turma turma) {
        this.turma = turma;
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
