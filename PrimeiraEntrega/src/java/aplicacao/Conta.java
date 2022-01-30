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
public class Conta {
    private String nome;
    private String banco;
    private String agencia;
    private String conta_corrente;
    private Usuario usuario;
    private Integer Id;
    

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta_corrente() {
        return conta_corrente;
    }

    public void setConta_corrente(String conta_corrente) {
        this.conta_corrente = conta_corrente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
     public boolean ehIgual(String nome, String conta_corrente ) {
		if(!this.nome.equals(nome)) {
			return false;
		}
		
		if(!this.conta_corrente.equals(conta_corrente)) {
			return false;
		}
		
		return true;
	}
}
