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
public class Banco {
    private static List<Administrador> lista1 = new ArrayList<>();
    private static List<Usuario> listaUsuario = new ArrayList<>();
    private static List<Categoria> listaCategoria = new ArrayList<>();
    private static int idAdm = 0;
    private static int idCat = 0;
    private static int idUse = 0;
    
    static{
    Administrador admin = new Administrador();
    admin.setCPF("249.252.810-38");
    admin.setNome("Leonardo");
 
    admin.setSenha("111");
    admin.setId(idAdm++);
    Banco.lista1.add(admin);
    

    
    
    
    
    
    }
    
    public Administrador buscaAdmin(Integer id){
        for(Administrador administrador:lista1){
            if(administrador.getId() == id){
                return administrador;
            }
            
        }
        return null;
    }

    public Administrador existeAdmin(String CPF, String Senha) {
        for(Administrador administrador : lista1) {
	        if(administrador.ehIgual(CPF,Senha)) {
	            return administrador;
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
    
    public  void adicionaAdm(String CPF, String Nome, String Senha, String email){
        Administrador admin = new Administrador();
        admin.setCPF(CPF);
        admin.setNome(Nome);
        admin.setSenha(Senha);

        admin.setId(Banco.idAdm++);
        Banco.lista1.add(admin);
                
    }
    
    public boolean removeAdm(Administrador adm){
       return Banco.lista1.remove(adm);
    }

    public  List<Administrador> getLista1() {
        return lista1;
    }

    public  List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public  List<Categoria> getListaCategoria() {
        return listaCategoria;
    }
    
    
    
}
