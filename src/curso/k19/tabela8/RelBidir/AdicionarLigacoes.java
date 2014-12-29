package curso.k19.tabela8.RelBidir;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdicionarLigacoes")
public class AdicionarLigacoes extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdicionarLigacoes() {
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
				
				Ligacao lig1 = new Ligacao();
				lig1.setDuracao(123);
				
				Ligacao lig2 = new Ligacao();
				lig2.setDuracao(354);
				
				Fatura f = new Fatura();
				//f.setVencimento(new GregorianCalendar(2012,11,20));
				f.setVencimento(Calendar.getInstance());
				
				f.getLigacoes().add(lig1);
				f.getLigacoes().add(lig2);
				
				lig1.setFatura(f);
				lig2.setFatura(f);
				
				em.persist(f);
				em.persist(lig1);
				em.persist(lig2);
				
				em.getTransaction().commit();
				out.println("<h1>Dados salvos com sucesso!</h1>");
			}catch(Exception e){
				out.println("<h1>Erro ao salvar dados!</h1>"+e.getMessage());
				em.getTransaction().rollback();
			}
			
			em.close();
			factory.close();
		}catch(Exception e){
			out.println("<h1>Erro ao criar tabelas!</h1>"+e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
