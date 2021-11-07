package edu.com.unoesc.restaurante.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import edu.com.unoesc.restaurante.models.Endereco;

public class EnderecoAdicionarForm {
	@NotNull
	private Integer id;
	@NotBlank
	private String logradouro;
	@NotBlank
	private String bairro;
	@NotBlank
	private String cidade;
	@NotBlank
	private String cep;

	public EnderecoAdicionarForm() {
		this.id = -1;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		System.out.println("Set id " + id);
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Endereco getEndereco() {
		return new Endereco(id, logradouro, bairro, cidade, cep);
	}

}
