/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package apptracking.entry;

import apptracking.funct.ComboboxValue;
import apptracking.funct.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Randy_Machfud
 */
public class masterUser extends javax.swing.JPanel {
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    private String useridold ="";
    SimpleDateFormat frmt1 = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form masterUser1
     */
    public masterUser() {
        initComponents();
        Object[] Baris = {"User ID","Username","Password","Role ID","No. HP","Email","Expired"};
        tabmode = new DefaultTableModel(null, Baris);
        doLoadCmbRole();
        doLoadDataTable();
    }
    
    protected void aktif() {
        txtUserID.setEnabled(true);
        txtUsername.setEnabled(true);
        jPassword.setEnabled(true);
        cmbRoleId.setEnabled(true);
        txtNoHP.setEnabled(true);
        txtEmail.setEnabled(true);
        txtUserID.requestFocus();    
    }
    
    protected void kosong() {
        txtUserID.setText("");
        txtUsername.setText("");
        jPassword.setText("");
        cmbRoleId.setSelectedIndex(0);
        txtNoHP.setText("");
        txtEmail.setText("");
        jExpired.setDate(null);
        btnSimpan.setLabel("Simpan");
        useridold ="";
    }
    
    private void doLoadCmbRole() {
        cmbRoleId.removeAllItems();
        try {
            ResultSet hasil = queryRole("");
            while (hasil.next()) {
                ComboboxValue cmbValue = new ComboboxValue();
                cmbValue.setValue(hasil.getString("roleid"));
                cmbValue.setLabel(hasil.getString("rolenm"));
                cmbRoleId.addItem(cmbValue);
                
            }
        } catch (SQLException e) {
            
        }
    }
    
    private ResultSet queryRole(String param){
        if (param.equals("")){
            param = "";  
        }else {
            param = " where roleid='"+param+"'";
        }
        ResultSet hasil = null;
        String sql = "select roleid,rolenm from mst_role"+param;
        try {
            Statement stat= conn.createStatement();
            hasil=stat.executeQuery(sql);
            
        } catch (Exception e) {
            System.out.println("Menampilkan Data Error "+e);
        } 
            return hasil;
    }
    
    private void doLoadDataTable() {
        tblUser.revalidate();
        tblUser.repaint();
        tblUser.setModel(tabmode);
        if(tabmode.getRowCount()>0){
            tabmode.setRowCount(0);  
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "select * from mst_user";
        try {
            Statement stat= conn.createStatement();
            ResultSet hasil=stat.executeQuery(sql);
           int count=0;
            while (hasil.next()) {
                String d ="";
                ResultSet hasil2 = queryRole(hasil.getString("roleid"));
                while (hasil2.next()){
                    d = hasil2.getString("rolenm");
                }
                String a = hasil.getString("userid");
                String b = hasil.getString("usernm");
                String c = hasil.getString("password");
                String e = hasil.getString("nohp");
                String f = hasil.getString("email");
                String g = sdf.format(hasil.getDate("expired"));
                String h = hasil.getString("roleid");
                String [] data={a,b,c,d,e,f,g};
                tabmode.addRow(data);
            }
        } catch (Exception e) {
            System.out.println("Menampilkan Data Error "+e);
        }  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNoHP = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtUserID = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        btnUlang = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnHapus = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        cmbRoleId = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jExpired = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel7.setText("Expired Date");

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel1.setText("Username");

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUser);

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel2.setText("User ID");

        btnSimpan.setBackground(new java.awt.Color(56, 86, 35));
        btnSimpan.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUlang.setBackground(new java.awt.Color(56, 86, 35));
        btnUlang.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        btnUlang.setForeground(new java.awt.Color(255, 255, 255));
        btnUlang.setText("Ulang");
        btnUlang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUlangActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel3.setText("Role ID");

        btnHapus.setBackground(new java.awt.Color(56, 86, 35));
        btnHapus.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel5.setText("E-mail");

        cmbRoleId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbRoleIdItemStateChanged(evt);
            }
        });
        cmbRoleId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbRoleIdFocusGained(evt);
            }
        });
        cmbRoleId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbRoleIdMouseClicked(evt);
            }
        });
        cmbRoleId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRoleIdActionPerformed(evt);
            }
        });
        cmbRoleId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cmbRoleIdKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
        jLabel6.setText("No. HP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbRoleId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(94, 94, 94))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnUlang, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jExpired, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRoleId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jExpired, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus)
                    .addComponent(btnUlang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        // TODO add your handling code here:

        btnSimpan.setLabel("Ubah");
        int bar = tblUser.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        useridold = a;
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        try {
            Date tgl = new SimpleDateFormat("yyyy-MM-dd").parse(g);
            System.out.println("g:"+tgl);
            jExpired.setDate(tgl);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        txtUserID.setText(a);
        txtUsername.setText(b);
        jPassword.setText(c);
        doLoadCmbRole();
        for (int i = 0; i < cmbRoleId.getItemCount(); i++) {
            ComboboxValue item=(ComboboxValue) cmbRoleId.getItemAt(i);
            if (item.getLabel().equals(d)) {
                cmbRoleId.setSelectedIndex(i);
                break;
            }
        }
        txtNoHP.setText(e);
        txtEmail.setText(f);
    }//GEN-LAST:event_tblUserMouseClicked

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        String msg = "";
        if (validation()) {
            Date dateValue = new Date();

            java.sql.Date dt;
            dateValue = jExpired.getDate();
            String dateString1 = frmt1.format(dateValue);
            dt = java.sql.Date.valueOf(dateString1);
            if (useridold.equalsIgnoreCase("")) {
                msg = "Simpan";
            } else {
                msg = "Ubah";
            }
            int result = JOptionPane.showConfirmDialog(getParent(), "Yakin data akan di " + msg + " ?", "Konfimasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                if (useridold == null || useridold.equalsIgnoreCase("")) {
                    String sql = "insert into mst_user values (?,?,?,?,?,?,?,null,null,null,null)";
                    try {
                        PreparedStatement stat = conn.prepareStatement(sql);
                        stat.setString(1, txtUserID.getText());
                        stat.setString(2, txtUsername.getText());
                        stat.setString(3, jPassword.getText());
                        ComboboxValue dataValue=(ComboboxValue)cmbRoleId.getSelectedItem();
                        stat.setString(4, dataValue.getValue());
                        stat.setString(5, txtNoHP.getText());
                        stat.setString(6, txtEmail.getText());
                        stat.setDate(7, dt);

                        stat.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                        kosong();
                        txtUserID.requestFocus();
                        doLoadDataTable();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Data Gagal Disimpan" + e);
                    }
                } else {
                    String message;
                    String userid = txtUserID.getText();
                    String usernm = txtUsername.getText();
                    String password = jPassword.getText();
                    ComboboxValue dataValue=(ComboboxValue)cmbRoleId.getSelectedItem();
                    String roleid = dataValue.getValue();
                    String nohp = txtNoHP.getText();
                    String email = txtEmail.getText();
                    Date expired = jExpired.getDate();

                    try {
                        message = "Data Berhasil Diubah";
                        PreparedStatement p = conn.prepareStatement("UPDATE mst_user SET userid=?, usernm=?, password=?, roleid=?, nohp=?, email=?, expired=? WHERE userid=?");
                        p.setString(1, userid);
                        p.setString(2, usernm);
                        p.setString(3, password);
                        p.setString(4, roleid);
                        p.setString(5, nohp);
                        p.setString(6, email);
                        p.setString(7, frmt1.format(expired));
                        p.setString(8, useridold);
                        p.executeUpdate();
                        JOptionPane.showMessageDialog(null, message);
                        kosong();
                        txtUserID.requestFocus();
                        doLoadDataTable();
                    } catch (Exception e) {
                        message = "Data Gagal Diubah " + e.getMessage();
                        JOptionPane.showMessageDialog(null, message);
                    }
                }
            }

        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUlangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUlangActionPerformed
        // TODO add your handling code here:
        kosong();
        doLoadDataTable();
    }//GEN-LAST:event_btnUlangActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data ini?","Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok==0) {
            String sql ="delete from mst_user where userid ='"+txtUserID.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                kosong();
                txtUserID.requestFocus();
                doLoadDataTable();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus"+e);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void cmbRoleIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRoleIdActionPerformed
       
    }//GEN-LAST:event_cmbRoleIdActionPerformed

    private void cmbRoleIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbRoleIdKeyReleased
       
    }//GEN-LAST:event_cmbRoleIdKeyReleased

    private void cmbRoleIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbRoleIdMouseClicked
        
    }//GEN-LAST:event_cmbRoleIdMouseClicked

    private void cmbRoleIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbRoleIdItemStateChanged
        
    }//GEN-LAST:event_cmbRoleIdItemStateChanged

    private void cmbRoleIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbRoleIdFocusGained
       doLoadCmbRole();
    }//GEN-LAST:event_cmbRoleIdFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUlang;
    private javax.swing.JComboBox cmbRoleId;
    private com.toedter.calendar.JDateChooser jExpired;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNoHP;
    private javax.swing.JTextField txtUserID;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
    private boolean validation() {
        boolean isValid=true;
        if (isValid) {
            if(txtUserID.getText()== useridold){
                isValid=false;
                JOptionPane.showMessageDialog(null,"User ID sudah digunakan");
                txtUserID.requestFocus();
            }
        }
        return isValid;   
    }
}
