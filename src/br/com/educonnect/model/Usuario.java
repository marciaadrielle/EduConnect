package br.com.educonnect.model;

public abstract class Usuario implements Autenticacao {
    private String nome;
    private String login;
    private String senha;

    public Usuario(String nome, String login, String senha) {
        //Validações
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do usuário não pode estar vazio.");
        }
        if (login == null || login.isBlank() || login.length() < 4) {
            throw new IllegalArgumentException("O login deve ter no mínimo 4 caracteres.");
        }

        if (senha == null || senha.isBlank() || senha.length() < 8) {
            throw new IllegalArgumentException("A senha deve ter no mínimo 8 caracteres.");
        }

        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    //Getters

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);


    }
}