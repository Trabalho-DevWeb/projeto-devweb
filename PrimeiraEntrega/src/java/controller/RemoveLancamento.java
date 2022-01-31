/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Conta;
import aplicacao.Lancamento;
import aplicacao.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ContaDAO;
import model.LancamentoDAO;

/**
 *
 * @author Ramos
 */
public class RemoveLancamento implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer idConta = Integer.parseInt(request.getParameter("idConta"));
       
        ContaDAO contadao = new ContaDAO();
        
        
        HttpSession sessao = request.getSession();
        
        
        
        sessao.setAttribute("conta", contadao.getContaPorId(idConta));
        
        LancamentoDAO lancamentodao = new LancamentoDAO();
     
        
        List<Lancamento> creditos = lancamentodao.creditos(idConta);
        
        List<Lancamento> debitos = lancamentodao.debitos(idConta);
        
        
        
        
        List<Lancamento> lancamentos = lancamentodao.getLista(idConta);
        
        request.setAttribute("lancamentos", lancamentos);
        request.setAttribute("creditos", creditos);
        request.setAttribute("debitos", debitos);
       
        
        
        if(lancamentodao.excluir(id)){
           return "redirect:entrada?acao=ListaContas"; 
        } else {
            return "forward:erroRemoverLancamento.jsp";
        }
        
    }
    
}
