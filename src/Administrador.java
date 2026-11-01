public class Administrador extends Usuario {

    public Administrador(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("\n============== ADMINISTRADOR ========");
        System.out.println("Nome: " + getNome());
        System.out.println("Login: " + getLogin());
        System.out.println("=======================================");
    }
}