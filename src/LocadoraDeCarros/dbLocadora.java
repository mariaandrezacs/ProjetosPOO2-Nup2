package LocadoraDeCarros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbLocadora {
    public void inserir(Aluguel a){
        String sql = "insert into aluguel(marca, modelo, ano, valor, completo) values(?, ?, ?, ?, ?)";
        Connection conexao = LocadoraDeCarrosConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, a.getMarca());
            ps.setString(2, a.getModelo());
            ps.setInt(3, a.getAno());
            ps.setDouble(4, a.getValor());
            ps.setString(5, a.getCompleto());
            
            ps.execute();
            ps.close();
            conexao.close();
               
        } catch (SQLException ex) {
            Logger.getLogger(dbLocadora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void alterar(Aluguel a){
        String sql = "update aluguel set marca=?, modelo=?, ano=?, valor=?, completo=? where id=?";
        Connection conexao = LocadoraDeCarrosConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, a.getMarca());
            ps.setString(2, a.getModelo());
            ps.setInt(3, a.getAno());
            ps.setDouble(4, a.getValor());
            ps.setString(5, a.getCompleto());
            ps.setInt(6, a.getId());
            
            ps.execute();
            ps.close();
            conexao.close();
               
        } catch (SQLException ex) {
            Logger.getLogger(dbLocadora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void excluir(Aluguel a){
        String sql = "delete from aluguel where id=?";
        Connection conexao = LocadoraDeCarrosConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setInt(1, a.getId());
            
            ps.execute();
            ps.close();
            conexao.close();
               
        } catch (SQLException ex) {
            Logger.getLogger(dbLocadora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public ArrayList<Aluguel> listar(String condicao){
        ArrayList<Aluguel> listaEstoque = new ArrayList<Aluguel>();
        
        String sql = "select * from aluguel";
        
        
        Connection conexao = LocadoraDeCarrosConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                listaEstoque.add(new Aluguel(rs.getInt("id"), rs.getString("marca"), rs.getString("modelo"), 
                         rs.getInt("ano") , rs.getDouble("valor"), rs.getString("completo")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(dbLocadora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaEstoque;
    }
    
    public Aluguel ConsultaId(int id){
        Aluguel retorne = null;
        String sql = "select * from aluguel where id=?";
        Connection conexao = LocadoraDeCarrosConexao.getConnection();
        
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
 
            while(rs.next()){
                retorne = new Aluguel(rs.getInt("id"), rs.getString("marca"), rs.getString("modelo"), 
                         rs.getInt("ano") , rs.getDouble("valor"), rs.getString("completo"));
 
            }
        } catch (SQLException ex) {
            Logger.getLogger(dbLocadora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorne;
    }
}
