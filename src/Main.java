import model.*;
import repository.AlunoRepository;
import repository.CursoRepository;
import repository.ProfessorRepository;
import repository.TurmaRepository;
import service.AlunoService;
import service.CursoService;
import service.ProfessorService;
import service.TurmaService;
import ui.MenuPrincipal;
import ui.MenuRelatorio;
import ui.MenuTurmas;


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
        MenuTurmas menuTurmas = new MenuTurmas(turmaService, cursoService, professorService, alunoService);
        MenuRelatorio menuRelatorio = new MenuRelatorio(alunoService, professorService, cursoService);
        MenuPrincipal menu = new MenuPrincipal(alunoService, professorService, cursoService, menuTurmas, menuRelatorio);


        //Exibir Menu
        menu.exibirMenu();
    }
}

