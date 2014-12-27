package texte.git;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdicionarFilme")
public class AdicionarFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdicionarFilme() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try{
			EntityManagerFactory factory = 
					Persistence.createEntityManagerFactory("sistema");
			
			factory.close();
			out.println("Tabelas criada com sucesso!");
		}catch(Exception e){
			out.println("Erro ao criar tabelas!<br />"+e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
