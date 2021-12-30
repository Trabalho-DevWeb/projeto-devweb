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
    
    static{
    Administrador admin = new Administrador();
    admin.setCPF("249.252.810-38");
    admin.setSenha("111");
    lista1.add(admin);
    
    }

    public Administrador existeAdmin(String CPF, String Senha) {
        for(Administrador administrador : lista1) {
	        if(administrador.ehIgual(CPF,Senha)) {
	            return administrador;
	        }
	    }
	    return null;
    }
    
    
    
    
}
