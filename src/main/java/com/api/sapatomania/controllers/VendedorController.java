package com.api.sapatomania.controllers;



import com.api.sapatomania.dto.VendedorDTO;
import com.api.sapatomania.services.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vendedores")
public class VendedorController {

    private final VendedorService vendedorService;

    @Autowired
    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @GetMapping
    public ResponseEntity<List<VendedorDTO>> listarVendedores() {
        List<VendedorDTO> vendedores = vendedorService.listarVendedores();
        return ResponseEntity.ok(vendedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendedorDTO> obterVendedor(@PathVariable Long id) {
        VendedorDTO vendedor = vendedorService.obterVendedor(id);
        return ResponseEntity.ok(vendedor);
    }

    @PostMapping
    public ResponseEntity<VendedorDTO> criarVendedor(@RequestBody VendedorDTO vendedorDTO) {
        VendedorDTO novoVendedor = vendedorService.criarVendedor(vendedorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoVendedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendedorDTO> atualizarVendedor(@PathVariable Long id, @RequestBody VendedorDTO vendedorDTO) {
        VendedorDTO vendedorAtualizado = vendedorService.atualizarVendedor(id, vendedorDTO);
        return ResponseEntity.ok(vendedorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirVendedor(@PathVariable Long id) {
        vendedorService.excluirVendedor(id);
        return ResponseEntity.noContent().build();
    }
}


