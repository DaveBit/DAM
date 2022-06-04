/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prog03.Principal;

import com.prog03.figuras.Rectangulo;


/**
 *
 * @author David
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creacion de los dos rectangulos con el constructor de la clase y atributos 0. 
        Rectangulo rect1 = new Rectangulo();
        Rectangulo rect2 = new Rectangulo();
        
        //comprobacion de obtenerAltura para los dos rectangulos iniciales. 
        System.out.println(rect1.obtenerAltura()); 
        System.out.println(rect1.obtenerBase());
        System.out.println(rect2.obtenerAltura());
        System.out.println(rect2.obtenerBase());
        
        //comprobacion de los metodos actualizarAltura y actualizarBase. 
        rect1.actualizarAltura(100);
        rect1.actualizarBase(100);
        rect2.actualizarAltura(100);
        rect2.actualizarBase(150);
        
        //comprobacion de que los cambios se han llevado a cabo. 
        System.out.println("Altura de rect1 despues de actualizar " +rect1.obtenerAltura()); 
        System.out.println("Base de rect1 despues de actualizar " +rect1.obtenerBase());
        System.out.println("Altura de rect2 despues de actualizar " +rect2.obtenerAltura());
        System.out.println("Base de rect2 despues de actualizar " +rect2.obtenerBase());
        
        //Comprobacion del metodo getAre para rect1 y rect2. 
        System.out.println(rect1.getArea());
        System.out.println(rect2.getArea());
        
        //comprobacion del metodo ToString e isCuadrado para rect1 y rect2. 
        System.out.println(rect1.ToString());
        System.out.println("El rectagulo uno es cuadrado? " +rect1.isCuadrado());
        System.out.println(rect2.ToString());
        System.out.println("El rectangulo dos es cuadrado? " +rect2.isCuadrado());
        
        
        //testeo de la creacion de un tercer objeto con asignacion directa de parametros usando el constructor que inicializa base y altura.
        //Tambien se ha probado obtenerAltura, obtenerBase, getArea, toString e isCuadrado. 
        Rectangulo rect3 = new Rectangulo(200,200);
        System.out.println("Alura del rectangulo 3 " +rect3.obtenerAltura()); 
        System.out.println("Base del rectangulo 3 " +rect3.obtenerBase());
        System.out.println("Area del rectangulo 3 " + rect3.getArea());
        System.out.println("Comprobacion de el metodo Tostring \n" +rect3.ToString());
        System.out.println("Es rectangulo tres es cuadrado? " + rect3.isCuadrado());
        
        
    }
    
}
