package br.projeto.trabalho_ecommerce.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record pedidoDTO (
                         LocalDateTime data_pedido,
                         String andamento,
                         BigDecimal total){
}