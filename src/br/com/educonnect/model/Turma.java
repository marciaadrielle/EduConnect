package br.com.educonnect.model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private List<Aluno>listaAlunos;

    //Construtor
    public Turma(String codigo, Professor professor, Curso curso) {
        //validações
        if(codigo == null || codigo.isBlank()){
            throw new IllegalArgumentException("O código da turma não pode estar vazio.");
        }
        if (professor == null){
            throw new IllegalArgumentException("A turma precisa estar associada a um professor.");
        }
        if (curso == null){
            throw new IllegalArgumentException("A turma precisa estar associada a um curso");
        }
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
        this.listaAlunos = new ArrayList<>();
    }
    //Método para adicionar um aluno na lista
    public void adicionarAluno(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("O aluno não pode ser nulo."
            );
        }
        for (Aluno alunoCadastrado : listaAlunos) {

            if (alunoCadastrado.getMatricula().equals(aluno.getMatricula())) {
                throw new IllegalArgumentException("Já existe um aluno com essa matrícula na turma."
                );
            }
        }
        listaAlunos.add(aluno);
    }
    //Método para remover um aluno da lista
    public void removerAluno(String matricula){
        if(matricula == null || matricula.isBlank()){
            throw new IllegalArgumentException("A matricula não pode estar vazia.");
        }
        boolean removido = listaAlunos.removeIf(
                aluno -> aluno.getMatricula().equals(matricula)
        );

        if (!removido){
            throw new IllegalArgumentException("Aluno não encontrado na turma.");
        }
    }

    //Método para mostrar o resumo da turma
    public void exibirResumo(){
        System.out.println("\n================= TURMA =================");
        System.out.println("Código: " + codigo);
        System.out.println("Curso: " + curso.getNome());
        System.out.println("Professor: " + professor.getNome());
        System.out.println("Quantidade de Alunos Matriculados: " +
                listaAlunos.size());
        System.out.println("=========================================");
    }


    public void exibirAvaliacoes() {
        System.out.println("\n===== AVALIAÇÕES DA TURMA " + codigo + " =====");

        // Percorre os alunos matriculados na turma
        for (Aluno aluno : listaAlunos) {

            System.out.println("Aluno: " + aluno.getNome());
            System.out.println("Matrícula: " + aluno.getMatricula());
            for (Avaliacao avaliacao : aluno.getAvaliacoes()) {
                System.out.println("Avaliação: " + avaliacao.getDescricao());
                System.out.println("Nota: " + avaliacao.getNota());
            }

            System.out.println("==========================================");
        }
    }







}
