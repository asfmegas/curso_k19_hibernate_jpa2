package curso.extra.teste.relacionamentos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbfone")
public class Fone {
	
	@Id @GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="ddd",nullable=false)
	private Integer ddd;
	
	@Column(name="numeo",length=15)
	private String numero;
	
	@Column(name="tipo")
	private Character tipo;
	
	@Column(name="operadora",length=20)
	private String operadora;
	
	@ManyToOne
	@JoinColumn(name="fone_idalu")
	private Aluno alu;
	
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

	public Aluno getAlu() {
		return alu;
	}

	public void setAlu(Aluno alu) {
		this.alu = alu;
	}
	
}
