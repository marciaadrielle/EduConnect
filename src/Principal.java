import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        // Instanciando alunos
        Aluno aluno = new Aluno(
                "Márcia Adrielle",
                "marcia",
                "123",
                "25195792-5",
                "Análise e Desenvolvimento de Sistemas"
        );

        Aluno aluno1 = new Aluno(
                "Christopher Brandon",
                "christopher",
                "456",
                "2595666-1",
                "Análise e Desenvolvimento de Sistemas"
        );

        Aluno aluno2 = new Aluno(
                "Elizabeth Bennet",
                "elizabeth",
                "789",
                "129466-5",
                "Redes de Computadores"
        );

        // Instanciando professor
        Professor professor = new Professor(
                "Edmar Senne",
                "edmar",
                "456",
                "Programação Orientada a Objetos",
                "PF0056"
        );

        // Instanciando administrador
        Administrador administrador = new Administrador(
                "Administrador",
                "admin",
                "789"
        );

        // Instanciando um curso presencial
        CursoPresencial cursoPresencial = new CursoPresencial(
                "Redes de Computadores",
                "RD001",
                1900,
                "Sala 2"
        );

        // Instanciando um curso EAD
        CursoEAD cursoEAD = new CursoEAD(
                "Análise e Desenvolvimento de Sistemas",
                "ADS001",
                2200,
                "Studeo"
        );

        // Instanciando turma
        Turma turma1 = new Turma("TURMA001", professor, cursoEAD);

        // Adicionando alunos na turma
        turma1.adicionarAluno(aluno);
        turma1.adicionarAluno(aluno1);
        turma1.adicionarAluno(aluno2);

        // Atribuindo as avaliações
        Avaliacao avaliacao = new Avaliacao("Prova de POO", aluno);
        avaliacao.atribuirNota(8.5);

        Avaliacao avaliacao1 = new Avaliacao(
                "Prova Substitutiva de Banco de dados", aluno1);
        avaliacao1.atribuirNota(6);

        Avaliacao avaliacao2 = new Avaliacao("Prova de POO", aluno2);
        avaliacao2.atribuirNota(10);

        // Adicionando avaliações à turma
        turma1.adicionarAvaliacao(avaliacao);
        turma1.adicionarAvaliacao(avaliacao1);
        turma1.adicionarAvaliacao(avaliacao2);

        // Exibindo resumo da turma
        turma1.mostrarResumo();

        // Exibindo os detalhes dos cursos
        cursoPresencial.detalharCurso();
        cursoEAD.detalharCurso();

        // Criando uma lista polimórfica que aceita qualquer coisa que gere relatório
        List<Relatorio> listaDeRelatorios = new ArrayList<>();
        listaDeRelatorios.add(aluno);
        listaDeRelatorios.add(aluno1);
        listaDeRelatorios.add(aluno2);
        listaDeRelatorios.add(professor);
        listaDeRelatorios.add(cursoPresencial);
        listaDeRelatorios.add(cursoEAD);

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        // Laço de repetição para o Menu
        while (opcao != 0) {
            System.out.println("\n========== MENU DE RELATÓRIOS ==========");
            System.out.println("1 - Gerar Relatório geral");
            System.out.println("2 - Gerar Relatório de alunos");
            System.out.println("3 - Gerar Relatório de professores");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nGerando Relatório Geral do Sistema...");
                    System.out.println("\n========== RELATÓRIOS GERAL ==========");
                    for (Relatorio item : listaDeRelatorios) {
                        item.gerarRelatorio();
                    }
                    System.out.println("========== FIM DO RELATÓRIO ==========");
                    break;
                case 2:
                    System.out.println("\nGerando Relatório de Alunos...");
                    System.out.println("\n========== RELATÓRIO DE ALUNOS ==========");
                    for (Relatorio item : listaDeRelatorios) {
                        if (item instanceof Aluno) { // Filtra apenas objetos do tipo Aluno
                            item.gerarRelatorio();
                        }
                    }
                    System.out.println("========== FIM DO RELATÓRIO ==========");
                    break;
                case 3:
                    System.out.println("\nGerando Relatório de Professores...");
                    System.out.println("\"\n========== RELATÓRIOS DE PROFESSORES ==========");
                    for (Relatorio item : listaDeRelatorios) {
                        if (item instanceof Professor) { // Filtra apenas objetos do tipo Professor
                            item.gerarRelatorio();
                        }
                    }
                    System.out.println("========== FIM DO RELATÓRIO ==========");
                    break;
                case 0:
                    System.out.println("Saindo do sistema de relatórios.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();

    }


}
