package br.com.facef.informatica.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "professores")
public class Professor implements Serializable {

    private static final long serialVersionUID = -5562519274377355030L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String especializacao;

    @OneToMany(mappedBy = "professor")
    private Set<Materia> materias;

    public Professor() {
    }

    public Professor(int id, String nome, String especializacao) {
        this.id = id;
        this.nome = nome;
        this.especializacao = especializacao;
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

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
}
