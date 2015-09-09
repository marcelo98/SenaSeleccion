package ShailoGM;
import java.io.*;
import java.io.Serializable;
 

public class manejo implements Serializable {
    String Nombre, contrasena; 

    public manejo(String contrasena, String Nombre) {
       this.Nombre = Nombre;
       this.contrasena = contrasena;
        
    }
    
    public static boolean crearadmi(){  
          try {
            File archivo = new  File("usuario.txt");
            FileOutputStream ruta = new  FileOutputStream(archivo);
            ObjectOutputStream escribir = new  ObjectOutputStream(ruta);
            
            //1 contraseña
            //2 user
            manejo persona = new manejo("980531","980531");
            
            escribir.writeObject(persona);
            escribir.close();
            return true;
        }catch (Exception e) {
            return false;
        }
}  
public static int ValidarUsuario(String nombre,String contrasena){
        try {
            File archivo = new  File("usuario.txt");
            FileInputStream ruta = new  FileInputStream(archivo);
            ObjectInputStream leer = new  ObjectInputStream(ruta);
            
            manejo persona = (manejo) leer.readObject();
            System.out.println("username : "+persona.getNombre()+" password : "+persona.getContrasena());
            if(persona.getNombre().equals(nombre)&& persona.getContrasena().equals(contrasena)){
                return 1;
                }else{
                    return 2;
            }
        } catch (Exception e) {
                return 0;
        }
    }
    
    public String getContrasena(){
        return contrasena;
    }
      
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
 }
