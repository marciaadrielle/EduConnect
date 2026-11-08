package br.com.educonnect;

import br.com.educonnect.model.Aluno;
import br.com.educonnect.model.Curso;
import br.com.educonnect.model.Professor;

public class Main {
    public static void main(String[] args){

        Curso curso = new Curso("Análise e Desenvolvimento de Sistemas", "ADS01", 2000);
        System.out.println("\n================ CURSO ==============");
        System.out.println("Nome: " + curso.getNome());
        System.out.println("Código: " + curso.getCodigo());
        System.out.println("Carga Horária: " + curso.getCargaHoraria());
        System.out.println("=====================================");

        Aluno aluno = new Aluno("Márcia Adrielle","000000-01",curso);
        System.out.println("\n================ ALUNO ===============");
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Matricula: " + aluno.getMatricula());
        System.out.println("Curso: " + aluno.getCurso().getNome());
        System.out.println("======================================");

        Professor professor = new Professor("Edmar Senne", "Java", "111113-66");
        System.out.println("\n============== PROFESSOR =============");
        System.out.println("Nome: " + professor.getNome());
        System.out.println("Especialidade: " + professor.getEspecialidade());
        System.out.println("Registro: " + professor.getRegistro());
        System.out.println("=======================================");

    }

}
