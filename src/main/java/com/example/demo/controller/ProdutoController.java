package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;

@RestController
@Tag(name = "Produto")
@RequestMapping("/api/v1/produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepository _ProdutRepository;

    @PostMapping("/create")
    public ResponseEntity<Produto> CreateProduct(@RequestBody Produto produto){
        Produto newProduct = _ProdutRepository.save(produto);
         return ResponseEntity.ok().body(newProduct);
       
    }

    @GetMapping("/get")
    public ResponseEntity<Produto> GetProductById(@PathParam(value = "id") int productId){
        Produto foundProduct = _ProdutRepository.findById(productId).get();
        return ResponseEntity.ok().body(foundProduct);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Produto>> GetAll(){
        List<Produto> produtos = _ProdutRepository.findAll();
        return ResponseEntity.ok().body(produtos);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> Delete(@PathParam(value = "productId") int productId){
        _ProdutRepository.deleteById(productId);

        return ResponseEntity.ok().body("Deletado com sucesso");
    }

    @PutMapping("/update")
    public ResponseEntity<Produto> UpdateProduct(@RequestBody Produto produto){

        Produto alterProduto = new Produto();

        Produto productOld = _ProdutRepository.findById(produto.getId()).get();

        if(productOld != null){
            productOld.setCodigo(produto.getCodigo());
            productOld.setNome(produto.getNome());
 
            alterProduto = _ProdutRepository.save(productOld);
        }
        return ResponseEntity.ok().body(alterProduto);
    }

    @GetMapping("/getProductByCode")
    public ResponseEntity<Produto> getProductByCode(@PathParam(value = "productCode") String productCode){
        Produto produto = _ProdutRepository.findByCodigo(productCode);

        return ResponseEntity.ok().body(produto);
    }

}
