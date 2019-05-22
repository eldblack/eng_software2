/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardapio;

/**
 *
 * @author Marcos Paulo
 */
public class Acompanhamento {
    private String tipo;
    private Double valor;
    private int qtd;

    public Acompanhamento(String tipo, Double valor, int qtd) {
        this.tipo = tipo;
        this.valor = valor;
        this.qtd = qtd;
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
    
}
