
public class Professor {
    private String nome;
    private String especialidade;
    private String registro;

    // Método para validar os campos
    private void validarCampo(String valor, String mensagem) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    // Construtor
    public Professor(String nome, String especialidade, String registro) {

        validarCampo(nome, "O nome do professor não pode ser vazio.");
        validarCampo(especialidade, "A especialidade não pode ser vazia.");
        validarCampo(registro, "O registro não pode ser vazio.");

        this.nome = nome;
        this.especialidade = especialidade;
        this.registro = registro;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarCampo(nome, "O nome do professor não pode ser vazio.");
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        validarCampo(especialidade, "A especialidade não pode ser vazia.");
        this.especialidade = especialidade;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        validarCampo(registro, "O registro não pode ser vazio.");
        this.registro = registro;
    }

    // Método para exibir os dados do professor
    public void exibirInformacoes() {
        System.out.println("\n============== PROFESSOR ============");
        System.out.println("Nome: " + nome);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Registro: " + registro);
        System.out.println("=======================================");
    }
}
