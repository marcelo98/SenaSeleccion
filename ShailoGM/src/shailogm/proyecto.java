
package ShailoGM;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class proyecto {

private int idproyecto; 
private String titulo; 
private String descripcion; 
private String ob_principal; 
private String duracion; 
private String archivo = "proyectos.txt";  

    public int getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(int idproyecto) {
        this.idproyecto = idproyecto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOb_principal() {
        return ob_principal;
    }

    public void setOb_principal(String ob_principal) {
        this.ob_principal = ob_principal;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public proyecto(int idproyecto, String titulo, String descripcion, String ob_principal, String duracion) {
        this.idproyecto = idproyecto;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ob_principal = ob_principal;
        this.duracion = duracion;
    }

    
    public proyecto() {
    }

    
    
    
    public ArrayList<proyecto> listaProyectos(){
        String Linea ="";
        ArrayList<proyecto> arrayproyectos = new ArrayList<proyecto>();
        try {
            File datosproyecto = new File (archivo); 
            BufferedReader leer = new BufferedReader ( new FileReader(datosproyecto)); 
            
            while ((Linea = leer.readLine())!=null){
                if(Linea.length() > 1 ){
                    proyecto proyec = new proyecto(); 
                    
                    
                    String data [] = Linea.split(","); 
                    
                    proyec.setIdproyecto(Integer.parseInt(data[0]));
                    proyec.setTitulo(data[1]);
                    proyec.setDescripcion(data[2]);
                    proyec.setOb_principal(data[3]);
                    proyec.setDuracion(data[4]);
                    
                    arrayproyectos.add(proyec); 
                }
            }return arrayproyectos; 
                
        }catch (FileNotFoundException ex){
             Logger.getLogger(proyecto.class.getName()).log(Level.SEVERE, null,ex);
        }catch(IOException ex){
             Logger.getLogger(proyecto.class.getName()).log(Level.SEVERE, null,ex);
        }return null; 
    }

    @Override
    public String toString() {
        return "proyecto{" + "idproyecto=" + idproyecto + ", titulo=" + titulo + ", descripcion=" + descripcion + ", ob_principal=" + ob_principal + ", duracion=" + duracion + ", archivo=" + archivo + '}';
    }
    public int obtenerID (){
        int id = 0; 
        ArrayList<proyecto> Proyecto = listaProyectos(); 
        for (proyecto proyecto : Proyecto){
            System.out.println(proyecto.getIdproyecto()); 
            id = proyecto.getIdproyecto(); 
        } 
        return id+1; 
    }
    
    public proyecto buscarID (int id ){
        ArrayList<proyecto> Proyecto = listaProyectos(); 
        for(proyecto proyecto1 : Proyecto){
            if (proyecto1.getIdproyecto()== id){
                return proyecto1; 
            }
            
     } return null; 

    }
    public boolean registar (String titulo, String descripcion, String ob_principal, String duracion){
        
        PrintWriter escribir = null; 
        this.idproyecto = this.obtenerID(); 
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ob_principal = ob_principal; 
        this.duracion = duracion; 
        
        try{
            this.idproyecto =idproyecto;
            
            File datosproyecto = new File (archivo);
            escribir = new PrintWriter(new BufferedWriter(new FileWriter(datosproyecto,true))); 
            escribir.println(this.idproyecto+","+this.titulo+","+this.descripcion+","+this.ob_principal+","+this.duracion);
            escribir.close();
             JOptionPane.showMessageDialog(null,"SE HA REGISTRADO UN EL PROYECTO " + this.titulo  ,"INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            return true; 
        }catch(Exception ex){
             Logger.getLogger(proyecto.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null,"SE HA PRODUCIDO UN ERROR","ERROR", JOptionPane.ERROR_MESSAGE);
        }finally {
             escribir.close();
        }
        return false; 
    }

    public boolean modificar (int idproyectos, String titulo, String descripcion, String ob_principal, String duracion){
        
        int cont = 0;
        PrintWriter escribir = null; 
        proyecto pr = buscarID(idproyectos); 
        pr.setIdproyecto(idproyectos);
        pr.setTitulo(titulo);
        pr.setDescripcion(descripcion);
        pr.setOb_principal(ob_principal);
        pr.setDuracion(duracion);
        
        ArrayList<proyecto> arr = listaProyectos();
        for (proyecto p : arr){
            if(p.idproyecto == pr.idproyecto){
                arr.set(cont, pr); 
            }
            cont++; 
        }
        try {
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("");
            bw.close();
        }catch (IOException ex ){
            Logger.getLogger(proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File datos = new File (archivo); 
        try{
            escribir = new PrintWriter(new BufferedWriter(new FileWriter(datos,true)));
            for(proyecto pro : arr ){
                escribir.println(pro.idproyecto+","+pro.titulo+","+pro.descripcion+","+pro.ob_principal+","+pro.duracion);
            }
            escribir.close();
             JOptionPane.showMessageDialog(null,"SE HA MODICADO EL PROYECTO","INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }catch(IOException ex){
             Logger.getLogger(proyecto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"SE HA PRODUCIDO UN ERROR","ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return false; 
}
    
    public boolean elimimar (int idproyectos){
        int cont = 0; 
        PrintWriter escribir = null; 
        ArrayList<proyecto> array = listaProyectos(); 
        ArrayList<proyecto>arr = listaProyectos(); 
        
        for (proyecto p : arr){
            if(p.idproyecto == idproyectos){
                array.remove(cont); 
            }
            cont++; 
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("");
            bw.close();
        }catch (IOException ex) {
            Logger.getLogger(proyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        File datos = new File (archivo); 
        try{
            escribir = new PrintWriter(new BufferedWriter(new FileWriter(datos,true)));
            for (proyecto ar: array){
                escribir.println(ar.idproyecto+","+ar.titulo+","+ar.descripcion+","+ar.ob_principal+","+ar.duracion);
            }
            escribir.close();
            JOptionPane.showMessageDialog(null,"SE HA ELIMINADO EL PROYECTO","INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }catch (IOException ex) {
            Logger.getLogger(proyecto.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null,"SE HA PRODUCIDO UN ERROR","ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return false; 
    }
    

}