package curso.extra.teste.relacionamentos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClasseDAO {
	EntityManagerFactory factory;
	private EntityManager em;
	
	
	public ClasseDAO() {
		 factory = Persistence.createEntityManagerFactory("sistema");
		 em = factory.createEntityManager();
	}
	
	public Aluno getById(int id){
		Aluno aluno = null;
		try{
			em.getTransaction().begin();
			aluno = em.find(Aluno.class, id);
		}catch(Exception e){
			
		}finally{
			em.close();
			factory.close();
		}
		return aluno;
	}
}
