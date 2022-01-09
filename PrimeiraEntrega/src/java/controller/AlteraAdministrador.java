/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Administrador;
import aplicacao.Banco;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AdminDAO;

/**
 *
 * @author Ramos
 */
public class AlteraAdministrador implements  Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        try{
        String cpf = request.getParameter("cpfAdm");
        String email = request.getParameter("emailAdm");
        String nome = request.getParameter("nomeAdm");
        String senha = request.getParameter("senhaAdm");
        Integer id = Integer.parseInt(request.getParameter("idAdm"));
        
        //Banco banco = new Banco();
        
        //Administrador admin = banco.buscaAdmin(id);
        
        AdminDAO admindao = new AdminDAO();
        
        Administrador admin = admindao.getAdministradorPorID(id);
        
        
        
        admin.setCPF(cpf);
        admin.setNome(nome);
        admin.setSenha(senha);
        
        if(admindao.atualizar(admin)){
          return "redirect:entrada?acao=ListaAdmins";  
        } else {
            return "forward:erroAtualizar.jsp";
        }
        } catch(Exception e){
            System.out.println("Exceção - Atualizar Administrador");
            return "forward:erroAtualizar.jsp";
        }
        
    }
    
}
