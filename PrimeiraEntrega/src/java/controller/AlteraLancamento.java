/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Lancamento;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LancamentoDAO;

/**
 *
 * @author Ramos
 */
public class AlteraLancamento implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        
        
       Integer id = Integer.parseInt(request.getParameter("id"));  
      String cartao = request.getParameter("cartao");
       String valor = request.getParameter("valor");
       String data = request.getParameter("data");
       String categoria = request.getParameter("categoria");
       String descricao = request.getParameter("descricao");
       String nconta = request.getParameter("conta");
      
       
      
        
      
       
      
        
       LancamentoDAO lancamentodao = new LancamentoDAO();
        
       Lancamento lancamento = lancamentodao.getLancamentoPorID(id);
         
       Date dataFormatada= Date.valueOf(data);
       
       
       String valor1 = valor.replace(",", ".");
       Double valorFormatado = Double.parseDouble(valor1);
       

       lancamento.setData(dataFormatada);
       lancamento.setDescricao(descricao);
       lancamento.setOperacao(cartao);
       lancamento.setValor(valorFormatado);
         
        if(lancamentodao.atualizar(lancamento)){
            
          return "redirect:entrada?acao=ListaContas";   
        } else {
            return "forward:erroAtualizar.jsp";
        }
         
        } catch(Exception e){
            System.out.println("Excecao - Altera Conta");
            return "forward:erroAtualizar.jsp";
        }
    }
    
}
