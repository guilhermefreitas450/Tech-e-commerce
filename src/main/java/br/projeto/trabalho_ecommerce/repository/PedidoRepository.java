package br.projeto.trabalho_ecommerce.repository;

import br.projeto.trabalho_ecommerce.model.pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<pedido, Integer> {

}
