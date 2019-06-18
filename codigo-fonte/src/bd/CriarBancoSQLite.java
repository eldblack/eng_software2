/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos Paulo
 */
public class CriarBancoSQLite {
    
    private final ConexaoSQlite conexaoSQlite;

    public CriarBancoSQLite(ConexaoSQlite conexaoSQlite) {
        this.conexaoSQlite = conexaoSQlite;
    }
    
    public void criarTabelaFuncionario(){
        String sql = "CREATE TABLE IF NOT EXISTS tbl_funcionario"
                + "("
                + "id integer PRIMARY KEY,"
                + "nome text NOT NULL,"
                + "cpf text NOT NULL,"
                + "salario float NOT NULL,"
                + "telefone text NOT NULL,"
                + "funcao text NOT NULL,"
                + "RG text NOT NULL,"
                + "senha text NOT NULL"
                + ");";

        boolean conectou = false;
        
        try{
            conectou=this.conexaoSQlite.conectar();
            Statement stmt = this.conexaoSQlite.criarStatement();
            stmt.execute(sql);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao Criar Tabela Funcionario", "Erro",JOptionPane.WARNING_MESSAGE);
        }finally{
            if(conectou){
                this.conexaoSQlite.desconectar();
            }
        }
        
    }
    
    public void criarTabelaLanche(){
        
        String sql = "CREATE TABLE IF NOT EXISTS tbl_lanche"
                + "("
                + "id integer PRIMARY KEY AUTOINCREMENT,"
                + "nome text NOT NULL,"
                + "preco floar NOT NULL,"
                + "qtd integer NOT NULL"
                + ");";
        boolean conectou = false;
        try{
            conectou=this.conexaoSQlite.conectar();
            Statement stmt = this.conexaoSQlite.criarStatement();
            stmt.execute(sql);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao Criar Tabele lanche", "Erro",JOptionPane.WARNING_MESSAGE);
        }finally{
            if(conectou){
                this.conexaoSQlite.desconectar();
            }
        }
    }
    
    public void criarTabelaAcompanhamento(){
        
        String sql = "CREATE TABLE IF NOT EXISTS tbl_acompanhamento"
                + "("
                + "id integer PRIMARY KEY AUTOINCREMENT,"
                + "tipo text NOT NULL,"
                + "valor floar NOT NULL,"
                + "qtd integer NOT NULL"
                + ");";
        boolean conectou = false;
        try{
            conectou=this.conexaoSQlite.conectar();
            Statement stmt = this.conexaoSQlite.criarStatement();
            stmt.execute(sql);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao Criar Tabele Acompanhamento", "Erro",JOptionPane.WARNING_MESSAGE);
        }finally{
            if(conectou){
                this.conexaoSQlite.desconectar();
            }
        }
    }
    
    public void criarTabelaPedido(){
        
        String sql = "CREATE TABLE IF NOT EXISTS tbl_pedido"
                + "("
                + "id integer PRIMARY KEY AUTOINCREMENT,"
                + "nome text NOT NULL,"
                + "lanche text NOT NULL,"
                + "acompanhamento text,"
                + "valor floar NOT NULL"
                + ");";
        boolean conectou = false;
        try{
            conectou=this.conexaoSQlite.conectar();
            Statement stmt = this.conexaoSQlite.criarStatement();
            stmt.execute(sql);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao Criar Tabela Pedido", "Erro",JOptionPane.WARNING_MESSAGE);
        }finally{
            if(conectou){
                this.conexaoSQlite.desconectar();
            }
        }
    }
    public void criarTabelaReserva(){
        
        String sql = "CREATE TABLE IF NOT EXISTS tbl_reserva"
                + "("
                + "id integer PRIMARY KEY AUTOINCREMENT,"
                + "nome text NOT NULL,"
                + "cpf text NOT NULL,"
                + "telefone text NOT NULL,"
                + "RG text NOT NULL,"
                + "data text NOT NULL,"
                + "hora text NOT NULL,"
                + "endereco text,"
                + "numCartao text,"
                + "numMesa integer NOT NULL,"
                + "numPessoa integer NOT NULL"
                + ");";
        boolean conectou = false;
        try{
            conectou=this.conexaoSQlite.conectar();
            Statement stmt = this.conexaoSQlite.criarStatement();
            stmt.execute(sql);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao Criar Tabele Reserva", "Erro",JOptionPane.WARNING_MESSAGE);
        }finally{
            if(conectou){
                this.conexaoSQlite.desconectar();
            }
        }
    }
    
    public void criarTabelaCliente(){
        String sql = "CREATE TABLE IF NOT EXISTS tbl_cliente"
                + "("
                + "id integer PRIMARY KEY AUTOINCREMENT,"
                + "nome text NOT NULL,"
                + "telefone text NOT NULL,"
                + "idade integer,"
                + "RG text NOT NULL,"
                + "Endereco text NOT NULL"
                + ");";
        
        boolean conectou = false;
        
        try{
            conectou=this.conexaoSQlite.conectar();
            Statement stmt = this.conexaoSQlite.criarStatement();
            stmt.execute(sql);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao Criar Tabele Cliente", "Erro",JOptionPane.WARNING_MESSAGE);
        }finally{
            if(conectou){
                this.conexaoSQlite.desconectar();
            }
        }
        
    }
    public void criarTabelaProduto(){
        String sql = "CREATE TABLE IF NOT EXISTS tbl_produto"
                + "("
                + "id integer PRIMARY KEY AUTOINCREMENT,"
                + "nome text NOT NULL,"
                + "Quantidade integer,"
                + "valor_de_compra double,"
                + "valor_de_venda double"
                + ");";

        boolean conectou = false;
        
        try{
            conectou=this.conexaoSQlite.conectar();
            Statement stmt = this.conexaoSQlite.criarStatement();
            stmt.execute(sql);
                     
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao Criar Tabele Produto", "Erro",JOptionPane.WARNING_MESSAGE);
        }finally{
            if(conectou){
                this.conexaoSQlite.desconectar();
            }
        }
        
    }
    
    public void criarTabelaEntrega(){
    
        String sql = "CREATE TABLE IF NOT EXISTS tbl_entrega"
                + "("
                + "id integer PRIMARY KEY AUTOINCREMENT,"
                + "nome text NOT NULL,"
                + "cpf text NOT NULL,"
                + "telefone text NOT NULL,"
                + "RG text NOT NULL,"
                + "endereco text NOT NULL"
                + ");";

            boolean conectou = false;

            try{
                conectou=this.conexaoSQlite.conectar();
                Statement stmt = this.conexaoSQlite.criarStatement();
                stmt.execute(sql);

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Erro ao Criar Tabela Entrega", "Erro",JOptionPane.WARNING_MESSAGE);
            }finally{
                if(conectou){
                    this.conexaoSQlite.desconectar();
                }
        }
        
    }
}
