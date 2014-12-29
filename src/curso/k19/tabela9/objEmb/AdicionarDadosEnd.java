package curso.k19.tabela9.objEmb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdicionarDadosEnd")
public class AdicionarDadosEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdicionarDadosEnd() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try{
			EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("sistema");
			
			EntityManager em = factory.createEntityManager();
			Pessoa p = new Pessoa();
			p.setNome("Carbono Torrado dos Santos");
			p.setNasc(new GregorianCalendar(1964,8,24));
			
			Endereco end = new Endereco();
			end.setRua("Rua da Amizade");
			end.setBairro("Centro");
			
			p.setEnd(end);
			
			try{
				em.getTransaction().begin();
				em.persist(p);
				em.persist(end);
				
				em.getTransaction().commit();
				out.println("Dados salvos com sucesso!!");
			}catch(Exception e){
				em.getTransaction().rollback();
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
