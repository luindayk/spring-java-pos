package br.com.facef.informatica.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "materias")
public class Materia implements Serializable {

    private static final long serialVersionUID = -1099255255720011691L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Professor professor;

    public Materia() {
    }

    public Materia(int id, String nome, String descricao, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.professor = professor;
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

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
