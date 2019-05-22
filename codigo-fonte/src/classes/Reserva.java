/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

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

    public Reserva(String data, String hora, int numPessoas, int numMesa, String edereco, String numeroCartao, String nome, String cpf, String rg, String telefone) {
        super(edereco, numeroCartao, nome, cpf, rg, telefone);
        this.data = data;
        this.hora = hora;
        this.numPessoas = numPessoas;
        this.numMesa = numMesa;
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
    
}
