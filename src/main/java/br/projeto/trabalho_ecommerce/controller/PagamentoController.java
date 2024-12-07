package br.projeto.trabalho_ecommerce.controller;

import br.projeto.trabalho_ecommerce.dto.pagamentoDTO;
import br.projeto.trabalho_ecommerce.model.pagamento;
import br.projeto.trabalho_ecommerce.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoRepository repository;

    @GetMapping // CRUD GET
    public ResponseEntity<List<pagamento>> findAll() {
        List<pagamento> pagamento = this.repository.findAll();
        return ResponseEntity.ok(pagamento);
    }

    @GetMapping("/{id}") // CRUD GET
    public pagamento findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("pagamento indefinido"));
    }

    @PostMapping //CRUD POST
    public ResponseEntity<pagamento> save(@RequestBody pagamentoDTO dto) {

        if (dto.forma_pgmt() .isEmpty() ) {
            return ResponseEntity.status(428).build();
        } // aplica a validação na pedido

        pagamento pagamento = new pagamento();
        pagamento.setForma_pgmt(dto.forma_pgmt());
        pagamento.setData_pgmt(dto.data_pgmt());
        pagamento.setValor(dto.valor());

        this.repository.save(pagamento);
        return ResponseEntity.ok(pagamento);
    }

    @DeleteMapping("/{id}") // CRUD DELETE
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        pagamento pagamento = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("pagamento cancelado"));

        this.repository.delete(pagamento);
        return ResponseEntity.noContent().build();
    }

    @PutMapping ("/{id}") // CRUD UPDATE
    public ResponseEntity<pagamento> upddate(@PathVariable Integer id, @RequestBody pagamentoDTO dto) {

        if (dto.forma_pgmt() .isEmpty()) {
            return ResponseEntity.status(428).build();
        } // aplica a validação em todos os pagamento

        pagamento pagamento = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("pagamento atualizado"));

        pagamento.setForma_pgmt(dto.forma_pgmt());
        pagamento.setData_pgmt(dto.data_pgmt());
        pagamento.setValor(dto.valor());

        this.repository.save(pagamento);
        return ResponseEntity.ok(pagamento);
    }
}