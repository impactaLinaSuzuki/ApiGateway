package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Produto;
import com.example.demo.model.ProdutoComponente;


@Repository
public interface ProdutoComponenteRepository extends JpaRepository<ProdutoComponente, Integer>{ 
    public List<ProdutoComponente> findByProdutoCodigo(Produto produto);
}
