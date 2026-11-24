package ui;

import model.Aluno;
import model.Professor;
import model.Curso;
import model.Turma;
import service.AlunoService;
import service.CursoService;
import service.ProfessorService;
import service.TurmaService;

import java.util.Scanner;

public class MenuTurmas {
    private final TurmaService turmaService;
    private final CursoService cursoService;
    private final ProfessorService professorService;
    private final AlunoService alunoService;

    public MenuTurmas(TurmaService turmaService, CursoService cursoService, ProfessorService professorService, AlunoService alunoService) {
        this.turmaService = turmaService;
        this.cursoService = cursoService;
        this.professorService = professorService;
        this.alunoService = alunoService;
    }

    public void exibirMenu() {
        Scanner leitura = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n========== GERENCIAR TURMAS ==========");
            System.out.println("1 - Cadastrar turma");
            System.out.println("2 - Adicionar aluno à turma");
            System.out.println("3 - Remover aluno da turma");
            System.out.println("4 - Listar turmas");
            System.out.println("0 - Voltar ao menu principal");
            System.out.println("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(leitura.nextLine());
            } catch (NumberFormatException var12) {
                System.out.println("Digite uma opção válida.");
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 0:
                    System.out.println("Voltando para o menu principal.");
                    break;
                case 1:
                    try {
                        if (this.cursoService.listarTodosCursos().isEmpty()) {
                            System.out.println("Não existem cursos cadastrados");
                            System.out.println("Cadastre um curso antes de criar uma turma");
                        } else if (this.professorService.listarTodosProfessores().isEmpty()) {
                            System.out.println("Não existem professores cadastrados.");
                            System.out.println("Cadastre um professor antes de criar uma turma.");
                        } else {
                            System.out.println("\n========= CADASTRAR TURMA =========");
                            System.out.println("Digite o código da turma: ");
                            String codigoTurma = leitura.nextLine();
                            System.out.println("Digite o registro do professor: ");
                            String registroProfessor = leitura.nextLine();
                            Professor professorTurma = this.professorService.buscarPorRegistro(registroProfessor);
                            if (professorTurma == null) {
                                System.out.println("Professor não encontrado. Cadastro não realizado");
                            } else {
                                System.out.println("Digite o código do curso: ");
                                String codigoCursoTurma = leitura.nextLine();
                                Curso cursoTurma = this.cursoService.buscarPorCodigo(codigoCursoTurma);
                                if (cursoTurma == null) {
                                    System.out.println("Curso não encontrado. Cadastro não realizado");
                                } else {
                                    Turma turma = new Turma(codigoTurma, professorTurma, cursoTurma);
                                    this.turmaService.cadastrarTurma(turma);
                                    System.out.println("Turma cadastrada com sucesso!");
                                }
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        if (this.turmaService.listarTodasTurmas().isEmpty()) {
                            System.out.println("Não existem turmas cadastradas");
                            System.out.println("Cadastre uma turma para adicionar alunos");
                        } else {
                            System.out.println("=================== ADICIONAR ALUNO À TURMA ==================");
                            System.out.println("Digite o código da turma: ");
                            String codigoTurma = leitura.nextLine();
                            Turma turma = this.turmaService.buscarTurmaPorCodigo(codigoTurma);
                            if (turma == null) {
                                System.out.println("Turma não encontrada. Operação não realizada.");
                            } else {
                                System.out.println("Digite a matricula do aluno: ");
                                String matricula = leitura.nextLine();
                                Aluno aluno = this.alunoService.buscarAlunoPorMatricula(matricula);
                                if (aluno == null) {
                                    System.out.println("Aluno não encontrado. Operação não realizada.");
                                } else {
                                    turma.adicionarAluno(aluno);
                                    System.out.println("Aluno adicionado com sucesso");
                                }
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        if (this.turmaService.listarTodasTurmas().isEmpty()) {
                            System.out.println("Não existem turmas cadastradas para realizar a remoção.");
                        } else {
                            System.out.println("=================== REMOVER ALUNO DA TURMA ==================");
                            System.out.println("Digite o código da turma: ");
                            String codigoTurma = leitura.nextLine();
                            Turma turma = this.turmaService.buscarTurmaPorCodigo(codigoTurma);
                            if (turma == null) {
                                System.out.println("Turma não encontrada. Operação não realizada.");
                            } else {
                                System.out.println("Digite a matricula do aluno: ");
                                String matricula = leitura.nextLine();
                                turma.removerAluno(matricula);
                                System.out.println("Aluno removido com sucesso");
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("\n========= LISTA DE TURMAS =========");
                    if (this.turmaService.listarTodasTurmas().isEmpty()) {
                        System.out.println("Não existem turmas cadastradas.");
                    } else {
                        for(Turma turma : this.turmaService.listarTodasTurmas()) {
                            turma.exibirResumo();
                        }
                    }
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while(opcao != 0);

    }
}
