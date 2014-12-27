package curso.k19.tabela5;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


@Entity
public class Departamento {
	
	@Id @GeneratedValue
	private Long id;
	
	private String nome;
	
	@OneToMany
	//@JoinTable(name="dep_func", joinColumns=@JoinColumn(name="dep_id"), inverseJoinColumns=@JoinColumn(name="func_id"))
	private Collection<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public Departamento() {
		// TODO Auto-generated constructor stub
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

	public Collection<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Collection<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
}
