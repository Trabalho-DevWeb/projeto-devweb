/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramos
 */
public class Entrada extends HttpServlet {

    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String paramAcao = request.getParameter("acao");
         
        switch (paramAcao) {
            case "Login":
                String nome1;
                Login acao = new Login();
                nome1 = acao.executa(request, response);
                response.sendRedirect(nome1);
                break;
            case "IndexAdmin":
                String nome2;
                IndexAdm acao2 = new IndexAdm();
                nome2 = acao2.executa(request, response);
                RequestDispatcher rd1 = request.getRequestDispatcher("frontend/src/html/" + nome2);
                break;
            case "LoginForm":
                String nome3;
                LoginForm acao3 = new LoginForm();
                nome3 = acao3.executa(request, response);
                RequestDispatcher rd2 = request.getRequestDispatcher("frontend/src/html/" + nome3);
                break;
            default:
                break;
        }
        }
    }

  

