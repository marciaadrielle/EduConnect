package br.com.educonnect.ui;

import br.com.educonnect.model.*;
import br.com.educonnect.service.*;

import java.util.Scanner;

public class MenuPrincipal {

    private final AlunoService alunoService;
    private final ProfessorService professorService;
    private final CursoService cursoService;
    private final MenuTurmas menuTurmas;
    private final MenuRelatorio menuRelatorio;

    public MenuPrincipal(AlunoService alunoService, ProfessorService professorService, CursoService cursoService, MenuTurmas menuTurmas, MenuRelatorio menuRelatorio) {
        this.alunoService = alunoService;
        this.professorService = professorService;
        this.cursoService = cursoService;
        this.menuTurmas = menuTurmas;
        this.menuRelatorio = menuRelatorio;
    }

    public void exibirMenu() {
        Scanner leitura = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("=============== EDUCONNECT ==============");
            System.out.println("1 - Cadastrar curso");
            System.out.println("2 - Cadastrar professor");
            System.out.println("3 - Cadastrar aluno");
            System.out.println("4 - Gerenciar turmas");
            System.out.println("5 - Registrar avaliações");
            System.out.println("6 - Relatórios");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");
            try {
                opcao = Integer.parseInt(leitura.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite uma opção válida.");
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1:
                    try {
                        System.out.println("\n========= CADASTRAR CURSO =========");
                        System.out.println("Digite o nome do curso: ");
                        String nomeCurso = leitura.nextLine();

                        System.out.println("Digite o código do curso: ");
                        String codigoCurso = leitura.nextLine();

                        System.out.println("Digite a carga horária do curso: ");
                        int cargaHoraria = Integer.parseInt(leitura.nextLine());

                        System.out.println("Escolha a modalidade: ");
                        System.out.println("1 - Presencial ");
                        System.out.println("2 - EAD");
                        int modalidade = Integer.parseInt(leitura.nextLine());

                        Curso curso;
                        if (modalidade == 1) {
                            System.out.println("Digite a sala de aula do curso: ");
                            String sala = leitura.nextLine();

                            curso = new CursoPresencial(nomeCurso, codigoCurso, cargaHoraria, sala);
                        } else if (modalidade == 2) {
                            System.out.println("Digite a plataforma virtual: ");
                            String plataformaVirtual = leitura.nextLine();

                            curso = new CursoEAD(nomeCurso, codigoCurso, cargaHoraria, plataformaVirtual);
                        } else {
                            System.out.println("modalidade inválida! Digite novamente");
                            break;
                        }
                        cursoService.cadastrarCurso(curso);
                        System.out.println("Curso cadastrado com sucesso!");
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: informe um número válido.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }

                    break;

                case 2:
                    try {
                        System.out.println("\n========= CADASTRAR PROFESSOR =========");
                        System.out.println("Digite o nome do professor: ");
                        String nomeProfessor = leitura.nextLine();

                        System.out.println("Digite o login do professor: ");
                        String loginProfessor = leitura.nextLine();

                        System.out.println("Digite uma senha com no mínimo 8 caracteres: ");
                        String senhaProfessor = leitura.nextLine();

                        System.out.println("Digite a especialidade do professor: ");
                        String especialidade = leitura.nextLine();

                        System.out.println("Digite o registro do professor: ");
                        String registro = leitura.nextLine();

                        Professor professor;
                        professor = new Professor(nomeProfessor, loginProfessor, senhaProfessor, especialidade, registro);

                        professorService.cadastrarProfessor(professor);
                        System.out.println("Professor cadastrado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        if (cursoService.listarTodosCursos().isEmpty()) {
                            System.out.println("Não existem cursos cadastrados.");
                            System.out.println("Cadastre um curso antes de cadastrar alunos.");
                            break;
                        }
                        System.out.println("\n========= CADASTRAR ALUNO =========");
                        System.out.println("Digite o nome do aluno: ");
                        String nomeAluno = leitura.nextLine();

                        System.out.println("Digite o login do aluno: ");
                        String loginAluno = leitura.nextLine();

                        System.out.println("Digite uma senha com no mínimo 8 caracteres: ");
                        String senhaAluno = leitura.nextLine();

                        System.out.println("Digite a matricula: ");
                        String matricula = leitura.nextLine();

                        System.out.println("Digite o curso do aluno: ");
                        String codigoCursoAluno = leitura.nextLine();

                        Curso cursoAluno = cursoService.buscarPorCodigo(codigoCursoAluno);

                        if (cursoAluno == null) {
                            System.out.println("Curso não encontrado. Cadastro não realizado.");
                            break;
                        }
                        Aluno aluno;
                        aluno = new Aluno(nomeAluno, loginAluno, senhaAluno, matricula, cursoAluno);
                        alunoService.cadastrarAluno(aluno);
                        System.out.println("Aluno cadastrado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 4:
                    menuTurmas.exibirMenu();
                    break;

                case 5:
                    try {
                        if (alunoService.listarTodosAlunos().isEmpty()) {
                            System.out.println("Não existem alunos cadastrados.");
                            break;
                        }

                        System.out.println("\n=============== REGISTRAR AVALIAÇÃO ===============");

                        // Solicita a matrícula do aluno
                        System.out.println("Digite a matrícula do aluno: ");
                        String matricula = leitura.nextLine();

                        // Busca o aluno cadastrado
                        Aluno aluno = alunoService.buscarAlunoPorMatricula(matricula);

                        if (aluno == null) {
                            System.out.println("Aluno não encontrado. Avaliação não registrada.");
                            break;
                        }

                        // Solicita os dados da avaliação
                        System.out.println("Digite a descrição da avaliação: ");
                        String descricao = leitura.nextLine();

                        System.out.println("Digite a nota da avaliação (0 a 10): ");
                        double nota = Double.parseDouble(leitura.nextLine());

                        // Cria a avaliação associada ao aluno
                        Avaliacao avaliacao = new Avaliacao(descricao, aluno);

                        // Valida e atribui a nota
                        avaliacao.atribuirNota(nota);

                        // Adiciona a avaliação à lista do aluno
                        aluno.adicionarAvaliacao(avaliacao);

                        System.out.println("Avaliação registrada com sucesso!");

                    } catch (NumberFormatException e) {
                        System.out.println("Erro: Informe uma nota numérica válida.");

                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 6:
                    menuRelatorio.exibirMenu();
                    break;

                case 0:
                    System.out.println("Encerrando o EduConnect...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
