/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

/**
 *
 * @author Ramos
 */
public class Administrador {
    
    private String nome;
    private String CPF;
    private String senha;
    private Integer id;

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

   

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
