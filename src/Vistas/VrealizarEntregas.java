
package Vistas;

import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Controlador.*;




/**
 *
 * @author Claud
 */
public class VrealizarEntregas extends javax.swing.JPanel {
    
    //Instancias de los objetos que se van a necesitar
    EmpleadoDB empleadodb= new EmpleadoDB();
    EpiDB epidb= new EpiDB();
    EntregaEpiDB entregaepidb = new EntregaEpiDB();
    DefaultTableModel modelo = new DefaultTableModel();
    Files pdf = new Files();
    
    public VrealizarEntregas() {
        initComponents();
      // crearDirectorio(); 
       epidb. mostrarEpi(tablaEpis);
        String crearDirEntregasEpi = Files.crearDirEntregasEpi();
      
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jlIdEmpleado = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlApellido1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jlPuesto = new javax.swing.JLabel();
        jlApellido2 = new javax.swing.JLabel();
        tfIdEmp = new javax.swing.JTextField();
        btnEntregar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaEntregas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnAdd1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaEpis = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        setBackground(new java.awt.Color(0, 92, 137));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(11, 27, 54));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Selecciona empleado");

        jlIdEmpleado.setText("Codigo:");

        jLabel5.setText("Nombre:");

        jLabel7.setText("Puesto:");

        jlApellido1.setBackground(new java.awt.Color(255, 255, 255));
        jlApellido1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("2º Apellido");

        jlNombre.setBackground(new java.awt.Color(255, 255, 255));
        jlNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setText("1º Apellido");

        jlPuesto.setBackground(new java.awt.Color(255, 255, 255));
        jlPuesto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlApellido2.setBackground(new java.awt.Color(255, 255, 255));
        jlApellido2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tfIdEmp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tfIdEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfIdEmpMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfIdEmpMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jlIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIdEmpleado)
                    .addComponent(tfIdEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jlPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 280, 200));

        btnEntregar.setBackground(new java.awt.Color(255, 153, 0));
        btnEntregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEntregar.setText("Entregar");
        btnEntregar.setBorder(null);
        btnEntregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntregarMouseClicked(evt);
            }
        });
        jPanel1.add(btnEntregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 370, 100, 30));

        tablaEntregas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tablaEntregas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descripcion", "Und"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEntregas.setGridColor(new java.awt.Color(0, 0, 0));
        tablaEntregas.setSelectionBackground(new java.awt.Color(119, 200, 255));
        jScrollPane3.setViewportView(tablaEntregas);
        if (tablaEntregas.getColumnModel().getColumnCount() > 0) {
            tablaEntregas.getColumnModel().getColumn(0).setMinWidth(30);
            tablaEntregas.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaEntregas.getColumnModel().getColumn(0).setMaxWidth(30);
            tablaEntregas.getColumnModel().getColumn(2).setMinWidth(25);
            tablaEntregas.getColumnModel().getColumn(2).setPreferredWidth(35);
            tablaEntregas.getColumnModel().getColumn(2).setMaxWidth(35);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 340, 240));

        jLabel2.setBackground(new java.awt.Color(218, 234, 219));
        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Entrega de Epi");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 279, 43));

        btnDelete.setBackground(new java.awt.Color(255, 153, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.setBorder(null);
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 370, 90, 30));

        btnAdd1.setBackground(new java.awt.Color(255, 153, 0));
        btnAdd1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd1.setText("Añadir");
        btnAdd1.setBorder(null);
        btnAdd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdd1MouseClicked(evt);
            }
        });
        jPanel1.add(btnAdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 550, 80, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Seleccionar datos:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Material a entregar:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/documento60px.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        tablaEpis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaEpis);
        if (tablaEpis.getColumnModel().getColumnCount() > 0) {
            tablaEpis.getColumnModel().getColumn(0).setMinWidth(25);
            tablaEpis.getColumnModel().getColumn(0).setPreferredWidth(25);
            tablaEpis.getColumnModel().getColumn(0).setMaxWidth(5);
        }

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 280, 210));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 720));
    }// </editor-fold>//GEN-END:initComponents

    

    private void btnEntregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntregarMouseClicked
         Date date = new Date();
         String nombreDoc= jlNombre.getText()+" "+ jlApellido1.getText()+" "+pdf.formatFecha(date);
         String nombreUn=  pdf.generarNombreUnico(nombreDoc);
         String ruta =  Files.crearDirEmp(jlNombre.getText()+" "+ jlApellido1.getText()+" "+ jlApellido2.getText());
         boolean unidadesNulas = false;
  
      for (int i = 0; i < tablaEntregas.getRowCount(); i++) {
            Object unidades = tablaEntregas.getValueAt(i, 2); // Obtener el valor de la celda  de unidades
            if (unidades == null) {
                unidadesNulas = true;
                break;
            }
        }
      
      if (tfIdEmp.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Añadir empleado");
        } else if(tablaEntregas.getRowCount()==0){
         JOptionPane.showMessageDialog(this, "Añadir equipo");
        }else if(unidadesNulas){
         JOptionPane.showMessageDialog(this, "Añadir unidades");
        }else{
           
         entregaepidb.crearPDFentrega(nombreUn, ruta, jlNombre.getText(), jlApellido1.getText(),
                 jlApellido2.getText(),jlPuesto.getText(), tablaEntregas);
         epidb.actualizarUnidades(tablaEntregas);
         entregaepidb.actualizarTabEntrega(tablaEntregas,jlNombre.getText(),jlApellido1.getText(),jlApellido2.getText(),
                 jlPuesto.getText(),tfIdEmp.getText());
         
         //limpiar datos del empleado
        jlNombre.setText("");
        jlApellido1.setText("");
        jlApellido2.setText("");
        jlPuesto.setText("");
        tfIdEmp.setText("");
        
        // limpiar tabla de entregas
         entregaepidb.limpiarTabEntregas(tablaEntregas);
         JOptionPane.showMessageDialog(this, "Entrega realizada");
        }
        
        
         
        
  
    }//GEN-LAST:event_btnEntregarMouseClicked
   
    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
       entregaepidb.eliminarFila(tablaEntregas);
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnAdd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdd1MouseClicked
      
        if(tablaEpis.getSelectedRow()==-1){
       JOptionPane.showMessageDialog(this, "Hay que seleccionar fila");
    }else{
         epidb.moverFila(tablaEntregas, tablaEpis);
        }
        
       
    }//GEN-LAST:event_btnAdd1MouseClicked

    private void tfIdEmpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfIdEmpMouseExited
       
        if(tfIdEmp.getText().isEmpty()){
             System.out.println("No hay dato introducido.");
        }else{
          try{
                empleadodb.listarEmpleado( tfIdEmp.getText(),jlNombre,jlApellido1,jlApellido2,jlPuesto );
            }catch(Exception e){
               System.out.println("Error en seleccion empleado") ;
        }}
       
    }//GEN-LAST:event_tfIdEmpMouseExited

    private void tfIdEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfIdEmpMouseClicked
           if(tfIdEmp.getText().isEmpty()){
             System.out.println("No hay dato introducido.");
        }else{
          try{
                empleadodb.listarEmpleado( tfIdEmp.getText(),jlNombre,jlApellido1,jlApellido2,jlPuesto );
            }catch(Exception e){
               System.out.println("Error en seleccion empleado") ;
        }}
    }//GEN-LAST:event_tfIdEmpMouseClicked
   
       
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEntregar;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlApellido1;
    private javax.swing.JLabel jlApellido2;
    private javax.swing.JLabel jlIdEmpleado;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlPuesto;
    private javax.swing.JTable tablaEntregas;
    private javax.swing.JTable tablaEpis;
    private javax.swing.JTextField tfIdEmp;
    // End of variables declaration//GEN-END:variables
}
