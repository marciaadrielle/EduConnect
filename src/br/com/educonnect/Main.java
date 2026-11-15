package br.com.educonnect;

import br.com.educonnect.model.*;
import br.com.educonnect.repository.AlunoRepository;
import br.com.educonnect.service.AlunoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AlunoRepository alunoRepository = new AlunoRepository();
        AlunoService alunoService = new AlunoService(alunoRepository);
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

        //Cria lista de cursos
        List<Curso> cursos = new ArrayList<>();
        cursos.add(cursoPresencial);
        cursos.add(cursoEAD);

        // Instancia um aluno
        Aluno aluno = new Aluno(
                "Márcia Adrielle",
                "marcia.adrielle",
                "Naruto123",
                "000000-01",
                cursoEAD);

        System.out.println("\n================ ALUNO ===============");
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Matrícula: " + aluno.getMatricula());
        System.out.println("Curso: " + aluno.getCurso().getNome());
        System.out.println("======================================");

        // Instancia um professor
        Professor professor = new Professor(
                "Edmar Senne",
                "EdmarSenne",
                "S1234678",
                "Java",
                "111113-66"
        );
        Professor professor1 = new Professor(
                "Maria Lovelace",
                "lovelace",
                "love1234",
                "Banco de Dados",
                "111615-00"
        );

        //Cria a lista de professores
        List<Professor> professores = new ArrayList<>();
        professores.add(professor);
        professores.add(professor1);

        System.out.println("\n============== PROFESSOR =============");
        System.out.println("Nome: " + professor.getNome());
        System.out.println("Especialidade: " + professor.getEspecialidade());
        System.out.println("Registro: " + professor.getRegistro());
        System.out.println("=======================================");

        // Instancia uma turma
        Turma turma = new Turma(
                "TURMA001",
                professor,
                cursoEAD);

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

        System.out.println("\n===== TESTES DE AUTENTICAÇÃO =====");

        // Autenticação do aluno
        if (aluno.autenticar("marcia.adrielle", "Naruto123")) {
            System.out.println(aluno.getNome() + " logado com sucesso!");
        } else {
            System.out.println(aluno.getNome() + " não logado!");
        }

        // Autenticação do professor
        if (professor.autenticar("EdmarSenne", "S1234678")) {
            System.out.println(professor.getNome() + " logado com sucesso!");
        } else {
            System.out.println(professor.getNome() + " não logado!");
        }

        // Autenticação do administrador
        if (administrador.autenticar("admin", "senhaErrada")) {
            System.out.println(administrador.getNome() + "logado com sucesso!");
        } else {
            System.out.println(administrador.getNome() + " não logado!");
        }


        Scanner leitura = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n========= MENU DE RELATÓRIOS =========");
            System.out.println("1 - Relatório geral de alunos");
            System.out.println("2 - Relatório geral de professores");
            System.out.println("3 - Relatório geral de cursos");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            try {
                opcao = Integer.parseInt(leitura.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite uma opção válida.");
                opcao = -1;
                continue;
            }

            switch (opcao) {

                // Relatório geral de alunos
                case 1:
                    System.out.println("\n========= RELATÓRIO GERAL DE ALUNOS =========");

                    for (Aluno a : alunoService.listarTodosAlunos()) {
                        a.gerarRelatorio();
                    }
                    System.out.println("\n==============  FIM DO RELATÓRIO ==============");
                    break;

                // Relatório geral de professores
                case 2:
                    System.out.println("\n======== RELATÓRIO GERAL DE PROFESSORES ========");

                    for (Professor p : professores) {
                        p.gerarRelatorio();
                    }
                    System.out.println("\n==============  FIM DO RELATÓRIO ==============");
                    break;

                // Relatório geral de cursos
                case 3:
                    System.out.println("\n========== RELATÓRIO GERAL DE CURSOS ==========");

                    for (Curso c : cursos) {
                        c.gerarRelatorio();
                    }
                    System.out.println("\n==============  FIM DO RELATÓRIO ==============");
                    break;

                case 0:
                    System.out.println("Saindo do menu de relatórios...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

    }
}