package edu.com.unoesc.restaurante.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "estabelecimento")
public class Estabelecimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "razao_social")
	private String razaoSocial;
	@Column(name = "cnpj")
	private String cnpj;
	@Column(name = "inscricao_estadual")
	private String inscricaoEstadual;
	@Column(name = "telefone")
	private String telefone;
	@OneToOne()
	@JoinColumn(name = "id_endereco", referencedColumnName = "id")
	private Endereco endereco;

	public Estabelecimento() {
		this.id = -1;
	}
	
	public Estabelecimento(Integer id, String nome, String razaoSocial, String cnpj, String inscricaoEstadual,
			String telefone, Endereco endereco) {
		this.id = id;
		this.nome = nome;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.telefone = telefone;
		this.endereco = endereco;
	}



	@JsonIgnore
	@OneToMany(mappedBy = "estabelecimento")
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, endereco, id, inscricaoEstadual, nome, razaoSocial, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estabelecimento other = (Estabelecimento) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(endereco, other.endereco)
				&& Objects.equals(id, other.id) && Objects.equals(inscricaoEstadual, other.inscricaoEstadual)
				&& Objects.equals(nome, other.nome) && Objects.equals(razaoSocial, other.razaoSocial)
				&& Objects.equals(telefone, other.telefone);
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

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
