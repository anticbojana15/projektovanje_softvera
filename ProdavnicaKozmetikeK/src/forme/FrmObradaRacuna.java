/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import KontrolerKIRadSaRacunom.KontrolerKIUnosRacuna;
import KontrolerKIRadSaRacunom.KontrolerKIDodajStavku;
import KontrolerKIRadSaRacunom.KontrolerKIInicijalizacijaTabele;
import KontrolerKIRadSaRacunom.KontrolerKIIzmenaRacuna;
import KontrolerKIRadSaRacunom.KontrolerKIStornirajRacun;
import KontrolerKIRadSaRacunom.KontrolerKIObrisiStavku;
import KontrolerKIRadSaRacunom.KontrolerKIPronadjiRacun;
import KontrolerKIRadSaRacunom.KontrolerKIPopuniComboRadnici;
import domen.Racun;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import sesija.Sesija;
import tableModel.TableStavke;


public class FrmObradaRacuna extends javax.swing.JFrame {
   

    /**
     * Creates new form PanelObracun
     */
    public FrmObradaRacuna() {
        initComponents();     
        buttonGroupDaNe.add(jbtnDa);
        buttonGroupDaNe.add(jbtnNe);
        jbtnNe.setSelected(true);
        KontrolerKIInicijalizacijaTabele.inicijalizujTabelu(jtbStavke);
        KontrolerKIPopuniComboRadnici.prikaziRadnike(jcbRadnik);
        jtxtIznos.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupDaNe = new javax.swing.ButtonGroup();
        jbtnKreiraj = new javax.swing.JButton();
        jbtnPretrazi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtRacunID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbStavke = new javax.swing.JTable();
        jbtnDodajStavku = new javax.swing.JButton();
        jbtnObrisiStavku = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtxtIznos = new javax.swing.JTextField();
        jbtnStorniraj = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jcbRadnik = new javax.swing.JComboBox();
        jbtnOsvezi = new javax.swing.JButton();
        jdcDatumR = new com.toedter.calendar.JDateChooser();
        jbtnNe = new javax.swing.JRadioButton();
        jbtnDa = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Obrada računa");

        jbtnKreiraj.setText("Kreiraj");
        jbtnKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnKreirajActionPerformed(evt);
            }
        });

        jbtnPretrazi.setText("Pretraži");
        jbtnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPretraziActionPerformed(evt);
            }
        });

        jLabel1.setText("Račun ID:");

        jLabel2.setText("Datum:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Stavke računa:");

        jtbStavke.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtbStavke);

        jbtnDodajStavku.setText("+");
        jbtnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDodajStavkuActionPerformed(evt);
            }
        });

        jbtnObrisiStavku.setText("-");
        jbtnObrisiStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnObrisiStavkuActionPerformed(evt);
            }
        });

        jLabel3.setText("Iznos:");

        jtxtIznos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtIznosActionPerformed(evt);
            }
        });

        jbtnStorniraj.setText("Storniraj");
        jbtnStorniraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnStornirajActionPerformed(evt);
            }
        });

        jLabel5.setText("Radnik:");

        jcbRadnik.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbtnOsvezi.setText("Osveži");
        jbtnOsvezi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOsveziActionPerformed(evt);
            }
        });

        jdcDatumR.setDateFormatString("yyyy-MM-dd");

        jbtnNe.setText("Ne");

        jbtnDa.setText("Da");

        jLabel6.setText("Storniran:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnDodajStavku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnObrisiStavku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jbtnDa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnNe)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbRadnik, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jdcDatumR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jtxtRacunID, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jbtnPretrazi))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jbtnKreiraj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbtnStorniraj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jbtnOsvezi, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtIznos, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtxtRacunID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnPretrazi)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbtnKreiraj)))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jdcDatumR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnStorniraj))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbRadnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jbtnOsvezi)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnNe)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jbtnDa)))
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnDodajStavku)
                        .addGap(11, 11, 11)
                        .addComponent(jbtnObrisiStavku)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtIznos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnKreirajActionPerformed
        KontrolerKIUnosRacuna.sacuvajRacun(jtxtRacunID, jdcDatumR, jcbRadnik, jtbStavke,jbtnDa,jbtnNe);
         KontrolerKIPronadjiRacun.pronadjiRacun(jtxtRacunID, jdcDatumR, jcbRadnik, jtbStavke,jtxtIznos,jbtnDa,jbtnNe);
    }//GEN-LAST:event_jbtnKreirajActionPerformed

    private void jtxtIznosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtIznosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtIznosActionPerformed

    private void jbtnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDodajStavkuActionPerformed
        try {
            KontrolerKIDodajStavku.dodajStavku(jtbStavke);
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }//GEN-LAST:event_jbtnDodajStavkuActionPerformed

    private void jbtnObrisiStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnObrisiStavkuActionPerformed
        KontrolerKIObrisiStavku.obrisiStavku(jtbStavke);
    }//GEN-LAST:event_jbtnObrisiStavkuActionPerformed

    private void jbtnStornirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnStornirajActionPerformed
        KontrolerKIStornirajRacun.stornirajRacun(jtxtRacunID, jbtnDa);
        ocistiFormu();
    }//GEN-LAST:event_jbtnStornirajActionPerformed

    private void jbtnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPretraziActionPerformed
        // TODO add your handling code here:
        KontrolerKIPronadjiRacun.pronadjiRacun(jtxtRacunID, jdcDatumR, jcbRadnik, jtbStavke,jtxtIznos,jbtnDa,jbtnNe);
    }//GEN-LAST:event_jbtnPretraziActionPerformed

    private void jbtnOsveziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOsveziActionPerformed
        ocistiFormu();
    }//GEN-LAST:event_jbtnOsveziActionPerformed

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
            java.util.logging.Logger.getLogger(FrmObradaRacuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmObradaRacuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmObradaRacuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmObradaRacuna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmObradaRacuna().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupDaNe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jbtnDa;
    private javax.swing.JButton jbtnDodajStavku;
    private javax.swing.JButton jbtnKreiraj;
    private javax.swing.JRadioButton jbtnNe;
    private javax.swing.JButton jbtnObrisiStavku;
    private javax.swing.JButton jbtnOsvezi;
    private javax.swing.JButton jbtnPretrazi;
    private javax.swing.JButton jbtnStorniraj;
    private javax.swing.JComboBox jcbRadnik;
    private com.toedter.calendar.JDateChooser jdcDatumR;
    private javax.swing.JTable jtbStavke;
    private javax.swing.JTextField jtxtIznos;
    private javax.swing.JTextField jtxtRacunID;
    // End of variables declaration//GEN-END:variables

 

    private void ocistiFormu() {
        try {
            jtxtRacunID.setText("");
            jdcDatumR.setDate(null);
            jtxtIznos.setText("");
            jcbRadnik.setSelectedItem(Sesija.dajObjekat().getUlogovaniRadnik());
            KontrolerKIInicijalizacijaTabele.inicijalizujTabelu(jtbStavke);
        } catch (IOException ex) {
            Logger.getLogger(FrmObradaRacuna.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
 
}