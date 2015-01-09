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

@WebServlet("/RemoveDados")
public class RemoveDados extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RemoveDados() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try{
			EntityManagerFactory factory = 
					Persistence.createEntityManagerFactory("sistema");
			
			EntityManager em = factory.createEntityManager();
			try{
				
				Pessoa ps = em.find(Pessoa.class, 1L);
				em.getTransaction().begin();
				
				em.remove(ps);
				
				em.getTransaction().commit();
				out.println("<br /><br />Dados removidos com sucesso!<br /><br />");
				
				
			}catch(Exception e){
				out.println("Erro ao salvar dados nas tabelas<br /> "+e.getMessage());
				em.getTransaction().rollback();
			}
		}catch(Exception e){
			out.println("Erro ao criar tabelas<br /> "+e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
