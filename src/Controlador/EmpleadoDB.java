
package Controlador;

import java.sql.*;
import java.util.*;
import Modelos.Empleado;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Claud
 */
public class EmpleadoDB extends ConexionDB {
    
    //Instancias de los objetos necesarios
 
     private PreparedStatement ps;
     private ResultSet rs;
     private DefaultTableModel modelo = new DefaultTableModel();
    
    
    //contructor vacio
    public EmpleadoDB(){}
    
    
    //-----------------------consultas a la base de datos --------------------------------//
    //Metodo para mostrar la tabla empleado en la tabla visual
    private List <Empleado> listaTablaEmpleado(){
       List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleado";
        try{
            conectar();
            ps = prepararConsulta(sql);
            rs = ejecutarConsulta(ps);
            
            while(rs.next()){
                Empleado emp= new Empleado();
                
                emp.setIdEmpleado(rs.getInt(1));
                emp.setNombre(rs.getString(2));
                emp.setApellido1(rs.getString(3));
                emp.setApellido2(rs.getString(4));
                emp.setPuesto(rs.getString(5));
                
                lista.add(emp);
            }
             } catch(SQLException e){
                    System.out.println("Error en empladoDao");
                }finally{
       desconectar();
        }
        return lista;
   }
     // Metodo para filtrar empleado por id para la tabla
    private List  <Empleado> filtrarId(int id){
     List<Empleado> lista = new ArrayList<>();
        
        String sql = "select * from empleado where Id_empleado= "+id+";";
        try{
             conectar();
            ps = prepararConsulta(sql);
            rs = ejecutarConsulta(ps);
            
            while(rs.next()){
                Empleado emp= new Empleado();
                
                emp.setIdEmpleado(rs.getInt(1));
                emp.setNombre(rs.getString(2));
                emp.setApellido1(rs.getString(3));
                emp.setApellido2(rs.getString(4));
                emp.setPuesto(rs.getString(5));
                
                lista.add(emp);
            }
             } catch(SQLException e){
                    System.out.println("Error en empladoDao");
                } finally{
       desconectar();
        }
        return lista;
   } 
    //Metodo para seleccionar datos para la ventana de entrega de epi
    private Empleado idEmpleado (int id){
    
        Empleado emp= new Empleado();
        String sql = "select * from empleado where Id_empleado= "+id+";";
        try{
            conectar();
            ps = prepararConsulta(sql);
            rs = ejecutarConsulta(ps);
            
            while(rs.next()){
               
                emp.setIdEmpleado(rs.getInt(1));
                emp.setNombre(rs.getString(2));
                emp.setApellido1(rs.getString(3));
                emp.setApellido2(rs.getString(4));
                emp.setPuesto(rs.getString(5));   
            }
             } catch(SQLException e){
                    System.out.println("Error en empladoDao");
                    } finally{
       desconectar();
        }
         return emp;
        
         
    }
  
    //-----------------------Metodos para jframe --------------------------------//
    public void mostrarTablaEmpleado(JTable tablaEmpleados){
    
    List<Empleado> lista = listaTablaEmpleado();
    modelo = (DefaultTableModel)tablaEmpleados.getModel();
    Object[] ob = new Object[5];
    
    for(int i =0; i<lista.size();i++){
        ob[0]=lista.get(i).getIdEmpleado();
        ob[1]=lista.get(i).getNombre();
        ob[2]=lista.get(i).getApellido1();
        ob[3]=lista.get(i).getApellido2();
        ob[4]=lista.get(i).getPuesto();
        modelo.addRow(ob);
    }
    tablaEmpleados.setModel(modelo);
    }
    public void filtrarTabIdEmpleado(JTable tablaEmpleados, int id){
    List<Empleado> lista = filtrarId(id);
    modelo = (DefaultTableModel)tablaEmpleados.getModel();
    Object[] ob = new Object[5];
    
    for(int i =0; i<lista.size();i++){
    
        ob[0]=lista.get(i).getIdEmpleado();
        ob[1]=lista.get(i).getNombre();
        ob[2]=lista.get(i).getApellido1();
        ob[3]=lista.get(i).getApellido2();
        ob[4]=lista.get(i).getPuesto();
        
        modelo.addRow(ob);
    }
    
    tablaEmpleados.setModel(modelo);
    
       
    }
    public void limpiarTabla() {
        for(int i =0 ; i<modelo.getRowCount(); i++){
            modelo.removeRow(i);
            i = i-1;
    
    
    }}
    public void abrirDirectorio(JTable tablaEmpleados) {
     Files pdf = new Files();  
     tablaEmpleados.addMouseListener(new MouseAdapter() {
    @Override
      public void mouseClicked(MouseEvent e) {
        Files pdf = new Files();  
        if (e.getClickCount() == 2) {
            int filaSeleccionada = tablaEmpleados.getSelectedRow();
            if (filaSeleccionada != -1) {
                String fileName = 
                       tablaEmpleados.getValueAt(filaSeleccionada, 1).toString()+" "+ 
                       tablaEmpleados.getValueAt(filaSeleccionada, 2).toString()+" "+ 
                       tablaEmpleados.getValueAt(filaSeleccionada, 3).toString()+" ";       
                pdf.abrirDirectorio(fileName);
                      }else{
              javax.swing.JOptionPane.showMessageDialog(null, "Aun no hay carpeta existente", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
              }
            }
         });
    }
    
    //---------------------metodos para jframe realizar entregas----------------//
  
    public void listarEmpleado(String idEmp, JLabel jlNombre, JLabel jlApellido1, JLabel jlApellido2, JLabel jlPuesto) {
        try {
        // Convertir el ID de empleado a entero
        int idEmpleado = Integer.parseInt(idEmp);
        
        // Obtener el empleado de la base de datos
        Empleado empleado = idEmpleado(idEmpleado);
        
        // Verificar si el empleado existe
        if (empleado != null) {
            // Actualizar los campos de texto con la información del empleado
            jlNombre.setText(empleado.getNombre());
            jlApellido1.setText(empleado.getApellido1());
            jlApellido2.setText(empleado.getApellido2());
            jlPuesto.setText(empleado.getPuesto());
        } else {
            // Si no se encuentra el empleado, limpiar los campos de texto
            jlNombre.setText("");
            jlApellido1.setText("");
            jlApellido2.setText("");
            jlPuesto.setText("");
            // También puedes mostrar un mensaje de error o tomar otras acciones según sea necesario
            JOptionPane.showMessageDialog(null, "Empleado no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        // Manejar la excepción si el ID del empleado no es un número válido
        // Limpiar los campos de texto
        jlNombre.setText("");
        jlApellido1.setText("");
        jlApellido2.setText("");
        jlPuesto.setText("");
        // También puedes mostrar un mensaje de error o tomar otras acciones según sea necesario
        JOptionPane.showMessageDialog(null, "Por favor, introduzca un ID válido", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
}
