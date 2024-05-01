
package Controlador;

import Modelos.EntregaEpi;
import Vistas.VrealizarEntregas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Claud
 */
public class EntregaEpiDB extends ConexionDB {
   
     private PreparedStatement ps;
     private ResultSet rs;
     private DefaultTableModel modelo = new DefaultTableModel();
     private VrealizarEntregas vrealizarEntregas ;
     private Files files = new Files();
    
    //Contructor vacio
    public EntregaEpiDB(){}
    
    //-----------------metodos de consulta a la base de datos ----------------------//
    
    private List entregaEpi(){
    
     List<EntregaEpi> lista = new ArrayList<>();
        String sql = "Select * from entrega_epi ;";
        try{
            conectar();
            ps = prepararConsulta(sql);
            rs = ejecutarConsulta(ps);
            
            while(rs.next()){
                EntregaEpi r = new EntregaEpi();
                
                r.setIdEntrega(rs.getInt(1));
                r.setNombre(rs.getString(2));
                r.setApellido1(rs.getString(3));
                r.setApellido2(rs.getString(4));
                r.setPuesto(rs.getString(5));
                r.setDescripcion(rs.getString(6));
                r.setFecha(rs.getString(7));
                r.setIdEmpleado(rs.getInt(8));
                r.setIdEpi(rs.getInt(9));
                r.setUnd(rs.getInt(10));
                
                lista.add(r);  
            }
                    } catch(Exception e){
                    } 
        finally{
        desconectar();
        }    
        return lista;
    }
    //Metodo para seleccionar por idEmpleado
    private List<EntregaEpi> filtrarIdEmpB(int idEmp){
    
     List<EntregaEpi> lista = new ArrayList<>();
        String sql = "select * from entrega_epi where id_empleado_fk= "+idEmp+";";
        try{
         conectar();
            ps = prepararConsulta(sql);
            rs = ejecutarConsulta(ps);
            
            while(rs.next()){
                EntregaEpi r = new EntregaEpi();
                
                r.setIdEntrega(rs.getInt(1));
                r.setNombre(rs.getString(2));
                r.setApellido1(rs.getString(3));
                r.setApellido2(rs.getString(4));
                r.setPuesto(rs.getString(5));
                r.setDescripcion(rs.getString(6));
                r.setFecha(rs.getString(7));
                r.setIdEmpleado(rs.getInt(8));
                r.setIdEpi(rs.getInt(9));
                r.setUnd(rs.getInt(10));

                lista.add(r);
            }
                    } catch(Exception e){
                     e.printStackTrace();
                    }finally{
        desconectar();
        }
        return lista;
    }
    //Metodo para seleccionar por idEpi
    private List <EntregaEpi> filtrarIdEpiB(int idEpi){
    
     List<EntregaEpi> lista = new ArrayList<>();
        String sql = "select * from entrega_epi where id_epi= "+idEpi+";";
        try{
          conectar();
            ps = prepararConsulta(sql);
            rs = ejecutarConsulta(ps);
            
            while(rs.next()){
                EntregaEpi r = new EntregaEpi();
                
                r.setIdEntrega(rs.getInt(1));
                r.setNombre(rs.getString(2));
                r.setApellido1(rs.getString(3));
                r.setApellido2(rs.getString(4));
                r.setPuesto(rs.getString(5));
                r.setDescripcion(rs.getString(6));
                r.setFecha(rs.getString(7));
                r.setIdEmpleado(rs.getInt(8));
                r.setIdEpi(rs.getInt(9));
                r.setUnd(rs.getInt(10));

                lista.add(r);
            }
                    } catch(Exception e){
                    } finally{
        desconectar();
        }
        return lista;
    
    }
    //Metodo para seleccionar los empleados que segun el idEmp y el idEpi
    private List <EntregaEpi> filtrarIdesB(int idEmp, int idEpi){
    List<EntregaEpi> lista = new ArrayList<>();
        
        String sql = "select * from entrega_epi where id_empleado_fk = "+idEmp+" and id_epi= "+idEpi+";";
        try{
            conectar();
            ps = prepararConsulta(sql);
            rs = ejecutarConsulta(ps);
            
            while(rs.next()){
            
                EntregaEpi r = new EntregaEpi();
                
                r.setIdEntrega(rs.getInt(1));
                r.setNombre(rs.getString(2));
                r.setApellido1(rs.getString(3));
                r.setApellido2(rs.getString(4));
                r.setPuesto(rs.getString(5));
                r.setDescripcion(rs.getString(6));
                r.setFecha(rs.getString(7));
                r.setIdEmpleado(rs.getInt(8));
                r.setIdEpi(rs.getInt(9));
                r.setUnd(rs.getInt(10));
                
                lista.add(r);
            }
                    } catch(Exception e){ 
                    } finally{
        desconectar();
        } 
        return lista;
    }
     // Metodo para insertar datos en la tabla entrega_epi y a la vez obtener el id generado
    private int insertarEntregaYObtenerID(Connection con,String nombre, String apellido1, String apellido2,
                                         String puesto, String descripcion, int idEmpleado, int idEpi, int unidades) throws SQLException {
        
        String query = "INSERT INTO ENTREGA_EPI (Nombre_emp, Apellido1_emp, Apellido2_emp, "
                + "Puesto_emp, Descripcion_epi, id_empleado_fk, id_epi, und) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setString(1, nombre);
        statement.setString(2, apellido1);
        statement.setString(3, apellido2);
        statement.setString(4, puesto);
        statement.setString(5, descripcion);
        statement.setInt(6, idEmpleado);
        statement.setInt(7, idEpi);
        statement.setInt(8, unidades);

        // Ejecutar la inserción
        statement.executeUpdate();

        // Obtener el ID generado automáticamente
        ResultSet rs = statement.getGeneratedKeys();
        int idGenerado = -1;
        if (rs.next()) {
            idGenerado = rs.getInt(1);
        }
        
        return idGenerado;
        
    }
    
    
    //-----------------metodos para jframe  consulta entregas ----------------------//
   
 
    public void mostrarTablaEntregaEpi(JTable tablaConsultaEntregasEpi){
    
    List<EntregaEpi> lista = entregaEpi();
    modelo = (DefaultTableModel)tablaConsultaEntregasEpi.getModel();
    Object[] ob = new Object[10];
    
    for(int i =0; i<lista.size();i++){
    
        ob[0]=lista.get(i).getIdEntrega();
        ob[1]=lista.get(i).getNombre();
        ob[2]=lista.get(i).getApellido1();
        ob[3]=lista.get(i).getApellido2();
        ob[4]=lista.get(i).getPuesto();
        ob[5]=lista.get(i).getDescripcion();
        ob[6]=lista.get(i).getFecha();
        ob[7]=lista.get(i).getIdEmpleado();
        ob[8]=lista.get(i).getIdEpi();
        ob[9]=lista.get(i).getUnd();
        
        modelo.addRow(ob);
    }
    
    tablaConsultaEntregasEpi.setModel(modelo);
    
    }
    public void filtrarIdEpi(JTable tablaConsultaEntregasEpi, int idEpi){
        List<EntregaEpi> lista =filtrarIdEpiB(idEpi);
        modelo = (DefaultTableModel)tablaConsultaEntregasEpi.getModel();
        Object[] ob = new Object[10];

       for(int i =0; i<lista.size();i++){

           ob[0]=lista.get(i).getIdEntrega();
           ob[1]=lista.get(i).getNombre();
           ob[2]=lista.get(i).getApellido1();
           ob[3]=lista.get(i).getApellido2();
           ob[4]=lista.get(i).getPuesto();
           ob[5]=lista.get(i).getDescripcion();
           ob[6]=lista.get(i).getFecha();
           ob[7]=lista.get(i).getIdEmpleado();
           ob[8]=lista.get(i).getIdEpi();
           ob[9]=lista.get(i).getUnd();

           modelo.addRow(ob);
       }

       tablaConsultaEntregasEpi.setModel(modelo);

   
   }
    public void filtrarIdes(JTable tablaConsultaEntregasEpi, int idEpi, int idEmp){
   
        List<EntregaEpi> lista = filtrarIdesB(idEmp,idEpi);
        modelo = (DefaultTableModel)tablaConsultaEntregasEpi.getModel();
        Object[] ob = new Object[10];

        for(int i =0; i<lista.size();i++){

            ob[0]=lista.get(i).getIdEntrega();
            ob[1]=lista.get(i).getNombre();
            ob[2]=lista.get(i).getApellido1();
            ob[3]=lista.get(i).getApellido2();
            ob[4]=lista.get(i).getPuesto();
            ob[5]=lista.get(i).getDescripcion();
            ob[6]=lista.get(i).getFecha();
            ob[7]=lista.get(i).getIdEmpleado();
            ob[8]=lista.get(i).getIdEpi();
            ob[9]=lista.get(i).getUnd();

            modelo.addRow(ob);
        }
    
        tablaConsultaEntregasEpi.setModel(modelo);
   
   }
    public void limpiarTabla() {
        for(int i =0 ; i<modelo.getRowCount(); i++){
            modelo.removeRow(i);
            i = i-1;}}
    public void filtrarTabIdEmpleado(JTable tablaConsultaEntregasEpi, int idEmp){
    List<EntregaEpi> lista = filtrarIdEmpB(idEmp);
    modelo = (DefaultTableModel)tablaConsultaEntregasEpi.getModel();
    Object[] ob = new Object[10];
    
    for(int i =0; i<lista.size();i++){
    
        ob[0]=lista.get(i).getIdEntrega();
        ob[1]=lista.get(i).getNombre();
        ob[2]=lista.get(i).getApellido1();
        ob[3]=lista.get(i).getApellido2();
        ob[4]=lista.get(i).getPuesto();
        ob[5]=lista.get(i).getDescripcion();
        ob[6]=lista.get(i).getFecha();
        ob[7]=lista.get(i).getIdEmpleado();
        ob[8]=lista.get(i).getIdEpi();
        ob[9]=lista.get(i).getUnd();
        
        modelo.addRow(ob);
    }
    
    tablaConsultaEntregasEpi.setModel(modelo);
 
   }
    public void AbrirPDF(JTable tablaConsultaEntregasEpi) {
     Files pdf = new Files();  
     tablaConsultaEntregasEpi.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            int filaSeleccionada = tablaConsultaEntregasEpi.getSelectedRow();
            if (filaSeleccionada != -1) {
                String fileName = tablaConsultaEntregasEpi.getValueAt(filaSeleccionada, 0).toString() +" "+ 
                       tablaConsultaEntregasEpi.getValueAt(filaSeleccionada, 1).toString()+" "+ 
                       tablaConsultaEntregasEpi.getValueAt(filaSeleccionada, 2).toString()+" "+ 
                       tablaConsultaEntregasEpi.getValueAt(filaSeleccionada, 3).toString()
                           ;       
                pdf.abrirPDF(fileName);
                      }
              }
            }
         });
    }
    
    
     //-----------------metodos para jframe  realizar entregas ----------------------//
    
     public void limpiarTabEntregas(JTable tablaEntregas){
       modelo = (DefaultTableModel) tablaEntregas.getModel();
       modelo.getDataVector().removeAllElements();
       modelo.fireTableDataChanged();
     
   }
     public void crearPDFentrega(String nombreUn, String ruta, String nombre, String ap1, String ap2, String puesto, JTable tablaEntregas){
 
         java.util.Date date = new java.util.Date();
         Files file = new Files();
         
         
         files.crearPDFempleado(ruta,nombreUn,nombre,ap1, ap2, puesto, tablaEntregas );
         JOptionPane.showMessageDialog(vrealizarEntregas, "Archivo creado", "CORRECTO", HEIGHT);

   }
     public void eliminarFila(JTable tablaEntregas){
        modelo =  (DefaultTableModel) tablaEntregas.getModel();
         vrealizarEntregas = new VrealizarEntregas();
        if(tablaEntregas.getSelectedRow()==-1){
        JOptionPane.showMessageDialog(vrealizarEntregas, "Hay que seleccionar fila","Error",JOptionPane.ERROR_MESSAGE);
        }else{
         modelo.removeRow(tablaEntregas.getSelectedRow());
        }
    }
     public void actualizarTabEntrega(JTable tablaEntregas, String nombre, String ap1, String ap2,String puesto,String idEmp){

        try {
       
            Connection con;
            con=conectar();
 
            for (int f = 0; f < tablaEntregas.getRowCount(); f++) {
                // Realizar inserción en la base de datos y obtener el ID generado
               int idGenerado=  insertarEntregaYObtenerID(con,nombre, 
                        ap1, ap2,
                        puesto, tablaEntregas.getValueAt(f, 1).toString(),
                        Integer.parseInt(idEmp),
                        Integer.parseInt(tablaEntregas.getValueAt(f, 0).toString()),
                        Integer.parseInt(tablaEntregas.getValueAt(f, 2).toString()));
                
                 //Generar PDF con el ID generado
                files.crearPDFid(idGenerado, nombre,ap1,ap2, puesto, tablaEntregas );
            }
        } catch (SQLException ex) {
            Logger.getLogger(VrealizarEntregas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    
    
    
}
