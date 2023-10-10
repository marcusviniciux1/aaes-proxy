package org.example;

import java.util.List;

public class ProdutoProxy implements IProduto {

    private Produto produto;

    private Integer codigo;

    public ProdutoProxy(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public List<String> obterDetalhes() {
        if (this.produto == null) {
            this.produto = new Produto(this.codigo);
        }
        return this.produto.obterDetalhes();
    }

    @Override
    public Integer obterQntdEstoque(Funcionario funcionario) {
        if (!funcionario.isAdministrador()) {
            throw new IllegalArgumentException("Funcionário não autorizado");
        }
        if (this.produto == null) {
            this.produto = new Produto(this.codigo);
        }
        return this.produto.obterQntdEstoque(funcionario);
    }
}