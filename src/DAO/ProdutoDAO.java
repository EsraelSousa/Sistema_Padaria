/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.CriaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Logica.Produtos;

/**
 *
 * @author esrael
 */
public class ProdutoDAO {
    
    private Connection conexao;
    public ProdutoDAO() throws SQLException{
        this.conexao = CriaConexao.getConexao();
        
    }
    // Botão  Salvar
    public void adicionar(Produtos pd) throws SQLException{
        // prepara
        String sql = "insert into produtos(nomeProd, descrição, qtdeProd, valUnitProd, ValTotalProd)" +
                "values (?,?,?,?,?)";
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        //seta os valores
        stmt.setString(1, pd.getNomeProd());
        stmt.setString(2, pd.getDescricao());
        stmt.setString(3, pd.getQtdeProd());
        stmt.setString(4, pd.getValUnitProd());
        stmt.setString(5, pd.getValTotalProd());
        
        // Executa o código sql
        stmt.execute();
        stmt.close();
    }
    
    // Botão Aditar
    public void alterar(Produtos pd) throws SQLException{
        // Prepara conexao
        String sql = "UPDATE produtos SET nomeProd=?, descrição=?, qtdeProd=?, valUnitProd=?, ValTotalProd=? WHERE idProd=? ";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        //seta os valores
        stmt.setString(1, pd.getNomeProd());
        stmt.setString(2, pd.getDescricao());
        stmt.setString(3, pd.getQtdeProd());
        stmt.setString(4, pd.getValUnitProd());
        stmt.setString(5, pd.getValTotalProd());
        stmt.setLong(6, pd.getIdProd());
        
        // Executa o código sql
        
        stmt.execute();
        stmt.close();
    }
    
    // Botão excluir
    public void remover(Produtos pd) throws SQLException{
        // Prepara conexao
        String sql = "delete from produtos where idProd=?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        //seta os valores
        stmt.setLong(1, pd.getIdProd());
        
        // Executa o código sql
        stmt.execute();
        stmt.close();
    }
    
    // Botão Pesquisar
    public List<Produtos> getNome(String nomeProd) throws SQLException{
        // Prepara conexao
        String sql = "select * from produtos where nomeProd like ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        //seta os valores
        stmt.setString(1, nomeProd);
        ResultSet rs = stmt.executeQuery();
        List<Produtos> minhaLista = new ArrayList<Produtos>();
        while(rs.next()){
            Produtos pd = new Produtos();
            pd.setIdProd(Long.valueOf(rs.getString("idProd")));
            pd.setNomeProd(rs.getString("nomeProd"));
            pd.setDescricao(rs.getString("descrição"));
            pd.setQtdeProd(rs.getString("qtdeProd"));
            pd.setValUnitProd(rs.getString("valUnitProd"));
            pd.setValTotalProd(rs.getString("ValTotalProd"));
            minhaLista.add(pd);
        }
        rs.close();
        stmt.close();
        return minhaLista;
    }

    public void setNomeProd(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
