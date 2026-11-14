package br.com.educonnect.model;

public class Professor extends Usuario {
    private String especialidade;
    private String registro;

    public Professor(String nome, String login, String senha, String especialidade, String registro) {
        super(nome, login, senha);
        //Validações
        if (especialidade == null || especialidade.isBlank()) {
            throw new IllegalArgumentException("A especialidade do professor não pode estar vazia.");
        }

        if (registro == null || registro.isBlank()) {
            throw new IllegalArgumentException("O registro do professor não pode estar vazio.");
        }
        this.especialidade = especialidade;
        this.registro = registro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getRegistro() {
        return registro;
    }

}
