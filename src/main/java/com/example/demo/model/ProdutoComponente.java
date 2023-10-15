package com.example.demo.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "ProdutoComponente")
@Table(name = "ProdutoComponente")
public class ProdutoComponente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne
    @JoinColumn(name = "ProdutoId")
    public Produto produto;

    @ManyToOne
    @JoinColumn(name = "ComponenteId")
    public Componente componente;

    // public Produto produto;

    // public Componente componente;

    public ProdutoComponente() {
        super();
    }

    public ProdutoComponente(
        Produto produto, 
        Componente componente
       ) {
        this.produto = produto;
        this.componente = componente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    } 
    
     @Override
    public boolean equals(Object o) {
        if (this == o) 
            return true;

        if (o == null || getClass() != o.getClass()) 
            return false;
            
        ProdutoComponente that = (ProdutoComponente) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
