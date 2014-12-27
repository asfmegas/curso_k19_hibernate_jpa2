package curso.k19.tabela2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdicionarUsuario")
public class AdicionarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdicionarUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try{
			EntityManagerFactory factory = 
					Persistence.createEntityManagerFactory("sistema");
			
			EntityManager em = factory.createEntityManager();
			try {
				em.getTransaction().begin();
				
				Usuario usuario = new Usuario();
				usuario.setEmail("asfmegas@gmail.com");
				usuario.setDataCadastro(Calendar.getInstance());	
				
				em.persist(usuario);
				em.getTransaction().commit();
				
				out.println("<h1>Dados salvos com sucesso!</h1>");
				
			} catch (Exception e) {
				out.println("<h1>Erro ao salvar dados</h1>"+e.getMessage());
			}
			em.close();
			factory.close();
			
		}catch(Exception e){
			out.println("<h1>Erro ao criar tabelas</h1>"+e.getMessage());
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
