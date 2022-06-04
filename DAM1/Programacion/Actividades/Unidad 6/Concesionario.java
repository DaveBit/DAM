/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prog06_tarea;
import com.mycompany.prog06_tarea.vehiculo;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 * Clase concesionario, donde hemos creado el array para los vehiculos de nuestro concesionario, tendra un valor de 50 coches. 
 */
public class Concesionario {
    
    /**
    * Atributos explicados a continuacion. 
     */
    private static final byte MAX_VEHICULOS = 50;
    private final vehiculo[] vehiculos; //referencia del array que contendra los vehiculos. 
    private byte numVehiculos; //Numero de vehiculos con los que cuenta el concesionario.
    int length = MAX_VEHICULOS; //variable que he utilizado para los loops, para propio entendimiento y codigo mas limpio. 

    
    /**
     * constructor que ademas inicializa las todas los huecos del array. 
     */
    public Concesionario(){
        this.vehiculos = new vehiculo [MAX_VEHICULOS]; //creacion Array de datos no variable. 
        this.numVehiculos=0; //El numero inicial de vehiculos en la array es 0.
        for(int i=0; i<MAX_VEHICULOS; i++){
            vehiculos[i] = new vehiculo();
        }
    }
    /**
     * 
     * @param matricula Recibe la matricula que queremos buscar y que viene del usuario; 
     * @return carInfo devuelve la informacion del vehiculo si lo encontrara y null si no lo encuentra. 
     */
    public String buscaVehiculo (String matricula){
       
        String carInfo = null;
                
        for (int i = 0; i < length ; i++){
            if (vehiculos[i].verMatricula().equalsIgnoreCase(matricula)){
                carInfo = (vehiculos[i].toString());
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
            for(int i=0; i<length; i++){
                if ("notSetUp".equals(vehiculos[i].verMarca())){
                vehiculos[i].allSet(marca, matricula, numeroDeKm, diaMatriculacion, mesMatriculacion, anioMatriculacion, descripcion, precio, propietario, dni);
                numVehiculos ++;
                status = 0;
                break;
                }
            }
        }
            return status; 
    }
        
    /** 
     * esta funcione lista los vehiculos que hay en el concesionario
     */
    public void listaVehiculos (){
              for (int i =0; i < length; i++) {
            if ("notSetUp".equals(vehiculos[i].verMarca())){
                continue;
            }
            else {
            System.out.println("La marca es " + vehiculos[i].verMarca()+ " " +
                    "La matricula es "+ vehiculos[i].verMatricula()+ " " +
                    "El precio es "+ vehiculos[i].verPrecio()+ " " +
                    "El numero de km es "+ vehiculos[i].verNumeroDeKm()+" "+
                    "La descripcion es " + vehiculos[i].verDescripcion());
            }   
       }
    }
    /**
     * Esta funciona recibe la matricula a buscar y nos ayuda en otras funciones de la clase concesionario. 
     * @param matricula
     * @return 
     */
    public String buscarVehiculo (String matricula){
        String buscarVehiculo = "El vehiculo no existe";
        for(int i = 0; i<length; i++ ){
             if(vehiculos[i].verMatricula().equalsIgnoreCase(matricula)){
                 buscarVehiculo = vehiculos[i].toStringMarcaMatriculaPrecio();
                 break;
             }
             
         }
        return buscarVehiculo;
    }
    /**
     * Esta funcion nos ayuda con la actualizacion de km de los coches presentes. 
     * @param matricula
     * @param numeroKms
     * @return Los KM actualizados.
     */
    public String actualizarKms (String matricula, int numeroKms){
        String actualizadoKms = null;
        
        for (int i = 0; i<length; i++){
            if(vehiculos[i].verMatricula().equals(matricula)){
                if(vehiculos[i].verNumeroDeKm()<numeroKms){
                    vehiculos[i].actualizarKm(numeroKms);
                    actualizadoKms = "El numero de KM ha sido actualizado";
                    break;
                }
                else if (vehiculos[i].verNumeroDeKm() > numeroKms) {
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
    /**
     * Esta funcion busca la matricula y nos dice si esta presente en el concesionario. 
     * @param matricula
     * @return devuelve si la matricula esta presente o no. 
     */
    public boolean buscarMatricula (String matricula){
        boolean estaMatricula = false;
        
        for (int i = 0; i< length; i++){
            if ("notSetUp".equals(vehiculos[i].verMatricula())){
                continue;
            }
            
            else if (vehiculos[i].verMatricula().equalsIgnoreCase(matricula)){
                estaMatricula = true;
                break;
            }
        }
        return estaMatricula;
    }
    /**
     * Este metodo comprueba que concesionario este lleno o no, ayuda a otros metodos de la clase. 
     * @return devuelve si el concesionario esta lleno o no. 
     */
    public boolean checkFull (){
        boolean isFull = true;
        
        
        for (int i=0; i<length; i++){
            if("notSetUp".equals(vehiculos[i].verMatricula())){
                isFull = false;
                break;
            }
        }
        return isFull;
    }
    /**
     * Este metodo nos ayuda a ver si el array es nulo en algun punto. No se utiliza, pues se ha decidido inicializar el array para evitar trabajar con NULL. 
     * @param i
     * @return si el concesinario esta lleno o no. 
     */
    public boolean isNull(int i){
        boolean isNull = false; 
        if (vehiculos[i] == null){
            isNull = true;
        }
        return isNull;
    }
    
    /**
     * Este metodo comprueba cuan larga es la array. 
     * @return el tamanio de la array. 
     */
    public int checkLenghtVehiculos(){
        return length;
    }
    /**
     * Este metodo nos dice si el concesionario esta vacio o lleno
     * @return devuelve el boolean dependiendo en el estado;
     */
    public boolean isEmpty (){
        int x = 0;
        boolean isEmpty = true;
        for (int i=0; i<length; i++){
            if(!"notSetUp".equals(vehiculos[i].verMatricula())){
            x++;
            }
        }
        if (x>0){
            isEmpty = false;
        }
        
        return isEmpty;
    }
    
   
  
    
        
    
  
    
    
    
    
    
    
}
        
