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

@WebServlet("/FindManager")
public class FindManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FindManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try{
			EntityManagerFactory factory = 
					Persistence.createEntityManagerFactory("sistema");
			
			EntityManager em = factory.createEntityManager();
			try{
				
				
				//out.println("Teste");
				
				
				Pessoa pessoa = em.find(Pessoa.class, 1L);
				out.println("Id: "+pessoa.getId());
				out.println("<br />");
				out.println("Nome: "+pessoa.getNome());

				Pessoa p = em.find(Pessoa.class, 1L);
				p.setNome("Carbono Torrado da Slva");
				
				em.getTransaction().begin();
				
				em.persist(p);
				
				em.getTransaction().commit();
				
				out.println("<br /><br />Dados alterados com sucesso!<br /><br />");
				out.println("Id: "+p.getId());
				out.println("<br />");
				out.println("Nome: "+p.getNome());
				
				/*
				Pessoa ps = em.find(Pessoa.class, 1L);
				em.getTransaction().begin();
				
				em.remove(ps);
				
				em.getTransaction().commit();
				out.println("<br /><br />Dados removidos com sucesso!<br /><br />");
				
				*/
				
				out.println("<br /><br /><a href='RemoveDados'>Remover dados</a><br /><br />");
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
		// TODO Auto-generated method stub
	}

}
