package org.example;

import java.util.Arrays;
import java.util.List;

public class Produto implements IProduto {

    private Integer codigo;
    private String nome;
    private Float preco;
    private Integer qntdEstoque;

    public Produto(int codigo) {
        this.codigo = codigo;
        Produto objeto = BD.getProduto(codigo);
        this.nome = objeto.nome;
        this.preco = objeto.preco;
        this.qntdEstoque = objeto.qntdEstoque;
    }

    public Produto(Integer codigo, String nome, Float preco, Integer qntdEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.qntdEstoque = qntdEstoque;
    }

    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public List<String> obterDetalhes() {
        return Arrays.asList(this.nome, this.preco.toString());
    }

    @Override
    public Integer obterQntdEstoque(Funcionario funcionario) {
        return this.qntdEstoque;
    }
}