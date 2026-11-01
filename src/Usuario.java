public abstract class Usuario implements Autenticacao {

    private String nome;
    private String login;
    private String senha;

    // Construtor
    public Usuario(String nome, String login, String senha) {
        validarCampo(nome, "O nome não pode ser vazio.");
        validarCampo(login, "O login não pode ser vazio.");
        validarCampo(senha, "A senha não pode ser vazia.");

        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    // Método protegido para poder ser usado pelas subclasses
    protected void validarCampo(String valor, String mensagem) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    // Implementação padrão da autenticação para todos os usuários
    @Override
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    // Método abstrato para obrigar as subclasses a implementarem a exibição
    public abstract void exibirInformacoes();

    // Getters
    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
}