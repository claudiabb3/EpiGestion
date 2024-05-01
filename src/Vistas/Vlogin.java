
package Vistas;

import java.awt.Color;
import Controlador.UsuarioDB;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Claud
 */
public final class Vlogin extends javax.swing.JFrame {
        //Instanciamos las clases usuario y log

    
      private final UsuarioDB usuariodb = new UsuarioDB();
    
    public Vlogin() {
        
         initComponents();
         //Llamada al metodo setLocation para que al iniciar el progama este aparezca en el centro
         this.setLocationRelativeTo(null);
         
         //cambiar el color del jframe
         this.getContentPane().setBackground(Color.decode("#005C89"));
         
         
         
         setIconImage(getIconImage());
         this.setTitle("EpiGestion");
        
    }
    
    //icono jframe 
       @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Img/ingeniero60px.png"));
        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txPass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        btnInicioSesion = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(11, 27, 54));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INICIO  SESION");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        txUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(txUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 200, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuario:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        txPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(txPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 200, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ingeniero60px.png"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        btnInicioSesion.setBackground(new java.awt.Color(255, 153, 0));
        btnInicioSesion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnInicioSesion.setText("Aceptar");
        btnInicioSesion.setBorder(null);
        btnInicioSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInicioSesionMouseClicked(evt);
            }
        });
        btnInicioSesion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnInicioSesionKeyTyped(evt);
            }
        });
        jPanel3.add(btnInicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 120, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioSesionMouseClicked
       
        
          boolean valido= usuariodb.validar(txUsuario.getText(), txPass.getText());
           if (valido) {
           this.dispose();}
          
    }//GEN-LAST:event_btnInicioSesionMouseClicked

    private void btnInicioSesionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnInicioSesionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInicioSesionKeyTyped
   
   
    
   public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Vlogin().setVisible(true);
        });
    }
   
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JToggleButton btnInicioSesion;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPasswordField txPass;
    public javax.swing.JTextField txUsuario;
    // End of variables declaration//GEN-END:variables
}
