/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;

import bd.ComandoSQl;
import bd.ConexaoSQlite;
import bd.CriarBancoSQLite;
import cardapio.Acompanhamento;
import cardapio.Lanche;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro
 */
public class CadLanche {
    
    public void cadastrarLanche(Lanche lanche){
    
        ConexaoSQlite conexoaSQlite = new ConexaoSQlite();
        CriarBancoSQLite criarBancoSQlite = new CriarBancoSQLite(conexoaSQlite);
        criarBancoSQlite.criarTabelaLanche();
        conexoaSQlite.conectar();
        
        String sqlInsert = ComandoSQl.ADD_LANCHE.comando;
        PreparedStatement preparedStatement = conexoaSQlite.criarPreparedStatement(sqlInsert);
        
        try{
            preparedStatement.setString(1, lanche.getNome());
            preparedStatement.setDouble(2, lanche.getPreco());
            preparedStatement.setInt(3, lanche.getQtd());
            int resultado= preparedStatement.executeUpdate();
            if(resultado!=1){
                JOptionPane.showMessageDialog(null,"Erro ao adicionar lanche", "Erro",JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Falha ao inserir lanche", "Erro",JOptionPane.WARNING_MESSAGE);
        }finally{
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            conexoaSQlite.desconectar();
        }
    }
    
    public void cadastrarAcomp(Acompanhamento acomp){
        ConexaoSQlite conexoaSQlite = new ConexaoSQlite();
        CriarBancoSQLite criarBancoSQlite = new CriarBancoSQLite(conexoaSQlite);
        criarBancoSQlite.criarTabelaAcompanhamento();
        conexoaSQlite.conectar();
        
        String sqlInsert = ComandoSQl.ADD_ACOMPANHAMENTO.comando;
        PreparedStatement preparedStatement = conexoaSQlite.criarPreparedStatement(sqlInsert);
        
        try{
            preparedStatement.setString(1, acomp.getTipo());
            preparedStatement.setDouble(2, acomp.getValor());
            preparedStatement.setInt(3, acomp.getQtd());
            int resultado= preparedStatement.executeUpdate();
            
            if(resultado!=1){
                JOptionPane.showMessageDialog(null,"Erro ao adicionar Acompanhamento", "Erro",JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Falha ao inserir Acompanhamento", "Erro",JOptionPane.WARNING_MESSAGE);
        }finally{
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            conexoaSQlite.desconectar();
        }
    }
}
