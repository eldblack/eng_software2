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
public class Funcionario extends Pessoa{
    private String funcao;
    private Double salario;
    private String senha;

    
    public Funcionario(){}
    
    public Funcionario(String funcao, Double salario, String senha, String nome, String cpf, String rg, String telefone) {
        super(nome, cpf, rg, telefone);
        this.funcao = funcao;
        this.salario = salario;
        this.senha = senha;
    }

    

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
