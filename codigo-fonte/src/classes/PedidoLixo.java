/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Pedro
 */
public class PedidoLixo {
      
    String nome;
    String lanche;
    String acomp;
    double valor;
    public PedidoLixo(){}

    public PedidoLixo(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLanche() {
        return lanche;
    }

    public void setLanche(String lanche) {
        this.lanche = lanche;
    }

    public String getAcomp() {
        return acomp;
    }

    public void setAcomp(String acomp) {
        this.acomp = acomp;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
