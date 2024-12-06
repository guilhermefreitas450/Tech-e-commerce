package br.projeto.trabalho_ecommerce.controller;

import br.projeto.trabalho_ecommerce.dto.categoriaDTO;
import br.projeto.trabalho_ecommerce.model.categoria;
import br.projeto.trabalho_ecommerce.repository.categoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private categoriaRepository repository;

    @GetMapping // CRUD GET
    public ResponseEntity<List<categoria>> findAll() {
        List<categoria> categoria = this.repository.findAll();
        return ResponseEntity.ok(categoria);
    }

    @GetMapping("/{id}") // CRUD GET
    public categoria findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria indefinida"));
    }

    @PostMapping //CRUD POST
    public ResponseEntity<categoria> save(@RequestBody categoriaDTO dto) {

        if (dto.nome() .isEmpty() || dto.descricao() .isEmpty()) {
            return ResponseEntity.status(428).build();
        } // aplica a validação na categoria

        categoria categoria = new categoria();
        categoria.setNome(dto.nome());
        categoria.setDescricao(dto.descricao());

        this.repository.save(categoria);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/{id}") // CRUD DELETE
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        categoria categoria = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria excluida"));

        this.repository.delete(categoria);
        return ResponseEntity.noContent().build();
    }

    @PutMapping ("/{id}") // CRUD UPDATE
    public ResponseEntity<categoria> upddate(@PathVariable Integer id, @RequestBody categoriaDTO dto) {

        if (dto.nome() .isEmpty() || dto.descricao() .isEmpty()) {
            return ResponseEntity.status(428).build();
        } // aplica a validação em todos os itens

        categoria categoria = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria atualizada"));

        categoria.setNome(dto.nome());
        categoria.setDescricao(dto.descricao());

        this.repository.save(categoria);
        return ResponseEntity.ok(categoria);
    }
}