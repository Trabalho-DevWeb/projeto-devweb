/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import aplicacao.Administrador;
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
public class AdminDAO {
    private Connection conexao;
    
    public AdminDAO(){
        
      try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    public List<Administrador> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        List<Administrador> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from administradores");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                //Cria o objeto da classe Contato para armazenar os dados
                //que vieram do BD
                Administrador adm = new Administrador();
                
                //Pega o conteúdo da coluna "id" do ResultSet (rs)
                adm.setId(rs.getInt("id"));
                //Pega o conteúdo da coluna "nome" do ResultSet (rs)
                adm.setNome( rs.getString("nome") );
                //Pega o conteúdo da coluna "telefone" do ResultSet (rs)
                adm.setCPF(rs.getString("cpf") );
                
                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(adm);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Contatos encontrados no banco de dados.
        return resultado;
    }
    
    public Administrador getAdministradorPorID( int codigo ) {
        Administrador adm = new Administrador();
        try {
            String sql = "SELECT * FROM administradores WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                adm.setId(rs.getInt("id"));
                adm.setNome( rs.getString("nome") );
                adm.setCPF(rs.getString("cpf"));
                adm.setSenha(rs.getString("senha"));
               
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return adm;
    }
    
     public Administrador getAdministradorPorCPF( String cpf ) {
        Administrador adm = new Administrador();
        try {
            String sql = "SELECT * FROM administradores WHERE cpf = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, cpf);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                adm.setId(rs.getInt("id"));
                adm.setNome( rs.getString("nome") );
                adm.setCPF(rs.getString("cpf"));
                adm.setSenha(rs.getString("senha"));
               
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return adm;
    }
    
    public boolean gravar( Administrador adm ) {
        try {
            String sql = "INSERT INTO administradores (nome, cpf, senha) VALUES (?,?,?)";
            
            PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, adm.getNome());
            ps.setString(2, adm.getCPF());
            ps.setString(3, adm.getSenha());
            
       
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            int chaveGerada = 0;
            if(rs.next()){
                chaveGerada = rs.getInt(1);
            }
            
            
            adm.setId(chaveGerada);
            System.out.println("O adm foi adicionda com chave:"+adm.getId());
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    
    public boolean atualizar(Administrador adm){
        
        try{
            String sql = "UPDATE administradores SET nome=?, cpf=?, senha=? WHERE id=?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setString(1, adm.getNome());
            ps.setString(2, adm.getCPF());
            ps.setString(3, adm.getSenha());
            ps.setInt(4, adm.getId());

            ps.execute();
            
            System.out.println("Os dados do administrador foram atulizados");
            
            return true;
        
        } catch (SQLException e){
            System.out.println("Erro de SQL:" + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM administradores WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Administrador removido");
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    public boolean getAdminPorCPF(String cpf) {
        Administrador adm = new Administrador();
        try {
            String sql = "SELECT * FROM administradores WHERE cpf = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, cpf);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                adm.setId(rs.getInt("id"));
                adm.setNome( rs.getString("nome") );
                adm.setCPF(rs.getString("cpf"));
                adm.setSenha(rs.getString("senha"));
               return false;
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return true;
    }
}


