/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prog05_ejerc01;

/**
 *
 * @author David
 * Esta clase es utilizada para crear objetos de la clase vehiculo. 
 * Los atributos han sido establecidos en private, de modo que solo pueden ser manipulados desde la clase. 
 */
public class vehiculo {

       private String marca;
       private String matricula;
       private int numeroDeKm;
       private int diaMatriculacion;
       private int mesMatriculacion;
       private int anioMatriculacion;
       private String descripcion;
       private double precio;
       private String propietario;
       private String dni;
       private int antiguedad;
       
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
       /**
        * A continuacion para los siguientes metodos, reciben string, int o double y actualizar los atributos del objetos dependendiendo
        * de que metodo se llame. 
        * Son public de modo que sean accesibles desde cualquier parte. 
        * 
        */
        public void actualizarMarca(String marca){
           this.marca = marca;
        }
        public void actualizarMatricula(String matricula){
           this.matricula = matricula;
        }
        
        public void actualizarKm(int numeroDeKm){
           this.numeroDeKm = numeroDeKm;}
        
        public void actualizarDescripcion(String descripcion){
           this.descripcion = descripcion;}
        
        public void actualizarPrecio(double precio){
           this.precio = precio;}
        
        public void actualizarPropietario(String propietario){
           this.propietario = propietario;}
        
        public void actualizarDni(String dni){
           this.dni = dni;}
        
        public void actualizarDiaMatriculacion(int diaMatriculacion){
           this.diaMatriculacion = diaMatriculacion;}
        
        public void actualizarMesMatriculacion(int mesMatriculacion){
           this.mesMatriculacion = mesMatriculacion;}
        
        public void actualizarAnioMatriculacion(int anioMatriculacion){
           this.anioMatriculacion = anioMatriculacion;}

        
        
     
       //public int get_Anios(){
           //int anosDeAntiguedad;
           //anosDeAntiguedad = (2021 - fecha que se matriculo);
           //return anosDeAntiguedad;
       //}
       
       /**
        * Los siguiente metodos son metodos getter, de modo que al llamarlos devuelven un string, int o double del atributo en cuestion. 
        *
        */
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
       /**
        * Este motodo es el unico que realizar una operacion. 
        * @param anios Los anios actuales
        * Calcula la diferencia entre la matriculacion. 
        * @return los anios de antiguedad
        */
       public int get_Anios(int anios){
               antiguedad = (anios-anioMatriculacion);
               return antiguedad;
       }
       
       
       
    
    
    
    
}
