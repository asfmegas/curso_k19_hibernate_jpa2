package curso.k19.tabela7.ManyToMany;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdicionarLivroEscritor")
public class AdicionarLivroEscritor extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdicionarLivroEscritor() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try{
			EntityManagerFactory factory = 
					Persistence.createEntityManagerFactory("sistema");
			
			EntityManager em = factory.createEntityManager();
			
			try{
				em.getTransaction().begin();
				Escritor e = new Escritor();
				e.setNome("Daniel Suarez");
				
				Livro l1 = new Livro();
				Livro l2 = new Livro();
				l1.setNome("Daemon");
				l1.getEscritores().add(e);
				l2.setNome("Freedom");
				l2.getEscritores().add(e);
				
				em.persist(e);
				em.persist(l1);
				em.persist(l2);
				
				em.getTransaction().commit();
				out.println("Dados salvos com sucesso!");
			}catch(Exception e){
				out.println("Erro ao salvar dados!<br />"+e.getMessage());
			}
			em.close();
			factory.close();
		}catch(Exception e){
			out.println("Erro ao criar tabelas!<br />"+e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
