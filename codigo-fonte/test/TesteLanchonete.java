/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cadastro.Cadastro;
import classes.Entrega;
import classes.Pedido;
import classes.Reserva;
import java.sql.SQLException;
import metodos.Metodos;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pessoas.Funcionario;

/**
 *
 * @author Pedro
 */
public class TesteLanchonete {
    
    public TesteLanchonete() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
   
    
    @Test
    public void testBuscaReserva(){
    
        String cpf = "101.010.101-01";
        Reserva busca = new Reserva();
        Reserva reserva = busca.getReserva(cpf);
        String result = reserva.getNome();
        String expResult = "Mario Leite";
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testBuscaPedido(){
        
        int idPedido = 16;
        Pedido busca = new Pedido();
        Pedido pedido=null;
        try{
            pedido = busca.buscarPedidoIP(idPedido);
        }catch(SQLException e){}
        String result = pedido.getNome();
        String expResult = "Coxinha";
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBuscaEntrega(){
    
        String cpf = "067.130.493-38";
        Entrega entrega = new Entrega();
        Entrega result = entrega.getEntrega(cpf);
        assertNotNull(result);
    }
    
    @Test
    public void testRemoveFuncionario(){
    
        int idFunc = 5;
        Cadastro func = new Cadastro();
        boolean result = func.removerFuncionario(idFunc);
        boolean expResult = true;
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCancelaReserva(){
    
        int idReserva = 11;
        Cadastro reserva = new Cadastro();
        boolean result = reserva.cancelarReserva(idReserva);
        boolean expResult = true;
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCadastraRemoveFuncionario(){
        Metodos met = new Metodos();
        String nome = "João Paulo";
        String funcao = "Vendedor";
        double salario = 1200;
        String senha = "987";
        String cpf = "123.345.678-90";
        String rg = "9899192891";
        String fone = "(89)9913-2134";
        Funcionario funcionario = new Funcionario(funcao,salario,senha,nome,cpf,rg,fone);
        Cadastro cadastro = new Cadastro();
        cadastro.cadastroVendedor(funcionario);
        Funcionario busca = met.buscaFunc(10);
        String result = busca.getNome();
        String expResult = nome;
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBuscaRemove(){
        Metodos met = new Metodos();
        Funcionario busca = new Funcionario();
        Cadastro func = new Cadastro();
        int idFunc = 8;
        func.removerFuncionario(idFunc);
        busca = met.buscaFunc(idFunc);
        assertNull(busca);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
