package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoProxyTest {

    @BeforeEach
    void setUp() {
        BD.addProduto(new Produto(10001, "Mouse", 100.0f, 50));
        BD.addProduto(new Produto(20001, "Teclado", 150.0f, 25));
    }

    @Test
    void deveRetornarDetalherProduto() {
        ProdutoProxy produto = new ProdutoProxy(10001);

        assertEquals(Arrays.asList("Mouse", "100.0"), produto.obterDetalhes());
    }

    @Test
    void deveRetonarQuantidadeEmEstoqueProduto() {
        Funcionario funcionario = new Funcionario("Marcus", true);
        ProdutoProxy produto = new ProdutoProxy(20001);

        assertEquals(25, produto.obterQntdEstoque(funcionario));
    }

    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoConsultarQuantidadeEmEstoqueProduto() {
        try {
            Funcionario funcionario = new Funcionario("Vinícus", false);
            ProdutoProxy produto = new ProdutoProxy(20001);

            produto.obterQntdEstoque(funcionario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }
}