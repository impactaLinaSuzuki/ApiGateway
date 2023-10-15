package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Componente;
import com.example.demo.model.Produto;
import com.example.demo.model.ProdutoComponente;
import com.example.demo.repository.ProdutoComponenteRepository;
import com.example.demo.repository.ProdutoRepository;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;

@RestController
@Tag(name = "ProdutoComponente")
@RequestMapping("/api/v1")
public class ProdutoComponenteController {
    
    @Autowired
    private ProdutoRepository _ProdutoRepository;

    @Autowired
    private ProdutoComponenteRepository _ProdutoComponenteRepository;

    public ProdutoComponenteController(
        ProdutoRepository produtoRepository,
        ProdutoComponenteRepository produtoComponenteRepository) {
        this._ProdutoRepository = produtoRepository;
        this._ProdutoComponenteRepository = produtoComponenteRepository;
    }

    @PostMapping("/produtoComponente/create")
    public ResponseEntity<ProdutoComponente> createProdutoComponente(
        @PathParam(value = "{produto}") Produto produto, 
        @PathParam(value = "{componente}") Componente componente)
    {
        ProdutoComponente produtoComponente = new ProdutoComponente(produto, componente);

        produtoComponente = _ProdutoComponenteRepository.save(produtoComponente);

        return ResponseEntity.ok().body(produtoComponente);
    }

    @PostMapping("/produtoComponente/get")
    public ResponseEntity<ProdutoComponente> GetProductById(
        @PathParam(value = "id") int productComponenteId)
    {
        ProdutoComponente produtoComponente = _ProdutoComponenteRepository.findById(productComponenteId).get();

        return ResponseEntity.ok().body(produtoComponente);
    }

    @GetMapping("/produtoComponente/getAll")
    public ResponseEntity<List<ProdutoComponente>> GetAll(){
        List<ProdutoComponente> produtoComponentes = _ProdutoComponenteRepository.findAll();
        return ResponseEntity.ok().body(produtoComponentes);
    }

    @DeleteMapping("/produtoComponente/delete")
    public ResponseEntity<String> Delete(@PathParam(value = "productComponenteId") int productComponenteId){
        _ProdutoComponenteRepository.deleteById(productComponenteId);

        return ResponseEntity.ok().body("Deletado com sucesso");
    }

    @PutMapping("/produtoComponente/update")
    public ResponseEntity<ProdutoComponente> UpdateProduct(@RequestBody ProdutoComponente productComponente){

        ProdutoComponente alterProdutoComponente = new ProdutoComponente();

        ProdutoComponente productComponenteOld = _ProdutoComponenteRepository.findById(productComponente.getId()).get();

        if(productComponente != null){
           productComponenteOld.setProduto(productComponente.getProduto());
           productComponenteOld.setComponente(productComponente.getComponente());
 
            alterProdutoComponente = _ProdutoComponenteRepository.save(productComponenteOld);
        }
        return ResponseEntity.ok().body(alterProdutoComponente);
    }


    
    @PostMapping(value = "/produto/{codigo}/componente")
    public ResponseEntity<ProdutoComponente> addComponentInProduct(@PathVariable String codigo, @RequestBody Componente componente){
        Produto produto = _ProdutoRepository.findByCodigo(codigo);
        ProdutoComponente produtoComponente = new ProdutoComponente(produto, componente);
        
        produtoComponente = _ProdutoComponenteRepository.save(produtoComponente);
        
        return ResponseEntity.ok().body(produtoComponente);
    }

    @GetMapping(value = "/produto/{codigo}/componente/{indice}")
    public ResponseEntity<List<ProdutoComponente>> findByProdCodAndIndex(
        @PathVariable String codigo, 
        @PathVariable int indice)
    {
        List<ProdutoComponente> newProdutoComponentes = new ArrayList<ProdutoComponente>();

        List<ProdutoComponente> produtosComponentes = _ProdutoComponenteRepository.findAll().stream().toList();

        for (ProdutoComponente produtoComponente : produtosComponentes) {
            if(produtoComponente.getProduto().getCodigo() == codigo &&
             produtoComponente.getComponente().getIndice() == indice)
            {
                newProdutoComponentes.add(produtoComponente);
            }
        }

        return ResponseEntity.ok().body(newProdutoComponentes);
    }

    @GetMapping(value = "/produto/{codigo}/componente")
    public ResponseEntity<List<ProdutoComponente>> getComponentByProdCode(@PathVariable String codigo){

        List<ProdutoComponente> newProdutosComponentes = new ArrayList<ProdutoComponente>();

        List<ProdutoComponente> produtosComponentes = _ProdutoComponenteRepository.findAll().stream().toList();

        for (ProdutoComponente produtoComponente : produtosComponentes) 
        {
            if(produtoComponente.getProduto().getCodigo() != codigo){
                newProdutosComponentes.add(produtoComponente);
            }
        }

        return ResponseEntity.ok().body(newProdutosComponentes);
    }

    @GetMapping(value = "produto/componente?descricao={descricao}")
    public ResponseEntity<List<ProdutoComponente>> getComponentByDescription(@PathVariable String descricao){

        List<ProdutoComponente> newProdutosComponentes = new ArrayList<ProdutoComponente>();

        List<ProdutoComponente> produtosComponentes = _ProdutoComponenteRepository.findAll().stream().toList();

        for (ProdutoComponente produtoComponente : produtosComponentes) {
            if(produtoComponente.getComponente().getDescricao() != descricao){
                newProdutosComponentes.add(produtoComponente);
            }
        }

        return ResponseEntity.ok().body(newProdutosComponentes);
    }
}
