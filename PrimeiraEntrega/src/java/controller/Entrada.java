/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ramos
 */
public class Entrada extends HttpServlet {
    
    
    
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String paramAcao = request.getParameter("acao");
      
       
        HttpSession sessao = request.getSession();
        try{
        boolean adminNaoEstaLogado
                = (sessao.getAttribute("adminLogado") == null);
        boolean ehUmaAcaoProtegida
                = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));

        if (ehUmaAcaoProtegida && adminNaoEstaLogado) {
            response.sendRedirect("entrada?acao=LoginForm");
            return;
        }
        } catch(NullPointerException e){
            System.out.println("deu nulo");
        }
      
      String nome = null ;
      if(paramAcao.equals("Login")){
          System.out.println("Login aqui"); 
         Login acao = new Login(); 
         nome = acao.executa(request,response);
       } else if(paramAcao.equals("LoginForm")){
           LoginForm acao = new LoginForm();
           nome = acao.executa(request,response);   
       } else if(paramAcao.equals("IndexAdm")){
           IndexAdm acao = new IndexAdm();
           nome = acao.executa(request,response);
       } else if(paramAcao.equals("FormAdmin")){
           FormAdmin acao = new FormAdmin();
           nome = acao.executa(request,response);
       } else if(paramAcao.equals("FormCategoria")){
           FormCategoria acao = new FormCategoria();
           nome = acao.executa(request,response);
       } else if(paramAcao.equals("FormUsuario")){
           FormUsuario acao = new FormUsuario();
           nome = acao.executa(request,response);
       }  else if(paramAcao.equals("CadastroAdmin")){
           CadastroAdmin acao = new CadastroAdmin();
           nome = acao.executa(request,response);
       } else if(paramAcao.equals("CadastroCategoria")){
           CadastroCategoria acao = new CadastroCategoria();
           nome = acao.executa(request,response);
       } else if(paramAcao.equals("CadastroUsuario")){
           CadastroUsuario acao = new CadastroUsuario();
           nome = acao.executa(request,response);
       } else if(paramAcao.equals("ListaAdmins")){
           ListaAdmins acao = new ListaAdmins();
           nome = acao.executa(request,response);
       } else if(paramAcao.equals("ListaCategorias")){
           ListaCategorias acao = new ListaCategorias();
           nome = acao.executa(request,response);
       } else if(paramAcao.equals("ListaUsuarios")){
           ListaUsuarios acao = new ListaUsuarios();
           nome = acao.executa(request,response);
       } else if(paramAcao.equals("MostraAdmin")){
           MostraAdmin acao = new MostraAdmin();
           nome = acao.executa(request,response);
        } else if(paramAcao.equals("MostraCategoria")){
           MostraCategoria acao = new MostraCategoria();
           nome = acao.executa(request,response);
        }  else if(paramAcao.equals("MostraUsuario")){
           MostraUsuario acao = new MostraUsuario();
           nome = acao.executa(request,response);
        }  else if(paramAcao.equals("RemoveAdmin")){
            RemoveAdmin acao = new RemoveAdmin();
            nome = acao.executa(request,response);
        } else if(paramAcao.equals("RemoveCategoria")){
            RemoveCategoria acao = new RemoveCategoria();
            nome = acao.executa(request,response);
        }  else if(paramAcao.equals("RemoveUsuario")){
            RemoveUsuario acao = new RemoveUsuario();
            nome = acao.executa(request,response);
        } else if(paramAcao.equals("AlteraAdministrador")){
            AlteraAdministrador acao = new AlteraAdministrador();
            nome = acao.executa(request,response);
        } else if(paramAcao.equals("AlteraCategoria")){
            AlteraCategoria acao = new AlteraCategoria();
            nome = acao.executa(request,response);
        } else if(paramAcao.equals("AlteraUsuario")){
            AlteraUsuario acao = new AlteraUsuario();
            nome = acao.executa(request,response);
        }
      
      try{
        String[] tipoEEndereco = nome.split(":");
        if(tipoEEndereco[0].equals("forward")){
            RequestDispatcher rd = request.getRequestDispatcher("frontend/src/html/"+tipoEEndereco[1]);
            rd.forward(request,response);
        } else {
            response.sendRedirect(tipoEEndereco[1]);
        }
      } catch(NullPointerException e){
          System.out.println("Nome é nulo");
      } 
      
         
      
      
//        switch (paramAcao) {
//            case "Login":
//                String nome1;
//                Login acao = new Login();
//                nome1 = acao.executa(request, response);
//                response.sendRedirect(nome1);
//                break;
//            case "IndexAdmin":
//                String nome2;
//                IndexAdm acao2 = new IndexAdm();
//                nome2 = acao2.executa(request, response);
//                RequestDispatcher rd1 = request.getRequestDispatcher("frontend/src/html/" + nome2);
//                break;
//            case "LoginForm":
//                String nome3;
//                LoginForm acao3 = new LoginForm();
//                nome3 = acao3.executa(request, response);
//                RequestDispatcher rd2 = request.getRequestDispatcher("frontend/src/html/" + nome3);
//                break;
//            default:
//                break;
//        }
        }
    }

  

