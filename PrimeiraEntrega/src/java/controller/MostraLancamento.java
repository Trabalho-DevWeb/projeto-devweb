/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Categoria;
import aplicacao.Conta;
import aplicacao.Lancamento;
import aplicacao.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CategoriaDAO;
import model.ContaDAO;
import model.LancamentoDAO;

/**
 *
 * @author Ramos
 */
public class MostraLancamento implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String id = request.getParameter("id");
       Integer idAux = Integer.parseInt(id);
       
       //Banco banco = new Banco();
      // Administrador admin = banco.buscaAdmin(idAux); 
       HttpSession sessao = request.getSession();
       LancamentoDAO lancamentodao = new LancamentoDAO();
       Lancamento lancamento = lancamentodao.getLancamentoPorID(idAux);
       Usuario usuario =(Usuario) sessao.getAttribute("individuoLogado");
        
        CategoriaDAO categoriadao = new CategoriaDAO();
        
        List<Categoria> listaCategorias = categoriadao.getLista();
        
        ContaDAO contadao = new ContaDAO();
        
        Conta conta = contadao.getContaPorId(lancamento.getConta());
      
        request.setAttribute("categorias", listaCategorias);
        request.setAttribute("lancamento", lancamento);
        request.setAttribute("conta", conta);
       
       return "forward:form-altera-lancamento.jsp";
    }
    
}
