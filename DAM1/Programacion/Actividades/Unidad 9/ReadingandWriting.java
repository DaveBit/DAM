/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog09x_tarea;

import java.io.*;

/**
 *
 * @author David
 */
public class ReadingandWriting {
    
    public static Concesionario leerFichero(String ruta) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        Concesionario concesionarioNuevo = null;
        ObjectInputStream recuperado_fichero = new ObjectInputStream(new FileInputStream(ruta));
        concesionarioNuevo = (Concesionario)recuperado_fichero.readObject();
        recuperado_fichero.close();
        
    
        return concesionarioNuevo;
    }
    
    public static void escribirFichero (Object x, String nombre) throws FileNotFoundException, IOException{
        ObjectOutputStream escribiendo_fichero = null;
        
            escribiendo_fichero = new ObjectOutputStream(new FileOutputStream(nombre));
            escribiendo_fichero.writeObject(x);
            escribiendo_fichero.close();
        
    
    }
}
