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

        // Instanciando curso
        Curso curso = new Curso(
                "Análise e Desenvolvimento de Sistemas",
                "ADS001",
                2200);

        //Instanciando turma
        Turma turma1 = new Turma("TURMA001",professor,curso);

        //Adicionando alunos na turma
        turma1.adicionarAluno(aluno);
        turma1.adicionarAluno(aluno1);
        turma1.adicionarAluno(aluno2);

        //Exibindo o resumo da turma
        turma1.mostrarResumo();

        //Removendo aluno da turma
        turma1.removerAluno(aluno2);

        //Exibindo o resumo da turma após a remoção
        turma1.mostrarResumo();


    }
}
