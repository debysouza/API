package br.com.api.faculdade.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="alu_cd_id")
	private Long alunoId;
	
	@Column(name="alu_tx_nome")
	private String nome;
	
	@Column(name="alu_tx_email")
	private String email;

	//Muitos para um
	@ManyToOne
	@JoinColumn(name="fk_facul_cd_id")
	private Faculdade faculdadeRel;
	
	@OneToOne(mappedBy="alunoRel")
	private Avaliacao avaliacao;
	
	public Aluno() {
	}

	public Aluno(Long alunoId, String nome, String email) {
		this.alunoId = alunoId;
		this.nome = nome;
		this.email = email;
	}

	public Long getId() {
		return alunoId;
	}

	public void setId(Long alunoId) {
		this.alunoId = alunoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
