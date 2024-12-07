package br.projeto.trabalho_ecommerce.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record pagamentoDTO( String forma_pgmt,
                            LocalDateTime data_pgmt,
                            BigDecimal valor){
}