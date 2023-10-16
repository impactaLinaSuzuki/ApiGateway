package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Componente;
import com.example.demo.repository.ComponenteRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;

@RestController
@Tag(name = "Componente")
@RequestMapping("/api/v1/componente")
public class ComponenteController {
    @Autowired
    private ComponenteRepository _ComponenteRepository;

    @PostMapping("/create")
    @Operation(summary = "Create a new component")
    public ResponseEntity<Componente> CreateComponente(@RequestBody Componente componente){
        Componente newComponente = _ComponenteRepository.save(componente);
        return ResponseEntity.ok().body(newComponente);
       
    }

    @GetMapping("/get")
    @Operation(summary = "Get component by id")
    public ResponseEntity<Componente> GetProductById(@PathParam(value = "id") int componenteId){
        Componente foundProduct = _ComponenteRepository.findById(componenteId).get();
        return ResponseEntity.ok().body(foundProduct);
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get all components")
    public ResponseEntity<List<Componente>> GetAll(){
        List<Componente> componentes = _ComponenteRepository.findAll();
        return ResponseEntity.ok().body(componentes);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete component")
    public ResponseEntity<String> Delete(@PathParam(value = "componenteId") int componenteId){
        _ComponenteRepository.deleteById(componenteId);

        return ResponseEntity.ok().body("Deletado com sucesso");
    }

    @PutMapping("/update")
    @Operation(summary = "Updae component")
    public ResponseEntity<Componente> UpdateProduct(@RequestBody Componente componente){

        Componente alterComponente = new Componente();

        Componente componenteOld = _ComponenteRepository.findById(componente.getId()).get();

        if(componenteOld != null){
            componenteOld.setDescricao(componente.getDescricao());
            componenteOld.setCodigo(componente.getCodigo());
            componenteOld.setIndice(componente.getIndice());
            componenteOld.setPreco(componente.getPreco());
            componenteOld.setQuantidade(componente.getQuantidade());
            componenteOld.setSku(componente.getSku());
 
            alterComponente = _ComponenteRepository.save(componenteOld);
        }
        return ResponseEntity.ok().body(alterComponente);
    }
}
