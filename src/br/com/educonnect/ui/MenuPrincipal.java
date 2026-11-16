package br.com.educonnect.ui;

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
                    System.out.println("Cadastro de cursos em desenvolvimento.");
                    break;

                case 2:
                    System.out.println("Cadastro de professores em desenvolvimento.");
                    break;

                case 3:
                    System.out.println("Cadastro de alunos em desenvolvimento.");
                    break;

                case 4:
                    System.out.println("Gerenciamento de turmas em desenvolvimento.");
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
