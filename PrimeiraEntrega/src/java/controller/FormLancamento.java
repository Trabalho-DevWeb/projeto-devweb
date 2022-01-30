/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Categoria;
import aplicacao.Conta;
import aplicacao.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CategoriaDAO;
import model.ContaDAO;
import model.UsuarioDAO;

/**
 *
 * @author Ramos
 */
public class FormLancamento implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        
       
        
        Usuario usuario =(Usuario) sessao.getAttribute("individuoLogado");
        
        CategoriaDAO categoriadao = new CategoriaDAO();
        
        List<Categoria> listaCategorias = categoriadao.getLista();
        
        ContaDAO contadao = new ContaDAO();
        
        List<Conta> listaContas = contadao.getLista(usuario.getId());
        
       
        
        System.out.println("CPF do usuario XXX :" + usuario.getCPF());
        System.out.println("ID do usuario:" + usuario.getId());
        request.setAttribute("contas",listaContas ); 
        request.setAttribute("categorias", listaCategorias);
        System.out.println(request.getSession().getAttribute("categorias"));
         System.out.println(request.getSession().getAttribute("contas"));
        
        return "forward:form-lancamento.jsp";
    }
    
}
