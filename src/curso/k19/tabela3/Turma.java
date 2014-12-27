package curso.k19.tabela3;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Turma {
	@Id
	@GeneratedValue
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Periodo periodo;
	
	public Turma() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	
	
}

