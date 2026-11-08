package br.com.educonnect.model;

public class Aluno {
    private String nome;
    private String matricula;
    private Curso curso;

    public Aluno(String nome, String matricula, Curso curso) {
        //Validações
        if (nome == null || nome.isBlank()){
            throw new IllegalArgumentException("O nome do aluno não pode estar vazio.");
        }

        if (matricula == null || matricula.isBlank()){
            throw  new IllegalArgumentException("A matricula do aluno não pode estar vazia.");
        }
        if (curso ==null){
            throw new IllegalArgumentException("O aluno precisa estar associado a um curso.");
        }
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    //Getters

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public Curso getCurso() {
        return curso;
    }
}
