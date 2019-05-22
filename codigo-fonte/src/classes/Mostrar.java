/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import bd.ComandoSQl;
import static bd.ComandoSQl.MOSTRAR_LANCHE;
import bd.ConexaoSQlite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pedro
 */
public class Mostrar {
    
    public DefaultTableModel mostrarLanche(JTable tabelaLanche){
    
                ConexaoSQlite conSQLite = new ConexaoSQlite();
                ResultSet resultSet=null;
		Statement statement;
		conSQLite.conectar();
		String query = ComandoSQl.MOSTRAR_LANCHE.comando;
		statement = conSQLite.criarStatement();
		int linhas=0;
		try {
			                 System.out.println("1");
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				linhas++;
			}
                
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "ERRO", "erro", JOptionPane.ERROR_MESSAGE);
		}
                
                DefaultTableModel tModel = (DefaultTableModel)tabelaLanche.getModel();
                tModel.setRowCount(linhas);
                linhas=0;
             
		try {
                   
			
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				tabelaLanche.setValueAt(resultSet.getInt("id"), linhas, 0);
                                tabelaLanche.setValueAt(resultSet.getString("nome"), linhas, 1);
                                tabelaLanche.setValueAt("R$"+resultSet.getDouble("preco"), linhas, 2);
                                tabelaLanche.setValueAt(resultSet.getInt("qtd"), linhas, 3);
                                linhas++;
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "ERRO", "erro", JOptionPane.ERROR_MESSAGE);
		}finally {
			try {
				resultSet.close();
				statement.close();
				conSQLite.desconectar();
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null, "ERRO", "erro", JOptionPane.ERROR_MESSAGE);

			}
		}
                return tModel;
    }
    
    public DefaultTableModel mostraAcompanhamento(JTable tabelaAcomp){
    
    
        ConexaoSQlite conSQLite = new ConexaoSQlite();
                ResultSet resultSet=null;
		Statement statement;
		conSQLite.conectar();
		String query = ComandoSQl.MOSTRAR_ACOMPANHAMENTO.comando;
		statement = conSQLite.criarStatement();
		int linhas=0;
		try {
			
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				linhas++;
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "ERRO", "erro", JOptionPane.ERROR_MESSAGE);
		}
                linhas=0;
                DefaultTableModel tModel = (DefaultTableModel)tabelaAcomp.getModel();
             
		try {
			
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				tabelaAcomp.setValueAt(resultSet.getInt("id"), linhas, 0);
                                tabelaAcomp.setValueAt(resultSet.getString("tipo"), linhas, 1);
                                tabelaAcomp.setValueAt("R$"+resultSet.getDouble("valor"), linhas, 2);
                                tabelaAcomp.setValueAt(resultSet.getInt("qtd"), linhas, 3);
                                linhas++;
			}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "ERRO", "erro", JOptionPane.ERROR_MESSAGE);
		}finally {
			try {
				resultSet.close();
				statement.close();
				conSQLite.desconectar();
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null, "ERRO", "erro", JOptionPane.ERROR_MESSAGE);

			}
		}
                return tModel;
    }
}

