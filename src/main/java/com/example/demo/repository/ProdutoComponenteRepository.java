package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ProdutoComponente;

@Repository
public interface ProdutoComponenteRepository extends JpaRepository<ProdutoComponente, Integer>{ 
    public ArrayList<ProdutoComponente> findAllByProdutoId(int produtoId);
    public ArrayList<ProdutoComponente> findAllByComponenteId(int componenteId);

     public ProdutoComponente findByProdutoId(int produtoId);
    public ProdutoComponente findByComponenteId(int componenteId);
}
