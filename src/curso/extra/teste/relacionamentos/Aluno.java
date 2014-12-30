package curso.extra.teste.relacionamentos;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbaluno")
public class Aluno {
	
	@Id @GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="nome",length=150,nullable=false)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Calendar nasc;
	
	@Column(name="email",length=150)
	private String email;
	
	@Column(name="rua",length=150)
	private String rua;
	
	@Column(name="numero")
	private Integer numero;
	
	@Column(name="bairro",length=150)
	private String bairro;

	@Column(name="cidade",length=100)
	private String cidade;
	
	@Column(name="uf",length=50)
	private String estado;
	
	@Column(name="cep",length=10)
	private String cep;
	
	public Aluno() {
		super();
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

	public Calendar getNasc() {
		return nasc;
	}

	public void setNasc(Calendar nasc) {
		this.nasc = nasc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
