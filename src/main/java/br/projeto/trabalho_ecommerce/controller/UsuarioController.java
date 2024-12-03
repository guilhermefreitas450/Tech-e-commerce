package br.projeto.trabalho_ecommerce.controller;

import br.projeto.trabalho_ecommerce.dto.usuarioDTO;
import br.projeto.trabalho_ecommerce.model.usuario;
import br.projeto.trabalho_ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<usuario> findAll(){
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public usuario findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Usuario nao pode ser encontrado"));
    }

@PostMapping
    public usuario save(@RequestBody usuarioDTO dto) {
        usuario usuario = new usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setTelefone(dto.telefone());
        usuario.setEndereco(dto.endereco());

        return this.repository.save(usuario) ;
    }
}