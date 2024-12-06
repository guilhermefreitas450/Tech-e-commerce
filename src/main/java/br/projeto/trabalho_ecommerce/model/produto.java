package br.projeto.trabalho_ecommerce.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String nome;

    @Column(length = 500)
    private String descricao;

    @Column
    private BigDecimal preco;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {return preco;}

    public void setPreco(BigDecimal preco) {this.preco = preco;}
}
