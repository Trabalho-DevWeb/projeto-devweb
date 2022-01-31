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
public class CadastroAdmin implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try{
        String nome = request.getParameter("nomeAdm");
        String CPF = request.getParameter("cpfAdm");
        String senha = request.getParameter("senhaAdm");
        
       // Banco banco = new Banco();
       Administrador adm = new Administrador();
       
       adm.setNome(nome);
       adm.setCPF(CPF);
       adm.setSenha(senha);

       
       AdminDAO admindao = new AdminDAO();
       
       
       if(admindao.getAdminPorCPF(CPF)){
            if(admindao.gravar(adm)){
                 request.setAttribute("nomeAdm",nome );
                 return "forward:sucessoCadastroAdmin.jsp";
            } else{
                return "forward:erroCadastro.jsp";
            }
       }
       
       return "forward:erroAdminExistente.jsp";
//        if(banco.existeAdmin(CPF, senha) == null){
//            banco.adicionaAdm(CPF, nome, senha, email);
//            request.setAttribute("nomeAdm",nome );
//            return "forward:sucessoCadastroAdmin.jsp";
//        } else {
//            return "redirect:entrada?acao=ErroLogin";
//        }
        } catch(Exception e){
            System.out.println("EXCEÇÃO - Cadastro Administrador");
            return "forward:erroCadastro.jsp";
        }
    }
    
}
