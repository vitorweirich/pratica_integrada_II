package edu.com.unoesc.restaurante.form;

import edu.com.unoesc.restaurante.dao.EnderecoDAO;
import edu.com.unoesc.restaurante.dao.EstabelecimentoDAO;
import edu.com.unoesc.restaurante.models.Endereco;
import edu.com.unoesc.restaurante.models.Estabelecimento;
import edu.com.unoesc.restaurante.models.Funcionario;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class FuncionarioAdicionarForm {

    @NotNull
    private Integer id;
    @NotBlank
    private String nome;
    @NotNull
    private LocalDate nascimento;
    @NotBlank
    private String cpf;
    @NotBlank
    private String funcao;
    @NotNull
    private int endereco;
    @NotNull
    private int estabelecimento;

    public FuncionarioAdicionarForm() {
        this.id = -1;
    }

    public FuncionarioAdicionarForm(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.nascimento = funcionario.getNascimento();
        this.cpf = funcionario.getCpf();
        this.funcao = funcionario.getFuncao();
        this.endereco = funcionario.getEndereco().getId();
        this.estabelecimento = funcionario.getEstabelecimento().getId();
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

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getEndereco() {
        return endereco;
    }

    public void setEndereco(int endereco) {
        this.endereco = endereco;
    }

    public int getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(int estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Funcionario getFuncionario(EnderecoDAO enderecoDAO, EstabelecimentoDAO estabelecimentoDAO) {
        Endereco enderecoById = enderecoDAO.getEnderecoById(this.getEndereco());
        Estabelecimento estabelecimentoById = estabelecimentoDAO.getEstabelecimentoById(this.getEstabelecimento());
        return new Funcionario(id, nome, nascimento, cpf, funcao, enderecoById, estabelecimentoById);
    }
}
