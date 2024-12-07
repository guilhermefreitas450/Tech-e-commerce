package br.projeto.trabalho_ecommerce.dto;

import java.math.BigDecimal;

public record itemPedidoDTO(Integer pedidoId,
                            Integer produtoId,
                            Integer quantidade,
                            BigDecimal preco) {
}
