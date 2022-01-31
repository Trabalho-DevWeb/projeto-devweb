/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Categoria;
import aplicacao.Conta;
import aplicacao.Lancamento;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CategoriaDAO;
import model.LancamentoDAO;

/**
 *
 * @author Ramos
 */
public class ListaLancamentos implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        String idConta = request.getParameter("id");
        
        
        Integer id = Integer.parseInt(idConta);
        
        
        
       

        LancamentoDAO lancamentodao = new LancamentoDAO();
        
        List<Lancamento> creditos = lancamentodao.creditos(id);
        
        List<Lancamento> debitos = lancamentodao.debitos(id);
        
        
        
        
        List<Lancamento> lancamentos = lancamentodao.getLista(id);
        
        request.setAttribute("lancamentos", lancamentos);
        request.setAttribute("creditos", creditos);
        request.setAttribute("debitos", debitos);
        request.setAttribute("idConta",id);
        
        return "forward:listaLancamentos.jsp";
        } catch(NumberFormatException e){
            System.out.println("Exceção " + e.toString());
        }
        return "forward:erroAtualizarUsuario.jsp";
    }
    
}
