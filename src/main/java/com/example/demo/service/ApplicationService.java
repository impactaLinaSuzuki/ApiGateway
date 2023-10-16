package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Componente;
import com.example.demo.model.Produto;
import com.example.demo.repository.ComponenteRepository;
import com.example.demo.repository.ProdutoComponenteRepository;
import com.example.demo.repository.ProdutoRepository;

//import com.example.demo.repository.ComponenteRepository;


@Service
public class ApplicationService {
    private ProdutoRepository _ProdutRepository;

    private ComponenteRepository _ComponenteRepository;

    //private ProdutoComponenteRepository _ProdutoComponenteRepository;

    public ApplicationService(
        ProdutoRepository produtRepository,
        ComponenteRepository componenteRepository,
        ProdutoComponenteRepository produtoComponenteRepository
        ) {
        this._ProdutRepository = produtRepository;
        this._ComponenteRepository = componenteRepository;
        // this._ProdutoComponenteRepository = produtoComponenteRepository;
    }

    public void Save(Produto produto, Componente componente){
        if(produto != null && componente != null)
        {
            _ProdutRepository.save(produto);
            _ComponenteRepository.save(componente);
        }
    }


}
