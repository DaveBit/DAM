/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prog04_ejerc3;

import java.util.Scanner;
import java.lang.ArithmeticException;

/**
 *
 * @author David
 */
public class PROG04_Ejerc3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int dividendo, divisor, resultado;
        int divisionCantidad = 0;
        
        //4 variables son creadas, dividendo, divisor y resultado. Tambien una variables contador para ver el numero de divisiones efectuadas. 
        
        
        Scanner division = new Scanner(System.in);
        System.out.println("Introduce el dividendo y despues el divisor");
        //creamos el objeto de tipo scanner division y preguntamos por los valores en order. 
        try {
        do{
            System.out.println("Dividendo:");
            dividendo = division.nextInt();
            System.out.println("Divisor:");
            divisor = division.nextInt();
            resultado = dividendo/divisor;
            System.out.println("El resultado es: " + resultado);
            divisionCantidad++;
            
            }
        while (dividendo !=-1 & divisor !=-1);
        //con try indicamos el bloque que podria causar problemas. 
        // hemos utilizado los metodos del tipo scanner para insertar dividendo y divisor. 
        // en cada iteracion se sumara 1 a la cantidad. 
        }
        catch (ArithmeticException e){
            System.out.println("An exception has occured. You can't divide by 0");
            
        }
        catch (Exception generic){
            System.out.println("Una excepcion ha ocurrido");
        }
        //con los metodos catch, identificamos los problemas e ofrecemos una alternativa al programa. 
        //Primero hemos usado la exception concreta ArithmeticException y posteriormente la superclasse exception. 
        //el motivo de poner esta dpues de la concreta es porque al ser Exception una superclasse, cualquier error seria capturado por ella primero. 
        //dejando fuera el ArithmeticException. 
        finally{
            System.out.println("El numero de divisiones ha sido "+divisionCantidad+ " .");
        }
        
        //pase lo que pase, el mensaje en finally sera impreso. 
        
                
       
            
        
       
       
    }
    
}
