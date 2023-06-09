/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package apptracking.dialog;

import apptracking.funct.ComboboxValue;
import apptracking.funct.dataCallback;
import apptracking.funct.functionCollection;
import apptracking.funct.koneksi;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Randy_Machfud
 */
public class dlgFaktur extends javax.swing.JFrame implements dataCallback{
    private Connection conn= new koneksi().connect();
    private functionCollection funct=new functionCollection();
    private String resultData="";

    /**
     * Creates new form dlgFaktur
     */
    public dlgFaktur() {
        initComponents();
        doLoadCmbType();
        doLoadTypeTrx();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPelanggan = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTujuan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPic = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTanggal = new org.jdesktop.swingx.JXDatePicker();
        jLabel5 = new javax.swing.JLabel();
        txtInvoice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtBarang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cmbJenis = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        cmbTrx = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtPPN = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtNoSPK = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnUlang = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel1.setText("Pelanggan");

        txtPelanggan.setBackground(new java.awt.Color(204, 204, 204));
        txtPelanggan.setEnabled(false);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel2.setText("Tujuan");

        txtTujuan.setBackground(new java.awt.Color(204, 204, 204));
        txtTujuan.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel3.setText("PIC");

        txtPic.setBackground(new java.awt.Color(204, 204, 204));
        txtPic.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel4.setText("Tanggal");

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel5.setText("Invoice");

        txtInvoice.setBackground(new java.awt.Color(204, 204, 204));
        txtInvoice.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel6.setText("Nama Barang");

        txtBarang.setBackground(new java.awt.Color(204, 204, 204));
        txtBarang.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel7.setText("Tipe Kendaraan");

        cmbType.setEnabled(false);
        cmbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTypeActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel8.setText("Jenis Kendaraan");

        cmbJenis.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel9.setText("Tipe Transaksi");

        cmbTrx.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel10.setText("Harga");

        txtHarga.setEnabled(false);
        txtHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel11.setText("Rp.");

        jLabel12.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel12.setText("PPN 11%");

        txtPPN.setEnabled(false);
        txtPPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPPNActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel13.setText("Rp.");

        jLabel14.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel14.setText("Total");

        jLabel15.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel15.setText("Rp.");

        txtTotal.setEnabled(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        txtNoSPK.setBackground(new java.awt.Color(204, 204, 204));
        txtNoSPK.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel16.setText("No. SPK");

        btnSimpan.setBackground(new java.awt.Color(56, 86, 35));
        btnSimpan.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUlang.setBackground(new java.awt.Color(56, 86, 35));
        btnUlang.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        btnUlang.setForeground(new java.awt.Color(255, 255, 255));
        btnUlang.setText("Ulang");
        btnUlang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUlangActionPerformed(evt);
            }
        });

        btnKeluar.setBackground(new java.awt.Color(56, 86, 35));
        btnKeluar.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        btnKeluar.setForeground(new java.awt.Color(255, 255, 255));
        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbTrx, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(txtPelanggan)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtPic)
                                            .addComponent(txtTujuan)
                                            .addComponent(txtInvoice))
                                        .addGap(47, 47, 47))
                                    .addComponent(txtNoSPK)
                                    .addComponent(txtBarang))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUlang, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel16)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(61, 61, 61)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPPN, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(74, 74, 74)
                                        .addComponent(jLabel11))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(79, 79, 79)
                                        .addComponent(jLabel15)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(txtTotal))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(txtHarga)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNoSPK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTrx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtPPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUlang)
                    .addComponent(btnKeluar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        dlgViewTrx dlg = new dlgViewTrx(this);
        dlg.setExtendedState(JFrame.PROPERTIES);
        dlg.setVisible(true);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaActionPerformed

    private void txtPPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPPNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPPNActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String msg="";
        if (validation()) {
            int result = JOptionPane.showConfirmDialog(getParent(), "Yakin data akan di " + msg + " ?", "Konfimasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                
                try {
                    String sqlInsert = " insert into mst_faktur "
                            + "          select trxid, invoice, trxdate, '" + funct.setDateToString(txtTanggal.getDate()) + "' as fakturdate, spk, nmplg, tujuan, nmbrg, volume, amount, ppn, totamount, trxuser \n" +
                              "          from mst_trx where trxid ='"+resultData+"'";
                    Statement stat = conn.createStatement();
                    stat.execute(sqlInsert);
                    doReset();
                    JOptionPane.showMessageDialog(null, "Data berhasil di simpan.");
                } catch (Exception e) {
                    System.out.println("Gagal Simpan Data Error " + e);
                    JOptionPane.showMessageDialog(null, "Data gagal di simpan." + e);
                }
            } else {

            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUlangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUlangActionPerformed
       doReset();
    }//GEN-LAST:event_btnUlangActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void cmbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTypeActionPerformed
        if (cmbType.getSelectedItem() != null) {
            ComboboxValue data=(ComboboxValue)cmbType.getSelectedItem();
            cmbJenis.removeAllItems();
            try {
                ResultSet hasil = queryParam("2", data.getValue());
                while (hasil.next()) {
                    ComboboxValue cv = new ComboboxValue();
                    cv.setValue(hasil.getString("parmid"));
                    cv.setLabel(hasil.getString("parmnm"));
                    cmbJenis.addItem(cv);
                }
            } catch (Exception e) {
                System.out.println("Menampilkan Data Error " + e);
            }
        }
    }//GEN-LAST:event_cmbTypeActionPerformed

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
            java.util.logging.Logger.getLogger(dlgFaktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgFaktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgFaktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgFaktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dlgFaktur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUlang;
    private javax.swing.JComboBox cmbJenis;
    private javax.swing.JComboBox cmbTrx;
    private javax.swing.JComboBox cmbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtBarang;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtInvoice;
    private javax.swing.JTextField txtNoSPK;
    private javax.swing.JTextField txtPPN;
    private javax.swing.JTextField txtPelanggan;
    private javax.swing.JTextField txtPic;
    private org.jdesktop.swingx.JXDatePicker txtTanggal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTujuan;
    // End of variables declaration//GEN-END:variables

    private void doLoadCmbType() {
        cmbType.removeAllItems();
        try {
            ResultSet hasil=queryParam("1","");
            while (hasil.next()) {
                ComboboxValue cv=new ComboboxValue();
                cv.setValue(hasil.getString("parmid"));
                cv.setLabel(hasil.getString("parmnm"));
                cmbType.addItem(cv);
            }
        } catch (Exception e) {
             System.out.println("Menampilkan Data Error " + e);
        }
    }
    
    private ResultSet queryParam(String param1,String param2){
        ResultSet hasil = null;
        
        if(param1.equals("")){
            param1="";
        }else{
            param1=" and parmgrp="+param1;
        }
        
        if(param2.equals("")){
            param2="";
        }else{
            param2=" and parmidoth='"+param2+"' ";
        }
        String sql = "select parmid,parmnm from mst_parameter where 1=1 "+param1+param2;
        try {
            Statement stat = conn.createStatement();
            hasil = stat.executeQuery(sql);

        } catch (Exception e) {
            System.out.println("Menampilkan Data Error " + e);
        }
        return hasil;
    }

    private void doLoadTypeTrx() {
        cmbTrx.removeAllItems();
        try {
            ResultSet hasil=queryParam("3","");
            while (hasil.next()) {
                ComboboxValue cv=new ComboboxValue();
                cv.setValue(hasil.getString("parmid"));
                cv.setLabel(hasil.getString("parmnm"));
                cmbTrx.addItem(cv);
            }
        } catch (Exception e) {
             System.out.println("Menampilkan Data Error " + e);
        }
    }

    @Override
    public void onDataReceived(String data) {
        String sql = "select * from mst_trx where trxid='" + data + "'";
        try {
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            System.out.println("||" + sql);
            while (hasil.next()) {
                Date tglTrx = hasil.getDate("trxdate");
                String namaPel = hasil.getString("nmplg");
                String alamat = hasil.getString("tujuan");
                String invoice = hasil.getString("invoice");
                String spk = hasil.getString("spk");
                String nmBarang = hasil.getString("nmbrg");
                String pic = hasil.getString("trxuser");
                String trx = hasil.getString("trxid");
                resultData = trx;
                txtPelanggan.setText(namaPel);
                txtTujuan.setText(alamat);
                txtPic.setText(pic);
                txtTanggal.setDate(tglTrx);
                txtInvoice.setText(invoice);
                txtNoSPK.setText(spk);
                txtBarang.setText(nmBarang);
                //cmbJenis.setSelectedItem("01");
                txtHarga.setText(hasil.getBigDecimal("amount").toString());
                txtPPN.setText(String.valueOf(hasil.getBigDecimal("amount").multiply(new BigDecimal(11).divide(new BigDecimal(100)))));
                txtTotal.setText(String.valueOf(hasil.getBigDecimal("amount").add(hasil.getBigDecimal("amount").multiply(new BigDecimal(11).divide(new BigDecimal(100))))));
                
            }
        } catch (Exception e) {
            System.out.println("Menampilkan Data Error " + e);
        }
    }

    public String getResult() {
        return resultData;
    }

    public void setResult(String result) {
        this.resultData = result;
    }

    private boolean validation() {
        boolean isValid = true;
        if (isValid) {
            
            if (txtTujuan.getText() == null) {
                isValid = false;
                JOptionPane.showMessageDialog(null, "Tujuan tidak boleh kosong");
                txtTujuan.requestFocus();
            } else {
                if (txtTujuan.getText().equalsIgnoreCase("")) {
                    isValid = false;
                    JOptionPane.showMessageDialog(null, "Tujuan tidak boleh kosong");
                    txtTujuan.requestFocus();
                }
            }
        }
        return isValid;
    }

    private void doReset() {
        txtPelanggan.setText("");
        txtTujuan.setText("");
        txtPic.setText("");
        txtTanggal.setDate(null);
        txtInvoice.setText("");
        txtNoSPK.setText("");
        txtBarang.setText("");
        txtHarga.setText("");
        txtPPN.setText("");
        txtTotal.setText("");
    }
}
