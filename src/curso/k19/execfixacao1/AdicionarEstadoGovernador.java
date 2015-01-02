package curso.k19.execfixacao1;

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

@WebServlet("/AdicionarEstadoGovernador")
public class AdicionarEstadoGovernador extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdicionarEstadoGovernador() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try{
			EntityManagerFactory factory = 
					Persistence.createEntityManagerFactory("sistema");
			
			EntityManager em = factory.createEntityManager();
			try{
				// ABRINDO A TRASACAO
				em.getTransaction().begin();
				
				// OBJETO NO ESTADO NEW
				Pessoa p = new Pessoa();
				p.setNome("Julio Cesar");	
				
				// OBJETO NO ESTADO MANAGED
				em.persist(p);
				
				// SINCRONIZANDO E CONFIRMANDO A TRANSACAO
				em.getTransaction().commit();
				
				out.println("Id: "+p.getId());
				out.println("Nome: "+p.getNome());
				
				response.sendRedirect("FindManager");
				
			}catch(Exception e){
				out.println("Erro ao salvar dados nas tabelas<br /> "+e.getMessage());
				em.getTransaction().rollback();
			}
			em.close();
			
			factory.close();
			
		}catch(Exception e){
			out.println("Erro ao criar tabelas<br /> "+e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
