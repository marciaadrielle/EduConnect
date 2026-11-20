package br.com.educonnect.ui;

import br.com.educonnect.model.Aluno;
import br.com.educonnect.model.Curso;
import br.com.educonnect.model.Professor;
import br.com.educonnect.model.Turma;
import br.com.educonnect.service.AlunoService;
import br.com.educonnect.service.CursoService;
import br.com.educonnect.service.ProfessorService;
import br.com.educonnect.service.TurmaService;

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
            } catch (NumberFormatException e) {
                System.out.println("Digite uma opção válida.");
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1:
                    try {
                        if (cursoService.listarTodosCursos().isEmpty()) {
                            System.out.println("Não existem cursos cadastrados");
                            System.out.println("Cadastre um curso antes de criar uma turma");
                            break;
                        }

                        if (professorService.listarTodosProfessores().isEmpty()) {
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

                        if (professorTurma == null) {
                            System.out.println("Professor não encontrado. Cadastro não realizado");
                            break;
                        }
                        System.out.println("Digite o código do curso: ");
                        String codigoCursoTurma = leitura.nextLine();
                        Curso cursoTurma = cursoService.buscarPorCodigo(codigoCursoTurma);

                        if (cursoTurma == null) {
                            System.out.println("Curso não encontrado. Cadastro não realizado");
                            break;
                        }

                        Turma turma;
                        turma = new Turma(codigoTurma, professorTurma, cursoTurma);
                        turmaService.cadastrarTurma(turma);
                        System.out.println("Turma cadastrada com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 2:

                    try {
                        if (turmaService.listarTodasTurmas().isEmpty()) {
                            System.out.println("Não existem turmas cadastradas");
                            System.out.println("Cadastre uma turma para adicionar alunos");
                            break;
                        }
                        System.out.println("=================== ADICIONAR ALUNO À TURMA ==================");
                        System.out.println("Digite o código da turma: ");
                        String codigoTurma = leitura.nextLine();

                        Turma turma = turmaService.buscarTurmaPorCodigo(codigoTurma);

                        if (turma == null) {
                            System.out.println("Turma não encontrada. Operação não realizada.");
                            break;
                        }

                        System.out.println("Digite a matricula do aluno: ");
                        String matricula = leitura.nextLine();

                        Aluno aluno = alunoService.buscarAlunoPorMatricula(matricula);

                        if (aluno == null) {
                            System.out.println("Aluno não encontrado. Operação não realizada.");
                            break;
                        }
                        turma.adicionarAluno(aluno);
                        System.out.println("Aluno adicionado com sucesso");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        if (turmaService.listarTodasTurmas().isEmpty()) {
                            System.out.println("Não existem turmas cadastradas para realizar a remoção.");
                            break;
                        }
                        System.out.println("=================== REMOVER ALUNO DA TURMA ==================");
                        System.out.println("Digite o código da turma: ");
                        String codigoTurma = leitura.nextLine();

                        Turma turma = turmaService.buscarTurmaPorCodigo(codigoTurma);

                        if (turma == null) {
                            System.out.println("Turma não encontrada. Operação não realizada.");
                            break;
                        }

                        System.out.println("Digite a matricula do aluno: ");
                        String matricula = leitura.nextLine();

                        turma.removerAluno(matricula);
                        System.out.println("Aluno removido com sucesso");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("\n========= LISTA DE TURMAS =========");

                    if (turmaService.listarTodasTurmas().isEmpty()) {
                        System.out.println("Não existem turmas cadastradas.");
                        break;
                    }

                    for (Turma turma : turmaService.listarTodasTurmas()) {
                        turma.exibirResumo();
                    }

                    break;
                case 0:
                    System.out.println("Voltando para o menu principal.");
                    break;

                default:
                    System.out.println("Opção inválida");
            }

        } while (opcao != 0);
    }

}
