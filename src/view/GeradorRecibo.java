package view;

import control.GeradorSQL;
import control.ItemRecibo;
import control.Produto;
import control.Recibo;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import utils.ConnectionFactory;
import utils.ReportUtils;

public class GeradorRecibo extends javax.swing.JFrame {

    private ArrayList<ItemRecibo> produtos = new ArrayList<>();

    public GeradorRecibo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldEndereco = new javax.swing.JTextField();
        jTextFieldFone = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonGerarRecibo = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButtonIncluir = new javax.swing.JButton();
        jButtonRemoverItem = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldTaxaEntrega = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();

        setTitle("Gerar Recibo");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        jLabel1.setText("Nome");

        jLabel2.setText("Endereço");

        try {
            jTextFieldFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextFieldFone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFoneActionPerformed(evt);
            }
        });

        jLabel3.setText("Fone");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 529, Short.MAX_VALUE))
                    .addComponent(jTextFieldEndereco)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldFone, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jButtonGerarRecibo.setText("Gerar");
        jButtonGerarRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarReciboActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonGerarRecibo);

        jButton2.setText("Sair");
        jButton2.setPreferredSize(new java.awt.Dimension(59, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos"));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setPreferredSize(new java.awt.Dimension(110, 248));

        jButtonIncluir.setText("Incluir");
        jButtonIncluir.setMinimumSize(new java.awt.Dimension(75, 23));
        jButtonIncluir.setPreferredSize(new java.awt.Dimension(75, 23));
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        jButtonRemoverItem.setText("Remover");
        jButtonRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverItemActionPerformed(evt);
            }
        });

        jLabel4.setText("Taxa de Entrega");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonRemoverItem, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 4, Short.MAX_VALUE)
                        .addComponent(jTextFieldTaxaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(181, Short.MAX_VALUE)
                .addComponent(jButtonIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButtonRemoverItem)
                .addGap(143, 143, 143)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTaxaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.add(jPanel6, java.awt.BorderLayout.LINE_START);

        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Quantidade", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProdutos);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldFoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFoneActionPerformed

    }//GEN-LAST:event_jTextFieldFoneActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    @SuppressWarnings("empty-statement")
    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed

        final SeletorProduto seletorProduto = new SeletorProduto();
        seletorProduto.setVisible(true);
        seletorProduto.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Produto produto = seletorProduto.getProduto();

                if (produto != null) {
                    String[] novoItem = {Integer.toString(produto.getId()), produto.getDescricao()};
                    DefaultTableModel model = (DefaultTableModel) jTableProdutos.getModel();
                    model.addRow(novoItem);
                    model.setValueAt(1, model.getRowCount()-1, 2);
                    model.setValueAt(produto.getPrecoVenda(), model.getRowCount()-1, 3);
                    jTableProdutos.setModel(model);
                }
            }
        });
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverItemActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableProdutos.getModel();
        produtos.remove(jTableProdutos.getSelectedRow());
        model.removeRow(jTableProdutos.getSelectedRow());
        jTableProdutos.setModel(model);
    }//GEN-LAST:event_jButtonRemoverItemActionPerformed

    private void jTableProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdutosMouseClicked

        if (evt.getClickCount() == 2) {
        }
    }//GEN-LAST:event_jTableProdutosMouseClicked

    private void jButtonGerarReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarReciboActionPerformed
        preencherProdutos();
        if (validarCampos()) {
            String taxaEntrega = jTextFieldTaxaEntrega.getText();
            if (taxaEntrega.equals("")){
                taxaEntrega = "0.00";
            }
            GeradorSQL geradorSQL = new GeradorSQL();
            int id;            
            Recibo recibo = new Recibo(jTextFieldCliente.getText(),
                    jTextFieldEndereco.getText(),
                    jTextFieldFone.getText(),
                    Float.parseFloat(taxaEntrega), produtos);
            id = geradorSQL.gravarRecibo(recibo);
            gerarRecibo(id);
            limparCampos();
        }
    }//GEN-LAST:event_jButtonGerarReciboActionPerformed

    private boolean validarCampos() {
        if (jTextFieldCliente.getText().equals("")){
            JOptionPane.showMessageDialog(this, "É necessário preencher o nome do cliente", "Cliente não informado", JOptionPane.ERROR_MESSAGE);
            jTextFieldCliente.requestFocus();
            return false;
        }
        if (produtos.isEmpty()){
            JOptionPane.showMessageDialog(this, "É necessário selecionar pelo menos um produto", "Nenhum produto selecionado", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void preencherProdutos() {
        DefaultTableModel model = (DefaultTableModel) jTableProdutos.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            ItemRecibo itemRecibo = new ItemRecibo(Integer.parseInt(model.getValueAt(i, 0).toString()), model.getValueAt(i, 1).toString(), Float.parseFloat(model.getValueAt(i, 2).toString()), Float.parseFloat(model.getValueAt(i, 3).toString()));
            produtos.add(itemRecibo);
        }
    }

    private void limparCampos() {
        produtos.clear();
        jTextFieldCliente.setText("");
        jTextFieldEndereco.setText("");
        jTextFieldFone.setText("");
        jTextFieldTaxaEntrega.setText("");
        DefaultTableModel model = (DefaultTableModel) jTableProdutos.getModel();
        for (int i = 1; i <= model.getRowCount(); i++) {
            model.removeRow(i);
        }
        jTableProdutos.setModel(model);

    }

    private void gerarRecibo(int id) {
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/Recibo.jasper");
        Map parametros = new HashMap();
        parametros.put("id", id);
        try {

            // abre o recibo
            ReportUtils.openReport("Recibo", inputStream, parametros,
                    ConnectionFactory.getConnectionControleEstoque());
        } catch (SQLException exc) {
            exc.printStackTrace();
        } catch (JRException exc) {
            exc.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeradorRecibo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonGerarRecibo;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonRemoverItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProdutos;
    private javax.swing.JTextField jTextFieldCliente;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JFormattedTextField jTextFieldFone;
    private javax.swing.JFormattedTextField jTextFieldTaxaEntrega;
    // End of variables declaration//GEN-END:variables
}
