package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javassist.CtMethod.ConstParameter.string;
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
    
    public DefaultTableModel getMovimentacao(String filtros) throws SQLException {
        String sql;
        String[] headers = {"Tipo movimentação", "Valor", "Descrição", "Data" };
        String[][] dados;

        sql = "SELECT "
                + "c.tipo_movimentacao, "
                + "c.valor, "
                + "c.descricao, "
                + "c.data "
                + "from "
                + "controleestoque.caixa c";

        if (!filtros.equals("")) {
            sql = sql + filtros;
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

    public String consultaSaldoCaixaIntervalo(String dataInicio, String dataFim) throws SQLException {
        String sql;
        sql = "SELECT sum(valor) as saldo FROM controleestoque.caixa WHERE data >= '"+dataInicio+"' and data <= '"+dataFim+"';";
        return gerenciadorDeDados.getSaldo(sql);
    }
    
    public String consultaSaldoCaixaIntervaloES(String dataInicio, String dataFim, String tipo) throws SQLException {
        String sql;
        switch (tipo) {
            case "ENTRADA":
                sql = "SELECT sum(valor) as saldo FROM controleestoque.caixa WHERE data >= '"+dataInicio+"' and data <= '"+dataFim+"' and tipo_movimentacao = '"+tipo+"';"; 
                break;
            case "SAIDA":
                sql = "SELECT sum(valor) as saldo FROM controleestoque.caixa WHERE data >= '"+dataInicio+"' and data <= '"+dataFim+"' and tipo_movimentacao = '"+tipo+"';"; 
                break;
            default:
                sql = "SELECT sum(valor) as saldo FROM controleestoque.caixa WHERE data >= '"+dataInicio+"' and data <= '"+dataFim+"';"; 
                break;
        }
        return gerenciadorDeDados.getSaldo(sql);
    }    
    
    public String consultaSaldoCaixaDia(String data) throws SQLException{
        String sql;
        sql = "SELECT sum(valor) as saldo FROM controleestoque.caixa WHERE data like '%"+ data +"%';";       
        return gerenciadorDeDados.getSaldo(sql);
    }
    
    public String consultaSaldoCaixaDiaES(String data, String tipo) throws SQLException{
        String sql;
        sql = "SELECT sum(valor) as saldo FROM controleestoque.caixa WHERE data like '%"+ data +"%' and tipo_movimentacao = '"+tipo+"';";       
        return gerenciadorDeDados.getSaldo(sql);
    }    
    
    public String consultaSaldoCaixa () throws SQLException{
        String sql;
        String hoje = (new java.text.SimpleDateFormat("yyy-MM-dd").format(new java.util.Date(System.currentTimeMillis())));
        sql = "SELECT sum(valor) as saldo FROM controleestoque.caixa WHERE data like '%"+ hoje +"%';";
        return gerenciadorDeDados.getSaldo(sql);
    }
    
    public String consultaSaldoCaixaDiario (String tipo) throws SQLException{
        String sql;
        String data = (new java.text.SimpleDateFormat("yyy-MM-dd").format(new java.util.Date(System.currentTimeMillis())));
        sql = "SELECT sum(valor) as saldo FROM controleestoque.caixa WHERE data like '%"+ data +"%' and tipo_movimentacao = '"+tipo+"';";
        return gerenciadorDeDados.getSaldo(sql);
    }    
    
    public String consultaSaldoCaixaTotal () throws SQLException {
        String sql;
        sql = "SELECT sum(valor) as saldo FROM controleestoque.caixa;";
        return gerenciadorDeDados.getSaldo(sql);
    }
    
    public String consultaSaldoCaixaMes (String mes) throws SQLException {
        String sql;
        if(Integer.parseInt(mes) < 10){
            mes = "0"+mes;
        }
        sql = "SELECT sum(valor) as saldo FROM controleestoque.caixa WHERE data like '%-"+ mes +"-%';";
        return gerenciadorDeDados.getSaldo(sql);
    }
    
    public String consultaSaldoCaixaMesES (String mes, String tipo) throws SQLException{
        String sql;
        if(Integer.parseInt(mes) < 10){
            mes = "0"+mes;
        }
        switch (tipo) {
            case "ENTRADA":
                sql = "SELECT sum(valor) as saldo FROM controleestoque.caixa WHERE data like '%-"+ mes +"-%' and tipo_movimentacao = '"+tipo+"';";
                break;
            case "SAIDA":
                sql = "SELECT sum(valor) as saldo FROM controleestoque.caixa WHERE data like '%-"+ mes +"-%' and tipo_movimentacao = '"+tipo+"';";
                break;
            default:
                sql = "SELECT sum(valor) as saldo FROM controleestoque.caixa WHERE data like '%-"+ mes +"-%';";
                break;
        }
        
        return gerenciadorDeDados.getSaldo(sql);        
    }
    
    public String consultaTotalEntradas () throws SQLException {
        String sql;
        sql = "SELECT sum(valor) as saldo FROM controleestoque.caixa WHERE tipo_movimentacao = 'ENTRADA';";
        return gerenciadorDeDados.getSaldo(sql);
    }
    
    public String consultaTotalSaidas () throws SQLException {
        String sql;
        sql = "SELECT sum(valor) as saldo FROM controleestoque.caixa WHERE tipo_movimentacao = 'SAIDA';";
        return gerenciadorDeDados.getSaldo(sql);
    }    
    
    public void realizaMovimentacaoCaixa(String descricao, String valor, tipoOperacao operacao) throws SQLException{
        String sql;
        String operador;
        if (operacao == tipoOperacao.SAIDA) {
            operador = "-";
        } else {
            operador = "";
        }        
        sql = "INSERT controleestoque.caixa set "                
                + "descricao = '" + descricao + "', "
                + "valor = '"+ operador + valor + "', "
                + "tipo_movimentacao = '" + operacao + "';";
        gerenciadorDeDados.executar(sql);
    };
    
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

    public Produto pesquisarProduto(String campo, String valor){
        try {
            String sql = "SELECT * FROM controleestoque.produtos WHERE " + campo + " = " + valor;
            return gerenciadorDeDados.getProduto(sql);
        } catch (SQLException ex) {
            return null;
        }
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
