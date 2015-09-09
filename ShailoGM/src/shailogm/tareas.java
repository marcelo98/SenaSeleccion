package ShailoGM;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class tareas {
    
    private int idtareas;
    private String titulo ; 
    private String descripcion; 
    private String duracion; 
    private String archivo = "fases.txt";

    public tareas() {
    }

    public tareas(int idtareas, String titulo, String descripcion, String duracion) {
        this.idtareas = idtareas;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getIdtareas() {
        return idtareas;
    }

    public void setIdtareas(int idtareas) {
        this.idtareas = idtareas;
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

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "tareas{" + "idtareas=" + idtareas + ", titulo=" + titulo + ", descripcion=" + descripcion + ", duracion=" + duracion + ", archivo=" + archivo + '}';
    }


    
    
    public ArrayList<tareas> listaTareas(){
        String Linea = ""; 
        ArrayList<tareas>arrtareas = new ArrayList<tareas>(); 
        try{
            File datost = new File (archivo);
            BufferedReader leer = new BufferedReader(new FileReader (datost));
            
            while((Linea = leer.readLine()) !=null){
                if (Linea.length()> 1) {
                    tareas ta = new tareas(); 
                    
                    String data [] = Linea.split(","); 
                    
                    ta.setIdtareas(Integer.parseInt(data[0]));
                    ta.setTitulo(titulo);
                    ta.setDescripcion(descripcion);
                    ta.setDescripcion(descripcion);
                    ta.setDuracion(duracion);
                    
                    arrtareas.add(ta); 
                }
            }
            return arrtareas; 
        }catch (FileNotFoundException ex){
            Logger.getLogger(tareas.class.getName()).log(Level.SEVERE, null,ex);
        }catch(IOException ex ){
        Logger.getLogger(tareas.class.getName()).log(Level.SEVERE, null,ex);
        }
        return null; 
    }
    
     public int obtenerID(){
        int id = 0; 
        ArrayList<tareas> t = listaTareas();
        for (tareas tar : t){
            id= tar.getIdtareas();
            
        } 
        return id+1; 
    }
     
     public tareas buscarID (int id){
    ArrayList<tareas> ta = listaTareas(); 
    for(tareas tar : ta){
        if(tar.getIdtareas()==id){
            return tar; 
        }   
    }return null; 
} 
     
     public boolean registar (int idtareas, String titulo, String descripcion, String duracion){
         PrintWriter escribir = null; 
         this.titulo= titulo; 
         this.descripcion = descripcion; 
         this.descripcion=descripcion;
         
          try{ 
            this.idtareas = idtareas; 
           
            File datosintar = new File (archivo); 
            escribir = new PrintWriter(new BufferedWriter(new FileWriter(datosintar,true))); 
            escribir.println(this.idtareas + ","+this.titulo+ ","+this.descripcion+","+this.duracion);
            escribir.close();
            JOptionPane.showMessageDialog(null,"SE HA REGISTRADO UN " ,"INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            return true; 
        } catch (Exception ex){
             Logger.getLogger(tareas.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null,"SE HA PRODUCIDO UN ERROR","ERROR", JOptionPane.ERROR_MESSAGE);
            }finally {
            escribir.close();
        }
        return false; 
     }
}
