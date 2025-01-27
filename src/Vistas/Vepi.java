/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Controlador.EpiDB;

/**
 *
 * @author Claud
 */
public class Vepi extends javax.swing.JPanel {

     EpiDB epidb = new EpiDB();
     DefaultTableModel modelo = new DefaultTableModel();
     int id;
     
     
    public Vepi() {
        initComponents();
        epidb.mostrarTablaEpi(tablaEpi);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEpi = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEpi = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jlUnidades = new javax.swing.JLabel();
        jlTalla = new javax.swing.JLabel();
        jlDescripcion = new javax.swing.JLabel();
        txtUnd = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtTalla = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 750));

        panelEpi.setBackground(new java.awt.Color(11, 27, 54));
        panelEpi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelEpi.setFocusTraversalPolicyProvider(true);
        panelEpi.setVerifyInputWhenFocusTarget(false);
        panelEpi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaEpi.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tablaEpi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descripcion", "Talla", "Unidades"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaEpi.setGridColor(new java.awt.Color(0, 0, 0));
        tablaEpi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEpiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEpi);
        if (tablaEpi.getColumnModel().getColumnCount() > 0) {
            tablaEpi.getColumnModel().getColumn(0).setMinWidth(20);
            tablaEpi.getColumnModel().getColumn(0).setPreferredWidth(2);
            tablaEpi.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        panelEpi.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 490, 590));

        btnDelete.setBackground(new java.awt.Color(255, 153, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.setBorder(null);
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        panelEpi.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 90, 30));

        btnUpdate.setBackground(new java.awt.Color(255, 153, 0));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setText("Actualizar");
        btnUpdate.setBorder(null);
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        panelEpi.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 90, 30));

        btnAdd.setBackground(new java.awt.Color(255, 153, 0));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setText("Añadir");
        btnAdd.setAutoscrolls(true);
        btnAdd.setBorder(null);
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        panelEpi.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 80, 30));

        jlUnidades.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlUnidades.setForeground(new java.awt.Color(255, 255, 255));
        jlUnidades.setText("Unidades:");
        panelEpi.add(jlUnidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 70, 20));

        jlTalla.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlTalla.setForeground(new java.awt.Color(255, 255, 255));
        jlTalla.setText("Talla:");
        panelEpi.add(jlTalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 50, 20));

        jlDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        jlDescripcion.setText("Descripción:");
        panelEpi.add(jlDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 90, 20));

        txtUnd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelEpi.add(txtUnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 180, 30));

        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelEpi.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 180, 30));

        txtTalla.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelEpi.add(txtTalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 180, 30));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EPI");
        panelEpi.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ropa60px.png"))); // NOI18N
        panelEpi.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEpi, javax.swing.GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEpi, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaEpiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEpiMouseClicked
        int fila = tablaEpi.getSelectedRow();

        if(fila ==-1){

            JOptionPane.showMessageDialog(this, "Tines que seleccionar una fila");
        } else{

            id = Integer.parseInt(tablaEpi.getValueAt(fila, 0).toString());
            String descripcion = tablaEpi.getValueAt(fila, 1).toString();
            String talla = tablaEpi.getValueAt(fila, 2).toString();
            String unidades = tablaEpi.getValueAt(fila, 3).toString();

            txtDescripcion.setText(descripcion);
            txtTalla.setText(talla);
            txtUnd.setText(unidades);
        }
    }//GEN-LAST:event_tablaEpiMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        epidb.eliminar(tablaEpi);
        epidb.limpiarTabla();
        epidb.mostrarTablaEpi(tablaEpi);
        txtDescripcion.setText("");
        txtTalla.setText("");
        txtUnd.setText("");
            
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        int fila = tablaEpi.getSelectedRow();
        if(fila ==-1){

            JOptionPane.showMessageDialog(this, "Tines que seleccionar una fila");
        }else{
            epidb.actualizarTab(Integer.parseInt(txtUnd.getText()),id);
            epidb.limpiarTabla();
            epidb.mostrarTablaEpi(tablaEpi);
            
             txtDescripcion.setText("");
             txtTalla.setText("");
             txtUnd.setText("");
        }

    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        
       
            
            epidb.añadir(txtDescripcion.getText(),txtTalla.getText(),txtUnd.getText());
            epidb.limpiarTabla();
            epidb.mostrarTablaEpi(tablaEpi);
       
            txtDescripcion.setText("");
            txtTalla.setText("");
            txtUnd.setText("");

           
    }//GEN-LAST:event_btnAddMouseClicked
  
   
  
   
   
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlDescripcion;
    private javax.swing.JLabel jlTalla;
    private javax.swing.JLabel jlUnidades;
    private javax.swing.JPanel panelEpi;
    private javax.swing.JTable tablaEpi;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtTalla;
    private javax.swing.JTextField txtUnd;
    // End of variables declaration//GEN-END:variables
}
