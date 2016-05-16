package view;

import control.GeradorSQL;
import control.Produto;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class CadastroProduto extends javax.swing.JFrame {

    public enum tipoOperacao {

        CRIACAO, EDICAO
    }

    tipoOperacao operacao;
    Produto produto;

    public CadastroProduto() {
        initComponents();
        this.operacao = tipoOperacao.CRIACAO;
    }

    public CadastroProduto(Produto produto) {
        initComponents();
        this.produto = produto;
        this.operacao = tipoOperacao.EDICAO;
        inicializarTela();
    }

    private void inicializarTela() {
        jTextFieldCodigo.setText(Integer.toString(produto.getId()));
        jTextFielDescricao.setText(produto.getDescricao());
        jTextFieldCodigoBarras.setText(produto.getCodigoBarras());
        jTextFieldPrecoCompra.setText(Float.toString(produto.getPrecoCompra()));
        jTextFieldPrecoVenda.setText(Float.toString(produto.getPrecoVenda()));
        jTextFieldCodigo.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonGravar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFielDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPrecoCompra = new javax.swing.JFormattedTextField();
        jTextFieldPrecoVenda = new javax.swing.JFormattedTextField();
        jTextFieldCodigoBarras = new javax.swing.JFormattedTextField();

        setResizable(false);

        jButtonGravar.setText("Gravar");
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonGravar);

        jButtonCancelar.setText("Cancelar");
        jPanel1.add(jButtonCancelar);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setMinimumSize(new java.awt.Dimension(316, 188));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel5.setText("Código");

        jTextFieldCodigo.setEditable(false);
        jTextFieldCodigo.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(324, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jLabel1.setText("Descrição");

        jLabel2.setText("Código de Barras");

        jLabel4.setText("Preço de Venda");

        jLabel3.setText("Preço de Compra");

        jTextFieldPrecoCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        jTextFieldPrecoVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        jTextFieldCodigoBarras.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jTextFieldCodigoBarras.setPreferredSize(new java.awt.Dimension(6, 20));
        jTextFieldCodigoBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCodigoBarrasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCodigoBarrasKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextFielDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(jTextFielDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(jTextFieldCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(jTextFieldPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(jTextFieldPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        GeradorSQL gerador = new GeradorSQL();
        String precoCompra;
        String precoVenda;
        if (validarCampos()) {
            try {
                Produto produto;

                precoCompra = jTextFieldPrecoCompra.getValue().toString().replace(",", ".");
                precoVenda = jTextFieldPrecoVenda.getValue().toString().replaceAll(",", ".");
                if (precoCompra.equals("")) {
                    precoCompra = "0.00";
                }
                if (precoVenda.equals("")) {
                    precoVenda = "0.00";
                }

                if (operacao == tipoOperacao.CRIACAO) {
                    produto = new Produto(jTextFielDescricao.getText(),
                            jTextFieldCodigoBarras.getValue().toString(),
                            Float.parseFloat(precoCompra),
                            Float.parseFloat(precoVenda));
                    gerador.cadastrarProduto(produto);
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    limparCampos();
                } else {
                    produto = new Produto(Integer.parseInt(jTextFieldCodigo.getText()),
                            jTextFielDescricao.getText(),
                            jTextFieldCodigoBarras.getValue().toString(),
                            Float.parseFloat(precoCompra),
                            Float.parseFloat(precoVenda));
                    gerador.alterarProduto(produto);
                    JOptionPane.showMessageDialog(null, "Produto alterado com sucesso", "Alteração", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jTextFieldCodigoBarrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigoBarrasKeyTyped
        String valor = jTextFieldCodigoBarras.getText();
        if (valor.length() >= 20) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }//GEN-LAST:event_jTextFieldCodigoBarrasKeyTyped

    private void jTextFieldCodigoBarrasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigoBarrasKeyReleased

    }//GEN-LAST:event_jTextFieldCodigoBarrasKeyReleased

    private boolean validarCampos() {
        if (jTextFielDescricao.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "A descrição do produto deve ser preenchida", "Informações Incompletas", JOptionPane.ERROR_MESSAGE);
            jTextFielDescricao.isFocusable();
            return false;
        }
        if (jTextFieldCodigoBarras.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O código de barras deve ser pr", "Informações Incompletas", JOptionPane.ERROR_MESSAGE);
            jTextFielDescricao.isFocusable();
            return false;
        }
        return true;
    }

    private void limparCampos() {
        jTextFieldCodigo.setText("");
        jTextFielDescricao.setText("");
        jTextFieldCodigoBarras.setValue(null);
        jTextFieldPrecoCompra.setValue(null);
        jTextFieldPrecoVenda.setValue(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextFielDescricao;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JFormattedTextField jTextFieldCodigoBarras;
    private javax.swing.JFormattedTextField jTextFieldPrecoCompra;
    private javax.swing.JFormattedTextField jTextFieldPrecoVenda;
    // End of variables declaration//GEN-END:variables
}
