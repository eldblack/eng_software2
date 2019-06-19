/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import bd.ConexaoSQlite;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pessoas.Cliente;

/**
 *
 * @author Pedro
 */
public class Entrega extends Cliente {
    private String endereco;
    private String lanche;
    private String acompanhamento;
    private double preco;
    
    public Entrega(){}
    public Entrega(String nome, String cpf, String rg, String telefone, String endereco) {
        super(nome, cpf, rg, telefone);
    
        this.endereco = endereco;
    }



    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLanche() {
        return lanche;
    }

    public void setLanche(String lanche) {
        this.lanche = lanche;
    }

    public String getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(String acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public Entrega getEntrega(String cpf) {

        Entrega entrega = new Entrega();
        ConexaoSQlite conSQLite = new ConexaoSQlite();
        conSQLite.conectar();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT * "
                + " FROM tbl_entrega"
                + " WHERE cpf = ?;";

        try {

            preparedStatement = conSQLite.criarPreparedStatement(sql);
            preparedStatement.setString(1, cpf);
            resultSet = preparedStatement.executeQuery();
            boolean ver = FALSE;
            while (resultSet.next()) {
                entrega.setNome(resultSet.getString("nome"));
                entrega.setCpf(resultSet.getString("cpf"));
                entrega.setRg(resultSet.getString("RG"));
                entrega.setEndereco(resultSet.getString("endereco"));
                entrega.setTelefone(resultSet.getString("telefone"));
                ver = TRUE;
                return entrega;
            }
            if (FALSE == ver) {
                JOptionPane.showMessageDialog(null, "ENTREGA NÃO ENCONTRADA");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ENTREGA NÃO ENCONTRADA: " + ex, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                conSQLite.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ENTREGA NÃO ENCONTRADA: " + ex, "ERRO", JOptionPane.ERROR_MESSAGE);

            }
        }
        return null;
    }
    
}
