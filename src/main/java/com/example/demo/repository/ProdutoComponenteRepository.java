package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ProdutoComponente;
import com.example.demo.model.Produto;
import java.util.List;


@Repository
public interface ProdutoComponenteRepository extends JpaRepository<ProdutoComponente, Integer>{ 
    public List<ProdutoComponente> findByProdutoCodigo(Produto produto);
}
