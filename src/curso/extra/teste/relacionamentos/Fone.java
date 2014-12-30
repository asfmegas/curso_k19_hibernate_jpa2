package curso.extra.teste.relacionamentos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbfone")
public class Fone {
	
	@Id @GeneratedValue
	@Column(name="idfone")
	private Long id;
	
	@Column(name="ddd",nullable=false)
	private Integer ddd;
	
	@Column(name="ddd",length=15)
	private String numero;
	
	@Column(name="ddd")
	private Character tipo;
	
	@Column(name="ddd",length=20)
	private String operadora;
	
	public Fone() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
}
