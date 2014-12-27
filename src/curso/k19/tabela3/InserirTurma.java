package curso.k19.tabela3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InserirTurma")
public class InserirTurma extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InserirTurma() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try{
			EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("sistema");
			
			/*
			EntityManager em = factory.createEntityManager();
			
			try{
				em.getTransaction().begin();
				Turma turma = new Turma();
				
				turma.setPeriodo(Periodo.MATUTINO);
				
				em.persist(turma);
				em.getTransaction().commit();
				
				out.println("Dados salvos com sucesso!");
				
			}catch(Exception e){
				out.println("Erro ao criar tabelas! <br />"+e.getMessage());
			}
			em.close();
			*/
			factory.close();
			
		}catch(Exception e){
			out.println("Erro ao criar tabelas! <br />"+e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
