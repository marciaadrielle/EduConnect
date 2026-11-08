package br.com.educonnect.model;

public class Professor {
    private String nome;
    private String especialidade;
    private String registro;

    public Professor(String nome, String especialidade, String registro) {
        //Validações
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do professor não pode estar vazio.");
        }

        if (especialidade == null || especialidade.isBlank()) {
            throw new IllegalArgumentException("A especialidade do professor não pode estar vazia.");
        }

        if (registro == null || registro.isBlank()) {
            throw new IllegalArgumentException("O registro do professor não pode estar vazio.");
        }
        this.nome = nome;
        this.especialidade = especialidade;
        this.registro = registro;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getRegistro() {
        return registro;
    }
}
