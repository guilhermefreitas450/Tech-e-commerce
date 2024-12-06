package br.projeto.trabalho_ecommerce.controller;

import br.projeto.trabalho_ecommerce.dto.produtoDTO;
import br.projeto.trabalho_ecommerce.model.produto;
import br.projeto.trabalho_ecommerce.repository.produtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private produtoRepository repository;

    @GetMapping // CRUD GET
    public ResponseEntity<List<produto>> findAll() {
        List<produto> produto = this.repository.findAll();
        return ResponseEntity.ok(produto);
    }

    @GetMapping("/{id}") // CRUD GET
    public produto findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("produto indefinida"));
    }

    @PostMapping //CRUD POST
    public ResponseEntity<produto> save(@RequestBody produtoDTO dto) {

        if (dto.nome() .isEmpty() || dto.descricao() .isEmpty()) {
            return ResponseEntity.status(428).build();
        } // aplica a validação na produto

        produto produto = new produto();
        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setPreco(dto.preco());

        this.repository.save(produto);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}") // CRUD DELETE
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        produto produto = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("produto excluida"));

        this.repository.delete(produto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping ("/{id}") // CRUD UPDATE
    public ResponseEntity<produto> upddate(@PathVariable Integer id, @RequestBody produtoDTO dto) {

        if (dto.nome() .isEmpty() || dto.descricao() .isEmpty()) {
            return ResponseEntity.status(428).build();
        } // aplica a validação em todos os itens

        produto produto = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria atualizada"));

        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setPreco(dto.preco());

        this.repository.save(produto);
        return ResponseEntity.ok(produto);
    }
}