
package br.com.educonnect;

import br.com.educonnect.model.*;

public class Main {

    public static void main(String[] args) {
        // Instancia um curso
        Curso curso = new Curso(
                "Análise e Desenvolvimento de Sistemas",
                "ADS01",
                2000
        );

        // Instancia um curso presencial
        Curso cursoPresencial = new CursoPresencial(
                "Banco de Dados",
                "BD001",
                2000,
                "SL12"
        );

        //Instancia um curso EAD
        Curso cursoEAD = new CursoEAD(
                "Desenvolvimento Back-end com Java",
                "JAVA01",
                220,
                "Studeo"
        );



        // Instancia um aluno
        Aluno aluno = new Aluno("Márcia Adrielle", "000000-01", curso);

        System.out.println("\n================ ALUNO ===============");
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Matrícula: " + aluno.getMatricula());
        System.out.println("Curso: " + aluno.getCurso().getNome());
        System.out.println("======================================");

        // Instancia um professor
        Professor professor = new Professor(
                "Edmar Senne",
                "Java",
                "111113-66"
        );

        System.out.println("\n============== PROFESSOR =============");
        System.out.println("Nome: " + professor.getNome());
        System.out.println("Especialidade: " + professor.getEspecialidade());
        System.out.println("Registro: " + professor.getRegistro());
        System.out.println("=======================================");

        // Instancia uma turma
        Turma turma = new Turma("TURMA001", professor, cursoEAD);

        // Instancia novos alunos
        Aluno aluno2 = new Aluno("Christopher Brandon", "000000-02", curso);
        Aluno aluno3 = new Aluno("Elizabeth Bennet", "000000-03", curso);
        Aluno aluno4 = new Aluno("Jane Eyre", "000000-04", curso);

        // Adiciona os alunos à turma
        turma.adicionarAluno(aluno);
        turma.adicionarAluno(aluno2);
        turma.adicionarAluno(aluno3);
        turma.adicionarAluno(aluno4);

        // Mostra o resumo da turma
        turma.exibirResumo();

        // Cria uma avaliação para cada aluno
        Avaliacao avaliacao = new Avaliacao("Prova de Java", aluno);
        Avaliacao avaliacao2 = new Avaliacao("Prova de Java", aluno2);
        Avaliacao avaliacao3 = new Avaliacao("Prova de Java", aluno3);
        Avaliacao avaliacao4 = new Avaliacao("Prova de Java", aluno4);

        // Atribui as notas
        avaliacao.atribuirNota(8.5);
        avaliacao2.atribuirNota(4.5);
        avaliacao3.atribuirNota(7.0);
        avaliacao4.atribuirNota(0.0);

        // Adiciona as avaliações às listas dos alunos
        aluno.adicionarAvaliacao(avaliacao);
        aluno2.adicionarAvaliacao(avaliacao2);
        aluno3.adicionarAvaliacao(avaliacao3);
        aluno4.adicionarAvaliacao(avaliacao4);

        // Exibe as avaliações de todos os alunos da turma
        turma.exibirAvaliacoes();

        // Exibe o detalhamento dos cursos
        curso.detalharCurso();
        cursoPresencial.detalharCurso();
        cursoEAD.detalharCurso();

    }
}
