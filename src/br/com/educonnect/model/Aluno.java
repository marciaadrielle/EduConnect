package br.com.educonnect.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
    private String matricula;
    private Curso curso;
    private List<Avaliacao> avaliacoes;

    public Aluno(String nome, String login, String senha, String matricula, Curso curso) {
        super(nome, login, senha);
        //Validações
        if (matricula == null || matricula.isBlank()) {
            throw new IllegalArgumentException("A matricula do aluno não pode estar vazia.");
        }
        if (curso == null) {
            throw new IllegalArgumentException("O aluno precisa estar associado a um curso.");
        }
        this.matricula = matricula;
        this.curso = curso;
        this.avaliacoes = new ArrayList<>();
    }

    //Método para adicionar a avaliação ao aluno
    public void adicionarAvaliacao(Avaliacao avaliacao) {
        if (avaliacao == null) {
            throw new IllegalArgumentException("A avaliação não pode ser nula");
        }

        if (avaliacoes.contains(avaliacao)) {
            throw new IllegalArgumentException(
                    "Esta avaliação já foi adicionada ao aluno."
            );
        }
        avaliacoes.add(avaliacao);
    }

    //Getters
    public String getMatricula() {
        return matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public List<Avaliacao> getAvaliacoes() {
        return List.copyOf(avaliacoes);
    }
}
