package curso.k19.tabela10;

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

@WebServlet("/AdicionarDados")
public class AdicionarDados extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdicionarDados() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try{
			EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("sistema");
			
			EntityManager em = factory.createEntityManager();
			
			Pessoa2 p = new Pessoa2();
			p.setNome("Pessoa Voip");
			
			/*erro
			 * dez 29, 2014 6:04:06 PM org.hibernate.cfg.annotations.EntityBinder bindTable
				INFORMA��ES: Bind entity curso.k19.tabela10.Pessoa2 on table Pessoa2
			 */
			
			try{
				em.getTransaction().begin();
				
				em.persist(p);
				
				em.getTransaction().commit();
				out.println("Dados salvos com sucesso!!");
			}catch(Exception e){
				em.getTransaction().rollback();
				out.println("Erro ao salvar dados!<br />"+e.getMessage());
			}
			
			em.close();
			
			out.println("muito sucesso!!");
			factory.close();
		}catch(Exception e){
			out.println("Erro ao criar tabelas!<br />"+e.getMessage());
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
