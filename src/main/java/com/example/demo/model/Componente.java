package com.example.demo.model;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "Componente")
@Table(name = "Componente")
public class Componente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Codigo", nullable = true)
    private String codigo;

    @Column(name = "Indice", nullable = true)
    private int indice;

    @Column(name = "SKU", nullable = true)
    private String sku;

    @Column(name = "Descricao", nullable = true)
    private String descricao;

    @Column(name = "Preco", nullable = true)
    private double preco;

    @Column(name = "Quantidade", nullable = true)
    private int quantidade;

    @OneToMany(mappedBy = "componente")
    private Set<ProdutoComponente> produtos = new HashSet<>();

    public Componente() {
        super();
    }

    public Componente(
        // int id, 
        String codigo, 
        int indice, 
        String sku, 
        String descricao, 
        double preco, 
        int quantidade
        //,Set<Produto> _produtos
        ) 
    {
        // this.id = id;
        this.codigo = codigo;
        this.indice = indice;
        this.sku = sku;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        //this.produtos = _produtos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // public Set<Produto> getProdutos() {
    //     return produtos;
    // }

    // public void setProdutos(Set<Produto> produtos) {
    //     this.produtos = produtos;
    // }
    
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoComponente that = (ProdutoComponente) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
