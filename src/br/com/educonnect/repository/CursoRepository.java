package br.com.educonnect.repository;

import br.com.educonnect.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoRepository {
    private List<Curso> cursos = new ArrayList<>();

    //Método para adicionar um curso na lista
    public void salvarCurso (Curso curso){
        cursos.add(curso);
    }
    //Método para listar todos os cursos
    public List<Curso> listarTodosCursos() {
        return new ArrayList<>(cursos);
    }

    //Método para buscar curso pelo código
    public  Curso buscarPorCodigo(String codigo){
        for (Curso curso : cursos){
            if (curso.getCodigo().equals(codigo)){
                return curso;
            }
        }
        return null;
    }
}
