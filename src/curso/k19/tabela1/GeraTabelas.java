package curso.k19.tabela1;

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

@WebServlet("/GeraTabelas")
public class GeraTabelas extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GeraTabelas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		try{
			EntityManagerFactory factory = 
					Persistence.createEntityManagerFactory("sistema");
			
			EntityManager em = factory.createEntityManager();
			
			em.getTransaction().begin();
			//salvando dados
			Autor autor = new Autor();
			autor.setNome("Machado de Assis");
			Editora ed = new Editora();
			ed.setNome("K19");
			ed.setEmail("k19@.k19.com");
			
			try{
			em.persist(autor);
			em.persist(ed);
			em.getTransaction().commit();
			}catch(Exception e){
				em.getTransaction().rollback();
			}

			factory.close();
			out.println("<h1>Tabelas criadas com sucesso!</h1>");
		}catch(Exception e){
			out.println("Erro ao gerar tabelas "+e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
