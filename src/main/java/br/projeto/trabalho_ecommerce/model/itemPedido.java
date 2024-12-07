package br.projeto.trabalho_ecommerce.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table
public class itemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    private pedido pedidoId;

    @ManyToOne
    @JoinColumn(name = "produtos_id", referencedColumnName = "id")
    private produto produtos_id;

    @Column
    private Integer quantidade;

    @Column
    private BigDecimal preco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public pedido getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(pedido pedidoId) {
        this.pedidoId = pedidoId;
    }

    public produto getProdutos_id() {
        return produtos_id;
    }

    public void setProdutos_id(produto produtos_id) {
        this.produtos_id = produtos_id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        itemPedido that = (itemPedido) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
