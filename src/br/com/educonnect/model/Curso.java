package br.com.educonnect.model;

public class Curso {
    private String nome;
    private String codigo;
    private int cargaHoraria;

    //Construtor
    public Curso(String nome, String codigo, int cargaHoraria) {
        //Validações
        if (cargaHoraria <= 0) {
            throw new IllegalArgumentException("A carga horária do curso deve ser maior que zero.");
        }

        if(nome == null || nome.isBlank()){
            throw new IllegalArgumentException("O nome do curso não pode estar vazio");
        }

        if(codigo == null || codigo.isBlank()){
            throw  new IllegalArgumentException("O código do curso não pode estar vazio.");
        }

        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    //Getters

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    // Método para detalhar o curso
    public void detalharCurso() {
        System.out.println("\n============== CURSO ================");
        System.out.println("Curso: " + nome);
        System.out.println("Código: " + codigo);
        System.out.println("Carga horária: " + cargaHoraria + " horas");
        System.out.println("========================================");
    }
}


