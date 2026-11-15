package br.com.educonnect.service;

import br.com.educonnect.model.Curso;
import br.com.educonnect.repository.CursoRepository;

import java.util.List;

public class CursoService {
    private CursoRepository cursoRepository;

    //Construtor
    public CursoService(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
    }

    //Método para cadastrar um novo curso
    public void cadastrarCurso(Curso curso){
        if(curso == null){
            throw new IllegalArgumentException("O curso não pode estar vazio");
        }
        Curso c = cursoRepository.buscarPorCodigo(curso.getCodigo());

        if (c != null){
            throw new IllegalArgumentException("Já possui um curso cadastrado com esse código");
        }
        cursoRepository.salvarCurso(curso);
    }

    //Método para listar todos os cursos
    public List<Curso> listarTodosCursos(){
        return cursoRepository.listarTodosCursos();
    }

    //Método para buscar um curso pelo código
    public Curso buscarPorCodigo(String codigo){
        return cursoRepository.buscarPorCodigo(codigo);
    }
}
