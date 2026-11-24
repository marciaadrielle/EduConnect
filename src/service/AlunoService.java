package service;

import model.Aluno;
import repository.AlunoRepository;
import java.util.List;

public class AlunoService {
    private AlunoRepository alunoRepository;

    // Construtor
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // Método para cadastrar um novo aluno
    public void cadastrarAluno(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("O aluno não pode estar vazio."
            );
        }
        Aluno a = alunoRepository.buscarPorMatricula(aluno.getMatricula());
        if (a != null) {
            throw new IllegalArgumentException(
                    "Já possui um aluno cadastrado com essa matrícula."
            );
        }
        alunoRepository.salvarAluno(aluno);
    }

    // Método para listar todos os alunos cadastrados
    public List<Aluno> listarTodosAlunos() {
        return alunoRepository.listarTodosAlunos();
    }

    // Método para buscar um aluno pela matrícula
    public Aluno buscarAlunoPorMatricula(String matricula) {
        return alunoRepository.buscarPorMatricula(matricula);
    }
}
