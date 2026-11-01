import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private List<Aluno> listaAlunos;
    private List<Avaliacao>listaAvaliacoes;

    // Método para validar os campos
    private void validarCampo(String valor, String mensagem) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    // Construtor
    public Turma(String codigo, Professor professor, Curso curso) {
        validarCampo(codigo, "O código da turma não pode ser vazio.");
        if (professor == null) {
            throw new IllegalArgumentException("O professor não pode ser nulo.");
        }
        if (curso == null) {
            throw new IllegalArgumentException("O curso não pode ser nulo.");
        }

        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
        this.listaAlunos = new ArrayList<>();
        this.listaAvaliacoes = new ArrayList<>();
    }

    // Getters e Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        validarCampo(codigo, "O código da turma não pode ser vazio.");
        this.codigo = codigo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        if (professor == null) {
            throw new IllegalArgumentException("O professor não pode ser nulo.");
        }
        this.professor = professor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("O curso não pode ser nulo.");
        }
        this.curso = curso;
    }

    public List<Aluno> getListaAlunos() {
        return new ArrayList<>(listaAlunos);
    }

    public List<Avaliacao>getListaAvaliacoes(){
        return new ArrayList<>(listaAvaliacoes);
    }

    // Método para adicionar um aluno na lista
    public void adicionarAluno(Aluno aluno) {

        if (aluno == null) {
            throw new IllegalArgumentException("O aluno não pode ser nulo.");
        }

        listaAlunos.add(aluno);

        System.out.println("Aluno " + aluno.getNome() +
                " adicionado à turma " + codigo + ".");
    }
    // Método para remover um aluno da lista
    public void removerAluno(Aluno aluno) {

        if (listaAlunos.remove(aluno)) {
            System.out.println("Aluno " + aluno.getNome() +
                    " removido da turma " + codigo + ".");
        } else {
            System.out.println("Aluno não encontrado nesta turma.");
        }
    }

    //Método para adicionar avaliação vinculada ao alunos da turma
    public void adicionarAvaliacao(Avaliacao avaliacao) {
        if (avaliacao == null) {
            throw new IllegalArgumentException("A avaliação não pode ser nula.");
        }
        // Valida se o aluno da avaliação pertence a esta turma
        if (!listaAlunos.contains(avaliacao.getAluno())) {
            throw new IllegalArgumentException("O aluno " + avaliacao.getAluno().getNome() + " não está matriculado nesta turma!");
        }

        listaAvaliacoes.add(avaliacao);
        System.out.println("Avaliação '" + avaliacao.getDescricao() + "' registrada para o aluno " + avaliacao.getAluno().getNome() + ".");
    }

    // Método para mostrar o resumo da turma
    public void mostrarResumo() {
        System.out.println("========================================");
        System.out.println("Turma: " + codigo);
        System.out.println("Curso: " + curso.getNome());
        System.out.println("Professor: " + professor.getNome());
        System.out.println("Quantidade de Alunos Matriculados: " +
                listaAlunos.size());

        System.out.println("========== ALUNOS MATRICULADOS ==========");

        if (listaAlunos.isEmpty()) {
            System.out.println("Nenhum aluno matriculado no momento.");
        } else {
            for (Aluno a : listaAlunos) {
                System.out.println(" * " + a.getNome());
            }
        }

        //Exibindo as avaliações no resumo ---
        System.out.println("=========== AVALIAÇÕES DA TURMA ===========");
        if (listaAvaliacoes.isEmpty()) {
            System.out.println("Nenhuma avaliação registrada no momento.");
        } else {
            for (Avaliacao av : listaAvaliacoes) {

                System.out.println(" * Nome: " + av.getAluno().getNome());
                System.out.println("Descrição: " + av.getDescricao());
                System.out.println("Nota: " + av.getNota());

            }
        }

        System.out.println("========================================");


    }


}
