package model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario implements Relatorio {
    private String matricula;
    private Curso curso;
    private List<Avaliacao> avaliacoes;

    //Construtor
    public Aluno(String nome, String login, String senha, String matricula, Curso curso) {
        super(nome, login, senha);
        //Validações
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do aluno não pode estar vazio.");
        }
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
        //Validação
        if (avaliacao == null) {
            throw new IllegalArgumentException("A avaliação não pode ser nula");
        }
        if (avaliacoes.contains(avaliacao)) {
            throw new IllegalArgumentException("Esta avaliação já foi adicionada ao aluno."
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

    //Implementa o metódo gerar relatório para aluno
    @Override
    public void gerarRelatorio() {
        System.out.println("Nome: " + getNome());
        System.out.println("Matrícula: " + getMatricula());
        System.out.println("Curso: " + getCurso().getNome());
        if (avaliacoes.isEmpty()) {
            System.out.println("Nenhuma avaliação cadastrada para este aluno.");
        } else {
            for (Avaliacao avaliacao : avaliacoes) {
                System.out.println("Avaliação: " + avaliacao.getDescricao());
                if (avaliacao.getNota() == null) {
                    System.out.println("Nota: Não atribuída");
                } else {
                    System.out.println("Nota: " + avaliacao.getNota());
                }
            }
        }
        System.out.println("-----------------------------------------------");

    }
}
