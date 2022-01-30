/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import java.util.List;

/**
 *
 * @author Ramos
 */
public class Usuario {
    private String nome;
    private String CPF; 
    private String senha;
    private Integer id;
    private String bloqueado;
   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }   

   
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(String bloqueado) {
        this.bloqueado = bloqueado;
    }
    
   public boolean ehIgual(String CPF, String senha ) {
		if(!this.CPF.equals(CPF)) {
			return false;
		}
		
		if(!this.senha.equals(senha)) {
			return false;
		}
		
		return true;
	}
    
}
