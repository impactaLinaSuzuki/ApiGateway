package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Componente;

@Repository
public interface ComponenteRepository extends JpaRepository<Componente, Integer>{
    public Componente findByIndice(int index);
    public Componente findByDescricao(String descricao);
}
