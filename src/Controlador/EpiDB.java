
package Controlador;


import java.sql.*;
import java.util.*;
import Modelos.Epi;
import Vistas.Vepi;
import Vistas.VrealizarEntregas;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Claud
 */
public class EpiDB extends ConexionDB{
 
   private PreparedStatement ps;
   private ResultSet rs;
   DefaultTableModel modelo = new DefaultTableModel();
     Vepi vepi;
    
   
   //Constructor vacio
    public EpiDB(){}
    
    //-----------------------consultas a la base de datos-------------------------//
    //Metodo para crear una lista de la tabla epi para poder mostrarla en una tabla 
    private List tablaEpi() {
        
        List<Epi> lista = new ArrayList<>();
        String sql = "Select * from epi";
        try{
             conectar();
            ps = prepararConsulta(sql);
            rs = ejecutarConsulta(ps);
            
            while(rs.next()){
              Epi epis = new Epi();
                
              epis.setIdEpi(rs.getInt(1));
              epis.setDescripcion(rs.getString(2));
              epis.setTalla(rs.getString(3));
              epis.setUnidades(rs.getInt(4));
              
              lista.add(epis);
            }
                    } catch(ClassNotFoundException | SQLException e){
                        System.out.println("Error en el metodo tablaEpi de la clase EpiDAO");
                    }finally{
        desconectar();
        }       
        return lista;
      
                    
    }
   //Metodo para añadir epi a traves de un objeto, se utilizara en la ventanaEpi
    private void añadirB(Object[] o) {
        vepi= new Vepi();
        String sql = "insert into epi(Descripcion,Talla,Unidades) values (?,?,?)";
        
        try{
            conectar();
            ps = prepararConsulta(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
         
            ps.executeUpdate();
        
        }catch(ClassNotFoundException | SQLException e){
         System.out.println("error en metodo add de epiB");
        
        }finally{
        desconectar();
        }
    }
   //Metodo para actualizar epi mediante un obejto, se utlizara en ventanaEpi
    private void actualizarB(Object[] o) {

        String sql = "update epi set Unidades =? where Id_epi =?";
        try{
            conectar();
            ps = prepararConsulta(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]); 
            
            ps.executeUpdate();
        
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("error metodo actualzar de epiDAO");
         }finally{
        desconectar();
        }
    }
   //Metodo para eliminar un epi, se utilizara en la  ventanaEpi
    private void eliminarb(int id) {
    String sql = "DELETE FROM epi WHERE Id_epi = ?";
    try {
        conectar();
        PreparedStatement ps = prepararConsulta(sql);
        ps.setInt(1, id);
        int filasAfectadas = ejecutarActualizacion(ps);
        if (filasAfectadas > 0) {
            System.out.println("El registro con Id_epi " + id + " se ha eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún registro con Id_epi " + id + " para eliminar.");
        }
    } catch (ClassNotFoundException | SQLException e) {
        System.out.println("Error al intentar eliminar el registro de la base de datos: " + e.getMessage());
    }finally{
        desconectar();
        }
}
    // metodo para actualizar las unidades despues de hacer una entrega
    private void actualizarUnidadesB ( int id, int und){
        try {
        conectar();
        String sql = "update epi set Unidades = Unidades - ? where Id_epi = ?";
        ps = prepararConsulta(sql);
        ps.setInt(1, und);
        ps.setInt(2, id);
        ps.executeUpdate();
    } catch (ClassNotFoundException | SQLException e) {
        System.out.println("Error al actualizar unidades de la base de datos: " + e.getMessage());
    } finally {
        desconectar(); 
    }
    }
    // metodo para comprobar si un epi existe
   private boolean existeEpi(String descripcion, String talla) {
    try {
        conectar();
        String sql = "SELECT COUNT(*) FROM epi WHERE Descripcion = ? AND Talla = ?";
        PreparedStatement ps = prepararConsulta(sql);
        ps.setString(1, descripcion);
        ps.setString(2, talla);
        ResultSet rs = ejecutarConsulta(ps);
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0;
        }
    } catch (ClassNotFoundException | SQLException e) {
        System.out.println("Error al verificar si existe el EPI: " + e.getMessage());
    }
    return false;
}
   private int obtenerUnidadesEPI(int id) {
    int unidadesActuales = 0;
    String sql = "SELECT Unidades FROM epi WHERE Id_epi = ?";
    try {
        conectar();
        ps = prepararConsulta(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if (rs.next()) {
            unidadesActuales = rs.getInt("Unidades");
        }
    } catch (ClassNotFoundException | SQLException e) {
        System.out.println("Error al obtener las unidades del EPI: " + e.getMessage());
    } finally {
        desconectar();
    }
    return unidadesActuales;
}
   
   
  
    //------------------------metodos para jframe epi-------------------------------//
    //metodo para seleccionar todos los epis que  tengan menos 3 unidades
   private void pocasUnidades(){
   StringBuilder mensaje = new StringBuilder();
   List<Epi> lista = tablaEpi();
   Vepi vepi = new Vepi();
    Object[] ob = new Object[4];
        ob[0]=lista.get(0).getIdEpi();
        ob[1]=lista.get(1).getDescripcion();
        ob[2]=lista.get(2).getTalla();
        ob[3]=lista.get(3).getUnidades();
    
       for(Epi obj : lista){
       
      
      if (obj.getUnidades() < 3) {
        mensaje.append("Quedan ").append(obj.getUnidades()).append(" unidades de: ")
               .append(obj.getDescripcion()).append(" ").append(obj.getTalla())
               .append(" id: ").append(obj.getIdEpi()).append("\n");
  
      
       }
    }
   if (mensaje.length() > 0) {
    JOptionPane.showMessageDialog(vepi, mensaje.toString(), "AVISO POCAS UNIDADES", JOptionPane.INFORMATION_MESSAGE);
}
   }
   public void ejecutarHiloAvisoUnidades() {
       
       
        Thread thread;
       thread = new Thread(new Runnable() {
           @Override
           public void run() {
               synchronized (this) {
                   try {
                       this.wait(2000); // Esperar 2 segundos
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Vepi.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   pocasUnidades(); // Llamar a avisoUnidades() después de esperar
               }
           }
       });
        thread.start(); // Iniciar el hilo
    }
   public void mostrarTablaEpi(JTable tablaEpi) {
        
    List<Epi> lista = tablaEpi();
    modelo =  (DefaultTableModel) tablaEpi.getModel();
    Object[] ob = new Object[4];
    
    for(int i =0; i<lista.size();i++){
    
        ob[0]=lista.get(i).getIdEpi();
        ob[1]=lista.get(i).getDescripcion();
        ob[2]=lista.get(i).getTalla();
        ob[3]=lista.get(i).getUnidades();
        
        modelo.addRow(ob);
    }
    
    tablaEpi.setModel(modelo);
        
    }
   public void actualizarTab(int und, int id) {
    // Consultar el valor actual de las unidades del EPI
    int unidadesActuales = obtenerUnidadesEPI(id);

    // Verificar si las unidades introducidas son diferentes a las actuales
    if (und <= 0) {
        JOptionPane.showMessageDialog(vepi, "La cantidad de unidades debe ser mayor que cero.");
    } else if (und == unidadesActuales) {
        JOptionPane.showMessageDialog(vepi, "No se ha actualizado");
    } else {
        Object[] ob = new Object[]{und, id};

        // Llama al método para actualizar la cantidad de unidades
        actualizarB(ob);
    }
}
   public void añadir(String descripcion, String talla, String undStr) {
    Vepi vepi = new Vepi();

    // Verificar si ya existe un registro con la misma descripción y talla
    if (existeEpi(descripcion, talla)) {
        JOptionPane.showMessageDialog(vepi, "Ya existe un EPI con la misma descripción y talla.");
    } else {
        // Si no existe, procede a agregar el nuevo registro
        Object[] ob = new Object[3];
        ob[0] = descripcion;
        ob[1] = talla;

        try {
            // Intenta convertir el valor de undStr a un entero
            int und = Integer.parseInt(undStr);
            ob[2] = und;

            if (descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(vepi, "Debes añadir una descripción.");
            } else if (talla.isEmpty()) {
                JOptionPane.showMessageDialog(vepi, "Debes añadir una talla.");
            } else if (und <= 0) {
                JOptionPane.showMessageDialog(vepi, "La cantidad no es valida");
            } else {
                añadirB(ob);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vepi, "El valor de la cantidad no es valido");
        }
    }
}
   public void eliminar(JTable tablaEpi) {
      // Obtener la cantidad de filas seleccionadas
    int filasSeleccionadas = tablaEpi.getSelectedRowCount();

    // Verificar si no se ha seleccionado ninguna fila
    if (filasSeleccionadas == 0) {
        JOptionPane.showMessageDialog(vepi, "Debes seleccionar una fila para eliminar.");
    } 
    // Verificar si se ha seleccionado más de una fila
    else if (filasSeleccionadas > 1) {
        JOptionPane.showMessageDialog(vepi, "Solo puedes eliminar una fila a la vez.");
    } 
    // Si solo se ha seleccionado una fila
    else {
        // Obtener el índice de la fila seleccionada
        int filaSeleccionada = tablaEpi.getSelectedRow();
        
        // Obtener el id de la fila seleccionada
        int id = Integer.parseInt(tablaEpi.getValueAt(filaSeleccionada, 0).toString());
        
        // Obtener la descripción y talla del EPI seleccionado
        String descripcion = tablaEpi.getValueAt(filaSeleccionada, 1).toString();
        String talla = tablaEpi.getValueAt(filaSeleccionada, 2).toString();
        
        // Mostrar un mensaje de confirmación con la información del EPI que se va a eliminar
        int opcion = JOptionPane.showConfirmDialog(vepi, "¿Estás seguro de eliminar el EPI : " + descripcion + " y talla: " + talla + "?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        
        // Verificar si el usuario confirmó la eliminación
        if (opcion == JOptionPane.YES_OPTION) {
            // Llamar al método eliminarB con el id obtenido
            eliminarb(id);
        }
    }
}
   public void limpiarTabla() {
        for(int i =0 ; i<modelo.getRowCount(); i++){
            modelo.removeRow(i);
            i = i-1;
         }
    }

     //------------------------metodos para jframe realizar entregas-------------------------------//
   public void moverFila( JTable tablaEntregas, JTable tablaEpis){
        VrealizarEntregas vrealizarEntregas = new VrealizarEntregas();
        modelo = (DefaultTableModel) tablaEntregas.getModel();
        List<Epi> lista = tablaEpi();
        int filaSelec = tablaEpis.getSelectedRow();
        if(filaSelec>=0){
         String datos[] = new String[2];
         datos[0] = tablaEpis.getValueAt(filaSelec,0).toString();
         datos[1] = tablaEpis.getValueAt(filaSelec, 1).toString();
         modelo.addRow(datos);
         
          
        }
        tablaEntregas.setModel(modelo);
        
        int idSeleccionado = Integer.parseInt(tablaEpis.getValueAt(filaSelec, 0).toString());
        for (Epi obj : lista) {
        if (obj.getIdEpi()==idSeleccionado) {
           // int unidadesRestantes = epi.getUnidades();
            String mensaje = "Quedan  "+ obj.getUnidades()+ " unidades de " 
                    +obj.getDescripcion()+ " talla: " + obj.getTalla();
              JOptionPane.showMessageDialog(vrealizarEntregas, mensaje.toString(), "AVISO DE UNIDADES", JOptionPane.INFORMATION_MESSAGE);
            break; // Una vez que se encuentra el ID, no es necesario seguir iterando sobre la lista
        }
    }
       
    }
   public void mostrarEpi(JTable tablaEpis){

    List<Epi> lista = tablaEpi();
    modelo =  (DefaultTableModel) tablaEpis.getModel();
    Object[] ob = new Object[2];
    
    for(int i =0; i<lista.size();i++){
        ob[0]=lista.get(i).getIdEpi();
        ob[1]=lista.get(i).getDescripcion() +" talla: "+ lista.get(i).getTalla();
   
       modelo.addRow(ob);
       
    }
    
    tablaEpis.setModel(modelo);
        
    
    
    }
   public void actualizarUnidades(JTable tablaEntregas){
     for(int f=0; f<tablaEntregas.getRowCount();f++){
    
         actualizarUnidadesB(Integer.parseInt(tablaEntregas.getValueAt(f, 0).toString()),
                 Integer.parseInt(tablaEntregas.getValueAt(f, 2).toString()));
     }
    }
   
 
   
}
