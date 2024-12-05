package br.projeto.trabalho_ecommerce.controller;

import br.projeto.trabalho_ecommerce.dto.usuarioDTO;
import br.projeto.trabalho_ecommerce.model.usuario;
import br.projeto.trabalho_ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping // CRUD GET
    public ResponseEntity<List<usuario>> findAll() {
        List<usuario> usuario = this.repository.findAll();
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{id}") // CRUD GET
    public usuario findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Usuario nao pode ser encontrado"));
    }

    @PostMapping //CRUD POST
    public ResponseEntity<usuario> save(@RequestBody usuarioDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }
        usuario usuario = new usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setTelefone(dto.telefone());
        usuario.setEndereco(dto.endereco());

        this.repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}") // CRUD DELETE
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        usuario usuario = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Usuário excluido"));
        this.repository.delete(usuario);
        return ResponseEntity.noContent().build();
    }

    @PutMapping ("/{id}") // CRUD UPDATE
    public ResponseEntity<usuario> upddate(@PathVariable Integer id, @RequestBody usuarioDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        usuario usuario = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Dados do usuário atualizados"));
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setTelefone(dto.telefone());
        usuario.setEndereco(dto.endereco());

        this.repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

}