package edu.com.unoesc.restaurante.form;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import edu.com.unoesc.restaurante.models.Produto;

public class ComandaAdicionarForm {

    @NotNull
    private Integer id;
    @NotNull
    private Double valorTotal;
    @NotNull
    private Double desconto;
    @NotNull
    private Double valorPago;
    @NotBlank
    private String mesa;
    @NotNull
    private LocalDateTime dataCriacao;
    @NotNull
    private LocalDateTime dataFinalizacao;
    @NotNull
    private int estabelecimento;
    @NotNull
    private List<Produto> produtos;

    public ComandaAdicionarForm() {
        this.id = -1;
    }

//    public ComandaAdicionarForm(Comanda comanda) {
//        this.id = comanda.getId();
//        this.valorTotal = comanda.getValorTotal();
//        this.desconto = comanda.getDesconto();
//        this.valorPago = comanda.getValorPago();
//        this.mesa = comanda.getMesa();
//        this.dataCriacao = comanda.getDataCriacao();
//        this.dataFinalizacao = comanda.getDataFinalizacao();
//        this.estabelecimento = comanda.getEstabelecimento().getId();
//        this.produtos = comanda.getProdutos();
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(LocalDateTime dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public int getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(int estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

//    public Comanda getComanda(EstabelecimentoDAO estabelecimentoDAO) {
//        Estabelecimento estabelecimentoById = estabelecimentoDAO.getEstabelecimentoById(this.getEstabelecimento());
//        return new Comanda(id, valorTotal, desconto, valorPago, mesa, dataCriacao, dataFinalizacao, estabelecimentoById);
//    }
}
