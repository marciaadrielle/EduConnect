public class Aluno {
    private String nome;
    private String matricula;
    private String curso;

    // Método para validar os campos
    private void validarCampo(String valor, String mensagem) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    // Construtor
    public Aluno(String nome, String matricula, String curso) {
        validarCampo(nome, "O nome do aluno não pode ser vazio.");
        validarCampo(matricula, "A matrícula não pode ser vazia.");
        validarCampo(curso, "O curso não pode ser vazio.");

        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarCampo(nome, "O nome do aluno não pode ser vazio.");
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        validarCampo(matricula, "A matrícula não pode ser vazia.");
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        validarCampo(curso, "O curso não pode ser vazio.");
        this.curso = curso;
    }

    // Método para exibir informações
    public void exibirInformacoes() {
        System.out.println("\n============== ALUNO ================");
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Curso: " + curso);
        System.out.println("========================================");
    }
}