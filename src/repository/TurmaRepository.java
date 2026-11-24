package repository;

import model.Turma;
import java.util.ArrayList;
import java.util.List;

public class TurmaRepository {
    private List<Turma> turmas = new ArrayList<>();
    //Método para salvar uma turma na lista
    public void salvarTurma(Turma turma) {
        turmas.add(turma);
    }
    //Método para listar todas as turmas
    public List<Turma> listarTodasTurmas(){
        return new ArrayList<>(turmas);
    }
    //Método para buscar Turma pelo código
    public Turma buscarPorCodigo(String codigo){
        for (Turma turma : turmas){
            if (turma.getCodigo().equals(codigo)){
                return turma;
            }
        }
        return null;
    }
}