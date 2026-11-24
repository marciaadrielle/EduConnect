package model;

public class Administrador extends Usuario {
    private final String id;

    public Administrador(String id, String nome, String login, String senha) {
        super(nome, login, senha);
        this.id = id;
    }

    public String getId() {
        return id;
    }
}