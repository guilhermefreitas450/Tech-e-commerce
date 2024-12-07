package br.projeto.trabalho_ecommerce.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table
public class pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private pagamento pagamento;

    @Column
    private String forma_pgmt;

    @Column
    private LocalDateTime data_pgmt;

    @Column(name = ("valor"))
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "itemPedido_id", referencedColumnName = "id")
    @JsonManagedReference
    private itemPedido itemPedido_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public br.projeto.trabalho_ecommerce.model.pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(br.projeto.trabalho_ecommerce.model.pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public String getForma_pgmt() {
        return forma_pgmt;
    }

    public void setForma_pgmt(String forma_pgmt) {
        this.forma_pgmt = forma_pgmt;
    }

    public LocalDateTime getData_pgmt() {
        return data_pgmt;
    }

    public void setData_pgmt(LocalDateTime data_pgmt) {
        this.data_pgmt = data_pgmt;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public itemPedido getItemPedido_id() {
        return itemPedido_id;
    }

    public void setItemPedido_id(itemPedido itemPedido_id) {
        this.itemPedido_id = itemPedido_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        pagamento pagamento = (pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
