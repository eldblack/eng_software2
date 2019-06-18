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
import cardapio.AcompanhamentoLixo;
import cardapio.Lanche;
import classes.Entrega;
import classes.Pedido;
import classes.Reserva;
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
    public void cadastrarEntrega(Entrega entrega){
        ConexaoSQlite conexoaSQlite = new ConexaoSQlite();
        CriarBancoSQLite criarBancoSQlite = new CriarBancoSQLite(conexoaSQlite);
        criarBancoSQlite.criarTabelaEntrega();
        conexoaSQlite.conectar();
        
        String sqlInsert = ComandoSQl.ADD_ENTREGA.comando;
        PreparedStatement preparedStatement = conexoaSQlite.criarPreparedStatement(sqlInsert);
        
        try{
            preparedStatement.setString(1, entrega.getNome());
            preparedStatement.setString(2, entrega.getCpf());
            preparedStatement.setString(3, entrega.getTelefone());
            preparedStatement.setString(4, entrega.getRg());
            preparedStatement.setString(5, entrega.getEndereco());
            int resultado= preparedStatement.executeUpdate();
            if(resultado!=1){
                JOptionPane.showMessageDialog(null,"Erro ao adicionar Entrega", "Erro",JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Entrega Cadastrada com sucesso!");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Falha ao inserir Entrega", "Erro",JOptionPane.WARNING_MESSAGE);
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
    
    public void cancelarEntrega(int codigo){
        ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
        conexaoSQlite.conectar();
        PreparedStatement preparedStatement=null;
        String sql = ComandoSQl.REMOVER_ENTREGA.comando;
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
    public void cadastrarReserva(Reserva reserva) throws SQLException{
        boolean verifica =true; //VerificaChoquedeHorario.verifica(reserva);
        
            if(verifica == true){
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
            preparedStatement.setString(5, reserva.getData());
            preparedStatement.setString(6, reserva.getHora());
            preparedStatement.setInt(7, reserva.getNumMesa());
             preparedStatement.setString(8, reserva.getEndereco());
              preparedStatement.setString(9,reserva.getCartao());
            preparedStatement.setInt(10, reserva.getNumPessoas());
            int resultado= preparedStatement.executeUpdate();
            if(resultado!=1){
                JOptionPane.showMessageDialog(null,"Erro ao adicionar Reserva", "Erro",JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Reserva Cadastrada com sucesso!");
            }
        }catch(SQLException e){
            System.err.println("Erro: "+e);
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
            }else{
                JOptionPane.showMessageDialog(null,"Já existe uma reserva nessa mesma data e horário", "Erro",JOptionPane.WARNING_MESSAGE);
            }
    }
    public boolean cancelarReserva(int codigo){
        ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
        conexaoSQlite.conectar();
        PreparedStatement preparedStatement=null;
        String sql = ComandoSQl.REMOVER_RESERVA.comando;
        try{
            preparedStatement=conexaoSQlite.criarPreparedStatement(sql);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
            return true;
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
        return false;
    }
    public boolean removerFuncionario(int codigo){
        ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
        conexaoSQlite.conectar();
        PreparedStatement preparedStatement=null;
        String sql = ComandoSQl.REMOVER_FUNCIONARIO.comando;
        try{
            preparedStatement=conexaoSQlite.criarPreparedStatement(sql);
            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();
            return true;
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
        return false;
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
    public void alterarLanche(Lanche lanche){
        ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
        conexaoSQlite.conectar();
        PreparedStatement preparedStatement=null;
        String sql = ComandoSQl.ALTERAR_LANCHE.comando;
        try{
            preparedStatement=conexaoSQlite.criarPreparedStatement(sql);
            preparedStatement.setString(1, lanche.getNome());
            preparedStatement.setDouble(2, lanche.getPreco());
            preparedStatement.setInt(3, lanche.getQtd());
            preparedStatement.setInt(4, lanche.getId());
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao alterar Lanche", "Erro",JOptionPane.WARNING_MESSAGE);
        }finally {
            try{
                preparedStatement.close();
                conexaoSQlite.desconectar();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro ao alterar Lanche", "Erro",JOptionPane.WARNING_MESSAGE);
            }            
        }
    }
    public void alterarAcomp(Acompanhamento acomp){
        ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
        conexaoSQlite.conectar();
        PreparedStatement preparedStatement=null;
        String sql = ComandoSQl.ALTERAR_ACOMP.comando;
        try{
            preparedStatement=conexaoSQlite.criarPreparedStatement(sql);
            preparedStatement.setString(1, acomp.getTipo());
            preparedStatement.setDouble(2, acomp.getValor());
            preparedStatement.setInt(3, acomp.getQtd());
            preparedStatement.setInt(4, acomp.getId());
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao alterar Acompanhamento", "Erro",JOptionPane.WARNING_MESSAGE);
        }finally {
            try{
                preparedStatement.close();
                conexaoSQlite.desconectar();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro ao alterar Acompanhamento", "Erro",JOptionPane.WARNING_MESSAGE);
            }            
        }
    }
    public void alterarPedido(Pedido pedido){
        ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
        conexaoSQlite.conectar();
        PreparedStatement preparedStatement=null;
        String sql = ComandoSQl.ALTERAR_PEDIDO.comando;
        try{
            preparedStatement=conexaoSQlite.criarPreparedStatement(sql);
            preparedStatement.setString(1, pedido.getNome());
            preparedStatement.setDouble(2, pedido.getPreco());
            preparedStatement.setInt(3, pedido.getQtd());
            preparedStatement.setString(4, pedido.getTipo());
            preparedStatement.setString(5, pedido.getCpf());
            preparedStatement.setInt(6, pedido.getID_lanche_Acomp());
            preparedStatement.setInt(7, pedido.getId());
            preparedStatement.executeUpdate();
            System.out.println("id: "+pedido.getId());
        }catch(SQLException e){
            System.out.println("aaaa");
            e.printStackTrace();
        }finally {
            try{
                preparedStatement.close();
                conexaoSQlite.desconectar();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro ao alterar Pedido1", "Erro",JOptionPane.WARNING_MESSAGE);
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
            preparedStatement.setDouble(2, pedido.getPreco());
            preparedStatement.setInt(3, pedido.getQtd());
            preparedStatement.setString(4, pedido.getTipo());
            preparedStatement.setString(5, pedido.getCpf());
            preparedStatement.setInt(6, pedido.getID_lanche_Acomp());
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
    public void removerPedido(String cpf){
    
        ConexaoSQlite conexaoSQlite = new ConexaoSQlite();
        conexaoSQlite.conectar();
        PreparedStatement preparedStatement=null;
        String sql = ComandoSQl.REMOVER_PEDIDO.comando;
        try{
            preparedStatement=conexaoSQlite.criarPreparedStatement(sql);
            preparedStatement.setString(1, cpf);
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
