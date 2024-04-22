
package Vistas;

import javax.swing.table.DefaultTableModel;
import Modelos.Empleado;
import Controlador.EmpleadoDB;

/**
 * @author Claud
 */
public class Vempleados extends javax.swing.JPanel {
    
    //Instancias de los objetos necesarios
    DefaultTableModel modelo = new DefaultTableModel();
    EmpleadoDB empDB = new EmpleadoDB();
  
    
    public Vempleados() {
        initComponents();
        empDB.mostrarTablaEmpleado(tablaEmpleados);
        empDB.abrirDirectorio(tablaEmpleados);
    }
  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        txId = new javax.swing.JTextField();

        setInheritsPopupMenu(true);
        setMinimumSize(new java.awt.Dimension(1000, 680));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1000, 680));
        setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(11, 27, 54));
        jPanel2.setMinimumSize(new java.awt.Dimension(680, 760));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Empleados");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 140, 40));

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "1º Apellido", "2º Apellido", "Puesto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaEmpleados);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 730, 510));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ingeniero60px.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Id:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        btnActualizar.setBackground(new java.awt.Color(255, 153, 0));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setBorder(null);
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });
        jPanel2.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, 80, 30));

        txId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 80, -1));

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        if(txId.getText().isEmpty()){
       
           empDB.limpiarTabla();
           empDB.mostrarTablaEmpleado(tablaEmpleados);
       }else{
            empDB.limpiarTabla();
            empDB.filtrarTabIdEmpleado(tablaEmpleados, Integer.parseInt(txId.getText()));
        
        }
    }//GEN-LAST:event_btnActualizarMouseClicked
   
  
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField txId;
    // End of variables declaration//GEN-END:variables
}
