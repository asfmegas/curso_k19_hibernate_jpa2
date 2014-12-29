package curso.k19.tabela4.OneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="estado")
public class Estado {

	@Id @GeneratedValue
	private Long id;
	
	private String nome;
	
	@OneToOne
	private Governador gov;
	
	public Estado() {
	
	}

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

	public Governador getGovernador() {
		return gov;
	}

	public void setGovernador(Governador governador) {
		this.gov = governador;
	}
	
	
}
