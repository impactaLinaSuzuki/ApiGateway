package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Componente;
import com.example.demo.model.Produto;
import com.example.demo.model.ProdutoComponente;
import com.example.demo.repository.ComponenteRepository;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.service.ApplicationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepository _ProdutRepository;

    @Autowired
    private ComponenteRepository _ComponenteRepository;

    @Autowired
    private ApplicationService _ApplicationService;

    @PostMapping()
    public Produto CreateProduct(@RequestParam String codigo, @RequestParam String nomeProduto){
        var produto = new Produto();
        produto.setCodigo(codigo);
        produto.setNome(nomeProduto);
         return _ProdutRepository.save(produto);
       
    }

    @GetMapping("/get/{productId}")
    public Produto GetProductById(@PathVariable int productId){
        return _ProdutRepository.findById(productId).get();
    }

    @GetMapping()
    public List<Produto> GetAll(){
        return _ProdutRepository.findAll();
    }

    @DeleteMapping(value = "{productId}")
    public void Delete(@PathVariable int productId){
        _ProdutRepository.deleteById(productId);
    }

    @PutMapping(value = "{productId}")
    public Produto UpdateProduct(@PathVariable int productId, @RequestBody Produto produto){
        Produto productOld = _ProdutRepository.findById(productId).get();

        if(productOld != null){
            productOld.setCodigo(produto.getCodigo());
            productOld.setNome(produto.getNome());
            //productOld.setComponentes(produto.getComponentes());

            _ProdutRepository.save(productOld);
        }
        return productOld;
    }

    @GetMapping(value = "{productCode}")
    public Produto getProductByCode(@PathVariable String productCode){
        return _ProdutRepository.findByCodigo(productCode);
    }

    @PostMapping(value = "{productCode}/componente")
    public ProdutoComponente addComponentInProduct(@PathVariable String productCode, @RequestBody Componente componente){
     
        return _ApplicationService.setComponenteInProduto(productCode, componente);
    }

    @GetMapping(value = "/{productCode}/componente/{index}")
    public ProdutoComponente findByProdCodAndIndex(@PathVariable String productCode, @PathVariable int index){
       
        return _ApplicationService.FindByProdCodAndIndex(productCode, index);
    }

    // @GetMapping(value = "/{productCode}/componente")
    // public Set<Componente> getComponentByProdCode(@PathVariable String productCode){
    //     //return _ProdutRepository.findByCodigo(productCode).getComponentes();
    // }

    @GetMapping(value = "/componente?descricao={description}")
    public Componente getComponentByDescription(@PathVariable String description){
        return _ComponenteRepository.findByDescricao(description);
    }
}
