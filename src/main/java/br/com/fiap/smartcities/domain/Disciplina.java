package br.com.fiap.smartcities.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_disciplina")
public class Disciplina {

	@Id
	@SequenceGenerator(name = "disciplina", sequenceName = "sq_tbl_disciplina", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disciplina")
	@Column(name = "id_disciplina")
	private Integer id;

	@Column(name = "nome_disciplina", length = 50)
	private String nome;

	@Column(name = "numero_carga_horaria")
	private Integer cargaHoraria;
	
	@ManyToOne
	private Professor professor;

	public Disciplina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Number getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

}