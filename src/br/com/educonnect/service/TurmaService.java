package br.com.educonnect.service;

import br.com.educonnect.model.Turma;
import br.com.educonnect.repository.TurmaRepository;

import java.util.List;

public class TurmaService {
    private TurmaRepository turmaRepository;

    //Construtor

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    //Método para cadastrar nova turma
    public void cadastrarTurma(Turma turma) {
        if (turma == null) {
            throw new IllegalArgumentException("A turma não pode ser nula");
        }
        Turma t = turmaRepository.buscarPorCodigo(turma.getCodigo());

        if (t != null) {
            throw new IllegalArgumentException("Já possui uma turma cadastrada com esse código");
        }
        turmaRepository.salvarTurma(turma);
    }

    //Método para listar todas as turmas
    public List<Turma> listarTodasTurmas() {
        return turmaRepository.listarTodasTurmas();
    }

    //Método para buscar uma turma pelo código
    public Turma buscarTurmaPorCodigo(String codigo){
        return turmaRepository.buscarPorCodigo(codigo);
    }

}