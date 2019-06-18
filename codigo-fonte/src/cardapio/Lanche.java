/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardapio;

import bd.ComandoSQl;
import bd.ConexaoSQlite;
import com.sun.org.apache.regexp.internal.REUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pedro
 */
public class Lanche {
    private int id;
    private String nome;
    private double preco;
    private int qtd;
    public Lanche(){}

    public Lanche(String nome, double preco, int qtd) {
        this.nome = nome;
        this.preco = preco;
        this.qtd = qtd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    public void alterar(int id){
        
    }
    public Lanche buscarLanche(int id){
        ConexaoSQlite conSQLite = new ConexaoSQlite();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        conSQLite.conectar();
        String query = ComandoSQl.BUSCAR_LANCHE.comando;
        Lanche lanche = new Lanche();
        try {
            statement = conSQLite.criarPreparedStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                lanche.setId(resultSet.getInt("id"));
                lanche.setNome(resultSet.getString("nome"));
                lanche.setPreco(resultSet.getDouble("preco"));
                lanche.setQtd(resultSet.getInt("qtd"));
                return lanche;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO", "erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                resultSet.close();
                statement.close();
                conSQLite.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO", "erro", JOptionPane.ERROR_MESSAGE);

            }
        }
        return null;
    }
}
