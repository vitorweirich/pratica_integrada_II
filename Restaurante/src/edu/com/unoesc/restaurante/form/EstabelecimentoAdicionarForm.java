package edu.com.unoesc.restaurante.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import edu.com.unoesc.restaurante.dao.EnderecoDAO;
import edu.com.unoesc.restaurante.models.Endereco;
import edu.com.unoesc.restaurante.models.Estabelecimento;

public class EstabelecimentoAdicionarForm {

	@NotNull
	private Integer id;
	@NotBlank
	private String nome;
	@NotBlank
	private String razaoSocial;
	@NotBlank
	private String cnpj;
	@NotBlank
	private String inscricaoEstadual;
	@NotBlank
	private String telefone;
	@NotNull
	private Integer endereco;

	public EstabelecimentoAdicionarForm() {
		this.id = -1;
	}

	public EstabelecimentoAdicionarForm(Estabelecimento estabelecimento) {
		this.id = estabelecimento.getId();
		this.nome = estabelecimento.getNome();
		this.razaoSocial = estabelecimento.getRazaoSocial();
		this.cnpj = estabelecimento.getCnpj();
		this.inscricaoEstadual = estabelecimento.getInscricaoEstadual();
		this.telefone = estabelecimento.getTelefone();
		this.endereco = estabelecimento.getEndereco().getId();
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

	public Integer getEndereco() {
		return endereco;
	}

	public void setEndereco(Integer endereco) {
		this.endereco = endereco;
	}

	public Estabelecimento getEstabelecimento(EnderecoDAO enderecoDAO) {
		Endereco enderecoById = enderecoDAO.getEnderecoById(this.getEndereco());
		return new Estabelecimento(id, nome, razaoSocial, cnpj, inscricaoEstadual, telefone, enderecoById);
	}

}
