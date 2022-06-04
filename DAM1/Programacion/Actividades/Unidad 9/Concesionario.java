/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog09x_tarea;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author David
 * Clase concesionario, donde hemos creado el array para los vehiculos de nuestro concesionario, tendra un valor de 50 coches. 
 */
public class Concesionario implements Serializable {
    
    /**
    * Atributos explicados a continuacion. 
     */
   
    ArrayList <vehiculo> vehiculos;
    //private final vehiculo[] vehiculos; //referencia del array que contendra los vehiculos. 
    private byte numVehiculos; //Numero de vehiculos con los que cuenta el concesionario.

    
    /**
     * constructor que ademas inicializa las todas los huecos del array. 
     */
    public Concesionario(){
        this.vehiculos = new ArrayList<vehiculo>(); 
        //this.vehiculos = new vehiculo [MAX_VEHICULOS]; //creacion Array de datos no variable. 
        this.numVehiculos=0; //El numero inicial de vehiculos en la array es 0.
        /**for(int i=0; i<MAX_VEHICULOS; i++){
             vehiculos.add(new vehiculo());
        }
        **/
    }
    /**
     * 
     * @param matricula Recibe la matricula que queremos buscar y que viene del usuario; 
     * @return carInfo devuelve la informacion del vehiculo si lo encontrara y null si no lo encuentra. 
     */
    public String buscaVehiculo (String matricula){
       
        String carInfo = null;
                
        for (int i = 0; i < vehiculos.size(); i++){
            if (vehiculos.get(i).verMatricula().equalsIgnoreCase(matricula)){
                carInfo = (vehiculos.get(i).toString());
                break;
            }
            
        }
        return carInfo;
    }
        /**
         * static String concatAll(Object[] things) {
      if(null == things) {
        return null;
      }
     //Rest of the code goes here
    }
         */
    
    /**
     * Este metodo inserta el vehiculo que hayamos introducido en el sistema. Recibe los parametros inferiores. 
     * @param marca
     * @param matricula
     * @param numeroDeKm
     * @param diaMatriculacion
     * @param mesMatriculacion
     * @param anioMatriculacion
     * @param descripcion
     * @param precio
     * @param propietario
     * @param dni
     * @return Devuelve el estado del registro, -2 si la matricula esta, -1 si el concesionario esta lleno y 0 si se ha realizado correctamente. 
     */
    public int insertarVehiculo (String marca, String matricula, int numeroDeKm, int diaMatriculacion, int mesMatriculacion, int anioMatriculacion, String descripcion, double precio, String propietario, String dni){
        int status = 0;
        boolean estaMatricula = buscarMatricula(matricula);
        boolean estaLleno = checkFull();
        
        
        if (estaMatricula){
                status = -2;
        }
        else if (estaLleno){
                status = -1;
        }
        else{
            for(int i=0; i<vehiculos.size(); i++){
                if ("notSetUp".equals(vehiculos.get(i).verMarca())){
                vehiculos.get(i).allSet(marca, matricula, numeroDeKm, diaMatriculacion, mesMatriculacion, anioMatriculacion, descripcion, precio, propietario, dni);
                numVehiculos ++;
                status = 0;
                break;
                }
            }
        }
            return status; 
    }
    
    //______________________________________________________________________________________________________________________________
        
    /** 
     * esta funcione lista los vehiculos que hay en el concesionario
     */
    public void listaVehiculos (){
              for (int i =0; i < vehiculos.size(); i++) {
            if ("notSetUp".equals(vehiculos.get(i).verMarca())){
                continue;
            }
            else {
            System.out.println("La marca es " + vehiculos.get(i).verMarca()+ " " +
                    "La matricula es "+ vehiculos.get(i).verMatricula()+ " " +
                    "El precio es "+ vehiculos.get(i).verPrecio()+ " " +
                    "El numero de km es "+ vehiculos.get(i).verNumeroDeKm()+" "+
                    "La descripcion es " + vehiculos.get(i).verDescripcion());
            }   
       }
    }
    //______________________________________________________________________________________________________________________________
    /**
     * Esta funciona recibe la matricula a buscar y nos ayuda en otras funciones de la clase concesionario. 
     * @param matricula
     * @return 
     */
    public String buscarVehiculo (String matricula){
        String buscarVehiculo = "El vehiculo no existe";
        for(int i = 0; i<vehiculos.size(); i++ ){
             if(vehiculos.get(i).verMatricula().equalsIgnoreCase(matricula)){
                 buscarVehiculo = vehiculos.get(i).toStringMarcaMatriculaPrecio();
                 break;
             }
             
         }
        return buscarVehiculo;
    }
    
    //______________________________________________________________________________________________________________________________
    /**
     * Esta funcion nos ayuda con la actualizacion de km de los coches presentes. 
     * @param matricula
     * @param numeroKms
     * @return Los KM actualizados.
     */
    public String actualizarKms (String matricula, int numeroKms){
        String actualizadoKms = null;
        
        for (int i = 0; i<vehiculos.size(); i++){
            if(vehiculos.get(i).verMatricula().equals(matricula)){
                if(vehiculos.get(i).verNumeroDeKm()<numeroKms){
                    vehiculos.get(i).actualizarKm(numeroKms);
                    actualizadoKms = "El numero de KM ha sido actualizado";
                    break;
                }
                else if (vehiculos.get(i).verNumeroDeKm() > numeroKms) {
                    actualizadoKms = "El numero de KM es inferior al actual";
                    break;
                }  
            break;               
            }
           
        }
         return actualizadoKms;
    }
    
    
    /**public vehiculos verConcesionario(){
        for(int i=0, i<vehiculos.lengh(), i++){
            return ;
    }
    }*/
    
    //______________________________________________________________________________________________________________________________
    /**
     * Esta funcion busca la matricula y nos dice si esta presente en el concesionario. 
     * @param matricula
     * @return devuelve si la matricula esta presente o no. 
     */
    public boolean buscarMatricula (String matricula){
        boolean estaMatricula = false;
        
        for (int i = 0; i< vehiculos.size(); i++){
            
            if (vehiculos.get(i).verMatricula().equalsIgnoreCase(matricula)){
                estaMatricula = true;
                break;
            }
        }
        return estaMatricula;
    }
    
    //______________________________________________________________________________________________________________________________
    /**
     * Este metodo comprueba que concesionario este lleno o no, ayuda a otros metodos de la clase. 
     * @return devuelve si el concesionario esta lleno o no. 
     */
    
    public boolean checkFull (){
        boolean isFull = false;
        if(vehiculos.size() == 50){
            isFull=true;
            System.out.println("El concesionario esta lleno, elimina algun vehiculo");
        }
        return isFull;
        
    }
        
       
        /**
        for (int i=0; i<vehiculos.size(); i++){
            if("notSetUp".equals(vehiculos.get(i).verMatricula())){
                isFull = false;
                break;
            }
        }
        return isFull;
        */
                
        
    
    //______________________________________________________________________________________________________________________________
    /**
     * Este metodo comprueba cuan larga es la array. 
     * @return el tamanio de la array. 
     */
    public int checkLenghtVehiculos(){
        return vehiculos.size();
    }
    
    //______________________________________________________________________________________________________________________________
    /**
     * Este metodo nos dice si el concesionario esta vacio o lleno
     * @return devuelve el boolean dependiendo en el estado;
     */
    public boolean isEmpty (){
        
        return vehiculos.isEmpty();
       /** int x = 0;
        boolean isEmpty = true;
        for (int i=0; i<length; i++){
            if(!"notSetUp".equals(vehiculos[i].verMatricula())){
            x++;
            }
        }
        if (x>0){
            isEmpty = false;
        }
        */
    }
    /**
     * El siguiente metodo, itera por el array, buscar la matricula, si la encuentra obtiene el indice y lo elimina. 
     * si no la encuentra, sale del metodo. 
     * @param matricula 
     */
    //______________________________________________________________________________________________________________________________
    public void removerVehiculo (String matricula){
        int z = -1;
        for (vehiculo x: vehiculos ){
            if(x.verMatricula().equalsIgnoreCase(matricula)){
               z = vehiculos.indexOf(x);
               break;
            }
        }
        if(z == -1){
            System.out.println("Vehiculo no encontrado");
        }
        else{
        vehiculos.remove(z);
            System.out.println("El vehiculo ha sido eliminado.");
        }

    }
    
    
    
   
  
    
        
    
  
    
    
    
    
    
    
}
        
