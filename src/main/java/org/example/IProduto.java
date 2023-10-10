package org.example;

import java.util.List;

public interface IProduto {

    List<String> obterDetalhes();

    Integer obterQntdEstoque(Funcionario funcionario);
}