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
public class BancoUsuario {
    private static List<Usuario> listaUsuario = new ArrayList<>();
    private static int idUser = 0;

    
    static{
    
    
    Usuario usuario = new Usuario();
    usuario.setCPF("111.111.111-22");
    usuario.setNome("Lucas");
    usuario.setSenha("1234");
    usuario.setId(idUser++);
    BancoUsuario.listaUsuario.add(usuario);
    
    
    
    
    
    }
    
    public Usuario buscaUsuario (Integer id){
        for(Usuario usuario:listaUsuario){
            if(usuario.getId() == id){
                return usuario;
            }
            
        }
        return null;
    }

 
    
     public Usuario usuarioExiste(String CPF, String Senha){
        for(Usuario usuario: listaUsuario){
            if(usuario.ehIgual(CPF,Senha)){
                return usuario;
            }
        }
        return null;
    }
    
    public  void adicionaUsuario(String CPF, String nome, String senha){
        Usuario usuario = new Usuario();
        usuario.setCPF(CPF);
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setId(BancoUsuario.idUser++);
        BancoUsuario.listaUsuario.add(usuario);
                
    }
    
    public boolean removeUsuario(Usuario user){
       return BancoUsuario.listaUsuario.remove(user);
    }

   

    public  List<Usuario> getListaUsuario() {
        return listaUsuario;
    }
    
}
