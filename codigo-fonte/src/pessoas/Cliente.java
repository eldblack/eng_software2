/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoas;

/**
 *
 * @author Marcos Paulo
 */
public class Cliente extends Pessoa{
    private String edereco;
    private String numeroCartao;

    public Cliente(String edereco, String numeroCartao, String nome, String cpf, String rg, String telefone) {
        super(nome, cpf, rg, telefone);
        this.edereco = edereco;
        this.numeroCartao = numeroCartao;
    }

    public String getEdereco() {
        return edereco;
    }

    public void setEdereco(String edereco) {
        this.edereco = edereco;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
}
