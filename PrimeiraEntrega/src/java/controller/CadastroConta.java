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
public class CadastroConta implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         try{ 
        
       String agencia = request.getParameter("agencia");
       String conta_corrente = request.getParameter("conta");
       String contabanco = request.getParameter("contabanco");
       String numerobanco = request.getParameter("numerobanco");
       String usuario = request.getParameter("idUsuario");
       
       // BancoUsuario banco = new BancoUsuario();
        
       Conta conta = new Conta();
       
       conta.setConta_corrente(conta_corrente);
       conta.setAgencia(agencia);
       conta.setBanco(numerobanco);
       conta.setNome(contabanco);
       
       
       
       ContaDAO contadao = new ContaDAO();
       
       
       
       
        if(contadao.gravar(conta,usuario)){
            request.setAttribute("nomeConta",conta);
            return "forward:sucessoCadastroConta.jsp";
        } else {
            return "forward:erroCadastroConta.jsp";
        }
        
       } catch(Exception e){
           System.out.println("Exceção - Cadastro Conta");
           return "forward:erroCadastroConta.jsp";
       }
    }
        
        
        
        
       
  }
    

