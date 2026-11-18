package br.com.educonnect.ui;

import br.com.educonnect.model.*;
import br.com.educonnect.service.*;

import java.util.Scanner;

public class MenuPrincipal {

    private final AlunoService alunoService;
    private final ProfessorService professorService;
    private final CursoService cursoService;
    private final TurmaService turmaService;

    public MenuPrincipal(AlunoService alunoService, ProfessorService professorService, CursoService cursoService, TurmaService turmaService) {
        this.alunoService = alunoService;
        this.professorService = professorService;
        this.cursoService = cursoService;
        this.turmaService = turmaService;
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
                    try {
                        if (cursoService.listarTodosCursos().isEmpty()){
                            System.out.println("Não existem cursos cadastrados");
                            System.out.println("Cadastre um curso antes de criar uma turma");
                            break;
                        }

                        if (professorService.listarTodosProfessores().isEmpty()){
                            System.out.println("Não existem professores cadastrados.");
                            System.out.println("Cadastre um professor antes de criar uma turma.");
                        break;
                        }

                        System.out.println("\n========= CADASTRAR TURMA =========");
                        System.out.println("Digite o código da turma: ");
                        String codigoTurma = leitura.nextLine();

                        System.out.println("Digite o registro do professor: ");
                        String registroProfessor = leitura.nextLine();
                        Professor professorTurma = professorService.buscarPorRegistro(registroProfessor);

                        if (professorTurma == null){
                            System.out.println("Professor não encontrado. Cadastro não realizado");
                            break;
                        }
                        System.out.println("Digite o código do curso: ");
                        String codigoCursoTurma = leitura.nextLine();
                        Curso cursoTurma = cursoService.buscarPorCodigo(codigoCursoTurma);

                        if (cursoTurma == null){
                            System.out.println("Cuso não encontrado. Cadastro não realizado");
                        break;
                        }

                        Turma turma;
                        turma = new Turma(codigoTurma, professorTurma,cursoTurma);
                        turmaService.cadastrarTurma(turma);
                        System.out.println("Turma cadastrada com sucesso!");
                    }catch (IllegalArgumentException e){
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Registro de avaliações em desenvolvimento.");
                    break;

                case 6:
                    System.out.println("Relatórios em desenvolvimento.");
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
