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


public class fases {

    private int idfases; 
    private String titulo ; 
    private String descripcion; 
    private String duracion; 
    private String archivo = "fases.txt"; 
    public fases() {
    }

    public fases(String titulo, String descripcion, String duracion) {
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

    public int getIdfases() {
        return idfases;
    }

    public void setIdfases(int idfases) {
        this.idfases = idfases;
    }
    
    
    
    
    public ArrayList<fases> listafases(){
        String Linea = ""; 
        ArrayList<fases> arrfases = new ArrayList<fases>(); 
        try{
            File datosfases = new File (archivo); 
            BufferedReader leer = new BufferedReader (new FileReader(datosfases)); 
            
            while ((Linea = leer.readLine())!=null); 
            if (Linea.length() > 1){
                fases fase = new fases();
                
                String data [] = Linea.split(","); 
                
                fase.setTitulo(titulo);
                fase.setDescripcion(descripcion);
                fase.setDuracion(duracion);
                
                arrfases.add(fase); 
            }
            return arrfases; 
        }catch (FileNotFoundException ex ){
              Logger.getLogger(fases.class.getName()).log(Level.SEVERE, null,ex);
        }catch(IOException ex) {
             Logger.getLogger(fases.class.getName()).log(Level.SEVERE, null,ex);
        }return null; 
    }
    
    
     public int obtenerID (){
        int id = 0; 
        ArrayList<fases> Fases = listafases(); 
        for (fases fa : Fases){
            id = fa.getIdfases(); 
        } 
        return id+1; 
    }
      public fases buscarID (int id ){
        ArrayList<fases> fase = listafases(); 
        for(fases fas : fase){
            if (fas.getIdfases()==id){
                return fas; 
            }
        } return null; 
    }
      
      public boolean registrar (String titulo, String descripcion, String duracion){
          PrintWriter escribir = null; 
          this.titulo = titulo; 
          this.descripcion = descripcion; 
          this.duracion = duracion; 
          
          try{
              
              this.idfases = idfases; 
              
              File datosfases = new File (archivo); 
              escribir = new PrintWriter (new BufferedWriter(new FileWriter(datosfases,true)));
              escribir.println(this.idfases+","+this.titulo+","+this.descripcion+","+this.duracion); 
              escribir.close();
              JOptionPane.showMessageDialog(null,"SE HA REGISTRADO LA FASE " + this.titulo  ,"INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            return true; 
          }catch(Exception ex){
               Logger.getLogger(fases.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null,"SE HA PRODUCIDO UN ERROR","ERROR", JOptionPane.ERROR_MESSAGE);
            }finally{
              escribir.close();
          }
     return  false; 
      }
   
}