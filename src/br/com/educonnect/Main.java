package br.com.educonnect;

import br.com.educonnect.model.*;
import br.com.educonnect.repository.*;
import br.com.educonnect.service.*;
import br.com.educonnect.ui.*;

public class Main {
    public static void main(String[] args) {
        AlunoRepository alunoRepository = new AlunoRepository();
        AlunoService alunoService = new AlunoService(alunoRepository);
        ProfessorRepository professorRepository = new ProfessorRepository();
        ProfessorService professorService = new ProfessorService(professorRepository);
        CursoRepository cursoRepository = new CursoRepository();
        CursoService cursoService = new CursoService(cursoRepository);
        TurmaRepository turmaRepository = new TurmaRepository();
        TurmaService turmaService = new TurmaService(turmaRepository);
        Menu menu = new Menu(alunoService,professorService,cursoService);



        //Instancia um administrador
        Administrador administrador = new Administrador(
                "Administrador",
                "adminMaster",
                "Admin1234"
        );
        // Instancia um curso presencial
        Curso cursoPresencial = new CursoPresencial(
                "Banco de Dados",
                "BD01",
                200,
                "SL12"
        );

        //Instancia um curso EAD
        Curso cursoEAD = new CursoEAD(
                "Análise e Desenvolvimento de Sistemas",
                "ADS01",
                2200,
                "Studeo"
        );


        cursoService.cadastrarCurso(cursoEAD);
        cursoService.cadastrarCurso(cursoPresencial);


        // Instancia um aluno
        Aluno aluno = new Aluno(
                "Márcia Adrielle",
                "marcia.adrielle",
                "Naruto123",
                "000000-01",
                cursoEAD);

        // Instancia um professor
        Professor professor = new Professor(
                "Edmar Senne",
                "EdmarSenne",
                "S1234678",
                "Java",
                "111113-66"
        );
        Professor professor2 = new Professor(
                "Maria Lovelace",
                "lovelace",
                "love1234",
                "Banco de Dados",
                "111615-00"
        );

        professorService.cadastrarProfessor(professor);
        professorService.cadastrarProfessor(professor2);

        // Instancia uma turma
        Turma turma = new Turma(
                "TURMA001",
                professor,
                cursoEAD);

        turmaService.cadastrarTurma(turma);

        // Instancia novos alunos
        Aluno aluno2 = new Aluno(
                "Christopher Brandon",
                "Bradon",
                "Marianne123",
                "000000-02", cursoEAD);
        Aluno aluno3 = new Aluno(
                "Elizabeth Bennet",
                "Elizabeth",
                "Darcy123",
                "000000-03", cursoEAD);
        Aluno aluno4 = new Aluno(
                "Jane Eyre",
                "Jane",
                "Eyre1023",
                "000000-04",
                cursoEAD);

        alunoService.cadastrarAluno(aluno);
        alunoService.cadastrarAluno(aluno2);
        alunoService.cadastrarAluno(aluno3);
        alunoService.cadastrarAluno(aluno4);



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
        cursoPresencial.detalharCurso();
        cursoEAD.detalharCurso();

        //Exibe o menu de relatorios
        menu.exibirMenu();

    }

}