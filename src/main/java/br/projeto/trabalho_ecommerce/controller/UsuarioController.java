package br.projeto.trabalho_ecommerce.controller;

import br.projeto.trabalho_ecommerce.model.usuario;
import br.projeto.trabalho_ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<usuario> findall(){
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public usuario findById(@PathVariable Integer id){
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Usuario nao pode ser encontrado"));
    }

}
