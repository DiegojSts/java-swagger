package com.products.apirest.controller;

import com.products.apirest.models.Product;
import com.products.apirest.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
@Api(value="## Api Rest Produtos ##")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    @ApiOperation(value="Retorna uma lista de produtos")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    @ApiOperation(value="Retorna um único produto")
    public ResponseEntity<Product> getOneProduct(@PathVariable(value = "id") long id) {
         Product responseEntity = productRepository.findById(id);
    return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }

    @PostMapping("/save/product")
    @ApiOperation(value="Cadastra um produto")
    public ResponseEntity saveProduct(@RequestBody Product product) {
       productRepository.save(product);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/product/{id}")
    @ApiOperation(value="Deleta um produto")
    public ResponseEntity deleteProduct(@PathVariable(value = "id") long id) {
        productRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/product")
    @ApiOperation(value="Atualiza um produto")
    public ResponseEntity updateProduct(@RequestBody Product product) {
       productRepository.save(product);
        return new ResponseEntity(HttpStatus.CREATED);


    }
}
