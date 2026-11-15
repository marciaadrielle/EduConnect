package br.com.educonnect.service;

import br.com.educonnect.model.Professor;
import br.com.educonnect.repository.ProfessorRepository;

import java.util.List;

public class ProfessorService {

    private ProfessorRepository professorRepository;

    //Construtor
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    //Método para cadastrar um professor
    public void cadastrarProfessor(Professor professor){
        if (professor == null){
            throw new IllegalArgumentException("O professor não pode estar vazio");
        }

        Professor p = professorRepository.buscarPorRegistro(professor.getRegistro());
        if (p != null){
            throw new IllegalArgumentException("Já possui um professor cadastrado com esse registro.");
        }

        professorRepository.salvarProfessor(professor);
    }

    //Método para listar todos os professores
    public List<Professor> listarTodosProfessores(){
        return professorRepository.listarTodosProfessores();
    }

    //Método para buscar um professor pelo registro
    public Professor buscarPorRegistro(String registro){
        return professorRepository.buscarPorRegistro(registro);
    }
}
