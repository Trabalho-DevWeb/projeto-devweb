/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import aplicacao.Categoria;
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
public class CategoriaDAO {
    private Connection conexao;
    
    public CategoriaDAO(){
         try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    
    public List<Categoria> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        List<Categoria> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from categorias");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                //Cria o objeto da classe Contato para armazenar os dados
                //que vieram do BD
                Categoria categoria = new Categoria();
                
                //Pega o conteúdo da coluna "id" do ResultSet (rs)
                categoria.setId(rs.getInt("id"));
                //Pega o conteúdo da coluna "nome" do ResultSet (rs)
                categoria.setDescricao( rs.getString("descricao") );
                //Pega o conteúdo da coluna "telefone" do ResultSet (rs)
                
                
                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(categoria);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Contatos encontrados no banco de dados.
        return resultado;
    }
    
    public Categoria getCategoriaPorID( int codigo ) {
        Categoria categoria = new Categoria();
        try {
            String sql = "SELECT * FROM categorias WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                categoria.setId(rs.getInt("id"));
                categoria.setDescricao(rs.getString("descricao"));
               
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return categoria;
    }
    
     public Categoria getCategoriaPorDescricao( String descricao ) {
        Categoria categoria = new Categoria();
        try {
            String sql = "SELECT * FROM categorias WHERE descricao = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, descricao);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                categoria.setId(rs.getInt("id"));
                categoria.setDescricao( rs.getString("descricao") );
                
               
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return categoria;
    }
    
    public boolean gravar( Categoria categoria ) {
        try {
            String sql = "INSERT INTO categorias (descricao) VALUES (?)";
            
            PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, categoria.getDescricao());
           
         
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            int chaveGerada = 0;
            if(rs.next()){
                chaveGerada = rs.getInt(1);
            }
            
            
            categoria.setId(chaveGerada);
            System.out.println("A categoria foi adicionda com chave:"+categoria.getId());
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    
    public boolean atualizar(Categoria categoria){
        
        try{
            String sql = "UPDATE categorias SET descricao=? WHERE id=?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setString(1, categoria.getDescricao());
            ps.setInt(2, categoria.getId());
           

            ps.execute();
            
            System.out.println("Os dados do Categoria foram atualizados");
            
            return true;
        
        } catch (SQLException e){
            System.out.println("Erro de SQL:" + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM categorias WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Categoria removida");
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
}
