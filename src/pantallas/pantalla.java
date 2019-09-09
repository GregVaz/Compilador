package pantallas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import compilador.Tokens;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jw.menage.ui.components.TextLineNumber;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chiva
 */
public class pantalla extends javax.swing.JFrame {

    Color fondo = new Color(36,35,34);
    Color contraste = new Color(61,64,58);
    Color carmesi = new Color(229,26,76);
    Color otroBlanco = new  Color(247,255,235);
    TextLineNumber numeroLinea;
    FileNameExtensionFilter filter;
    String direccionArchivo;
    int vis;
    DefaultTableModel modelo;
    String[] variables;
    
    /**
     * Creates new form pantalla
     */
    public pantalla() {
        initComponents();
        getContentPane().setBackground(fondo);
        Image icon = new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage();
        setIconImage(icon);
        
        
        numeroLinea= new TextLineNumber(textPane, 4);
        numeroLinea.setBackground(fondo);
        numeroLinea.setForeground(Color.WHITE);
        numeroLinea.setCurrentLineForeground(carmesi);
        textoCodigo.add(numeroLinea, BorderLayout.WEST);
        
        filter = new FileNameExtensionFilter("Archivos Para Compilador STEINS","steins");
        direccionArchivo= "";
        
        minErrores.setEnabled(false);
        tablaSimbolos.getTableHeader().setForeground(otroBlanco);
        tablaSimbolos.getTableHeader().setOpaque(false);
        tablaSimbolos.getTableHeader().setBackground(contraste);
        tablaSimbolos.getColumnModel().getColumn(0).setPreferredWidth(40);
        vis = 0;
        modelo=new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Lexema", "Componente lexico"});
        tablaSimbolos.setModel(modelo);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitulo = new javax.swing.JPanel();
        jlbCerrar = new javax.swing.JLabel();
        jlbMinimizar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelAcciones = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        visualizar = new javax.swing.JLabel();
        panelCodigo = new javax.swing.JPanel();
        codigo_Central = new javax.swing.JScrollPane();
        textoCodigo = new javax.swing.JPanel();
        textPane = new javax.swing.JTextPane();
        panelErrores = new javax.swing.JPanel();
        scrollErrores = new javax.swing.JScrollPane();
        areaErrores = new javax.swing.JTextArea();
        minErrores = new javax.swing.JLabel();
        paneTabla = new javax.swing.JPanel();
        scrollTabla = new javax.swing.JScrollPane();
        tablaSimbolos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTitulo.setBackground(new java.awt.Color(247, 255, 235));
        panelTitulo.setForeground(new java.awt.Color(247, 255, 235));
        panelTitulo.setPreferredSize(new java.awt.Dimension(983, 20));

        jlbCerrar.setBackground(new java.awt.Color(247, 255, 235));
        jlbCerrar.setForeground(new java.awt.Color(61, 64, 58));
        jlbCerrar.setText("  X");
        jlbCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlbCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbCerrarMouseClicked(evt);
            }
        });

        jlbMinimizar.setBackground(new java.awt.Color(247, 255, 235));
        jlbMinimizar.setForeground(new java.awt.Color(61, 64, 58));
        jlbMinimizar.setText("  -");
        jlbMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlbMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbMinimizarMouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(247, 255, 235));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(61, 64, 58));
        jLabel2.setText("Compilador STEINS");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 849, Short.MAX_VALUE)
                .addComponent(jlbMinimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jlbCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addComponent(jlbMinimizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelAcciones.setBackground(new java.awt.Color(61, 64, 58));
        panelAcciones.setForeground(new java.awt.Color(61, 64, 58));
        panelAcciones.setPreferredSize(new java.awt.Dimension(983, 30));

        jLabel3.setBackground(new java.awt.Color(247, 255, 235));
        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(244, 241, 233));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/abrirArchivo.png"))); // NOI18N
        jLabel3.setToolTipText("Abrir Archivo");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(247, 255, 235));
        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(244, 241, 233));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevoArchivo.png"))); // NOI18N
        jLabel4.setToolTipText("Abrir Archivo");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(247, 255, 235));
        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(244, 241, 233));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardarArchivoComo.png"))); // NOI18N
        jLabel8.setToolTipText("Guardar Archivo Como");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(247, 255, 235));
        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(244, 241, 233));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardarArchivo.png"))); // NOI18N
        jLabel9.setToolTipText("Guardar Archivo");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(247, 255, 235));
        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(244, 241, 233));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tablaDeSimbolos.png"))); // NOI18N
        jLabel11.setToolTipText("Tabla de  Simbolos");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(247, 255, 235));
        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(244, 241, 233));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/acercaDe.png"))); // NOI18N
        jLabel12.setToolTipText("Acerca de...");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(247, 255, 235));
        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(244, 241, 233));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/compilar.png"))); // NOI18N
        jLabel13.setToolTipText("Acerca de...");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        visualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Ojo.png"))); // NOI18N
        visualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        visualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                visualizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelAccionesLayout = new javax.swing.GroupLayout(panelAcciones);
        panelAcciones.setLayout(panelAccionesLayout);
        panelAccionesLayout.setHorizontalGroup(
            panelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(203, 203, 203)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(visualizar)
                .addContainerGap(456, Short.MAX_VALUE))
        );
        panelAccionesLayout.setVerticalGroup(
            panelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(visualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(panelAcciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        panelCodigo.setBackground(new java.awt.Color(36, 35, 34));

        codigo_Central.setBackground(new java.awt.Color(36, 35, 34));
        codigo_Central.setBorder(null);
        codigo_Central.setForeground(new java.awt.Color(36, 35, 34));
        codigo_Central.setPreferredSize(new java.awt.Dimension(1002, 20));

        textoCodigo.setLayout(new java.awt.BorderLayout());

        textPane.setBackground(new java.awt.Color(61, 64, 58));
        textPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textPane.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textPane.setForeground(new java.awt.Color(255, 255, 255));
        textPane.setCaretColor(new java.awt.Color(247, 255, 235));
        textPane.setSelectedTextColor(new java.awt.Color(61, 64, 58));
        textPane.setSelectionColor(new java.awt.Color(247, 255, 235));
        textoCodigo.add(textPane, java.awt.BorderLayout.CENTER);

        codigo_Central.setViewportView(textoCodigo);

        javax.swing.GroupLayout panelCodigoLayout = new javax.swing.GroupLayout(panelCodigo);
        panelCodigo.setLayout(panelCodigoLayout);
        panelCodigoLayout.setHorizontalGroup(
            panelCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCodigoLayout.createSequentialGroup()
                .addComponent(codigo_Central, javax.swing.GroupLayout.DEFAULT_SIZE, 973, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelCodigoLayout.setVerticalGroup(
            panelCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCodigoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(codigo_Central, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 983, 440));

        panelErrores.setBackground(new java.awt.Color(36, 35, 34));
        panelErrores.setPreferredSize(new java.awt.Dimension(983, 420));
        panelErrores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollErrores.setBorder(null);
        scrollErrores.setForeground(new java.awt.Color(255, 255, 255));

        areaErrores.setEditable(false);
        areaErrores.setBackground(new java.awt.Color(36, 35, 34));
        areaErrores.setColumns(20);
        areaErrores.setForeground(new java.awt.Color(247, 255, 235));
        areaErrores.setRows(5);
        areaErrores.setBorder(null);
        scrollErrores.setViewportView(areaErrores);

        panelErrores.add(scrollErrores, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 0, 940, 110));

        minErrores.setForeground(new java.awt.Color(255, 255, 255));
        minErrores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/minimizaError.png"))); // NOI18N
        minErrores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        minErrores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minErroresMouseClicked(evt);
            }
        });
        panelErrores.add(minErrores, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        getContentPane().add(panelErrores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 990, 110));

        paneTabla.setBackground(new java.awt.Color(36, 35, 34));

        scrollTabla.setBackground(new java.awt.Color(61, 64, 58));

        tablaSimbolos.setBackground(new java.awt.Color(36, 35, 34));
        tablaSimbolos.setForeground(new java.awt.Color(247, 255, 235));
        tablaSimbolos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexema", "Componente Lexico"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaSimbolos.setGridColor(new java.awt.Color(247, 255, 235));
        tablaSimbolos.setPreferredSize(new java.awt.Dimension(300, 330));
        tablaSimbolos.setSelectionBackground(new java.awt.Color(247, 255, 235));
        tablaSimbolos.setSelectionForeground(new java.awt.Color(36, 35, 34));
        scrollTabla.setViewportView(tablaSimbolos);

        javax.swing.GroupLayout paneTablaLayout = new javax.swing.GroupLayout(paneTabla);
        paneTabla.setLayout(paneTablaLayout);
        paneTablaLayout.setHorizontalGroup(
            paneTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );
        paneTablaLayout.setVerticalGroup(
            paneTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(paneTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, 240, 330));

        setSize(new java.awt.Dimension(983, 491));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jlbCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCerrarMouseClicked
        Salir sa = new Salir();
        sa.setVisible(true);
    }//GEN-LAST:event_jlbCerrarMouseClicked

    private void jlbMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbMinimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jlbMinimizarMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        JFileChooser AbrirA = new JFileChooser();
        AbrirA.setFileFilter(filter);
        int opcion = AbrirA.showOpenDialog(this);
        if(opcion==JFileChooser.APPROVE_OPTION){
            direccionArchivo = AbrirA.getSelectedFile().getPath();
            textPane.setText(new Archivo().abrirArchivo(direccionArchivo));
        }
        else
            showMessageDialog(this,"No se selecciono ningun archivo","Advertencia!", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        guardarArchivo();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        String temp = direccionArchivo;
        direccionArchivo = "";
        if(!guardarArchivo())
            direccionArchivo = temp;
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        direccionArchivo = "";
        textPane.setText("");
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        Creditos cr = new Creditos();
        cr.setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        Informacion in = new Informacion();
        in.setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        //minErrores.setEnabled(true);
        panelCodigo.setSize(740,320);
        codigo_Central.setSize(733,309);
        areaErrores.setBackground(contraste);
        areaErrores.setText("");
        
        modelo.setRowCount(0);
            
        try {
            analizarLexico();
            analizadorSintactico();
        } catch (IOException ex) {
            System.out.println("Error 2");
            Logger.getLogger(pantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jLabel13MouseClicked

    private void minErroresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minErroresMouseClicked
        panelCodigo.setSize(983,440);
        codigo_Central.setSize(973,419);
        textoCodigo.setSize(983,420);
        minErrores.setEnabled(false);
    }//GEN-LAST:event_minErroresMouseClicked

    private void visualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visualizarMouseClicked
        if(vis == 0){
            panelCodigo.setSize(983,440);
            codigo_Central.setSize(973,419);
            textoCodigo.setSize(983,420);
            minErrores.setEnabled(false);
            vis = 1;
        } else if (vis == 1){
            minErrores.setEnabled(true);
            panelCodigo.setSize(740,320);
            codigo_Central.setSize(733,309);
            areaErrores.setBackground(contraste);
            vis = 0;
        }
    }//GEN-LAST:event_visualizarMouseClicked
    
    /*public void showTokens(){
        for(String i : lexi.getTokens())
            System.out.println(i);
    }*/
    
    public void analizadorSintactico(){
        String ST = textPane.getText();
        //Sintax s = new Sintax(new AnalizadorLex.LexerCup(new StringReader(ST)));
        
        try {
        //        s.parse();
                minErrores.setText("Analisis sintactico realizado correctamente");
            } catch (Exception ex) {
        //        Symbol sym = s.getS();
        //        System.out.println("Error 1 \n" + "Error de sintaxis. Linea: " + sym.right + ". Columna: " + sym.right + "; Texto: \""+sym.value+"\"");
                Logger.getLogger(pantalla.class.getName()).log(Level.SEVERE, null, ex);
        //        minErrores.setText("Error de sintaxis. Linea: " + sym.right + ". Columna: " + sym.right + "; Texto: \""+sym.value+"\"");
            }
    }
    
    private void analizarLexico() throws IOException{
        int cont = 1;
        
        String expr = (String) textPane.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        
        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) {
                return;
            }
            switch (token) {
                case linea:
                    cont++;
                    break;
                case inicioSecuencia:
                    modelo.addRow(new Object[]{"inicioSecuencia","pr_control"});
                    break;
                case inicializacion:
                    modelo.addRow(new Object[]{"inicializacion","pr_control"});
                    break;
                case importar:
                    modelo.addRow(new Object[]{"importar","pr_control"});
                    break;
                case funcion:
                    modelo.addRow(new Object[]{"funcion","pr_control"});
                    break;
                case retorno:
                    modelo.addRow(new Object[]{"retorno","pr_control"});
                    break;
                case si:
                    modelo.addRow(new Object[]{"si","pr_control"});
                    break;
                case sino:
                    modelo.addRow(new Object[]{"sino","pr_control"});
                    break;
                case verdad:
                    modelo.addRow(new Object[]{"verdad","pr_control"});
                    break;
                case falso:
                    modelo.addRow(new Object[]{"falso","pr_control"});
                    break;
                case mientras:
                    modelo.addRow(new Object[]{"mientras","pr_control"});
                    break;
                case obtener:
                    modelo.addRow(new Object[]{"obtener","pr_control"});
                    break;
                    
                case decision:
                    modelo.addRow(new Object[]{"decision","pr_declaracion"});
                    break;
                case velocidad:
                    modelo.addRow(new Object[]{"velocidad","pr_declaracion"});
                    break;
                case tiempo:
                    modelo.addRow(new Object[]{"tiempo","pr_declaracion"});
                    break;
                case alerta:
                    modelo.addRow(new Object[]{"alerta","pr_declaracion"});
                    break;
                case color:
                    modelo.addRow(new Object[]{"color","pr_declaracion"});
                    break;
                case energia:
                    modelo.addRow(new Object[]{"energia","pr_declaracion"});
                    break;
                    
                case avanzar:
                    modelo.addRow(new Object[]{"inicioSecuencia","pr_movimiento"});
                    break;
                case detener:
                    modelo.addRow(new Object[]{"inicioSecuencia","pr_movimiento"});
                    break;
                case esperar:
                    modelo.addRow(new Object[]{"inicioSecuencia","pr_movimiento"});
                    break;
                case iniciar:
                    modelo.addRow(new Object[]{"inicioSecuencia","pr_movimiento"});
                    break;
                case reversa:
                    modelo.addRow(new Object[]{"inicioSecuencia","pr_movimiento"});
                    break;
                    
                case ubicar:
                    modelo.addRow(new Object[]{"inicioSecuencia","pr_ubicacion"});
                    break;
                case regresarBase:
                    modelo.addRow(new Object[]{"inicioSecuencia","pr_ubicacion"});
                    break;
                case detectarParada:
                    modelo.addRow(new Object[]{"inicioSecuencia","pr_ubicacion"});
                    break;
                case detectarLinea:
                    modelo.addRow(new Object[]{"inicioSecuencia","pr_ubicacion"});
                    break;
                    
                case obstaculo:
                    modelo.addRow(new Object[]{"inicioSecuencia","pr_seguridad"});
                    break;
                case estadoCamara:
                    modelo.addRow(new Object[]{"inicioSecuencia","pr_seguridad"});
                    break;
                case duracionRecorrido:
                    modelo.addRow(new Object[]{"inicioSecuencia","pr_seguridad"});
                    break;
                case detectarAnomalia:
                    modelo.addRow(new Object[]{"inicioSecuencia","pr_seguridad"});
                    break;
                case estadoEnergia:
                    modelo.addRow(new Object[]{"inicioSecuencia","pr_seguridad"});
                    break;
                case detectarColor:
                    modelo.addRow(new Object[]{"inicioSecuencia","pr_seguridad"});
                    break;
                    
                case identificador:
                    modelo.addRow(new Object[]{lexer.lexeme,"identificador"});
                    break;
                case time:
                    modelo.addRow(new Object[]{lexer.lexeme,"time"});
                    break;
                case cadena:
                    modelo.addRow(new Object[]{lexer.lexeme,"cadena"});
                    break;
                case veloc:
                    modelo.addRow(new Object[]{lexer.lexeme,"veloc"});
                    break;
                case colores:
                    modelo.addRow(new Object[]{lexer.lexeme,"colores"});
                    break;
                case caracter_especial:
                    modelo.addRow(new Object[]{lexer.lexeme,"caracter_especial"});
                    break;
                case op_relacional:
                    modelo.addRow(new Object[]{lexer.lexeme,"op_relacional"});
                    break;
                case igual:
                    modelo.addRow(new Object[]{lexer.lexeme,"igual"});
                    break;
                case suma:
                    modelo.addRow(new Object[]{lexer.lexeme,"suma"});
                    break;
                case resta:
                    modelo.addRow(new Object[]{lexer.lexeme,"resta"});
                    break;
                case parentesis_a:
                    modelo.addRow(new Object[]{lexer.lexeme,"parentesis_a"});
                    break;
                case parentesis_c:
                    modelo.addRow(new Object[]{lexer.lexeme,"parentesis_c"});
                    break;
                case llave_a:
                    modelo.addRow(new Object[]{lexer.lexeme,"llave_a"});
                    break;
                case llave_c:
                    modelo.addRow(new Object[]{lexer.lexeme,"llave_c"});
                    break;
            }
        }
    }
    
    
    public boolean guardarArchivo(){
        if(direccionArchivo.equals("")){
            try{
                    JFileChooser guardarA = new JFileChooser();
                    guardarA.showSaveDialog(this);
                    File guardar = guardarA.getSelectedFile();

                    if(guardar != null){
                        direccionArchivo = guardar + ".steins";
                        FileWriter  save=new FileWriter(guardar+".steins");
                        save.write(textPane.getText());
                        save.close();
                        return true;
                    }
                }catch(IOException ex){
                    System.out.println(ex);
                }
        }
        else{
            File fichero = new File(direccionArchivo);
            PrintWriter writer;
            try{
                writer = new PrintWriter(fichero);
                writer.print(textPane.getText());
                writer.close();
            }catch(FileNotFoundException e){
                System.out.println(e);
            }
        }
        return false;
    }//Fin guardarArchivo
    
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
            java.util.logging.Logger.getLogger(pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaErrores;
    private javax.swing.JScrollPane codigo_Central;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jlbCerrar;
    private javax.swing.JLabel jlbMinimizar;
    private javax.swing.JLabel minErrores;
    private javax.swing.JPanel paneTabla;
    private javax.swing.JPanel panelAcciones;
    private javax.swing.JPanel panelCodigo;
    private javax.swing.JPanel panelErrores;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JScrollPane scrollErrores;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tablaSimbolos;
    private javax.swing.JTextPane textPane;
    private javax.swing.JPanel textoCodigo;
    private javax.swing.JLabel visualizar;
    // End of variables declaration//GEN-END:variables
}
