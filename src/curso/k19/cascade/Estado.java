package curso.k19.cascade;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Estado {

	@Id @GeneratedValue
	private Long id;
	
	private String nome;
	
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Governador gov;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Governador getGov() {
		return gov;
	}

	public void setGov(Governador gov) {
		this.gov = gov;
	}
}
