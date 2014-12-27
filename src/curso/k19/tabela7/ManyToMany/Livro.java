package curso.k19.tabela7.ManyToMany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Livro {

	@Id @GeneratedValue
	private Long id;
	
	private String nome;
	
	@ManyToMany
	@JoinTable(name="liv_esc", joinColumns=@JoinColumn(name="liv_id"), inverseJoinColumns=@JoinColumn(name="esc_id"))
	private Collection<Escritor> escritores = new ArrayList<Escritor>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<Escritor> getEscritores() {
		return escritores;
	}

	public void setEscritores(Collection<Escritor> escritores) {
		this.escritores = escritores;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
