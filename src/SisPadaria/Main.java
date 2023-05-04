/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SisPadaria;

import Conexao.CriaConexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        new frames.FrCadProd().setVisible(true);
        Connection con = CriaConexao.getConexao();
        
         //testar se esta ativo
        if (con== null){
            JOptionPane.showMessageDialog(null, "Não é possivel estabelecer conexão com o banco de dados\nO programa será encerrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        con.close();
    }
    
}
