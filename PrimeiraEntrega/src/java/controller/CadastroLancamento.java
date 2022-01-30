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
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoriaDAO;
import model.ContaDAO;
import model.LancamentoDAO;

/**
 *
 * @author Ramos
 */
public class CadastroLancamento implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{ 
        
       String cartao = request.getParameter("cartao");
       String valor = request.getParameter("valor");
       String data = request.getParameter("data");
       String categoria = request.getParameter("categoria");
       String descricao = request.getParameter("descricao");
       String nconta = request.getParameter("conta");
       
       // BancoUsuario banco = new BancoUsuario();
        
       Lancamento lancamento = new Lancamento();
       
       
       
       Date dataFormatada= Date.valueOf(data);
       
       
       String valor1 = valor.replace(",", ".");
       Double valorFormatado = Double.parseDouble(valor1);
       

       lancamento.setData(dataFormatada);
       lancamento.setDescricao(descricao);
       lancamento.setOperacao(cartao);
       lancamento.setValor(valorFormatado);
       
       LancamentoDAO lancamentodao = new LancamentoDAO();
       
       
       
        if(lancamentodao.gravar(lancamento , nconta ,categoria )){
            request.setAttribute("lancamento",categoria);
            request.setAttribute("valor",valor);
            return "forward:sucessoCadastroLancamento.jsp";
        } else {
            return "forward:erroCadastroLancamento.jsp";
        }
        
       } catch(Exception e){
           System.out.println("Exceção - Cadastro Lancamento "+e.toString());
           return "forward:erroCadastroLancamento.jsp";
       }
    }
    }
    

