/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form.menu;

/**
 *
 * @author camper
 */

//IMPORTACIONES DEL CUESTIONARIO SOBRE TI
import capitulouno.sobreti.application.CreateSobretiUseCase;
import capitulouno.sobreti.infrastructure.in.SobretiController;
import capitulouno.sobreti.infrastructure.out.SobretiRepository;

public class Catalogo extends javax.swing.JFrame {

    /**
     * Creates new form Catalogo
     */
    public Catalogo() {
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

        jLabel1 = new javax.swing.JLabel();
        sobreti = new javax.swing.JButton();
        cuestionarioinformatico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Cap 1. CATALOGO");

        sobreti.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        sobreti.setText("Sobre ti");
        sobreti.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sobreti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sobretiActionPerformed(evt);
            }
        });

        cuestionarioinformatico.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        cuestionarioinformatico.setText("Cuestionario Informatico");
        cuestionarioinformatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuestionarioinformaticoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sobreti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cuestionarioinformatico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(sobreti)
                .addGap(18, 18, 18)
                .addComponent(cuestionarioinformatico)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sobretiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sobretiActionPerformed
        SobretiRepository sobretiRepository = new SobretiRepository();
        CreateSobretiUseCase createSobretiUseCase = new CreateSobretiUseCase(sobretiRepository);
        SobretiController sobretiController = new SobretiController(createSobretiUseCase, sobretiRepository);
        sobretiController.addSobreti();
    }//GEN-LAST:event_sobretiActionPerformed

    private void cuestionarioinformaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuestionarioinformaticoActionPerformed
        // aqui va todo lo del cuestionario informatico
    }//GEN-LAST:event_cuestionarioinformaticoActionPerformed

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
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Catalogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cuestionarioinformatico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton sobreti;
    // End of variables declaration//GEN-END:variables
}
