package ui;

import model.Aluno;
import model.Curso;
import model.Professor;
import service.AlunoService;
import service.CursoService;
import service.ProfessorService;
import java.util.Scanner;

public class MenuRelatorio {
    private final AlunoService alunoService;
    private final ProfessorService professorService;
    private final CursoService cursoService;

    public MenuRelatorio(AlunoService alunoService, ProfessorService professorService, CursoService cursoService) {
        this.alunoService = alunoService;
        this.professorService = professorService;
        this.cursoService = cursoService;
    }

    public void exibirMenu() {
        Scanner leitura = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n========= MENU DE RELATÓRIOS =========");
            System.out.println("1 - Relatório geral de alunos");
            System.out.println("2 - Relatório geral de professores");
            System.out.println("3 - Relatório geral de cursos");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(leitura.nextLine());
            } catch (NumberFormatException var5) {
                System.out.println("Digite uma opção válida.");
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 0:
                    System.out.println("Voltando para o menu principal.");
                    break;
                case 1:
                    System.out.println("\n========= RELATÓRIO GERAL DE ALUNOS =========");
                    if (this.alunoService.listarTodosAlunos().isEmpty()) {
                        System.out.println("Não existem alunos cadastrados.");
                        break;
                    }

                    for(Aluno a : this.alunoService.listarTodosAlunos()) {
                        a.gerarRelatorio();
                    }

                    System.out.println("\n==============  FIM DO RELATÓRIO ==============");
                    break;
                case 2:
                    System.out.println("\n======== RELATÓRIO GERAL DE PROFESSORES ========");
                    if (this.professorService.listarTodosProfessores().isEmpty()) {
                        System.out.println("Não existem professores cadastrados.");
                        break;
                    }

                    for(Professor p : this.professorService.listarTodosProfessores()) {
                        p.gerarRelatorio();
                    }

                    System.out.println("\n==============  FIM DO RELATÓRIO ==============");
                    break;
                case 3:
                    System.out.println("\n========== RELATÓRIO GERAL DE CURSOS ==========");
                    if (this.cursoService.listarTodosCursos().isEmpty()) {
                        System.out.println("Não existem cursos cadastrado");
                        break;
                    }

                    for(Curso c : this.cursoService.listarTodosCursos()) {
                        c.gerarRelatorio();
                    }

                    System.out.println("\n==============  FIM DO RELATÓRIO ==============");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 0);

    }
}
