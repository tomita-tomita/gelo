package control;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class GeradorSQL {

    GerenciadorDeDados gerenciadorDeDados = new GerenciadorDeDados("localhost", "3306", "root", "");

    public enum tipoOperacao {

        ENTRADA, SAIDA;
    }

    public void cadastrarProduto(Produto novoProduto) throws SQLException {
        String sql = "INSERT controleestoque.produtos set "
                + "descricao = '" + novoProduto.getDescricao() + "', "
                + "codigo_barras = " + novoProduto.getCodigoBarras() + ", "
                + "precoCompra = " + novoProduto.getPrecoCompra() + ", "
                + "precoVenda = " + novoProduto.getPrecoVenda();
        gerenciadorDeDados.executar(sql);
        inserirRegistroEstoque(novoProduto);
    }

    private void inserirRegistroEstoque(Produto novoProduto) throws SQLException {
        String sql = "INSERT controleestoque.estoque set "
                + "id_produto = " + gerenciadorDeDados.getIDProduto(novoProduto.getCodigoBarras()) + ", "
                + "quantidade = 0";
        gerenciadorDeDados.executar(sql);
    }

    public void alterarProduto(Produto produto) throws SQLException {
        String sql = "UPDATE controleestoque.produtos set "
                + "descricao = '" + produto.getDescricao() + "', "
                + "codigo_barras = " + produto.getCodigoBarras() + ", "
                + "precoCompra = " + produto.getPrecoCompra() + ", "
                + "precoVenda = " + produto.getPrecoVenda()
                + " WHERE "
                + "id = '" + produto.getId() + "'";
        gerenciadorDeDados.executar(sql);
    }

    public void excluirProduto(String codigo) throws SQLException {
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

        sql = "SELECT p.id, "
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
        dados = gerenciadorDeDados.getDadosTabela(sql);
        return new DefaultTableModel(dados, headers) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public DefaultTableModel consultarProdutos(String filtros) throws SQLException {
        String sql;
        String[] headers = {"Código", "Descrição", "Código de Barras"};
        String[][] dados;

        sql = "SELECT p.id, "
                + "p.descricao, "
                + "p.codigo_barras "
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

        sql = "SELECT id, "
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

    public int gravarRecibo(Recibo recibo) {
        ArrayList<ItemRecibo> itensRecibo = recibo.getItensRecibo();
        String sql = "INSERT controleestoque.recibos set "
                + " cliente = '" + recibo.getCliente() + "', "
                + " endereco = '" + recibo.getEndereco() + "', "
                + " telefone = '" + recibo.getTelefone() + "', "
                + " taxaEntrega = " + recibo.getTaxaEntrega() + ", "
                + " dataEmissao = now(), "
                + " valorTotal = " + recibo.getValorTotal();

        gerenciadorDeDados.executarComando(sql);
        int id = gerenciadorDeDados.getId("recibos");
        
        for (ItemRecibo itemRecibo : itensRecibo) {
            sql = "INSERT controleestoque.itens_recibo set "
                    + " id_recibo = " + id + ", "
                    + " id_produto = " + itemRecibo.getId_produto() + ", "
                    + " descricao = '" + itemRecibo.getDescricao() + "', "
                    + " quantidade = " + itemRecibo.getQuantidade() + ", "
                    + " precoUnitario = " + itemRecibo.getPrecoUnitario() + ", "
                    + " precoTotal = " + itemRecibo.getPrecoTotal();
            
            gerenciadorDeDados.executarComando(sql);
        }
        
        return id;
    }
}
