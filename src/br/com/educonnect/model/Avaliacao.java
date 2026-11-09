package br.com.educonnect.model;

public class Avaliacao {
    private Double nota;
    private String descricao;
    private Aluno aluno;

    public Avaliacao(String descricao, Aluno aluno) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException(
                    "A descrição não pode estar vazia."
            );
        }

        if (aluno == null){
            throw new IllegalArgumentException("A avaliação precisa estar associada a um aluno.");
        }
        this.descricao = descricao;
        this.aluno = aluno;
    }

    //Método para atribuir uma nota a avaliação
    public void atribuirNota(double valor){
        if (!Double.isFinite(valor) || valor < 0 || valor > 10){
            throw  new IllegalArgumentException("Nota inválida! A nota deve estar entre 0 e 10.");
        }
        this.nota = valor;
    }

    public Double getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public Aluno getAluno() {
        return aluno;
    }
}
