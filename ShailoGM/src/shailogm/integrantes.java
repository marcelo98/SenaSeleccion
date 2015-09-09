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

public class integrantes {
    
    private String nombre; 
    private String apellido; 
    private String tipo; 
    private String fecha_nacimiento; 
    private String correo; 
    private String telefono; 
    private String direccion; 
    private int idtipo; 
    private String archivo = "integrantes.txt"; 

    public integrantes(String nombre, String apellido, String tipo, String fecha_nacimiento, String correo, String telefono, String direccion, int idtipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.idtipo = idtipo;
    }

    @Override
    public String toString() {
        return "integrantes{" + "nombre=" + nombre + ", apellido=" + apellido + ", tipo=" + tipo + ", fecha_nacimiento=" + fecha_nacimiento + ", correo=" + correo + ", telefono=" + telefono + ", direccion=" + direccion + ", idtipo=" + idtipo + '}';
    }

    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public integrantes() {
    }

    
    public integrantes(String nombre, String apellido, String tipo, String fecha_nacimiento, String correo, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public ArrayList<integrantes>listaIntegrantes(){
        String Linea = ""; 
        ArrayList<integrantes> arrintegrantes = new ArrayList<integrantes>(); 
        try {
            File datosintegrantes = new File (archivo); 
            BufferedReader leer = new BufferedReader (new FileReader(datosintegrantes));
            
            while ((Linea = leer.readLine()) !=null){
                if(Linea.length() > 1 ){
                    integrantes inte = new integrantes(); 
                    
                    
                    String data [] = Linea.split(","); 
                    
                    inte.setIdtipo(Integer.parseInt(data[0])); 
                    inte.setNombre(nombre);
                    inte.setApellido(apellido);
                    inte.setTipo(tipo);
                    inte.setFecha_nacimiento(fecha_nacimiento);
                    inte.setCorreo(correo);
                    inte.setTelefono(telefono);
                    inte.setDireccion(direccion); 
                    
                    arrintegrantes.add(inte); 
                   }
            }
            return arrintegrantes;
             
        }catch (FileNotFoundException ex){
            Logger.getLogger(integrantes.class.getName()).log(Level.SEVERE, null,ex);
        }catch(IOException ex ){
        Logger.getLogger(integrantes.class.getName()).log(Level.SEVERE, null,ex);
        }
        return  null; 
    }

   public int obtenerID(){
        int id = 0; 
        ArrayList<integrantes> personas = listaIntegrantes();
        for (integrantes Integrantes : personas){
            id= Integrantes.getIdtipo(); 
        } 
        return id+1; 
    }
   
public integrantes buscarID (int id){
    ArrayList<integrantes> Integrantes = listaIntegrantes(); 
    for(integrantes integrante1 : Integrantes){
        if(integrante1.getIdtipo()==id){
            return integrante1; 
        }   
    }return null; 
}   
    
     public boolean registrar (String nombre, String apellido, String tipo, String fecha_nacimiento, String correo, String telefono, String direccion){
        PrintWriter escribir = null;
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.tipo = tipo = "jefe" + "tester"+"analista"+"desarrollador"; 
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo; 
        this.telefono = telefono; 
        this.direccion = direccion; 
        
        try{ 
            this.idtipo = idtipo; 
           
            File datosintegrantes = new File (archivo); 
            escribir = new PrintWriter(new BufferedWriter(new FileWriter(datosintegrantes,true))); 
            escribir.println(this.idtipo + ","+this.nombre+ ","+this.apellido+","+this.tipo+","+this.fecha_nacimiento+","+this.correo+","+this.telefono+","+this.direccion);
            escribir.close();
            JOptionPane.showMessageDialog(null,"SE HA REGISTRADO UN " + this.tipo ,"INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            return true; 
        } catch (Exception ex){
             Logger.getLogger(integrantes.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null,"SE HA PRODUCIDO UN ERROR","ERROR", JOptionPane.ERROR_MESSAGE);
            }finally {
            escribir.close();
        }
        return false; 
    }
}

