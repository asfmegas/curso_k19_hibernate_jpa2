package curso.extra.teste.relacionamentos;

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

@WebServlet("/CriarTabelas2")
public class CriarTabelas2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CriarTabelas2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try{
			EntityManagerFactory factory = 
					Persistence.createEntityManagerFactory("sistema");
			EntityManager em = factory.createEntityManager();
			
			Aluno aluno = new Aluno();
			aluno.setNome("Carbono Torrado da Silva");
			aluno.setNasc(new GregorianCalendar(1999,12,1));
			aluno.setEmail("carbonoT@gmail.com");
			aluno.setRua("Amizade");
			aluno.setBairro("Centro");
			aluno.setCep("60000000");
			aluno.setCidade("Fortaleza");
			aluno.setEstado("Ceará");
			
			Fone fone1 = new Fone();
			Fone fone2 = new Fone();
			
			fone1.setDdd(85);
			fone1.setNumero("55558548");
			fone1.setTipo('1');
			fone1.setOperadora("Tim");
			
			fone2.setDdd(85);
			fone2.setNumero("22225878");
			fone2.setTipo('0');
			fone2.setOperadora("Oi");
			
			aluno.getFone().add(fone1);
			aluno.getFone().add(fone2);
			 
			try{
				em.getTransaction().begin();
				em.persist(aluno);
				em.persist(fone1);
				em.persist(fone2);
				
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
