/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LancamentoDAO;

/**
 *
 * @author Ramos
 */
public class RemoveLancamento implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        Integer id = Integer.parseInt(request.getParameter("id"));
        
       
        
        LancamentoDAO lancamentodao = new LancamentoDAO();
        
        
        if(lancamentodao.excluir(id)){
           return "redirect:entrada?acao=ListaLancamentos"; 
        } else {
            return "forward:erroRemoverLancamento.jsp";
        }
        } catch(Exception e){
            System.out.println("Excecao - Remover Lancamento");
            return "forward:erroRemoverLancamento.jsp";
        }
    }
    
}
