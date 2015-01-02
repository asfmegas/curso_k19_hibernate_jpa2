package curso.k19.cascade;

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

@WebServlet("/TesteCascade")
public class TesteCascade extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TesteCascade() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistema");
			
			EntityManager em = factory.createEntityManager();
			
			Governador gov = new Governador();
			gov.setNome("Morris West");
			
			Estado uf = new Estado();
			uf.setNome("Mundo");
			
			gov.setEstado(uf);
			uf.setGov(gov);
			
			try{
				em.getTransaction().begin();
				em.persist(uf);
				em.getTransaction().commit();
				out.println("Dados salvos com sucesso!");
				
			}catch(Exception e){
				out.println("Erro ao salvar dados<br />"+e.getMessage());
			}
			
		}catch(Exception e){
			out.println("Erro ao criar tabelas<br />"+e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
