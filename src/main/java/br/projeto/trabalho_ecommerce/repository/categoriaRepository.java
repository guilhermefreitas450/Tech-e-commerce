package br.projeto.trabalho_ecommerce.repository;

import br.projeto.trabalho_ecommerce.model.categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categoriaRepository extends JpaRepository<categoria, Integer> {
}
