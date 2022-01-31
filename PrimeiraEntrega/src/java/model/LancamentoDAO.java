/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


import aplicacao.Categoria;
import aplicacao.Conta;
import aplicacao.Lancamento;
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
public class LancamentoDAO {
    private Connection conexao;
    public LancamentoDAO(){
        
        
        try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
   
    
    public List<Lancamento> getLista(int codigo) {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        List<Lancamento> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            String sql = "SELECT * FROM lancamentos WHERE id_conta = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            CategoriaDAO categoriadao = new CategoriaDAO();
           
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                //Cria o objeto da classe Lancamentoto para armazenar os dados
                //que vieram do BD
                Lancamento lancamento = new Lancamento();
                lancamento.setId_categoria(rs.getInt("id_categoria"));
                
                String categoria = categoriadao.getCategoriaPorString(lancamento.getId_categoria()) ;
                
                lancamento.setCategoria(categoria);
                
                lancamento.setId(rs.getInt("id"));
                //Pega o conteúdo da coluna "id" do ResultSet (rs)
                lancamento.setValor(rs.getDouble("valor"));
                //Pega o conteúdo da coluna "nome" do ResultSet (rs)
                lancamento.setOperacao(rs.getString("operacao"));
                
                lancamento.setData( rs.getDate("data") );
               
       
                lancamento.setDescricao(rs.getString("descricao"));
                
                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(lancamento);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Lancamentotos encontrados no banco de dados.
        return resultado;
    }
    
    public Lancamento getLancamentoPorID( int codigo ) {
        Lancamento lancamento = new Lancamento();
        try {
            String sql = "SELECT * FROM lancamentos WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                lancamento.setId(rs.getInt("id"));
                lancamento.setConta(rs.getInt("id_conta"));
                
                 lancamento.setValor(rs.getDouble("valor"));
                //Pega o conteúdo da coluna "nome" do ResultSet (rs)
                lancamento.setOperacao(rs.getString("operacao"));
                
                lancamento.setData( rs.getDate("data") );
               
       
                lancamento.setDescricao(rs.getString("descricao"));
               
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return lancamento;
    }
    
   /*  public Lancamento getLancamentoPorId( String id ) {
        Lancamento Lancamento = new Lancamento();
        try {
            String sql = "SELECT * FROM Lancamentos WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                Lancamento.setId(rs.getInt("id"));
                Lancamento.setNome( rs.getString("nome_Lancamento") );
                Lancamento.setBanco(rs.getString("banco"));
                Lancamento.setAgencia(rs.getString("agencia"));
                Lancamento.setLancamento_corrente(rs.getString("Lancamento_corrente"));
               
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Lancamento;
    }*/
    
    public boolean gravar( Lancamento lancamento, String conta, String categoria) {
        try {
            
            Integer contaFormatada = Integer.parseInt(conta);
            Integer categoriaFormatada = Integer.parseInt(categoria);
            
            
            
            String sql = "INSERT INTO lancamentos (id_conta, id_categoria, valor, operacao, data, descricao) VALUES (?,?,?,?,?,?)";
            
            
            PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, contaFormatada);
            ps.setInt(2, categoriaFormatada);
            ps.setDouble(3, lancamento.getValor());
            ps.setString(4, lancamento.getOperacao());
            ps.setDate(5, lancamento.getData());
            ps.setString(6, lancamento.getDescricao());
            
       
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            int chaveGerada = 0;
            if(rs.next()){
                chaveGerada = rs.getInt(1);
            }
            
            
            lancamento.setId(chaveGerada);
            System.out.println("O Lancamento foi adicionda com chave:"+lancamento.getId());
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    
    public boolean atualizar(Lancamento lancamento){
        
        try{
            String sql = "UPDATE Lancamentos SET valor=?, operacao=?, data=?, descricao=? WHERE id=?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            
           
            ps.setDouble(1, lancamento.getValor());
            ps.setString(2, lancamento.getOperacao());
            ps.setDate(3, lancamento.getData());
            ps.setString(4, lancamento.getDescricao());
            ps.setInt(5, lancamento.getId());

            ps.execute();
            
            System.out.println("Os dados do Lancamento foram atulizados");
            
            return true;
        
        } catch (SQLException e){
            System.out.println("Erro de SQL:" + e.getMessage());
            return false;
        }
    }
       
    public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM lancamentos WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Lancamento removido");
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
   public List<Lancamento> creditos( int id ) {
       List<Lancamento> resultado = new ArrayList<>();
        try {
            String sql = "SELECT * FROM lancamentos WHERE id_conta = ? AND operacao = 'C'";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Lancamentos regastados");
            
            ResultSet rs = ps.executeQuery();
            
        // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                //Cria o objeto da classe Lancamentoto para armazenar os dados
                //que vieram do BD
                Lancamento lancamento = new Lancamento();
                lancamento.setId_categoria(rs.getInt("id_categoria"));
                
          
                lancamento.setValor(rs.getDouble("valor"));
                
              
                
                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(lancamento);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Lancamentotos encontrados no banco de dados.
        return resultado;
    }
    
   public List<Lancamento> debitos( int id ) {
       List<Lancamento> resultado = new ArrayList<>();
        try {
            String sql = "SELECT * FROM lancamentos WHERE id_conta = ? AND operacao = 'D'";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Lancamentos regastados");
            
            ResultSet rs = ps.executeQuery();
            
        // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                //Cria o objeto da classe Lancamentoto para armazenar os dados
                //que vieram do BD
                Lancamento lancamento = new Lancamento();
                lancamento.setId_categoria(rs.getInt("id_categoria"));
                
          
                lancamento.setValor(rs.getDouble("valor"));
                
              
                
                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(lancamento);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Lancamentotos encontrados no banco de dados.
        return resultado;
    }
   
    
}

