package curso.extra.teste.relacionamentos;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbmovimento")
public class Movimento {

	@Id @GeneratedValue
	private Long id;
	
	private Float nota1;
	private Float nota2;
	private Float nota3;
	private Float nota4;
	private Float nota5;
	private Float nota6;
	private Integer falta;
	private String turma;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	@ManyToOne
	private Curso curso;
	
	@ManyToOne
	private Disciplina disc;
	
	@ManyToOne
	private Aluno aluno;
	
	public Movimento() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getNota1() {
		return nota1;
	}

	public void setNota1(Float nota1) {
		this.nota1 = nota1;
	}

	public Float getNota2() {
		return nota2;
	}

	public void setNota2(Float nota2) {
		this.nota2 = nota2;
	}

	public Float getNota3() {
		return nota3;
	}

	public void setNota3(Float nota3) {
		this.nota3 = nota3;
	}

	public Float getNota4() {
		return nota4;
	}

	public void setNota4(Float nota4) {
		this.nota4 = nota4;
	}

	public Float getNota5() {
		return nota5;
	}

	public void setNota5(Float nota5) {
		this.nota5 = nota5;
	}

	public Float getNota6() {
		return nota6;
	}

	public void setNota6(Float nota6) {
		this.nota6 = nota6;
	}

	public Integer getFalta() {
		return falta;
	}

	public void setFalta(Integer falta) {
		this.falta = falta;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Disciplina getDisc() {
		return disc;
	}

	public void setDisc(Disciplina disc) {
		this.disc = disc;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
}
