public class Professor extends Usuario implements Relatorio {

    private String especialidade;
    private String registro;

    // Construtor
    public Professor(String nome, String login, String senha, String especialidade, String registro) {
        super(nome, login, senha);
        validarCampo(especialidade, "A especialidade não pode ser vazia.");
        validarCampo(registro, "O registro não pode ser vazio.");

        this.especialidade = especialidade;
        this.registro = registro;
    }

    //Getters
    public String getEspecialidade() {
        return especialidade;
    }

    public String getRegistro() {
        return registro;
    }

    // Método para exibir os dados do professor
    @Override
    public void exibirInformacoes() {
        System.out.println("\n============== PROFESSOR ============");
        System.out.println("Nome: " + getNome());
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Registro: " + registro);
        System.out.println("=======================================");
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("Professor: " + getNome());
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Registro: " + registro);
        System.out.println("------------------------------------------");
    }


}