/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import bd.ComandoSQl;
import bd.ConexaoSQlite;
import cardapio.Lanche;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro
 */
public class Pedido {
    private int id;
    String nome;
    Double preco;
    int qtd;
    String tipo;
    String cpf;
    int ID_lanche_Acomp;

    public int getID_lanche_Acomp() {
        return ID_lanche_Acomp;
    }

    public void setID_lanche_Acomp(int ID_lanche_Acomp) {
        this.ID_lanche_Acomp = ID_lanche_Acomp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public Pedido(){}

    public Pedido(String nome, Double preco, int qtd, String tipo) {
        this.nome = nome;
        this.preco = preco;
        this.qtd = qtd;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public ArrayList<Pedido> buscarPedido(String cpf) throws SQLException{
        ConexaoSQlite conSQLite = new ConexaoSQlite();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        conSQLite.conectar();
        String query = ComandoSQl.BUSCAR_PEDIDO1.comando;
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try {
            statement = conSQLite.criarPreparedStatement(query);
            statement.setString(1, cpf);
            resultSet = statement.executeQuery();
            int cont=0;
            while(resultSet.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(resultSet.getInt("id"));
                pedido.setNome(resultSet.getString("nome"));
                pedido.setPreco(resultSet.getDouble("preco"));
                pedido.setQtd(resultSet.getInt("qtd"));
                pedido.setTipo(resultSet.getString("tipo"));
                pedido.setCpf(resultSet.getString("cpf"));
                pedido.setID_lanche_Acomp(resultSet.getInt("id_Lanche_Acomp"));
                pedidos.add(pedido);
                cont++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO", "erro", JOptionPane.ERROR_MESSAGE);
        } finally {
        }
        resultSet.close();
        statement.close();
        conSQLite.desconectar();
        return pedidos;
    }
    public Pedido buscarPedidoIP(int ip) throws SQLException{
        ConexaoSQlite conSQLite = new ConexaoSQlite();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        conSQLite.conectar();
        String query = ComandoSQl.BUSCAR_PEDIDO2.comando;
        Pedido pedido = new Pedido();
        try {
            statement = conSQLite.criarPreparedStatement(query);
            statement.setInt(1, ip);
            resultSet = statement.executeQuery();
            int cont=0;
            while(resultSet.next()) {
                pedido.setId(resultSet.getInt("id"));
                pedido.setNome(resultSet.getString("nome"));
                pedido.setPreco(resultSet.getDouble("preco"));
                pedido.setQtd(resultSet.getInt("qtd"));
                pedido.setTipo(resultSet.getString("tipo"));
                pedido.setCpf(resultSet.getString("cpf"));
                pedido.setID_lanche_Acomp(resultSet.getInt("id_Lanche_Acomp"));
                cont++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO", "erro", JOptionPane.ERROR_MESSAGE);
        } finally {
        }
        resultSet.close();
        statement.close();
        conSQLite.desconectar();
        return pedido;
    }
    
}
