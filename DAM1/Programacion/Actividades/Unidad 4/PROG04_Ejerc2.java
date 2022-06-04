package com.mycompany.prog04_ejerc2;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author David
 */
public class PROG04_Ejerc2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner primo = new Scanner(System.in);
        int numero;
        System.out.println("El siguiente programa va a calcular 5 numeros primos");
        
        //una variable y un objeto tipo scanner para pedir que la insercion del numero a calcular que posteriormente se almacenara en numero. 

        for (int i = 0; i < 5; i++) {
         //el loop creado para pedir 5 numeros, los erroes tambien cuenta, introducir 0 o 1 tambien cuenta.        
            System.out.println("Introduce el primer numero");
            numero = primo.nextInt();
            //el numero introducido se almacena en numero si no se cumplen dos de las restricciones inferiores. 
            if (numero == 1 || numero == 0) {
                System.out.println("El 1 y el 0 no son primarios");
            //que el numero sea 1 o 0, pues no son primarios por convencion. 
            } else if (numero < 0) {
                System.out.println("El numero no puede ser negativo");
            // o un numero menor que 0 pues no tienen primarios. 
            } else {
            //si estas dos no pasas, vemos si es primo. 
            
                boolean esPrimo = true;
                for (int x = 2; x < numero; x++) {
                    if (numero % x == 0) {
                        System.out.println("El " + numero + " no es primo");
                        esPrimo = false;
                        break;
                    }
                }
                if (esPrimo == true) {
                    System.out.println("El numero es primo");
                }
            }
            //para ello hemos creado un boolean, para saber si es o no. 
            // un loop que empiece por 2, pues no tenemos que dividir entre 0 por posibles erroes y todos los numeros son divisibles entre 0. 
            //este for loop, comprobara que el remanente del numero elegido entre sus numeros entre 2 y el mismo no es 0, pues si hay un 0, el numero no es primo. 
            // el loop parara con break y no imprimira el mensaje pues el boolean es establecido en falso. 
            // si no hay remanente 0, entonces esPrimo seguira siendo true y al acabar el loop, el mensaje ultimo se imprimira. 
        }

    }

}
