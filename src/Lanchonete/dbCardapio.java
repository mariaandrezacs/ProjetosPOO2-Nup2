
package Lanchonete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbCardapio {
    public void inserir(Cardapio c){
        String sql = "insert into cardapio(tipo, descricao, preco) values(?, ?, ?)";
        Connection conexao = LanchoneteConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, c.getTipo());
            ps.setString(2, c.getDescricao());
            ps.setDouble(3, c.getPreco());
            
            ps.execute();
            ps.close();
            conexao.close();
               
        } catch (SQLException ex) {
            Logger.getLogger(dbCardapio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void alterar(Cardapio c){
        String sql = "update cardapio set tipo=?, descricao=?, preco=? where id=?";
        Connection conexao = LanchoneteConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, c.getTipo());
            ps.setString(2, c.getDescricao());
            ps.setDouble(3, c.getPreco());
            ps.setInt(4, c.getId());
            
            ps.execute();
            ps.close();
            conexao.close();
               
        } catch (SQLException ex) {
            Logger.getLogger(dbCardapio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void excluir(Cardapio e){
        String sql = "delete from estoque where id=?";
        Connection conexao = LanchoneteConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setInt(1, e.getId());
            
            ps.execute();
            ps.close();
            conexao.close();
               
        } catch (SQLException ex) {
            Logger.getLogger(dbCardapio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public ArrayList<Cardapio> listar(String condicao){
        ArrayList<Cardapio> listaEstoque = new ArrayList<Cardapio>();
        
        String sql = "select * from cardapio";
        
        if(!condicao.equals("")){
            sql = sql + "where" + condicao;
        }
        
        Connection conexao = LanchoneteConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                listaEstoque.add(new Cardapio(rs.getInt("id"), rs.getString("tipo"), rs.getString("descricao"), 
                        rs.getDouble("preco")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(dbCardapio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaEstoque;
    }
    public Cardapio ConsultaId(int id){
        Cardapio retorne = null;
        String sql = "select * from cardapio where id=?";
        Connection conexao = LanchoneteConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
 
            while(rs.next()){
                retorne = new Cardapio(rs.getInt("id"), rs.getString("tipo"), rs.getString("descricao"), 
                        rs.getDouble("preco"));
 
            }
        } catch (SQLException ex) {
            Logger.getLogger(dbCardapio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorne;
    }
}
