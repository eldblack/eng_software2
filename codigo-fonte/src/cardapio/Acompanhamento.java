/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardapio;

import bd.ComandoSQl;
import bd.ConexaoSQlite;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos Paulo
 */
public class Acompanhamento {
    private int id;
    private String tipo;
    private Double valor;
    private int qtd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Acompanhamento(String tipo, Double valor, int qtd) {
        this.tipo = tipo;
        this.valor = valor;
        this.qtd = qtd;
    }

    public Acompanhamento() {
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    public Acompanhamento buscarAcomp(int id){
        ConexaoSQlite conSQLite = new ConexaoSQlite();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        conSQLite.conectar();
        String query = ComandoSQl.BUSCAR_ACOMP.comando;
        Acompanhamento acomp = new Acompanhamento();
        try {
            statement = conSQLite.criarPreparedStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                acomp.setId(resultSet.getInt("id"));
                acomp.setTipo(resultSet.getString("tipo"));
                acomp.setValor(resultSet.getDouble("valor"));
                acomp.setQtd(resultSet.getInt("qtd"));
                return acomp;
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
