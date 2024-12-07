package br.projeto.trabalho_ecommerce.controller;

import br.projeto.trabalho_ecommerce.dto.pedidoDTO;
import br.projeto.trabalho_ecommerce.model.pedido;
import br.projeto.trabalho_ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping // CRUD GET
    public ResponseEntity<List<pedido>> findAll() {
        List<pedido> pedido = this.repository.findAll();
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/{id}") // CRUD GET
    public pedido findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("pedido indefinido"));
    }

    @PostMapping //CRUD POST
    public ResponseEntity<pedido> save(@RequestBody pedidoDTO dto) {

        if (dto.andamento() .isEmpty() ) {
            return ResponseEntity.status(428).build();
        } // aplica a validação na pedido

        pedido pedido = new pedido();
        pedido.setData_pedido(dto.data_pedido());
        pedido.setAndamento(dto.andamento());
        pedido.setTotal(dto.total());

        this.repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}") // CRUD DELETE
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        pedido pedido = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("pedido excluida"));

        this.repository.delete(pedido);
        return ResponseEntity.noContent().build();
    }

    @PutMapping ("/{id}") // CRUD UPDATE
    public ResponseEntity<pedido> upddate(@PathVariable Integer id, @RequestBody pedidoDTO dto) {

        if (dto.andamento() .isEmpty()) {
            return ResponseEntity.status(428).build();
        } // aplica a validação em todos os itens

        pedido pedido = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("pedido atualizado"));

        pedido.setData_pedido(dto.data_pedido());
        pedido.setAndamento(dto.andamento());
        pedido.setTotal(dto.total());

        this.repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }
}