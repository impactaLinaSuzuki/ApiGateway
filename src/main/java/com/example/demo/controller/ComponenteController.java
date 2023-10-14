package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Componente;
import com.example.demo.repository.ComponenteRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1/componente")
public class ComponenteController {
    @Autowired
    private ComponenteRepository _ComponenteRepository;

    @PostMapping()
    public Componente CreateComponent(@RequestBody Componente componente){
       return _ComponenteRepository.save(componente);
    }

    @GetMapping("/{componentId}")
    public Componente GetComponent(@PathVariable int componentId){
        return _ComponenteRepository.findById(componentId).get();
    }

    @GetMapping()
    public List<Componente> GetAll(){
        return _ComponenteRepository.findAll();
    }

    @DeleteMapping("/{componentId}")
    public void Delete(@PathVariable int componentId){
        _ComponenteRepository.deleteById(componentId);
    }

    @PutMapping("/{componentId}")
    public Componente UpdateComponente(@PathVariable int componentId, @RequestBody Componente componente){
        Componente componentOld = _ComponenteRepository.findById(componentId).get();

        if(componentOld != null){
            componentOld.setCodigo(componente.getCodigo());
            componentOld.setDescricao(componente.getDescricao());
            componentOld.setIndice(componente.getIndice());
            componentOld.setPreco(componente.getPreco());
            componentOld.setQuantidade(componente.getQuantidade());
            componentOld.setSku(componente.getSku());
            //componentOld.setProdutos(componente.getProdutos());

            _ComponenteRepository.save(componentOld);
        }
        return componentOld;
    }
}
