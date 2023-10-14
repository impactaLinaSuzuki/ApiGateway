package com.example.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "ProdutoComponente")
@Table(name = "ProdutoComponente")
public class ProdutoComponente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "ProdutoId")
    public int produtoId;


    @Column(name = "ComponenteId")
    public int componenteId;

    public ProdutoComponente() {
        super();
    }

    public ProdutoComponente(
        int produtoId, 
        int componenteId
       ) {
        this.produtoId = produtoId;
        this.componenteId = componenteId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getComponenteId() {
        return componenteId;
    }

    public void setComponenteId(int componenteId) {
        this.componenteId = componenteId;
    } 
    
}
