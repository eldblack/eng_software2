/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author Marcos Paulo
 */
public enum ComandoSQl {
    BUSCAR_PRODUTO("SELECT * FROM tbl_produto WHERE id = ?;"),
    BUSCAR_LANCHE("SELECT * FROM tbl_lanche WHERE id = ?;"),
    BUSCAR_PEDIDO1("SELECT * FROM tbl_pedido WHERE cpf = ?;"),
    BUSCAR_PEDIDO2("SELECT * FROM tbl_pedido WHERE id = ?;"),
    BUSCAR_ACOMP("SELECT * FROM tbl_acompanhamento WHERE id = ?;"),
    MOSTRAR_LANCHE("SELECT * FROM tbl_lanche"),
    
    MOSTRAR_ACOMPANHAMENTO("SELECT * FROM tbl_acompanhamento"),
    
    ADD_FUNCIONARIO("INSERT INTO tbl_funcionario"
                + "("
                + "nome,"
                + "cpf,"
                + "salario,"
                + "telefone,"
                + "funcao,"
                + "RG,"
                + "senha"
                + ")VALUES(?,?,?,?,?,?,?)"
                + ";"),
    ADD_RESERVA("INSERT INTO tbl_reserva"
                + "("
                + "nome,"
                + "cpf,"
                + "telefone,"
                + "RG,"
                + "data,"
                + "hora,"
                + "numMesa,"
                +"endereco,"
                + "numCartao,"
                + "numPessoa"
                + ")VALUES(?,?,?,?,?,?,?,?,?,?)"
                + ";"),
    ADD_ENTREGA("INSERT INTO tbl_entrega"
                + "("
                + "nome,"
                + "cpf,"
                + "telefone,"
                + "RG,"
                + "endereco"
                + ")VALUES(?,?,?,?,?)"
                + ";"),
     ADD_PEDIDO("INSERT INTO tbl_pedido"
                + "("
                + "nome,"
                + "preco,"
                + "qtd,"
                + "tipo,"
                + "cpf,"
                + "id_Lanche_Acomp"
                + ")VALUES(?,?,?,?,?,?)"
                + ";"),
    REMOVER_PEDIDO("DELETE FROM tbl_pedido WHERE cpf = ?;"),
    
    BUSCAR_FUNCUIONARIO("SELECT * FROM tbl_funcionario WHERE cpf = ?;"),
    
    UPDATE_FUNCIONARIO("UPDATE tbl_funcionario SET "
                + "nome = ?,"
                + "telefone = ?,"
                + "idade = ?,"
                + "RG = ?,"
                + "carga_horaria = ?,"
                + "Endereco = ?"
                + "WHERE id = ?;"),
    REMOVER_FUNCIONARIO("DELETE FROM tbl_funcionario WHERE id = ?;"),
    ADD_CLIENTE("INSERT INTO tbl_cliente "
                + "("
                + "nome,"
                + "telefone,"
                + "idade,"
                + "RG,"
                + "Endereco"
                + ")VALUES(?,?,?,?,?)"
                + ";"),
    BUSCAR_CLIENTE("SELECT * FROM tbl_cliente WHERE id = ?;"),
    
    UPDATE_CLIENTE("UPDATE tbl_cliente SET "
                + "nome = ?,"
                + "telefone = ?,"
                + "idade = ?,"
                + "RG = ?,"
                + "Endereco = ?"
                + "WHERE id = ?;"),
    REMOVER_RESERVA("DELETE FROM tbl_reserva WHERE id = ?;"),
    REMOVER_ENTREGA("DELETE FROM tbl_entrega WHERE id = ?;"),
    
    ADD_LANCHE("INSERT INTO tbl_lanche"
                + "("
                + "nome,"
                + "preco,"
                + "qtd"
                + ")VALUES(?,?,?)"
                + ";"),

    ADD_ACOMPANHAMENTO("INSERT INTO tbl_acompanhamento"
                + "("
                + "tipo,"
                + "valor,"
                + "qtd"
                + ")VALUES(?,?,?)"
                + ";"),
    UPDATE_PRODUTO("UPDATE tbl_produto SET "
                + "nome = ?,"
                + "Quantidade = ?,"
                + "valor_de_compra = ?,"
                + "valor_de_venda = ?"
                + "WHERE id = ?;"),
    REMOVER_PRODUTO("DELETE FROM tbl_produto WHERE nome = ?;"),
    ADD_VENDAS("INSERT INTO tbl_vendas ("
                + "valorTotal,"
                + "data,"
                + "idCliente,"
                + "forma_pagamento"
                + ")VALUES(?,?,?,?);"),
    ADD_ITENS("INSERT INTO tbl_prod_venda("
                + "idProd,"
                + "idVenda,"
                + "quantidade"
                + ")VALUES(?,?,?);"),
    BAIXA_ESTOQUE("UPDATE tbl_produto SET "
                + "Quantidade = ?"
                + "WHERE id = ?;"),
    ADD_PAGAMENTO("INSERT INTO tbl_pagamento_func"
                + "("
                + "idFuncionario,"
                + "data,"
                + "valorPago"
                + ")VALUES(?,?,?)"
                + ";"),
    BUSCAR_VENDA("SELECT * FROM tbl_vendas WHERE data = ?;"),
    
    BUSCAR_ITENS_VENDA("SELECT * FROM tbl_prod_venda WHERE idVenda = ?;"),
    REMOVER_VENDA("DELETE FROM tbl_vendas WHERE idVenda = ?;"),
    REMOVER_ACOMPANAMENTO("DELETE FROM tbl_acompanhamento WHERE id = ?;"),
    REMOVER_LANCHE("DELETE FROM tbl_lanche WHERE id = ?;"),
    REMOVER_ITENS_VENDA("DELETE FROM tbl_prod_venda WHERE idVenda = ?;"),
    ALTERAR_LANCHE("UPDATE tbl_lanche SET nome=?,preco=?,qtd=? WHERE id=?;"),
    ALTERAR_ACOMP("UPDATE tbl_acompanhamento SET tipo=?,valor=?,qtd=? WHERE id=?;"),
    ALTERAR_PEDIDO("UPDATE tbl_pedido SET nome=?, preco=?,qtd=?,tipo=?,cpf=?,id_Lanche_Acomp=? WHERE id=?;");
    
    public String comando;
    
    private ComandoSQl(String comando) {
        this.comando = comando;
    }
}
