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
import com.example.demo.service.ApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;

@RestController
@Tag(name = "ProdutoComponente")
@RequestMapping("/api/v1")
public class ProdutoComponenteController {
    
    @Autowired
    private ProdutoRepository _ProdutoRepository;

    // @Autowired
    // private ComponenteRepository _ComponenteRepository;

    @Autowired
    private ProdutoComponenteRepository _ProdutoComponenteRepository;

    @Autowired
    private ApplicationService _ApplicationService;

    public ProdutoComponenteController(
        ProdutoRepository produtoRepository,
        ProdutoComponenteRepository produtoComponenteRepository,
        ApplicationService applicationService) {
        this._ProdutoRepository = produtoRepository;
        this._ProdutoComponenteRepository = produtoComponenteRepository;
        this._ApplicationService = applicationService;
    }

    // @PostMapping("/produtoComponente/create")
    // public ResponseEntity<ProdutoComponente> createProdutoComponente(
    //     @RequestBody Produto produto, 
    //     @RequestBody Componente componente)
    // {
    //     _ProdutoRepository.save(produto);
    //     _ComponenteRepository.save(componente);

    //     ProdutoComponente produtoComponente = new ProdutoComponente(produto, componente);

    //     produtoComponente = _ProdutoComponenteRepository.save(produtoComponente);

    //     return ResponseEntity.ok().body(produtoComponente);
    // }

    @PostMapping("/produtoComponente/create")
    @Operation(summary = "Create product and component and add component in product")
    public ResponseEntity<ProdutoComponente> createProdutoComponente(
        @RequestBody ProdutoComponente produtoComponente)
    {
        _ApplicationService.Save(produtoComponente.getProduto(), produtoComponente.getComponente());

        produtoComponente = _ProdutoComponenteRepository.save(produtoComponente);

        return ResponseEntity.ok().body(produtoComponente);
    }

    @GetMapping("/produtoComponente/get")
    @Operation(summary = "Get productComponent by id")
    public ResponseEntity<ProdutoComponente> GetProductById(
        @PathParam(value = "id") int productComponenteId)
    {
        ProdutoComponente produtoComponente = _ProdutoComponenteRepository.findById(productComponenteId).get();

        return ResponseEntity.ok().body(produtoComponente);
    }

    @GetMapping("/produtoComponente/getAll")
    @Operation(summary = "Get all product and your components")
    public ResponseEntity<List<ProdutoComponente>> GetAll(){
        List<ProdutoComponente> produtoComponentes = _ProdutoComponenteRepository.findAll();
        return ResponseEntity.ok().body(produtoComponentes);
    }

    @DeleteMapping("/produtoComponente/delete")
    @Operation(summary = "Delete a component of product")
    public ResponseEntity<String> Delete(@PathParam(value = "productComponenteId") int productComponenteId){
        _ProdutoComponenteRepository.deleteById(productComponenteId);

        return ResponseEntity.ok().body("Deletado com sucesso");
    }

    @PutMapping("/produtoComponente/update")
    @Operation(summary = "Update product value, component value or/and relationship between entities")
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
    @Operation(summary = "Add component in product")
    public ResponseEntity<ProdutoComponente> addComponentInProduct(@PathVariable String codigo, @RequestBody Componente componente){
        Produto produto = _ProdutoRepository.findByCodigo(codigo);
        ProdutoComponente produtoComponente = new ProdutoComponente(produto, componente);
        
        produtoComponente = _ProdutoComponenteRepository.save(produtoComponente);
        
        return ResponseEntity.ok().body(produtoComponente);
    }

    @GetMapping(value = "/produto/{codigo}/componente/{indice}")
    @Operation(summary = "Get product by code and your component by index")
    public ResponseEntity<List<ProdutoComponente>> findByProdCodAndIndex(
        @PathVariable String codigo, 
        @PathVariable int indice)
    {
        List<ProdutoComponente> newProdutoComponentes = new ArrayList<ProdutoComponente>();

        List<ProdutoComponente> produtosComponentes = _ProdutoComponenteRepository.findAll().stream().toList();

        for (ProdutoComponente produtoComponente : produtosComponentes) {
            
            if( produtoComponente.getProduto().getCodigo().equals(codigo) &&
                produtoComponente.getComponente().getIndice() == indice)
            {
                newProdutoComponentes.add(produtoComponente);
            }
        }

        return ResponseEntity.ok().body(newProdutoComponentes);
    }

    @GetMapping(value = "/produto/{codigo}/componente")
    @Operation(summary = "Get all components by product code")
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

    @GetMapping("produto/componente")
    @Operation(summary = "Get produto and component by description component")
    public ResponseEntity<List<ProdutoComponente>> getComponentByDescription(@PathParam(value = "descricao") String descricao){

        List<ProdutoComponente> newProdutosComponentes = new ArrayList<ProdutoComponente>();

        List<ProdutoComponente> produtosComponentes = _ProdutoComponenteRepository.findAll().stream().toList();

        for (ProdutoComponente produtoComponente : produtosComponentes) {
            if(produtoComponente.getComponente().getDescricao().equalsIgnoreCase(descricao)){
                newProdutosComponentes.add(produtoComponente);
            }
        }

        return ResponseEntity.ok().body(newProdutosComponentes);
    }
}
