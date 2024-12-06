package br.projeto.trabalho_ecommerce.dto;


import java.math.BigDecimal;

public record produtoDTO(String nome,
                         String descricao,
                         BigDecimal preco) {
}
