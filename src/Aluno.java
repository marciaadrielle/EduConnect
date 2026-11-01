public class Aluno extends Usuario implements Relatorio {

    private String matricula;
    private String curso;

    // Construtor
    public Aluno(String nome, String login, String senha, String matricula, String curso) {
        super(nome, login, senha);
        validarCampo(matricula, "A matrícula não pode ser vazia.");
        validarCampo(curso, "O curso não pode ser vazio.");

        this.matricula = matricula;
        this.curso = curso;
    }

    //Getters

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    // Método para exibir informações
    @Override
    public void exibirInformacoes() {
        System.out.println("\n============== ALUNO ================");
        System.out.println("Nome: " + getNome());
        System.out.println("Matrícula: " + matricula);
        System.out.println("Curso: " + curso);
        System.out.println("========================================");
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("Aluno: " + getNome());
        System.out.println("Matrícula: " + matricula);
        System.out.println("Curso: " + curso);
        System.out.println("------------------------------------------");

    }


}