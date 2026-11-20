package br.com.educonnect.ui;

import br.com.educonnect.model.Aluno;
import br.com.educonnect.model.Curso;
import br.com.educonnect.model.Professor;
import br.com.educonnect.service.AlunoService;
import br.com.educonnect.service.CursoService;
import br.com.educonnect.service.ProfessorService;

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

    public void exibirMenu(){
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
            } catch (NumberFormatException e) {
                System.out.println("Digite uma opção válida.");
                opcao = -1;
                continue;
            }

            switch (opcao) {

                // Relatório geral de alunos
                case 1:
                    System.out.println("\n========= RELATÓRIO GERAL DE ALUNOS =========");

                    if (alunoService.listarTodosAlunos().isEmpty()) {
                        System.out.println("Não existem alunos cadastrados.");
                        break;
                    }

                    for (Aluno a : alunoService.listarTodosAlunos()) {
                        a.gerarRelatorio();
                    }
                    System.out.println("\n==============  FIM DO RELATÓRIO ==============");
                    break;

                // Relatório geral de professores
                case 2:
                    System.out.println("\n======== RELATÓRIO GERAL DE PROFESSORES ========");

                    if (professorService.listarTodosProfessores().isEmpty()){
                        System.out.println("Não existem professores cadastrados.");
                        break;
                    }
                    for (Professor p : professorService.listarTodosProfessores() ) {
                        p.gerarRelatorio();
                    }
                    System.out.println("\n==============  FIM DO RELATÓRIO ==============");
                    break;

                // Relatório geral de cursos
                case 3:
                    System.out.println("\n========== RELATÓRIO GERAL DE CURSOS ==========");

                    if (cursoService.listarTodosCursos().isEmpty()){
                        System.out.println("Não existem cursos cadastrado");
                        break;
                    }
                    for (Curso c : cursoService.listarTodosCursos()) {
                        c.gerarRelatorio();
                    }
                    System.out.println("\n==============  FIM DO RELATÓRIO ==============");
                    break;

                case 0:
                    System.out.println("Voltando para o menu principal.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

    }
}
