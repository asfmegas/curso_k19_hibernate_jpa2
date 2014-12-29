package curso.extra.teste.relacionamentos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbdisciplina")
public class Disciplina {
	
	@Id @GeneratedValue
	@Column(name="iddisc")
	private Long id;
	
	@Column(name="nome_disc",length=100,nullable=false)
	private String nome;
	
	@Column(name="natureza",length=100)
	private String natureza;
	
	@Column(name="objetivo",length=150)
	private String objetivo;
	
	@Column(name="carga_horaria",length=4)
	private Integer carga;
	
	@Column(length=250)
	private String observacao;
	
	public Disciplina() {
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

	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Integer getCarga() {
		return carga;
	}

	public void setCarga(Integer carga) {
		this.carga = carga;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
