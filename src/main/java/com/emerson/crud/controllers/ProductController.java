package com.emerson.crud.controllers;

import com.emerson.crud.domain.product.Product;
import com.emerson.crud.domain.product.ProductRepository;
import com.emerson.crud.domain.product.RequestProduct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@RestController Uma anotação de conveniência que é anotada com @Controller e @ResponseBody.
//Os tipos que carregam essa anotação são tratados como controladores, onde os métodos @RequestMapping assumem a semântica @ResponseBody por padrão.
@RestController
//@RequestMapping Anotação para mapear solicitações da web em métodos em classes de tratamento de solicitações com assinaturas de métodos flexíveis.
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    //@GetMapping Anotação para mapear solicitações HTTP GET em métodos manipuladores específicos.
    @GetMapping
    public ResponseEntity<?> getAllProduct(){
        var allProduct = repository.findAllByActiveTrue();
        return ResponseEntity.ok(allProduct);
    }

    //@PostMapping Anotação para mapear solicitações HTTP POST em métodos manipuladores específicos.
    @PostMapping
    //@Valid Marca uma propriedade, parâmetro de método ou tipo de retorno de método para validação em cascata.
    public ResponseEntity<?> registerProduct(@RequestBody @Valid RequestProduct data){
        Product newProduct = new Product(data);
        repository.save(newProduct);
        return ResponseEntity.ok().build();
    }

    //@PutMapping Anotação para mapear solicitações HTTP PUT em métodos manipuladores específicos.
    @PutMapping
    //@Transactional Descreve um atributo de transação em um método individual ou em uma classe.
    @Transactional
    public ResponseEntity<?> updateProduct(@RequestBody @Valid RequestProduct data){
        Optional<Product> optionalProduct = repository.findById(data.id());
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(data.name());
            product.setPrice_in_cents(data.price_in_cents());
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //@DeleteMapping Anotação para mapear solicitações HTTP DELETE em métodos manipuladores específicos.
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteProduct(@PathVariable String id){
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setActive(false);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
