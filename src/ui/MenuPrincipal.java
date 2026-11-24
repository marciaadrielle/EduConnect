package ui;

import model.Aluno;
import model.Avaliacao;
import model.Curso;
import model.CursoEAD;
import model.CursoPresencial;
import model.Professor;
import service.AlunoService;
import service.CursoService;
import service.ProfessorService;

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
            } catch (NumberFormatException var16) {
                System.out.println("Digite uma opção válida.");
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 0:
                    System.out.println("Encerrando o EduConnect...");
                    break;
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
                        } else {
                            if (modalidade != 2) {
                                System.out.println("modalidade inválida! Digite novamente");
                                continue;
                            }

                            System.out.println("Digite a plataforma virtual: ");
                            String plataformaVirtual = leitura.nextLine();
                            curso = new CursoEAD(nomeCurso, codigoCurso, cargaHoraria, plataformaVirtual);
                        }

                        this.cursoService.cadastrarCurso(curso);
                        System.out.println("Curso cadastrado com sucesso!");
                    } catch (NumberFormatException var14) {
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
                        Professor professor = new Professor(nomeProfessor, loginProfessor, senhaProfessor, especialidade, registro);
                        this.professorService.cadastrarProfessor(professor);
                        System.out.println("Professor cadastrado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        if (this.cursoService.listarTodosCursos().isEmpty()) {
                            System.out.println("Não existem cursos cadastrados.");
                            System.out.println("Cadastre um curso antes de cadastrar alunos.");
                        } else {
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
                            Curso cursoAluno = this.cursoService.buscarPorCodigo(codigoCursoAluno);
                            if (cursoAluno == null) {
                                System.out.println("Curso não encontrado. Cadastro não realizado.");
                            } else {
                                Aluno aluno = new Aluno(nomeAluno, loginAluno, senhaAluno, matricula, cursoAluno);
                                this.alunoService.cadastrarAluno(aluno);
                                System.out.println("Aluno cadastrado com sucesso!");
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 4:
                    this.menuTurmas.exibirMenu();
                    break;
                case 5:
                    try {
                        if (this.alunoService.listarTodosAlunos().isEmpty()) {
                            System.out.println("Não existem alunos cadastrados.");
                        } else {
                            System.out.println("\n=============== REGISTRAR AVALIAÇÃO ===============");
                            System.out.println("Digite a matrícula do aluno: ");
                            String matricula = leitura.nextLine();
                            Aluno aluno = this.alunoService.buscarAlunoPorMatricula(matricula);
                            if (aluno == null) {
                                System.out.println("Aluno não encontrado. Avaliação não registrada.");
                            } else {
                                System.out.println("Digite a descrição da avaliação: ");
                                String descricao = leitura.nextLine();
                                System.out.println("Digite a nota da avaliação (0 a 10): ");
                                double nota = Double.parseDouble(leitura.nextLine());
                                Avaliacao avaliacao = new Avaliacao(descricao, aluno);
                                avaliacao.atribuirNota(nota);
                                aluno.adicionarAvaliacao(avaliacao);
                                System.out.println("Avaliação registrada com sucesso!");
                            }
                        }
                    } catch (NumberFormatException var10) {
                        System.out.println("Erro: Informe uma nota numérica válida.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 6:
                    this.menuRelatorio.exibirMenu();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

    }
}
