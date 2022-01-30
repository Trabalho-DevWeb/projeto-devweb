/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Conta;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ContaDAO;

/**
 *
 * @author Ramos
 */
public class AlteraConta implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        
        
       Integer id = Integer.parseInt(request.getParameter("id"));  
       String agencia = request.getParameter("agencia");
       String conta_corrente = request.getParameter("conta");
       String contabanco = request.getParameter("contabanco");
       String numerobanco = request.getParameter("numerobanco");

       ContaDAO contadao = new ContaDAO();
        
       Conta conta = contadao.getContaPorId(id);
         
       conta.setConta_corrente(conta_corrente);
       conta.setAgencia(agencia);
       conta.setBanco(numerobanco);
       conta.setNome(contabanco);
         
        if(contadao.atualizar(conta)){
            
          return "redirect:entrada?acao=ListaContas";   
        } else {
            return "forward:erroAtualizarUsuario.jsp";
        }
         
        } catch(Exception e){
            System.out.println("Excecao - Altera Conta "+ e.toString());
            return "forward:erroAtualizarUsuario.jsp";
        }
    }
    
    
}
