/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.BancoCategoria;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramos
 */
public class CadastroCategoria implements Acao{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descricao = request.getParameter("descricao");
        
        BancoCategoria banco = new BancoCategoria();
        
        if(banco.categoriaExiste(descricao) == null){
            banco.adicionaCategoria(descricao);
            request.setAttribute("descricao",descricao );
            return "forward:sucessoCadastro.jsp";
        } else {
            return "redirect:entrada?acao=ErroLogin";
        }
    }
    
}
