package curso.extra.teste.relacionamentos;

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

@WebServlet("/CriarTabelas")
public class CriarTabelas extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CriarTabelas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try{
			EntityManagerFactory factory = 
					Persistence.createEntityManagerFactory("sistema");
			EntityManager em = factory.createEntityManager();
			
			Curso curso = new Curso();
			curso.setNome("Analise e Desenvolvimento de Sistemas");
			curso.setCarga(850);
			curso.setObservacao("alguma coisa");

			Disciplina disc = new Disciplina();
			disc.setNome("Programação Avançada");
			disc.setCarga(180);
			disc.setNatureza("exatas");
			disc.setObjetivo("algum");
			disc.setObservacao("alguma coisa também");
			
			curso.getDisc().add(disc);
			
			try{
				em.getTransaction().begin();
				em.persist(disc);
				em.persist(curso);
				
				em.getTransaction().commit();
			}catch(Exception e){
				em.getTransaction().rollback();
			}
			
			out.println("<h1><font color='#929292'>Tabelas criadas com sucesso!</font></h1>");
			factory.close();
		}catch(Exception e){
			out.println("<h1><font color='#2f1f1f'>Erro ao criar tabelas!</font></h1><br />"+e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
