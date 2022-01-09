/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Administrador;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AdminDAO;
import model.Conexao;

/**
 *
 * @author Ramos
 */
public class ListaAdmins implements Acao{
    
    
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
 //       Banco banco = new Banco();
 
        AdminDAO admindao = new AdminDAO();
        
        List <Administrador> lista = admindao.getLista();
     
        
      //  List<Administrador> lista = banco.getLista1();
        
        request.setAttribute("administradores", lista);
        
       
        
        return "forward:listaAdmins.jsp";
        
    }
    
}
