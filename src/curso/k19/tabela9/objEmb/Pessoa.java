package curso.k19.tabela9.objEmb;

import java.util.Calendar;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pessoa {
	
	@Id @GeneratedValue
	private Long id;
	
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Calendar nasc;
	
	@Embedded
	private Endereco end;

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

	public Endereco getEnd() {
		return end;
	}

	public void setEnd(Endereco end) {
		this.end = end;
	}

}
