/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Radnik;
import javax.swing.JDialog;

public class FrmGlavna extends javax.swing.JFrame {

    static Radnik radnik;

    /**
     * Creates new form FrmGlavna
     */
    public FrmGlavna(Radnik radnik) {
        initComponents();
        this.radnik = radnik;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jmiObradaProizvoda = new javax.swing.JMenuItem();
        jmiObradaRacuna = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Klijent Početna");

        jMenu.setText("Operacija");
        jMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuActionPerformed(evt);
            }
        });

        jmiObradaProizvoda.setText("Rad sa proizvodom");
        jmiObradaProizvoda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiObradaProizvodaActionPerformed(evt);
            }
        });
        jMenu.add(jmiObradaProizvoda);

        jmiObradaRacuna.setText("Rad sa računom");
        jmiObradaRacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiObradaRacunaActionPerformed(evt);
            }
        });
        jMenu.add(jmiObradaRacuna);

        jMenuBar1.add(jMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiObradaRacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiObradaRacunaActionPerformed
        FrmObradaRacuna form = new FrmObradaRacuna();
        form.setVisible(true);
    }//GEN-LAST:event_jmiObradaRacunaActionPerformed

    private void jMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuActionPerformed

    private void jmiObradaProizvodaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiObradaProizvodaActionPerformed
        PanelProizvod panel = new PanelProizvod();
        JDialog dialog = new JDialog(this, "Forma za obradu proizvoda", true);
        dialog.add(panel);
        dialog.pack();
        dialog.setVisible(true);

    }//GEN-LAST:event_jmiObradaProizvodaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGlavna(radnik).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jmiObradaProizvoda;
    private javax.swing.JMenuItem jmiObradaRacuna;
    // End of variables declaration//GEN-END:variables
}
