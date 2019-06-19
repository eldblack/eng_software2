/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import bd.ComandoSQl;
import bd.ConexaoSQlite;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pessoas.Funcionario;

/**
 *
 * @author Pedro
 */
public class Metodos {
       
    public Funcionario busca(String cpf){
        Funcionario f = new Funcionario();
        
        ConexaoSQlite conexaoSqlite = new ConexaoSQlite();
        conexaoSqlite.conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement= null;
        String sql= ComandoSQl.BUSCAR_FUNCUIONARIO.comando;
        try {
            preparedStatement= conexaoSqlite.criarPreparedStatement(sql);
            preparedStatement.setString(1, cpf);
            resultSet = preparedStatement.executeQuery();
            f.setNome(resultSet.getString("nome"));
            f.setCpf(resultSet.getString("cpf"));
            f.setSalario(resultSet.getDouble("salario"));
            f.setTelefone(resultSet.getString("telefone"));
            f.setFuncao(resultSet.getString("funcao"));
            f.setRg(resultSet.getString("RG"));
            f.setSenha(resultSet.getString("senha"));
            f.setIdFunc(resultSet.getInt("id"));
            return f;
        } catch (SQLException ex) {
            
        }finally{
            try{
                resultSet.close();
                preparedStatement.close();
                conexaoSqlite.desconectar();
            }catch(SQLException ex){
                
            }
        }
        return null;
    }
    
    public Funcionario buscaFunc(int id){
        Funcionario f = new Funcionario();
        
        ConexaoSQlite conexaoSqlite = new ConexaoSQlite();
        conexaoSqlite.conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement= null;
        String sql= "SELECT *FROM tbl_funcionario WHERE id=?;";
        try {
            preparedStatement= conexaoSqlite.criarPreparedStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            f.setNome(resultSet.getString("nome"));
            f.setCpf(resultSet.getString("cpf"));
            f.setSalario(resultSet.getDouble("salario"));
            f.setTelefone(resultSet.getString("telefone"));
            f.setFuncao(resultSet.getString("funcao"));
            f.setRg(resultSet.getString("RG"));
            f.setSenha(resultSet.getString("senha"));
            f.setIdFunc(resultSet.getInt("id"));
            return f;
        } catch (SQLException ex) {
            
        }finally{
            try{
                resultSet.close();
                preparedStatement.close();
                conexaoSqlite.desconectar();
            }catch(SQLException ex){
                
            }
        }
        return null;
    }
    
    
    public int verifca(Funcionario f, String senha){
        
        try{
            if(f.getSenha().equals(senha)){
                return 1;
            }
        }catch(NullPointerException e){
        }
        return 0;
    }
}

