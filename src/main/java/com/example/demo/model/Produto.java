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


@Entity(name = "Produto")
@Table(name = "Produto")
public class Produto {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Codigo", nullable =  false)
    private String codigo;

    @Column(name = "Nome", nullable =  false)
    private String nome;

    @OneToMany(mappedBy = "produto")
    private Set<ProdutoComponente> componentes = new HashSet<>();

    // @ManyToMany(cascade = CascadeType.ALL)
    // @JoinTable(name = "produto_componente",
    //             joinColumns = 
    //             @JoinColumn(name = "ProdutoId"),
    //         inverseJoinColumns = 
    //         @JoinColumn(name = "ComponenteId"))
    // @JsonBackReference
    // private Set<Componente> componentes = new HashSet<>();
    
    public Produto() {
        super();
    }

    public Produto(
        // int id,
        String codigo, 
        String nome
        //,Set<Componente> _componentes
        ) 
    {
        // this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        //this.componentes = _componentes;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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
