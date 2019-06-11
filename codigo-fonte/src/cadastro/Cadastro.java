/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro;

import bd.ComandoSQl;
import bd.ConexaoSQlite;
import bd.CriarBancoSQLite;
import classes.Pedido;
import classes.Reserva;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pessoas.Funcionario;

/**
 *
 * @author Marcos Paulo
 */
public class Cadastro {
    public void cadastroVendedor(Funcionario func){
        ConexaoSQlite conexoaSQlite = new ConexaoSQlite();
        CriarBancoSQLite criarBancoSQlite = new CriarBancoSQLite(conexoaSQlite);
        criarBancoSQlite.criarTabelaFuncionario();
        conexoaSQlite.conectar();
        
        String sqlInsert = ComandoSQl.ADD_FUNCIONARIO.comando;
        PreparedStatement preparedStatement = conexoaSQlite.criarPreparedStatement(sqlInsert);
        
        try{
            preparedStatement.setString(1, func.getNome());
            preparedStatement.setString(2, func.getCpf());
            preparedStatement.setDouble(3, func.getSalario());
            preparedStatement.setString(4, func.getTelefone());
            preparedStatement.setString(5, func.getFuncao());
            preparedStatement.setString(6, func.getRg());
            preparedStatement.setString(7, func.getSenha());
            int resultado= preparedStatement.executeUpdate();
            if(resultado!=1){
                JOptionPane.showMessageDialog(null,"Erro ao adicionar Vendedor", "Erro",JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Falha ao inserir Vendedor", "Erro",JOptionPane.WARNING_MESSAGE);
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
    public void cadastrarReserva(Reserva reserva){
        ConexaoSQlite conexoaSQlite = new ConexaoSQlite();
        CriarBancoSQLite criarBancoSQlite = new CriarBancoSQLite(conexoaSQlite);
        criarBancoSQlite.criarTabelaReserva();
        conexoaSQlite.conectar();
        
        String sqlInsert = ComandoSQl.ADD_RESERVA.comando;
        PreparedStatement preparedStatement = conexoaSQlite.criarPreparedStatement(sqlInsert);
        
        try{
            preparedStatement.setString(1, reserva.getNome());
            preparedStatement.setString(2, reserva.getCpf());
            preparedStatement.setString(3, reserva.getTelefone());
            preparedStatement.setString(4, reserva.getRg());
            preparedStatement.setString(5, reserva.getEdereco());
            preparedStatement.setString(6, reserva.getNumeroCartao());
            preparedStatement.setString(7, reserva.getData());
            preparedStatement.setString(8, reserva.getHora());
            preparedStatement.setInt(9, reserva.getNumMesa());
            preparedStatement.setInt(10, reserva.getNumPessoas());
            int resultado= preparedStatement.executeUpdate();
            if(resultado!=1){
                JOptionPane.showMessageDialog(null,"Erro ao adicionar Reserva", "Erro",JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Reserva Cadastrada com sucesso!");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Falha ao inserir Reserva", "Erro",JOptionPane.WARNING_MESSAGE);
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
    public void cancelarReserva(int codigo){
        ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
        conexaoSQlite.conectar();
        PreparedStatement preparedStatement=null;
        String sql = ComandoSQl.REMOVER_RESERVA.comando;
        try{
            preparedStatement=conexaoSQlite.criarPreparedStatement(sql);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao Remover Reserva", "Erro",JOptionPane.WARNING_MESSAGE);
        }finally {
            try{
                preparedStatement.close();
                conexaoSQlite.desconectar();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro ao Remover Reserva", "Erro",JOptionPane.WARNING_MESSAGE);
            }            
        }
    }
    
    public void removerFuncionario(int codigo){
        ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
        conexaoSQlite.conectar();
        PreparedStatement preparedStatement=null;
        String sql = ComandoSQl.REMOVER_FUNCIONARIO.comando;
        try{
            preparedStatement=conexaoSQlite.criarPreparedStatement(sql);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao Remover Funcionario", "Erro",JOptionPane.WARNING_MESSAGE);
        }finally {
            try{
                preparedStatement.close();
                conexaoSQlite.desconectar();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro ao Remover Funcionario", "Erro",JOptionPane.WARNING_MESSAGE);
            }            
        }
    }
    
    public void removerAcomapnhamento(int codigo){
        ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
        conexaoSQlite.conectar();
        PreparedStatement preparedStatement=null;
        String sql = ComandoSQl.REMOVER_ACOMPANAMENTO.comando;
        try{
            preparedStatement=conexaoSQlite.criarPreparedStatement(sql);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao Remover Funcionario", "Erro",JOptionPane.WARNING_MESSAGE);
        }finally {
            try{
                preparedStatement.close();
                conexaoSQlite.desconectar();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro ao Remover Funcionario", "Erro",JOptionPane.WARNING_MESSAGE);
            }            
        }
    }
    
    public void removerLanche(int codigo){
        ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
        conexaoSQlite.conectar();
        PreparedStatement preparedStatement=null;
        String sql = ComandoSQl.REMOVER_LANCHE.comando;
        try{
            preparedStatement=conexaoSQlite.criarPreparedStatement(sql);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao Remover Lanche", "Erro",JOptionPane.WARNING_MESSAGE);
        }finally {
            try{
                preparedStatement.close();
                conexaoSQlite.desconectar();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro ao Remover Lanche", "Erro",JOptionPane.WARNING_MESSAGE);
            }            
        }
    }
    
    public void cadastrarPedido(Pedido pedido){
        ConexaoSQlite conexoaSQlite = new ConexaoSQlite();
        CriarBancoSQLite criarBancoSQlite = new CriarBancoSQLite(conexoaSQlite);
        criarBancoSQlite.criarTabelaPedido();
        conexoaSQlite.conectar();
        
        String sqlInsert = ComandoSQl.ADD_PEDIDO.comando;
        PreparedStatement preparedStatement = conexoaSQlite.criarPreparedStatement(sqlInsert);
        
        try{
            preparedStatement.setString(1, pedido.getNome());
            preparedStatement.setString(2, pedido.getLanche());
            preparedStatement.setString(3, pedido.getAcomp());
            preparedStatement.setDouble(4, pedido.getValor());
            int resultado= preparedStatement.executeUpdate();
            if(resultado!=1){
                JOptionPane.showMessageDialog(null,"Erro ao adicionar pedido", "Erro",JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "pedido Cadastrado com sucesso!");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Falha ao inserir pedido", "Erro",JOptionPane.WARNING_MESSAGE);
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
    
    public void removerPedido(int codigo){
    
        ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
        conexaoSQlite.conectar();
        PreparedStatement preparedStatement=null;
        String sql = ComandoSQl.REMOVER_PEDIDO.comando;
        try{
            preparedStatement=conexaoSQlite.criarPreparedStatement(sql);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao Remover pedido", "Erro",JOptionPane.WARNING_MESSAGE);
        }finally {
            try{
                preparedStatement.close();
                conexaoSQlite.desconectar();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro ao Remover pedido", "Erro",JOptionPane.WARNING_MESSAGE);
            }            
        }
    }
}
