package compilador;

import java.util.Hashtable;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chiva
 */
public class Informacion extends javax.swing.JFrame {
    Hashtable<String, String> pr = new Hashtable<>();
    
    /**
     * Creates new form Informacion
     */
    public Informacion() {
        initComponents();
        pr.put("inicioSecuencia", "\nInstrucción de inicio de nuestro programa, entendida como la declaración de inicio\ndel programa, esto nos permitirá mantener un orden en nuestro bloque de código\nasignando un nombre correspondiente.\n");
        pr.put("inicializacion", "\nPrimera instrucción a ejecutar donde se inicializan todas las variables.\n");
        pr.put("importar", "\nLa declaración de importación combina dos operaciones; busca el módulo nombrado\nluego vincula los resultados de esa búsqueda a un nombre en el ámbito local.\n");
        pr.put("funcion(*Parametros)", "\nDeclaración de un nombre único que contiene un bloque de código que realiza una \ntarea en específico, y se puede invocar a través de su nombre.\n");
        pr.put("retorno", "\nLa instrucción return se emplea para salir de la secuencia de ejecución de las sentencias de un método y, opcionalmente, devolver un valor.\n");
        pr.put("si", "\nSentencia que se ejecutará si la condición se evalúa como falsa, y exista una cláusula “sino”\n");
        asignar();
    }
    
    public void asignar(){
        for (Map.Entry<String, String> entry : pr.entrySet()) {
            txtPr.setText(txtPr.getText() + entry.getKey() + entry.getValue() + "\n");
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

        panel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPr = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jlbCerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(61, 64, 58));
        setUndecorated(true);
        setResizable(false);

        panel1.setBackground(new java.awt.Color(61, 64, 58));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPr.setColumns(20);
        txtPr.setRows(5);
        jScrollPane1.setViewportView(txtPr);

        panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 460, 370));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(61, 64, 58));
        jLabel1.setText("Palabras Reservadas");

        jlbCerrar.setBackground(new java.awt.Color(247, 255, 235));
        jlbCerrar.setForeground(new java.awt.Color(61, 64, 58));
        jlbCerrar.setText("  X");
        jlbCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlbCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbCerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlbCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jlbCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(498, 462));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jlbCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCerrarMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jlbCerrarMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbCerrar;
    private javax.swing.JPanel panel1;
    private javax.swing.JTextArea txtPr;
    // End of variables declaration//GEN-END:variables
}
