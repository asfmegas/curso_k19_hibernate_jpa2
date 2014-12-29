package curso.extra.teste.relacionamentos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbcurso")
public class Curso {
	
	@Id 
	@GeneratedValue
	@Column(name="idcur")
	private Long id;
	
	@Column(name="curso",length=100,nullable=false,unique=true)
	private String nome;
	
	@Column(name="carga_horaria",length=4)
	private Integer carga;
	
	@Column(length=250)
	private String observacao;
	
	@ManyToMany
	@JoinTable(
			name="tbcurso_disc",
			joinColumns=@JoinColumn(name="curso_id"),
			inverseJoinColumns=@JoinColumn(name="disc_id"))
	private List<Disciplina> disc = new ArrayList<Disciplina>();
	
	public Curso() {
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

	public List<Disciplina> getDisc() {
		return disc;
	}

	public void setDisc(List<Disciplina> disc) {
		this.disc = disc;
	}
}
