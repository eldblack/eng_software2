/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Marcos Paulo
 */
public class ConexaoSQlite {
    
    private Connection conexao;
    
    public boolean conectar(){
        try{
            String url = "jdbc:sqlite:bancoDeDados/bancoSqlite.db";
            this.conexao= DriverManager.getConnection(url);
        }catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
        //System.out.println("Conectou");
        return true;
    }
    
    public boolean desconectar(){
        try{
            if(this.conexao.isClosed()==false){
                this.conexao.close();
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
        //System.out.println("Desconectou");
        return true;
    }
    
    public Statement criarStatement(){
        try{
            return this.conexao.createStatement();
        }catch(SQLException e){
            System.err.println(e.getMessage());
            return null;
        }            
    }
    
    public PreparedStatement criarPreparedStatement(String sql){
        try{
            return this.conexao.prepareStatement(sql);
        }catch(SQLException e){
            System.err.println(e.getMessage());
            return null;
        }            
    }
    
}
