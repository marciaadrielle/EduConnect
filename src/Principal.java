
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

        // Testando autenticação
        System.out.println("\n============= AUTENTICAÇÃO ==============");
        if (aluno.autenticar("marcia", "234")) {
            System.out.println("Aluno: Usuário logado com sucesso!");
        } else {
            System.out.println("Aluno: Usuário ou senha incorretos.");
        }

        if (professor.autenticar("edmar", "456")) {
            System.out.println("Professor: Usuário logado com sucesso!");
        } else {
            System.out.println("Professor: Usuário ou senha incorretos.");
        }

        if (administrador.autenticar("admin", "789")) {
            System.out.println("Administrador: Usuário logado com sucesso!");
        } else {
            System.out.println("Administrador: Usuário ou senha incorretos.");
        }

    }
}
