package Estacionamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBEstacionamento {
    public void inserir(Rotatividade r){
        String sql = "insert into rotatividade(modelo, placa, entrada, saida, valor) values(?, ?, ?, ?, ?)";
        Connection conexao = EstacionamentoConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, r.getModelo());
            ps.setString(2, r.getPlaca());
            ps.setString(3, String.valueOf(r.getEntrada()));
            ps.setString(4, String.valueOf(r.getSaida()));
            ps.setString(5, String.valueOf(r.getValor()));
            
            ps.execute();
            ps.close();
            conexao.close();
               
        } catch (SQLException ex) {
            Logger.getLogger(DBEstacionamento.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    public void alterar(Rotatividade r){
        String sql = "update rotatividade set modelo=?, placa=?, entrada=?, saida=?, valor=? where id=?";
        Connection conexao = EstacionamentoConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, r.getModelo());
            ps.setString(2, r.getPlaca());
            ps.setString(3, String.valueOf(r.getEntrada()));
            ps.setString(4, String.valueOf(r.getSaida()));
            ps.setString(5, String.valueOf(r.getValor()));
            ps.setInt(6, r.getId());
            
            ps.execute();
            ps.close();
            conexao.close();
               
        } catch (SQLException ex) {
            Logger.getLogger(DBEstacionamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void excluir(Rotatividade e){
        String sql = "delete from rotatividade where id=?";
        Connection conexao = EstacionamentoConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setInt(1, e.getId());
            
            ps.execute();
            ps.close();
            conexao.close();
               
        } catch (SQLException ex) {
            Logger.getLogger(DBEstacionamento.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public ArrayList<Rotatividade> listar(String condicao){
        ArrayList<Rotatividade> listaEstoque = new ArrayList<Rotatividade>();
        
        String sql = "select * from rotatividade";
        
        if(!condicao.equals("")){
            sql = sql + "where" + condicao;
        }
        
        Connection conexao = EstacionamentoConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                listaEstoque.add(new Rotatividade(rs.getInt("id"), rs.getString("modelo"), rs.getString("placa"), 
                        rs.getString("entrada") , rs.getString("saida"), rs.getDouble("valor")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBEstacionamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaEstoque;
    }
    public Rotatividade ConsultaId(int id){
        Rotatividade retorne = null;
        String sql = "select * from estoque where id=?";
        Connection conexao = EstacionamentoConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
 
            while(rs.next()){
                retorne =new Rotatividade(rs.getInt("id"), rs.getString("modelo"), rs.getString("placa"), 
                        rs.getString("entrada") , rs.getString("saida"), rs.getDouble("valor"));
 
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBEstacionamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorne;
    }
      
}
