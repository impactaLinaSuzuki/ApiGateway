package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity(name = "Produto")
@Table(name = "Produto")
public class Produto {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Codigo", nullable =  true)
    private String codigo;

    @Column(name = "Nome", nullable =  true)
    private String nome;

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
        int id,
        String codigo, 
        String nome
        //,Set<Componente> _componentes
        ) 
    {
        this.id = id;
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

    // public Set<Componente> getComponentes() {
    //     return componentes;
    // }

    // public void setComponentes(Set<Componente> componentes) {
    //     this.componentes = componentes;
    // }

    
}
