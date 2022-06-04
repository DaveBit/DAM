/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prog04_ejerc1;

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.lang.Integer;

/**
 *
 * @author David
 */
public class PROG04_Ejerc1 {

    /**
     * @param args the command line arguments
     */
//He utilizado un array de numeros para posteriormente utilizardos como multiplicadores. 
//Con la intencion de practicar, he utilizar la estructura switch, de modo que la opcion que se seleccione calculara
//la tabla de manera diferente pero con igual resultado.     
    public static void main(String[] args) {
        int[] tablaDeMultiplicar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int opcion;
        int tablaDel;

        //se ha creado la array tablaDeMultiplicar y el int opcion asi podremos redireccionar el metodo a usar dependiendo del introducido por el usuario. 
        //tambien el int tablaDel que es la table que multiplicaremos. 
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("How would you like to calculate the table? \n Option 1 is a for/each/in, Option 2 is a foor loop and Option 3 is a do while. \n Please insert a number between 1 and 3, both included."));

        } while (opcion <= 0 || opcion > 3);
        //Aqui pedimos que se inserte de nuevo el numero por medio de el metodo statico JOptionPane.showInputdialog mientras que no este entre 1 y 3. 

        tablaDel = Integer.parseInt(JOptionPane.showInputDialog("Qué tabla te gustaría calcular? \n Por favor introduce un numero entre entre 1 y 29, ambos incluidos "));
        if (tablaDel >= 30) {
            JOptionPane.showMessageDialog(null, "Te lo advertimos! Menor que 30!");
            System.exit(0);
        }
        //preguntamos por la tabla que queremos calcular y anadimos la condicion if para que sea menor que 30, si es igual o mayor, lanzamos un mensaje y salimos del programa. 
        //hemos utilizado JoptionPane y ademas la clase integer con el metodo parseInt para tranformar el input string en int. 

        switch (opcion) {
            case 1:
                System.out.println("Has seleccionado la opcion 1. For each");
                System.out.println("La tabla de multiplicar del " + tablaDel + " es: ");

                for (int resultado : tablaDeMultiplicar) {
                    System.out.println(+tablaDel + "*" + resultado + " = " + (resultado * tablaDel));
                }

            //la primera parte de for/in/each nos crea la variable resultado que va a contener en cada iteracion el valor del array para i, en la segunda parte, el array que queremos ir a traves. 
            //Al cambiar el resultado continuamente y estar imprimiendo mediante println la multiplicacion de tabaDel por el resultado, tenemos la tabla representada.
            case 2:
                System.out.println("Has seleccionado la opcion 2. For loop. ");
                System.out.println("La tabla de multiplicar del " + tablaDel + " es: ");

                for (int i = 1; i <= 10; i++) {
                    System.out.println(+tablaDel + "*" + i + " = " + (i * tablaDel));
                }
            //Un for clasico, tenemos 10 multiplicadores, empezamos con 1 y para no salirnos del array, establecemos que se repita el loop hasta que i sea mayor que 10. pues de i=1 a i=10 hay 10 iteraciones. 

            case 3:
                System.out.println("Has seleccionado la opcion 3. Do While loop.");
                System.out.println("La tabla de multiplicar del " + tablaDel + " es: ");

                int i = 1;
                while (i <= 10) {
                    System.out.println(+tablaDel + "*" + i + " = " + (i * tablaDel));
                    i++;
                }
            //en la parte superior imprimimos el resultado mientras que i sea <=10.
        }

        //en la parte superior el metodo swith con los diferentes loops. 
    }
}
