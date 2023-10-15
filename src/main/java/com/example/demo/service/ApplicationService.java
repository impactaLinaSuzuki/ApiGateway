package com.example.demo.service;

import org.springframework.stereotype.Service;

//import com.example.demo.repository.ComponenteRepository;


@Service
public class ApplicationService {
    // @Autowired
    // private ProdutoRepository _ProdutRepository;
    // @Autowired
    // private ComponenteRepository _ComponenteRepository;

    // @Autowired
    // private ProdutoComponenteRepository _ProdutoComponenteRepository;

    // public ApplicationService(
    //     ProdutoRepository produtRepository,
    //     ComponenteRepository componenteRepository,
    //     ProdutoComponenteRepository produtoComponenteRepository
    //     ) {
    //     this._ProdutRepository = produtRepository;
    //     this._ComponenteRepository = componenteRepository;
    //     this._ProdutoComponenteRepository = produtoComponenteRepository;
    // }

    // public ProdutoComponente setComponenteInProduto(String productCode, Componente componente){
  
    //     //Produto produto = _ProdutRepository.findByCodigo(productCode);

    //     Componente newComponente = new Componente();
    //     newComponente.setCodigo(componente.getCodigo());
    //     newComponente.setDescricao(componente.getDescricao());
    //     newComponente.setIndice(componente.getIndice());
    //     newComponente.setPreco(componente.getPreco());
    //     newComponente.setQuantidade(componente.getQuantidade());
    //     newComponente.setSku(componente.getSku());

    //     //var novoComponente = _ComponenteRepository.save(newComponente);

    //     var produtoComponente = new ProdutoComponente();

    //     // if(produto != null && componente != null){
    //     //     produtoComponente.setProdutoId(produto.getId());
    //     //     produtoComponente.setComponenteId(novoComponente.getId());
    //     // }
        
    //     return _ProdutoComponenteRepository.save(produtoComponente);
    // }

    // public List<Componente> getComponentesByProductId(int produtoId){
        
    //     List<Componente> componentes = new ArrayList<Componente>();

    //     Optional<Produto> produto = _ProdutRepository.findById(produtoId);
     
    //     if(produto != null){
    //        ArrayList<ProdutoComponente> produtoComponentes =  _ProdutoComponenteRepository.findAllByProdutoId(produtoId);
        
    //     //    for(ProdutoComponente p:produtoComponentes){
    //     //     Optional<Componente> componente = _ComponenteRepository.findById(p.componenteId);
    //     //         componentes.add(componente.get());
    //     //    }
    //     }
        
    //     return componentes;
    // }

    // public List<Produto> getProdutosByComponenteId(int componenteId){
        
    //     List<Produto> produtos = new ArrayList<Produto>();

    //     Optional<Componente> componente = _ComponenteRepository.findById(componenteId);
     
    //     if(componente != null){
    //        ArrayList<ProdutoComponente> produtoComponentes =  _ProdutoComponenteRepository.findAllByComponenteId(componenteId);
        
    //     //    for(ProdutoComponente p:produtoComponentes){
    //     //     Optional<Produto> produto = _ProdutRepository.findById(p.produtoId);
    //     //         produtos.add(produto.get());
    //     //    }
    //     }
        
    //     return produtos;
    // }

    //@PostMapping(value = "produto/{codigo}/componente")
    // public Produto addComponentInProduct(String codigo, Componente componente){
    //     Produto produto = new Produto();

    //     boolean isSave =  _ProdutRepository.findByCodigo(codigo).getComponentes().add(componente);
      
    //     if(isSave){
    //         produto = _ProdutRepository.findByCodigo(codigo);
    //     }

    //     return produto;
    // }

    // public ProdutoComponente FindByProdCodAndIndex(String codigo, int index){
    //     var produto = _ProdutRepository.findByCodigo(codigo);
    //     var produtoComponente = _ProdutoComponenteRepository.findByProdutoId(produto.getId());

    //     var componente = _ComponenteRepository.findByIndice(index);
        
    //     if(produtoComponente.getComponenteId()!= componente.getId()){
            
    //     }
        
    //     return produtoComponente;
    // }

   


}
