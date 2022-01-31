/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


import aplicacao.Conta;
import aplicacao.Usuario;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ramos
 */
public class ContaDAO {
    private Connection conexao;
    public ContaDAO(){
        
        
        try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
   
    
    public List<Conta> getLista(int codigo) {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        List<Conta> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
           
            // Armazena o resultado do comando enviado para o banco de dados
           
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            String sql = "SELECT * FROM contas WHERE id_usuario = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            while( rs.next() ) {
                //Cria o objeto da classe Contato para armazenar os dados
                //que vieram do BD
                Conta conta = new Conta();
                
                conta.setId(rs.getInt("id"));
                
                conta.setNome(rs.getString("nome_conta"));
                //Pega o conteúdo da coluna "nome" do ResultSet (rs)
                conta.setBanco(rs.getString("banco"));
                
                conta.setAgencia( rs.getString("agencia") );
               
       
                conta.setConta_corrente(rs.getString("conta_corrente"));
                
                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(conta);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Contatos encontrados no banco de dados.
        return resultado;
    }
    
    public Conta getContaPorID( int codigo , int codigo_usuario ) {
        Conta Conta = new Conta();
        try {
            String sql = "SELECT * FROM Contas WHERE id = ? AND id_usuario = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.setInt(2, codigo_usuario);
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                Conta.setId(rs.getInt("id"));
                Conta.setNome( rs.getString("nome_conta") );
                Conta.setBanco(rs.getString("banco"));
                Conta.setAgencia(rs.getString("agencia"));
                Conta.setConta_corrente(rs.getString("conta_corrente"));
               
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Conta;
    }
    
     public Conta getContaPorId( Integer id ) {
        Conta Conta = new Conta();
        try {
            String sql = "SELECT * FROM Contas WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                Conta.setId(rs.getInt("id"));
                Conta.setNome( rs.getString("nome_conta") );
                Conta.setBanco(rs.getString("banco"));
                Conta.setAgencia(rs.getString("agencia"));
                Conta.setConta_corrente(rs.getString("conta_corrente"));
               
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Conta;
    }
    
     public boolean getContaPorContaCorrente( String conta ) {
        Conta Conta = new Conta();
        try {
            String sql = "SELECT * FROM contas WHERE conta_corrente = ? ";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, conta);
            
            ResultSet rs = ps.executeQuery();
            
           
            
            if ( rs.next() ) {
                Conta.setId(rs.getInt("id"));
                Conta.setNome( rs.getString("nome_conta") );
                Conta.setBanco(rs.getString("banco"));
                Conta.setAgencia(rs.getString("agencia"));
                Conta.setConta_corrente(rs.getString("conta_corrente"));
               return false;
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            
        }
       return true;
    }
     
     
    public boolean gravar( Conta conta, String usuario ) {
        try {
            
            Integer idUsuario = Integer.parseInt(usuario);
            
            String sql = "INSERT INTO contas (id_usuario, nome_conta, banco, agencia, conta_corrente) VALUES (?,?,?,?,?)";
            
            
            PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idUsuario);
            
            ps.setString(2, conta.getNome());
            ps.setString(3, conta.getBanco());
            ps.setString(4, conta.getAgencia());
            ps.setString(5, conta.getConta_corrente());
            
          
           
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            int chaveGerada = 0;
            if(rs.next()){
                chaveGerada = rs.getInt(1);
            }
            
            
            conta.setId(chaveGerada);
            System.out.println("A Conta foi adicionda com chave:"+conta.getId());
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    
    public boolean atualizar(Conta conta){
         
        try{
            String sql = "UPDATE contas SET nome_conta=?, banco=?, agencia=?, conta_corrente=? WHERE id=?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setString(1, conta.getNome());
            ps.setString(2, conta.getBanco());
            ps.setString(3, conta.getAgencia());
            ps.setString(4, conta.getConta_corrente());
            ps.setInt(5, conta.getId());

            ps.execute();
            
            System.out.println("Os dados do Conta foram atulizados");
            
            return true;
        
        } catch (SQLException e){
            System.out.println("Erro de SQL:" + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir( Integer id ) {
        try {
            String sqlAuxiliar = "DELETE FROM lancamentos WHERE id_conta = ?";
            PreparedStatement psAuxiliar = conexao.prepareStatement(sqlAuxiliar);
            psAuxiliar.setInt(1, id);
            psAuxiliar.execute();
            String sql = "DELETE FROM contas WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Conta removido");
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
   
    
   
    
}

