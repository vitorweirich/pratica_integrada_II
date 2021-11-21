package edu.com.unoesc.restaurante.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "comandas")
public class Comanda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "valor_total")
	private Double valorTotal;
	@Column(name = "desconto")
	private Double desconto;
	@Column(name = "valor_pago")
	private Double valorPago;
	@Column(name = "mesa")
	private String mesa;
	@Column(name = "data_hora_criacao")
	private LocalDateTime dataCriacao;
	@Column(name = "data_hora_finalizacao")
	private LocalDateTime dataFinalizacao;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_estabelecimento", referencedColumnName = "id")
	private Estabelecimento estabelecimento;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "pedidos", joinColumns = { @JoinColumn(name = "id_comandas") }, inverseJoinColumns = {
			@JoinColumn(name = "id_produtos") })
	private List<Produto> produtos = new ArrayList<Produto>();
	@JsonBackReference()
	@OneToMany(mappedBy = "comanda", fetch = FetchType.EAGER)
	private List<Pedido> pedidos = new ArrayList<Pedido>();

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Comanda() {
		this.id = -1;
	}

	public Comanda(Integer id, Double valorTotal, Double desconto, Double valorPago, String mesa, LocalDateTime dataCriacao, LocalDateTime dataFinalizacao, Estabelecimento estabelecimento) {
		this.id = id;
		this.valorTotal = valorTotal;
		this.desconto = desconto;
		this.valorPago = valorPago;
		this.mesa = mesa;
		this.dataCriacao = dataCriacao;
		this.dataFinalizacao = dataFinalizacao;
		this.estabelecimento = estabelecimento;
	}

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

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataCriacao, dataFinalizacao, desconto, estabelecimento, id, mesa, valorPago, valorTotal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comanda other = (Comanda) obj;
		return Objects.equals(dataCriacao, other.dataCriacao) && Objects.equals(dataFinalizacao, other.dataFinalizacao)
				&& Objects.equals(desconto, other.desconto) && Objects.equals(estabelecimento, other.estabelecimento)
				&& Objects.equals(id, other.id) && Objects.equals(mesa, other.mesa)
				&& Objects.equals(valorPago, other.valorPago) && Objects.equals(valorTotal, other.valorTotal);
	}

}
