/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Conta;
import aplicacao.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ContaDAO;

/**
 *
 * @author Ramos
 */
public class ListaContas implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         Usuario usuario = (Usuario) request.getSession().getAttribute("individuoLogado");
         
         ContaDAO contadao = new ContaDAO();
         
         
         List<Conta> contas = contadao.getLista(usuario.getId());
         
         request.setAttribute("contas", contas);
         
         return "forward:listaContas.jsp";
    }
    
}
