package br.com.educonnect;

import br.com.educonnect.model.*;
import br.com.educonnect.repository.*;
import br.com.educonnect.service.*;
import br.com.educonnect.ui.*;

public class Main {
    public static void main(String[] args) {
        AlunoRepository alunoRepository = new AlunoRepository();
        AlunoService alunoService = new AlunoService(alunoRepository);
        ProfessorRepository professorRepository = new ProfessorRepository();
        ProfessorService professorService = new ProfessorService(professorRepository);
        CursoRepository cursoRepository = new CursoRepository();
        CursoService cursoService = new CursoService(cursoRepository);
        TurmaRepository turmaRepository = new TurmaRepository();
        TurmaService turmaService = new TurmaService(turmaRepository);
        MenuTurmas menuTurmas = new MenuTurmas(turmaService,cursoService, professorService,alunoService);
        MenuPrincipal menu = new MenuPrincipal(alunoService,professorService,cursoService,turmaService,menuTurmas);



        //Exibe o menu de relatorios

        menu.exibirMenu();

    }

}