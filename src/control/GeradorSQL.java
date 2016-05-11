/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author valdir
 */
public class GeradorSQL {

    GerenciadorDeDados gerenciadorDeDados = new GerenciadorDeDados("localhost", "3306", "root", "");

    public enum tipoOperacao {

        ENTRADA, SAIDA, TESTE;
    }

    public void cadastrarProduto(Produto novoProduto) throws SQLException {
        String sql = "INSERT controleestoque.produtos set "
                + "codigo = '" + novoProduto.getCodigo() + "', "
                + "descricao = '" + novoProduto.getDescricao() + "', "
                + "codigo_barras = " + novoProduto.getCodigoBarras() + ", "
                + "precoCompra = " + novoProduto.getPrecoCompra() + ", "
                + "precoVenda = " + novoProduto.getPrecoVenda();
        gerenciadorDeDados.executar(sql);
        inserirRegistroEstoque(novoProduto);
    }

    private void inserirRegistroEstoque(Produto novoProduto) throws SQLException {
        String sql = "INSERT controleestoque.estoque set "
                + "id_produto = " + gerenciadorDeDados.getIDProduto(novoProduto.getCodigo()) + ", "
                + "quantidade = 0";
        gerenciadorDeDados.executar(sql);
    }
    
    public void alterarProduto(Produto produto) throws SQLException{
        String sql = "UPDATE controleestoque.produtos set "                
                + "descricao = '" + produto.getDescricao() + "', "
                + "codigo_barras = " + produto.getCodigoBarras() + ", "
                + "precoCompra = " + produto.getPrecoCompra() + ", "
                + "precoVenda = " + produto.getPrecoVenda()
                + " WHERE "
                + "codigo = '" + produto.getCodigo() + "'";
        gerenciadorDeDados.executar(sql);
    }
    
    public void excluirProduto(String codigo) throws SQLException{
      int id = gerenciadorDeDados.getIDProduto(codigo);
        String sql = "DELETE FROM controleestoque.produtos WHERE id = " + Integer.toString(id);
        gerenciadorDeDados.executar(sql);  
        sql = "DELETE FROM controleestoque.estoque WHERE id_produto = " + Integer.toString(id);
        gerenciadorDeDados.executar(sql);  
    }

    public DefaultTableModel getEstoque(String filtros) throws SQLException {
        String sql;
        String[] headers = {"Código", "Descrição", "Código de Barras", "Quantidade"};
        String[][] dados;

        sql = "SELECT p.codigo, "
                + "p.descricao, "
                + "p.codigo_barras, "
                + "e.quantidade "
                + "from "
                + "controleestoque.estoque e, "
                + "controleestoque.produtos p "
                + "where "
                + "e.id_produto = p.id";

        if (!filtros.equals("")) {
            sql = sql + " AND " + filtros;
        }
        System.out.println(sql);
        dados = gerenciadorDeDados.getDadosTabela(sql);
        return new DefaultTableModel(dados, headers) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public DefaultTableModel getProdutos(String filtros) throws SQLException {
        String sql;
        String[] headers = {"Código", "Descrição", "Código de Barras", "Preço de Compra", "Preço de Venda"};
        String[][] dados;

        sql = "SELECT codigo, "
                + "descricao, "
                + "codigo_barras, "
                + "precoCompra, "
                + "precoVenda "
                + "from "
                + "controleestoque.produtos ";

        if (!filtros.equals("")) {
            sql = sql + " WHERE " + filtros;
        }
        dados = gerenciadorDeDados.getDadosTabela(sql);
        DefaultTableModel model;
        return new DefaultTableModel(dados, headers) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public void realizarMovimentacao(String codigoBarras, int quantidade, tipoOperacao operacao) throws SQLException {
        String sql;
        String operador;

        if (operacao == tipoOperacao.ENTRADA) {
            operador = "+";
        } else {
            operador = "-";
        }

        sql = "UPDATE "
                + "controleestoque.estoque e, "
                + "controleestoque.produtos p "
                + "SET "
                + "e.quantidade = e.quantidade " + operador + " " + quantidade
                + " WHERE "
                + "p.codigo_barras = " + codigoBarras
                + " AND p.id = e.id_produto";

        gerenciadorDeDados.executar(sql);
    }

    public Produto pesquisarProduto(String campo, String valor) throws SQLException {
        String sql = "SELECT * FROM controleestoque.produtos WHERE " + campo + " = " + valor;
        return gerenciadorDeDados.getProduto(sql);
    }
}
