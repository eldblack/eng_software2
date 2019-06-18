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
 * @author Marcos Paulo
 */
public class Reserva extends Cliente{
    private String data;
    private String hora;
    private int numPessoas;
    private int numMesa;


    public Reserva(){
        
    }
    

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }
      private String endereco;
    private String cartao;

    public Reserva(String data, String hora, int numPessoas, int numMesa,  String nome, String cpf, String rg, String telefone, String endereco, String cartao) {
        super(nome, cpf, rg, telefone);
        this.data = data;
        this.hora = hora;
        this.numPessoas = numPessoas;
        this.numMesa = numMesa;
        this.endereco = endereco;
        this.cartao = cartao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getNumPessoas() {
        return numPessoas;
    }

    public void setNumPessoas(int numPessoas) {
        this.numPessoas = numPessoas;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }
     public Reserva getReserva(String cpf){
        
        
                Reserva entrega  = new Reserva();
                ConexaoSQlite conSQLite = new ConexaoSQlite();
                conSQLite.conectar();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		
		String sql = "SELECT * "
				+ " FROM tbl_reserva"
				+ " WHERE cpf = ?;";
		
		
		try {
			
			preparedStatement = conSQLite.criarPreparedStatement(sql);
			preparedStatement.setString(1,cpf);
			resultSet = preparedStatement.executeQuery();
                        boolean ver=FALSE;
			while(resultSet.next()) {
				entrega.setNome(resultSet.getString("nome"));
                                entrega.setCpf(resultSet.getString("cpf"));
                                entrega.setRg(resultSet.getString("RG"));
                                entrega.setEndereco(resultSet.getString("endereco"));
                                entrega.setTelefone(resultSet.getString("telefone"));
                                entrega.setData(resultSet.getString("data"));
                                entrega.setHora(resultSet.getString("hora"));
                                entrega.setCartao(resultSet.getString("numCartao"));
                                entrega.setNumMesa(resultSet.getInt("numMesa"));
                                entrega.setNumPessoas(resultSet.getInt("numPessoa"));
                                
                                ver = TRUE;
                                return entrega;
                        }
                        if(FALSE == ver){
                            JOptionPane.showMessageDialog(null, "RESERVA NÃO ENCONTRADA");
                        }
                        
                        
			
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "RESERVA NÃO ENCONTRADA: "+ex, "ERRO", JOptionPane.ERROR_MESSAGE);
		}finally {
			try {
				resultSet.close();
				preparedStatement.close();
				conSQLite.desconectar();
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null, "RESERVA NÃO ENCONTRADA: "+ex, "ERRO", JOptionPane.ERROR_MESSAGE);

			}
		}
        return null;
    }
     public Reserva getReservaid(String id){
        
        
                Reserva entrega  = new Reserva();
                ConexaoSQlite conSQLite = new ConexaoSQlite();
                conSQLite.conectar();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		
		String sql = "SELECT * "
				+ " FROM tbl_reserva"
				+ " WHERE id = ?;";
		
		
		try {
			
			preparedStatement = conSQLite.criarPreparedStatement(sql);
			preparedStatement.setString(1,id);
			resultSet = preparedStatement.executeQuery();
                        boolean ver=FALSE;
			while(resultSet.next()) {
				entrega.setNome(resultSet.getString("nome"));
                                entrega.setCpf(resultSet.getString("cpf"));
                                entrega.setRg(resultSet.getString("RG"));
                                entrega.setEndereco(resultSet.getString("endereco"));
                                entrega.setTelefone(resultSet.getString("telefone"));
                                entrega.setData(resultSet.getString("data"));
                                entrega.setHora(resultSet.getString("hora"));
                                entrega.setCartao(resultSet.getString("numCartao"));
                                entrega.setNumMesa(resultSet.getInt("numMesa"));
                                entrega.setNumPessoas(resultSet.getInt("numPessoa"));
                                
                                ver = TRUE;
                                return entrega;
                        }
                        if(FALSE == ver){
                            JOptionPane.showMessageDialog(null, "RESERVA NÃO ENCONTRADA");
                        }
                        
                        
			
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, "RESERVA NÃO ENCONTRADA: "+ex, "ERRO", JOptionPane.ERROR_MESSAGE);
		}finally {
			try {
				resultSet.close();
				preparedStatement.close();
				conSQLite.desconectar();
			}catch(SQLException ex) {
				JOptionPane.showMessageDialog(null, "RESERVA NÃO ENCONTRADA: "+ex, "ERRO", JOptionPane.ERROR_MESSAGE);

			}
		}
        return null;
    }
    
}
