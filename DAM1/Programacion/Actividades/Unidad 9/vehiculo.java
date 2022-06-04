/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog09x_tarea;

import java.io.Serializable;

/**
 *
 * @author David
 * Esta clase es utilizada para crear objetos de la clase vehiculo. 
 *
 */
public class vehiculo implements Serializable, Comparable<vehiculo> {
    
/**
 *  Los atributos han sido establecidos en private, de modo que solo pueden ser manipulados desde la clase. 
 *  Se ha decidido inicializar los atributos para evitar trabajar con null.
 * El numeroDeKm ha sido unicializado en -1 de modo que si se introdujera que el nuevo vehiculo tiene 0, seria facil indetificar si se ha utilizado ese indice o no. 
 * De modo que si se devuelve -1 no hay coche, si es otro numero superior a -1 si hay coche. 
 */
       private String marca = "notSetUp";
       private String matricula = "notSetUp";
           private int numeroDeKm = -1;
       private int diaMatriculacion = 0;
       private int mesMatriculacion = 0;
       private int anioMatriculacion = 0;
       private String descripcion = "notSetUp";
       private double precio = 0;
       private String propietario = "notSetUp";
       private String dni = "notSetUp";
       private int antiguedad = 0;
       
      /**
       * dos constructores, uno vacio y el segundo que creado el objeto con todos los atributos.
       */
       public vehiculo(){};
       public vehiculo(String marca, String matricula, int numeroDeKm, int diaMatriculacion, int mesMatriculacion, int anioMatriculacion, String descripcion, double precio, String propietario, String dni){
           this.marca = marca;
           this.matricula = matricula;
           this.numeroDeKm = numeroDeKm;
           this.diaMatriculacion = diaMatriculacion;
           this.mesMatriculacion = mesMatriculacion;
           this.anioMatriculacion = anioMatriculacion;
           this.descripcion = descripcion;
           this.precio = precio;
           this.propietario = propietario;
           this.dni = dni;
       }
       
       
       //___________________________________________________________________________________________________________________________________________________________________________________________________________________________
       /**
        * A continuacion para los siguientes metodos, reciben string, int o double y actualizar los atributos del objetos dependendiendo
        * de que metodo se llame. 
        * Son public de modo que sean accesibles desde cualquier parte. 
        * 
        */
       
       
       public void allSet (String marca, String matricula, int numeroDeKm, int diaMatriculacion, int mesMatriculacion, int anioMatriculacion, String descripcion, double precio, String propietario, String dni){
           this.marca = marca;
           this.matricula = matricula;
           this.numeroDeKm = numeroDeKm;
           this.diaMatriculacion = diaMatriculacion;
           this.mesMatriculacion = mesMatriculacion;
           this.anioMatriculacion = anioMatriculacion;
           this.descripcion = descripcion;
           this.precio = precio;
           this.propietario = propietario;
           this.dni = dni;
       }
       
       //___________________________________________________________________________________________________________________________________________________________________________________________________________________________
       
        public void actualizarMarca(String marca){
           this.marca = marca;
        }
        public void actualizarMatricula(String matricula){
           this.matricula = matricula;
        }
        
        public void actualizarKm(int numeroDeKm){
           this.numeroDeKm = numeroDeKm;}
        
        public void actualizarDiaMatriculacion(int diaMatriculacion){
           this.diaMatriculacion = diaMatriculacion;}
        
        public void actualizarMesMatriculacion(int mesMatriculacion){
           this.mesMatriculacion = mesMatriculacion;}
        
        public void actualizarAnioMatriculacion(int anioMatriculacion){
           this.anioMatriculacion = anioMatriculacion;}
        
        public void actualizarDescripcion(String descripcion){
           this.descripcion = descripcion;}
        
        public void actualizarPrecio(double precio){
           this.precio = precio;}
        
        public void actualizarPropietario(String propietario){
           this.propietario = propietario;}
        
        public void actualizarDni(String dni){
           this.dni = dni;}
     
       //public int get_Anios(){
           //int anosDeAntiguedad;
           //anosDeAntiguedad = (2021 - fecha que se matriculo);
           //return anosDeAntiguedad;
       //}
       
       //___________________________________________________________________________________________________________________________________________________________________________________________________________________________ 
        
       /**
        * 
        * Los siguiente metodos son metodos getter, de modo que al llamarlos devuelven un string, int o double del atributo en cuestion. 
        *
     *  
        */
       public String verMarca(){
           return marca;
       } 
       
       public String verMatricula(){
           return matricula;
       }
       
       public int verNumeroDeKm(){
           return numeroDeKm;
       }
       public String verPropietario(){
           return propietario;
       }
       public double verPrecio(){
           return precio;
       }
       public String verDescripcion (){
           return descripcion;
       }
       public int verAnioMatriculacion(){
           return anioMatriculacion;
       }
       public int verMesMatriculacion(){
           return mesMatriculacion;
       }
       public int verDiaMatriculacion(){
           return diaMatriculacion;
       }
       
       //___________________________________________________________________________________________________________________________________________________________________________________________________________________________
       /**
        * 
        * Este motodo es el unico que realizar una operacion. 
        * @param anios Los anios actuales
        * Calcula la diferencia entre la matriculacion. 
        * @return los anios de antiguedad
        */
       public int get_Anios(int anios){
               antiguedad = (anios-anioMatriculacion);
               return antiguedad;
       }
       
       
       //___________________________________________________________________________________________________________________________________________________________________________________________________________________________
       /**
        * Nuevo metodo creado para devolver los paramentros inferiores
        * @return marca, matricula, numeroDeKm, precio, fecha de matriculacion, propietario y dni. 
        */
       
       
       public String toString(){
           return ("La marca es "+this.marca+".\n"+
                   "La matricula es "+this.matricula+".\n"+
                   "El numero de km son "+this.numeroDeKm+".\n"+
                   "El precio es :"+this.precio+".\n"+
                   "La fecha de matriculacion (anio, mes y dia) es "+
                   this.anioMatriculacion+" "+
                   this.mesMatriculacion+" "+
                   this.diaMatriculacion+".\n"+
                   "El propietario del vehiculo es: "+this.propietario+".\n"+
                   "El DNI es " +this.dni+".\n");
       }
       //___________________________________________________________________________________________________________________________________________________________________________________________________________________________
       /**
        * El metodo a continuacion se ha utilizado para devolver unicamente marca, matricula y precio. 
        * @return devuelve string con marca, matricula y precio.
        */
       public String toStringMarcaMatriculaPrecio(){
           return("La marca es " + this.marca+".\n"+
                  "La matricula es " + this.matricula+".\n"+
                  "El precio es " + this.precio);
       }

    @Override
    public int compareTo(vehiculo x) {
        if((this.verMatricula()).compareTo(x.verMatricula()) == 0) return 0;
        else if((this.verMatricula()).compareTo(x.verMatricula()) > 1) return 1;
        else return -1;
        }

  

   
    }
       /**public String toString(){
        return (this.brand+" "+
                this.model+" "+
                this.color+" "+
                "Dimensions (LxWxH in mm): "+
                this.length+"x"+
                this.width+"x"+
                this.height
                );
    }*/
       
       
    
    
    
    

