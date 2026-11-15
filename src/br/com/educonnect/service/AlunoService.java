
package br.com.educonnect.service;

import br.com.educonnect.model.Aluno;
import br.com.educonnect.repository.AlunoRepository;

import java.util.List;

public class AlunoService {

    private AlunoRepository alunoRepository;

    // Construtor: recebe o repositório de alunos
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // Método para cadastrar um novo aluno
    public void cadastrarAluno(Aluno aluno) {

        // Verifica se o aluno é nulo
        if (aluno == null) {
            throw new IllegalArgumentException(
                    "O aluno não pode ser nulo."
            );
        }
        Aluno a  = alunoRepository.buscarPorMatricula(aluno.getMatricula());

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
