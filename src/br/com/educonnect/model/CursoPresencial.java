package br.com.educonnect.model;

public class CursoPresencial extends Curso {
    private String salaAula;

    //Construtor
    public CursoPresencial(String nome, String codigo, int cargaHoraria, String salaAula) {
        super(nome, codigo, cargaHoraria);
        if (salaAula == null || salaAula.isBlank()) {
            throw new IllegalArgumentException("É necessário informar a sala de aula");
        }
        this.salaAula = salaAula;
    }

    //Getter
    public String getSalaAula() {
        return salaAula;
    }

    //Método para sobreescrever o detalharCurso
    @Override
    public void detalharCurso() {
        System.out.println("\n============== CURSO PRESENCIAL =============");
        System.out.println("Curso: " + getNome());
        System.out.println("Código: " + getCodigo());
        System.out.println("Carga horária: " + getCargaHoraria() + " horas");
        System.out.println("Sala de aula: " + getSalaAula());
        System.out.println("===============================================");
    }
}
