package controleestoque;

import control.GeradorSQL;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MovimentacaoCaixa extends javax.swing.JFrame {

    GeradorSQL.tipoOperacao operacao; 
    
    /**
     * Creates new form MovimentacaoCaixa
     * @param operacao
     */
    public MovimentacaoCaixa(GeradorSQL.tipoOperacao operacao) {
        initComponents();
        URL url = this.getClass().getResource("/imagens/Icone.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        String data = (new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date(System.currentTimeMillis())));
        jFormattedTextFieldDataMovimentacao.setText(data);
        jFormattedTextFieldDataMovimentacao.setEnabled(false);
        try{
            GeradorSQL geradorSQL = new GeradorSQL();
            geradorSQL.consultaSaldoCaixa();
            if(geradorSQL.consultaSaldoCaixa() != null){
                jTextFieldSaldoCaixa.setText(geradorSQL.consultaSaldoCaixa());
                if(Float.parseFloat(jTextFieldSaldoCaixa.getText()) > 0){
                    jTextFieldSaldoCaixa.setForeground(Color.BLUE);
                }else{
                    jTextFieldSaldoCaixa.setForeground(Color.RED);
                }            
            }else{
                jTextFieldSaldoCaixa.setText("0.00");
            }
            
            jTextFieldSaldoCaixa.setEditable(false);            
        } catch(SQLException ex){
            Logger.getLogger(MovimentacaoEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.operacao = operacao;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldDescricaoMovimentacao = new javax.swing.JTextField();
        jTextFieldValorMovimentacao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        gravarMovimentacaoCaixa = new javax.swing.JButton();
        jFormattedTextFieldDataMovimentacao = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldSaldoCaixa = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMovimentacaoCaixa = new javax.swing.JTable();

        jButton1.setText("jButton1");

        setResizable(false);

        jTextFieldDescricaoMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDescricaoMovimentacaoActionPerformed(evt);
            }
        });

        jTextFieldValorMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorMovimentacaoActionPerformed(evt);
            }
        });
        jTextFieldValorMovimentacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldValorMovimentacaoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldValorMovimentacaoKeyReleased(evt);
            }
        });

        jLabel1.setText("Descrição*");

        jLabel2.setText("Valor*");

        gravarMovimentacaoCaixa.setText("Gravar");
        gravarMovimentacaoCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gravarMovimentacaoCaixaActionPerformed(evt);
            }
        });

        jFormattedTextFieldDataMovimentacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jFormattedTextFieldDataMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldDataMovimentacaoActionPerformed(evt);
            }
        });

        jLabel3.setText("Data");

        jLabel4.setText("Saldo atual do dia");

        jTextFieldSaldoCaixa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldSaldoCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSaldoCaixaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldDescricaoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldValorMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextFieldDataMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldSaldoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(gravarMovimentacaoCaixa)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDescricaoMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldValorMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldDataMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSaldoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gravarMovimentacaoCaixa))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jTableMovimentacaoCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição ", "Valor", "Tipo Movimentação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableMovimentacaoCaixa);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jTextFieldValorMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorMovimentacaoActionPerformed

    }//GEN-LAST:event_jTextFieldValorMovimentacaoActionPerformed

    private void jTextFieldDescricaoMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoMovimentacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDescricaoMovimentacaoActionPerformed

    private void gravarMovimentacaoCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gravarMovimentacaoCaixaActionPerformed
        if(jTextFieldDescricaoMovimentacao.getText().isEmpty() || jTextFieldValorMovimentacao.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campos obrigatórios não foram preenchidos.", "Dados incorretos", JOptionPane.DEFAULT_OPTION);
        }else{
            if(jTextFieldValorMovimentacao.getText().indexOf(",") > 0){
                String valor = jTextFieldValorMovimentacao.getText().replaceAll(",", ".");
                jTextFieldValorMovimentacao.setText(valor);
            }
            try {
                GeradorSQL geradorSQL = new GeradorSQL();
                geradorSQL.realizaMovimentacaoCaixa(jTextFieldDescricaoMovimentacao.getText(),
                        jTextFieldValorMovimentacao.getText(), operacao);
                inserirHistoricoMovimentacaoCaixaTabela(jTextFieldDescricaoMovimentacao.getText(), jTextFieldValorMovimentacao.getText(), operacao);
                jTextFieldDescricaoMovimentacao.setText("");
                jTextFieldDescricaoMovimentacao.grabFocus();
                jTextFieldValorMovimentacao.setText("");
                jTextFieldSaldoCaixa.setText(geradorSQL.consultaSaldoCaixa());
                if(Float.parseFloat(jTextFieldSaldoCaixa.getText()) > 0){
                    jTextFieldSaldoCaixa.setForeground(Color.BLUE);
                }else{
                    jTextFieldSaldoCaixa.setForeground(Color.RED);
                }
                JOptionPane.showMessageDialog(null, "Registro salvo com sucesso.", null, JOptionPane.DEFAULT_OPTION);
            } catch (SQLException ex) {
                Logger.getLogger(MovimentacaoEstoque.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gravarMovimentacaoCaixaActionPerformed

    private void jFormattedTextFieldDataMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataMovimentacaoActionPerformed
        
    }//GEN-LAST:event_jFormattedTextFieldDataMovimentacaoActionPerformed

    private void jTextFieldSaldoCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSaldoCaixaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSaldoCaixaActionPerformed

    private void jTextFieldValorMovimentacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorMovimentacaoKeyPressed

    }//GEN-LAST:event_jTextFieldValorMovimentacaoKeyPressed

    private void jTextFieldValorMovimentacaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorMovimentacaoKeyReleased
        jTextFieldValorMovimentacao.setText(jTextFieldValorMovimentacao.getText().replaceAll("[^0-9,.]", ""));
    }//GEN-LAST:event_jTextFieldValorMovimentacaoKeyReleased

        @SuppressWarnings("empty-statement")
    public void inserirHistoricoMovimentacaoCaixaTabela(String descricao, String valor, GeradorSQL.tipoOperacao operacao){
        //try {
            GeradorSQL gerador = new GeradorSQL();
            //Produto produto = gerador.pesquisarProduto("codigo_barras", jTextFieldCodigoBarras.getText());
            DefaultTableModel model = (DefaultTableModel)jTableMovimentacaoCaixa.getModel();  
            //String data = (new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date(System.currentTimeMillis())));            
            String[] valores = {descricao, valor, operacao.toString()};
            model.addRow(valores);            
            jTableMovimentacaoCaixa.setModel(model);            
        //} catch (SQLException ex) {
            //Logger.getLogger(MovimentacaoEstoque.class.getName()).log(Level.SEVERE, null, ex);
        //}
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gravarMovimentacaoCaixa;
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataMovimentacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMovimentacaoCaixa;
    private javax.swing.JTextField jTextFieldDescricaoMovimentacao;
    private javax.swing.JTextField jTextFieldSaldoCaixa;
    private javax.swing.JTextField jTextFieldValorMovimentacao;
    // End of variables declaration//GEN-END:variables
}
