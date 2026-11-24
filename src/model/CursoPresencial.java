package model;

public class CursoPresencial extends Curso {
    // Atributo específico do curso presencial
    private String salaAula;

    //Construtor
    public CursoPresencial(String nome, String codigo, int cargaHoraria, String salaAula) {
        // Chama o construtor da classe model.Curso e inicializa os atributos
        super(nome, codigo, cargaHoraria);
        //Validações
        if (salaAula == null || salaAula.isBlank()) {
            throw new IllegalArgumentException("É necessário informar a sala de aula");
        }
        this.salaAula = salaAula;
    }

    //Getter
    public String getSalaAula() {
        return salaAula;
    }

    //Método para sobreescrever o método herdado
    @Override
    public void detalharCurso() {
        System.out.println("\n============== CURSO PRESENCIAL  =============");
        System.out.println("Curso: " + getNome());
        System.out.println("Código: " + getCodigo());
        System.out.println("Carga horária: " + getCargaHoraria() + " horas");
        System.out.println("Sala de aula: " + getSalaAula());
        System.out.println("===============================================");
    }
}