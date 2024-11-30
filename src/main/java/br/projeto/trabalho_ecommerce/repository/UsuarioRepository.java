package br.projeto.trabalho_ecommerce.repository;

import br.projeto.trabalho_ecommerce.model.usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<usuario, Integer> {

}
