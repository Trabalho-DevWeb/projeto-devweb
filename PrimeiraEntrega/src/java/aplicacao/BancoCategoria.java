/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramos
 */
public class BancoCategoria {

    private static List<Categoria> listaCategoria = new ArrayList<>();
    private static int idCat = 0;

    
    static{
    
    
    Categoria categoria = new Categoria();
    categoria.setDescricao("Energia");
    categoria.setId(idCat++);
    BancoCategoria.listaCategoria.add(categoria);
    
    
    
    
    
    }
    
    public Categoria buscaCategoria(Integer id){
        for(Categoria categoria:listaCategoria){
            if(categoria.getId() == id){
                return categoria;
            }
            
        }
        return null;
    }

 
    
     public Categoria categoriaExiste(String descricao){
        for(Categoria categoria: listaCategoria){
            if(categoria.ehIgual(descricao)){
                return categoria;
            }
        }
        return null;
    }
    
    public  void adicionaCategoria(String descricao){
        Categoria categoria = new Categoria();
        categoria.setDescricao(descricao);
        categoria.setId(BancoCategoria.idCat++);
        BancoCategoria.listaCategoria.add(categoria);
                
    }
    
    public boolean removeCategoria(Categoria cat){
       return BancoCategoria.listaCategoria.remove(cat);
    }

   

    public  List<Categoria> getListaCategoria() {
        return listaCategoria;
    }
    
    
    
}
