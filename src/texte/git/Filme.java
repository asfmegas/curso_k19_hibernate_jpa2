package texte.git;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * 
 * @author Alesandro Façanha
 * @since 2014
 *
 */

@Entity
public class Filme {
	
	@Id @GeneratedValue
	private Long id;
	
	private String nome;
	
	private Calendar data;
	
	public Filme() {
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

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

}
