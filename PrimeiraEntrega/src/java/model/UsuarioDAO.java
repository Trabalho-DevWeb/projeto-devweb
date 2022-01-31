/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import aplicacao.Usuario;
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
public class UsuarioDAO {
    private Connection conexao;
    public UsuarioDAO(){
        
        
        try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
   
    
    public List<Usuario> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        List<Usuario> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from Usuarios");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                //Cria o objeto da classe Contato para armazenar os dados
                //que vieram do BD
                Usuario usuario = new Usuario();
                
                //Pega o conteúdo da coluna "id" do ResultSet (rs)
                usuario.setId(rs.getInt("id"));
                //Pega o conteúdo da coluna "nome" do ResultSet (rs)
                usuario.setNome( rs.getString("nome") );
                //Pega o conteúdo da coluna "telefone" do ResultSet (rs)
                usuario.setCPF(rs.getString("cpf") );
                
                usuario.setBloqueado(rs.getString("suspenso"));
                
                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(usuario);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Contatos encontrados no banco de dados.
        return resultado;
    }
    
    public Usuario getUsuarioPorID( int codigo ) {
        Usuario usuario = new Usuario();
        try {
            String sql = "SELECT * FROM usuarios WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                usuario.setId(rs.getInt("id"));
                usuario.setNome( rs.getString("nome") );
                usuario.setCPF(rs.getString("cpf"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setBloqueado(rs.getString("suspenso"));
               
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return usuario;
    }
    
     public Usuario getUsuarioPorCPF( String cpf ) {
        Usuario usuario = new Usuario();
        try {
            String sql = "SELECT * FROM usuarios WHERE cpf = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, cpf);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                usuario.setId(rs.getInt("id"));
                usuario.setNome( rs.getString("nome") );
                usuario.setCPF(rs.getString("cpf"));
                usuario.setSenha(rs.getString("senha"));
               
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return usuario;
    }
    
    public boolean gravar( Usuario usuario ) {
        try {
            String sql = "INSERT INTO usuarios (nome, cpf, senha, suspenso) VALUES (?,?,?,?)";
            
            PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getCPF());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.isBloqueado());
            
       
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            int chaveGerada = 0;
            if(rs.next()){
                chaveGerada = rs.getInt(1);
            }
            
            
            usuario.setId(chaveGerada);
            System.out.println("O usuario foi adicionda com chave:"+usuario.getId());
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    
    public boolean atualizar(Usuario usuario){
        
        try{
            String sql = "UPDATE usuarios SET nome=?, cpf=?, senha=?, suspenso=? WHERE id=?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getCPF());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.isBloqueado());
            ps.setInt(5, usuario.getId());

            ps.execute();
            
            System.out.println("Os dados do Usuario foram atulizados");
            
            return true;
        
        } catch (SQLException e){
            System.out.println("Erro de SQL:" + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM usuarios WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Usuario removido");
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    public boolean getUserPorCPF(String cpf) {
        Usuario usuario = new Usuario();
        try {
            String sql = "SELECT * FROM usuarios WHERE cpf = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, cpf);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                usuario.setId(rs.getInt("id"));
                usuario.setNome( rs.getString("nome") );
                usuario.setCPF(rs.getString("cpf"));
                usuario.setSenha(rs.getString("senha"));
              return false; 
            }
            
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return true;
    }
    
   
    
   
    
}
