package br.com.educonnect.model;

public class CursoEAD extends Curso {
    private String plataformaVirtual;

    //Construtor
    public CursoEAD(String nome, String codigo, int cargaHoraria, String plataformaVirtual) {
        super(nome, codigo, cargaHoraria);
        if (plataformaVirtual == null || plataformaVirtual.isBlank()) {
            throw new IllegalArgumentException("É necessário informar a plataforma virtual");
        }

        this.plataformaVirtual = plataformaVirtual;
    }

    //Getter
    public String getPlataformaVirtual() {
        return plataformaVirtual;
    }


    //Método para sobrescrever o detalharCurso
    @Override
    public void detalharCurso() {
    System.out.println("\n============= CURSO EAD ==============");
    System.out.println("Curso: " + getNome());
    System.out.println("Código: " + getCodigo());
    System.out.println("Carga horária: " + getCargaHoraria() + " horas");
    System.out.println("Plataforma Virtual: " + getPlataformaVirtual());
    System.out.println("========================================");
    }

}