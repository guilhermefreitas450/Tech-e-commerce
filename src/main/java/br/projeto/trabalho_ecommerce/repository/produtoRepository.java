package br.projeto.trabalho_ecommerce.repository;

import br.projeto.trabalho_ecommerce.model.produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface produtoRepository extends JpaRepository<produto, Integer> {
}
