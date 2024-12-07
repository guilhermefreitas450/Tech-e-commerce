package br.projeto.trabalho_ecommerce.repository;

import br.projeto.trabalho_ecommerce.model.pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<pagamento, Integer> {

}
