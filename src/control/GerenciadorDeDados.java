package control;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerenciadorDeDados {

    public final String USUARIO;
    public final String SENHA;
    public final String URL;

    public GerenciadorDeDados(String url, String porta, String usuario, String senha) {
        this.USUARIO = usuario;
        this.SENHA = senha;
        this.URL = "jdbc:mysql://" + url + ":" + porta;
    }

    public List<String> getBancoDeDados() throws SQLException {

        List<String> baseDados = new ArrayList<>();

        Connection connect = DriverManager.getConnection(URL, USUARIO, SENHA);
        Statement st = connect.createStatement();

        DatabaseMetaData metaDadosConexao = connect.getMetaData();

        metaDadosConexao.getTables("mysql", null, null, null);
        ResultSet resultSet = metaDadosConexao.getCatalogs();
        while (resultSet.next()) {
            baseDados.add(resultSet.getString("TABLE_CAT"));
        }

        connect.close();

        return baseDados;
    }

    public List<String> getTabelas(String baseDeDados) throws Exception {
        List<String> tabelas = new ArrayList<>();

        Connection connect = DriverManager.getConnection(URL, USUARIO, SENHA);
        DatabaseMetaData dbMeta = connect.getMetaData();

        ResultSet ts = dbMeta.getTables(baseDeDados, null, null, null);
        while (ts.next()) {
            tabelas.add(ts.getString("TABLE_NAME"));
        }

        connect.close();

        return tabelas;
    }

    public String[] getInfoTabela(String banco, String tabelas) throws SQLException {
        Connection connect = DriverManager.getConnection(URL, USUARIO, SENHA);
        Statement st = connect.createStatement();
        ResultSet resultSet = st.executeQuery("select * from " + banco + "." + tabelas);
        ResultSetMetaData rsMetadata = resultSet.getMetaData();
        int coluna = rsMetadata.getColumnCount();
        String[] tabela = new String[coluna];
        for (int i = 1; i <= coluna; i++) {
            String nomeColuna = rsMetadata.getColumnName(i);
            String nomeDoTipo = rsMetadata.getColumnTypeName(i);
            tabela[i - 1] = (nomeColuna + " (" + nomeDoTipo + ") ");
        }

        connect.close();
        return tabela;
    }

    public String[][] getDadosTabela(String consulta) throws SQLException {
        Connection connect = DriverManager.getConnection(URL, USUARIO, SENHA);
        Statement st = connect.createStatement();
        ResultSet resultSet = st.executeQuery(consulta);
        resultSet.last();
        int linha = resultSet.getRow();
        resultSet.beforeFirst();

        int colunas = resultSet.getMetaData().getColumnCount();

        String[][] dadosTabela;

        if (linha > 0) {
            dadosTabela = new String[linha][colunas];
        } else {
            dadosTabela = new String[1][colunas];
        }

        int i = 0;

        while (resultSet.next()) {
            for (int colun = 1; colun <= colunas; colun++) {
                if (resultSet.getObject(colun) != null) {
                    String valor = resultSet.getObject(colun).toString();
                    dadosTabela[i][colun - 1] = valor;
                } else {
                    dadosTabela[i][colun - 1] = " ";
                }
            }
            i++;
        }

        if (i == 0) {
            for (int colun = 1; colun <= colunas; colun++) {
                dadosTabela[i][colun - 1] = " ";
            }
        }

        connect.close();

        return dadosTabela;
    }

    public void executarComando(String comando) {
        try {
            executar(comando);
        } catch (SQLException ex) {
            Logger.getLogger(GerenciadorDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //A exceção deverá ser tratada na classe que chamar a função abaixo
    public void executar(String comando) throws SQLException {
        Connection connect;
        connect = DriverManager.getConnection(URL, USUARIO, SENHA);
        Statement st = connect.createStatement();
        st.executeUpdate(comando);
    }

    public int getIDProduto(String codigoProduto) throws SQLException {
        Connection connect;
        connect = DriverManager.getConnection(URL, USUARIO, SENHA);
        Statement st = connect.createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * "
                + "FROM controleestoque.produtos "
                + "WHERE "
                + "codigo_barras = '" + codigoProduto
                + "'");
        resultSet.first();
        return Integer.parseInt(resultSet.getObject(1).toString());
    }

    public Produto getProduto(String comando) throws SQLException {
        Produto produto;
        Connection connect;
        connect = DriverManager.getConnection(URL, USUARIO, SENHA);
        Statement st = connect.createStatement();
        ResultSet resultSet = st.executeQuery(comando);
        resultSet.first();
        produto = new Produto(Integer.parseInt(resultSet.getObject(1).toString()),
                resultSet.getObject(2).toString(),
                resultSet.getObject(3).toString(),                
                Float.parseFloat(resultSet.getObject(4).toString()),
                Float.parseFloat(resultSet.getObject(5).toString()));
        return produto;
    }

}
