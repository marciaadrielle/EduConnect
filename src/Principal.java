public class Principal {
    public static void main(String[] args) {

        // Instanciando alunos
        Aluno aluno = new Aluno(
                "Márcia Adrielle",
                "25195792-5",
                "Análise e Desenvolvimento de Sistemas");
        Aluno aluno1 = new Aluno(
                "Christopher Brandon",
                "2595666-1",
                "Análise e Desenvolvimento de Sistemas"

        );
        Aluno aluno2 = new Aluno(
                "Elizabeth Bennet",
                "129466-5",
                "Redes de Computadores"
        );

        // Instanciando professor
        Professor professor = new Professor(
                "Edmar Senne",
                "Programação Orientada a Objetos",
                "PF0056");

        /*/ Instanciando curso
        Curso curso = new Curso(
                "Análise e Desenvolvimento de Sistemas",
                "ADS001",
                2200);
*/
        //Instanciando um curso presencial
        CursoPresencial cursoPresencial = new CursoPresencial(
                "Redes de Computadores",
                "RD001",
                1900,
                "Sala 2"

        );

        //Instanciando um curso Ead
        CursoEAD cursoEAD = new CursoEAD(
                "Análise e Desenvolvimento de Sistemas",
                "ADS001",
                2200,
                "Studeo"
        );

        //Instanciando turma
        Turma turma1 = new Turma("TURMA001",professor,cursoEAD);

        //Adicionando alunos na turma
        turma1.adicionarAluno(aluno);
        turma1.adicionarAluno(aluno1);
        turma1.adicionarAluno(aluno2);

        //Atribuindo as avaliações
        Avaliacao avaliacao = new Avaliacao("Prova de POO", aluno);
        avaliacao.atribuirNota(8.5);

        Avaliacao avaliacao1 = new Avaliacao("Prova Substitutiva de Banco de dados", aluno1);
        avaliacao1.atribuirNota(6);

        Avaliacao avaliacao2 = new Avaliacao("Prova de POO", aluno2);
        avaliacao2.atribuirNota(10);

        // Adicionando avaliações à turma
        turma1.adicionarAvaliacao(avaliacao);
        turma1.adicionarAvaliacao(avaliacao1);
        turma1.adicionarAvaliacao(avaliacao2);

        turma1.mostrarResumo();

        // Exibindo os detalhes dos cursos
        cursoPresencial.detalharCurso();

        cursoEAD.detalharCurso();

    }
}
