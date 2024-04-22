
package Controlador;

import Vistas.Vmenu;
import Vistas.VrealizarEntregas;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Claud
 */
public class Files {
     //intancia objeto font para modificar la fuente   
    private final Font fuente1 = new Font();
    private final Font fuente2 = new Font();
    
    //constructor vacio
    public Files(){
    }
    //Crear directorio entregasEpi
    public static String crearDirEntregasEpi(){
     
     String ruta;
     File directorio = new File("../entregasEpi");
     if(!directorio.exists()){
     directorio.mkdir();
     ruta = directorio.getAbsolutePath();
     }
     else{
     return directorio.getAbsolutePath();
            }
     System.out.println( "directorio creado en "+ ruta);
        return directorio.getAbsolutePath();
    }
    //Crear directorio archivos pdf
    public static String crearDirArchivos(){
     String ruta;
     String rutaAbs = crearDirEntregasEpi();
     File directorio = new File(rutaAbs+"/"+"Archivos");
     if(!directorio.exists()){
     directorio.mkdir();
     ruta = directorio.getAbsolutePath();
     }
     else{
      return directorio.getAbsolutePath();
             }
        return directorio.getAbsolutePath();
    }
    //Crear directorio por empleado
    public  static String crearDirEmp(String nombreDir){
     String ruta;
     String rutaAbs = crearDirEntregasEpi();
     File directorio = new File(rutaAbs+"/"+nombreDir);
     if(!directorio.exists()){
     directorio.mkdir();
     ruta = directorio.getAbsolutePath();
     }
     else{
        return directorio.getAbsolutePath();
             }
    return directorio.getAbsolutePath();
    }
    // arbrir derectorio del empleado
    public  void abrirDirectorio(String directorio) {
        try {
             String rutaAbs = crearDirEntregasEpi();
            Desktop.getDesktop().open(new File(rutaAbs+"/"+directorio));
        } catch ( IllegalArgumentException e ) {
            JOptionPane.showMessageDialog(null, "Aún no se han entregado EPIs a este empleado", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     //metodo para abrir el pdf
    public void abrirPDF(String fileName) {
       try {
        String rutaAbs = crearDirArchivos();
        File pdfFile = new File(rutaAbs + "/" + fileName + ".pdf");
        if (pdfFile.exists()) {
            // Abrir el archivo PDF con el visor predeterminado
            Desktop.getDesktop().open(pdfFile);
            
            // Dormir el hilo durante un breve período de tiempo para permitir que el visor abra el archivo
            Thread.sleep(1000);
            
            // Cerrar el visor de PDF
            Runtime.getRuntime().exec("taskkill /f /im AcroRd32.exe"); // Cambiar "AcroRd32.exe" si el visor predeterminado es diferente
        } else {
            JOptionPane.showMessageDialog(null, "El archivo no existe", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (IOException | InterruptedException e) {
        JOptionPane.showMessageDialog(null, "Error al intentar abrir o cerrar el archivo PDF", "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }
    }
    //Crear pdf por cada id de entrega
    public void crearPDFid(int id, String nombre, String ap1, String ap2, String puesto, javax.swing.JTable tab){
    
        fuente1.setStyle(1);
        fuente1.setSize(18);
        fuente2.setStyle(1);
        //instancia de date para obtener la fecha actual
        Date date = new Date();
        //Instancia objeto necesarios para generar el pdf
        Document documento = new Document();
        PdfPTable tabla = new PdfPTable(3);
        FileOutputStream archivo;
      
        try {
            String rutaAbs = crearDirArchivos();
            archivo = new FileOutputStream(rutaAbs+"/"+id+" "+nombre+" "+ap1+" "+ap2+".pdf");
            Paragraph titulo = new Paragraph("ENTREGA DE EQUIPO DE PROTECCION",fuente1);
            
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            titulo.setAlignment(1);
            documento.add(titulo);
            
            //Añadir datos del empleado
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(new Paragraph("NOMBRE: "+ nombre));
            documento.add(new Paragraph("PRIMER APELLIDO : "+ ap1));
            documento.add(new Paragraph("SEGUNDO APELLIDO: "+ ap2));
            documento.add(new Paragraph("PUESTO: "+ puesto));
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            
            //Añadir texto legal
            Paragraph texto = new Paragraph("Mediante el presente documento, el empleado acepta la recepcion del material de seguridad \n" +
                    "para  cumplir la legislacion del Real Derecho 664/1197, de 12 de Mayo, sobre la protección \n" +
                    "de los trabajadores contra los riesgos relacionados con la exposición de agentes biológicos\n" +
                    "durante el trabajo.");
            texto.setAlignment(Element.ALIGN_JUSTIFIED);
            documento.add(texto);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(new Paragraph("Equipo entregado:"));
            documento.add(Chunk.NEWLINE);
            //Añadir tabla
            PdfPCell cabId = new PdfPCell(new Phrase("Id",fuente2));
            PdfPCell cabDes = new PdfPCell(new Phrase("Descripcion",fuente2));
            PdfPCell cabUnd = new PdfPCell(new Phrase("Unidades",fuente2));
            
            tabla.addCell(cabId);
            tabla.addCell(cabDes);
            tabla.addCell(cabUnd);
            
            //Añadir a la tabla pdf los epis de la tabla visual que se entregaran
            for(int f =0; f<tab.getRowCount();f++){
                tabla.addCell(tab.getValueAt(f, 0).toString());
                tabla.addCell(tab.getValueAt(f, 1).toString());
                tabla.addCell(tab.getValueAt(f, 2).toString());
                
            }
            documento.add(tabla);
            
            //Añadir fecha actual
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(new Paragraph("Fecha: " + formatFecha(date)));
            documento.add(Chunk.NEWLINE);
            
            documento.close();
            
        } catch (DocumentException | IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
              documento.close();
        }
}
    // crear pdf por cada entrega a empleado
    public void crearPDFempleado(String ruta,String ndoc,String nombre, String ap1, String ap2, String puesto, javax.swing.JTable tab){
    
        fuente1.setStyle(1);
        fuente1.setSize(18);
        fuente2.setStyle(1);
        //instancia de date para obtener la fecha actual
        Date date = new Date();
        //Instancia objeto necesarios para generar el pdf
        Document documento = new Document();
        PdfPTable tabla = new PdfPTable(3);
        FileOutputStream archivo;
      
        try {
            
            archivo = new FileOutputStream(ruta+"/"+ndoc+".pdf");
            Paragraph titulo = new Paragraph("ENTREGA DE EQUIPO DE PROTECCION",fuente1);
            
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            titulo.setAlignment(1);
            documento.add(titulo);
            
            //Añadir datos del empleado
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(new Paragraph("NOMBRE: "+ nombre));
            documento.add(new Paragraph("PRIMER APELLIDO : "+ ap1));
            documento.add(new Paragraph("SEGUNDO APELLIDO: "+ ap2));
            documento.add(new Paragraph("PUESTO: "+ puesto));
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            
            //Añadir texto legal
            Paragraph texto = new Paragraph("Mediante el presente documento, el empleado acepta la recepcion del material de seguridad \n" +
                    "para  cumplir la legislacion del Real Derecho 664/1197, de 12 de Mayo, sobre la protección \n" +
                    "de los trabajadores contra los riesgos relacionados con la exposición de agentes biológicos\n" +
                    "durante el trabajo.");
            texto.setAlignment(Element.ALIGN_JUSTIFIED);
            documento.add(texto);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(new Paragraph("Equipo entregado:"));
            documento.add(Chunk.NEWLINE);
            //Añadir tabla
            PdfPCell cabId = new PdfPCell(new Phrase("Id",fuente2));
            PdfPCell cabDes = new PdfPCell(new Phrase("Descripcion",fuente2));
            PdfPCell cabUnd = new PdfPCell(new Phrase("Unidades",fuente2));
            
            tabla.addCell(cabId);
            tabla.addCell(cabDes);
            tabla.addCell(cabUnd);
            
            //Añadir a la tabla pdf los epis de la tabla visual que se entregaran
            for(int f =0; f<tab.getRowCount();f++){
                tabla.addCell(tab.getValueAt(f, 0).toString());
                tabla.addCell(tab.getValueAt(f, 1).toString());
                tabla.addCell(tab.getValueAt(f, 2).toString());
                
            }
            documento.add(tabla);
            
            //Añadir fecha 
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(new Paragraph("Fecha: " + formatFecha(date)));
            documento.add(Chunk.NEWLINE);
            
            documento.close();
            
        } catch (DocumentException | IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
              documento.close();
        }
}
    //metodo para formatear fecha
    public String  formatFecha(Date date){
       SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
       date = new Date();
       String fecha = sdf.format(date);
       return fecha;
   
   }
    //metodo para generar nombre unico para pdf
    public  String generarNombreUnico(String nombreArchivo) {
        String nombreSinExtension = nombreArchivo.replaceFirst("[.][^.]+$", ""); // Eliminar la extensión del nombre
        String extension = nombreArchivo.substring(nombreSinExtension.length()); // Obtener la extensión del nombre
        return nombreSinExtension + "_" + UUID.randomUUID().toString() + extension; // Agregar un UUID único al nombre
    }
}
