/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package apptracking.main;

import apptracking.funct.koneksi;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author reki.pebriana
 */
public class loginpage extends javax.swing.JFrame {

    /**
     * Creates new form loginpage
     * 
     */
    
    private Connection conn = new koneksi().connect();
    
    public loginpage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbluser = new javax.swing.JLabel();
        lblpass = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        txtuserid = new javax.swing.JTextField();
        blogin = new javax.swing.JButton();
        bclose = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbluser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbluser.setForeground(new java.awt.Color(153, 153, 153));
        lbluser.setText("User ID");
        lbluser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbluserMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbluserMousePressed(evt);
            }
        });
        getContentPane().add(lbluser, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 363, 490, 42));

        lblpass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblpass.setForeground(new java.awt.Color(153, 153, 153));
        lblpass.setText("Password");
        lblpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblpassMousePressed(evt);
            }
        });
        getContentPane().add(lblpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 429, 490, 42));

        txtpass.setBackground(new java.awt.Color(255, 255, 255));
        txtpass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtpass.setForeground(new java.awt.Color(51, 51, 51));
        txtpass.setBorder(null);
        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpassKeyTyped(evt);
            }
        });
        getContentPane().add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 429, 490, 42));

        txtuserid.setBackground(new java.awt.Color(255, 255, 255));
        txtuserid.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtuserid.setForeground(new java.awt.Color(51, 51, 51));
        txtuserid.setBorder(null);
        txtuserid.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtuserid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuseridActionPerformed(evt);
            }
        });
        txtuserid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtuseridKeyTyped(evt);
            }
        });
        getContentPane().add(txtuserid, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 363, 490, 42));

        blogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        blogin.setContentAreaFilled(false);
        blogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bloginMouseEntered(evt);
            }
        });
        blogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloginActionPerformed(evt);
            }
        });
        getContentPane().add(blogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 553, 520, 48));

        bclose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        bclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bcloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bcloseMouseEntered(evt);
            }
        });
        getContentPane().add(bclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1227, 0, -1, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loginpage.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloginActionPerformed
        // TODO add your handling code here:
        String level =""; 
        try {
            txtuserid.requestFocus();
            java.sql.Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery("select * from mst_user where "
                    + "userid='" + txtuserid.getText() + "'");
            if (result.next()) {
                if (txtpass.getText().equals(result.getString("password"))) {
                    //new menuUtama().show();
                    JOptionPane.showMessageDialog(rootPane, "Selamat Datang " + txtuserid.getText());
                    mainMenu mn = new mainMenu();
                    mn.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    mn.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Password Salah");
                    txtpass.setText("");
                    txtuserid.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "User Tidak Ditemukan");
                txtuserid.setText("");
                txtpass.setText("");
                txtuserid.requestFocus();
            }
        } catch (Exception e){
            System.out.println("Error : "+e);
            JOptionPane.showMessageDialog(rootPane, "Gagal");
        }
    }//GEN-LAST:event_bloginActionPerformed

    private void bcloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcloseMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_bcloseMouseClicked

    private void txtuseridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuseridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuseridActionPerformed

    private void txtuseridKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuseridKeyTyped
        // TODO add your handling code here:
        lbluser.setVisible(false);
        if (txtuserid.getText().isEmpty()) {
            lbluser.setVisible(true);
        }


    }//GEN-LAST:event_txtuseridKeyTyped

    private void txtpassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyTyped

        lblpass.setVisible(false);
        if (txtpass.getText().isEmpty()) {
            lblpass.setVisible(true);
        }

    }//GEN-LAST:event_txtpassKeyTyped

    private void lbluserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbluserMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_lbluserMouseClicked

    private void lbluserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbluserMousePressed
        // TODO add your handling code here:
        txtuserid.setVisible(true);
        lbluser.setVisible(false);

    }//GEN-LAST:event_lbluserMousePressed

    private void lblpassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblpassMousePressed
        // TODO add your handling code here:
        txtpass.setVisible(true);
        lblpass.setVisible(false);

    }//GEN-LAST:event_lblpassMousePressed

    private void bcloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcloseMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_bcloseMouseEntered

    private void bloginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bloginMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_bloginMouseEntered

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
            java.util.logging.Logger.getLogger(loginpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bclose;
    private javax.swing.JButton blogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblpass;
    private javax.swing.JLabel lbluser;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuserid;
    // End of variables declaration//GEN-END:variables
}
