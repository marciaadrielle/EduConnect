package repository;

import model.Professor;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {
    private List<Professor> professores = new ArrayList<>();
    //Método para salvar um professor na lista
    public void salvarProfessor(Professor professor){
        professores.add(professor);
    }
    //Método para listar os professores salvos
    public List<Professor> listarTodosProfessores(){
        return new ArrayList<>(professores);
    }
    //Método para buscar um professor pelo registro
    public Professor buscarPorRegistro(String registro){
        for(Professor professor : professores){
            if(professor.getRegistro().equals(registro)){
                return professor;
            }
        }
        return null;
    }
}