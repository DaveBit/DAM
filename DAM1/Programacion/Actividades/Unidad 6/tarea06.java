/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prog06_tarea;

import static com.mycompany.prog06_tarea.validaciones.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.*;
import javax.swing.JOptionPane;


/**
 *
 * @author David
 */
public class tarea06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion;
        boolean menu = true;
        Concesionario davidConcesionario = new Concesionario();
        String marca;
        String matricula;
        String dni;
        int numeroDeKm;
        int diaMatriculacion;
        int mesMatriculacion;
        int anioMatriculacion;
        int antiguedad;
        String descripcion;
        double precio;
        String propietario;
        //boolean dataOk = true;
        boolean estaMatricula = false;
        //vehiculo coche = null;
        int nuevoNumeroDeKm;
        LocalDate dateNow = LocalDate.now();
        Scanner scan = new Scanner (System.in);
        
        Pattern matriculaRegex = Pattern.compile("[0-9]{4}[A-Z]{3}");
        Pattern dniPropietarioPattern = Pattern.compile("[0-9]{8}[A-Z]{1}");
        Matcher matriculaMatcher;
        Matcher dniPropietarioMatcher;
            
       //Muestra por pantalla las opciones siguientes. 
       
       
       /**
        * Aqui en el siguiente loop vamos a pedir una opcion y salvo que se eliga 5 para salir o una opcion correcta, volveremos siempre al menu. 
        */
       do{
           do{ opcion = Integer.parseInt(JOptionPane.showInputDialog("¿Qué te gustaría hacer?\n1.Nuevo Vehiculo\n2.ListarVehiculo\n"
                   + "3.Buscar Vehiculo\n4.Modificar kms Vehiculo\n"
                   + "5.Sayonara Baby"));
            }
           while (opcion > 5 || opcion < 1);
           
           switch (opcion){
               case 1: 
                    System.out.println("Que marca es el vehiculo?");
                    marca  = scan.nextLine();
                    
                    /*
                    Pedimos por pantalla la matricula usamor, la expresiones regular para que sea un formato correcto, si no lo es, volveremos a pedir la matricula. 
                    */
                    do{
                    System.out.println("Cual es la matricula?\n Debe seguir el siguiente patron:0000AAA con mayusculas");
                    matricula = scan.nextLine();
                    matriculaMatcher = matriculaRegex.matcher(matricula);
                    estaMatricula = false;
                 
                    /*
                    Si la matricula es correcta, buscaremos en el array y dependiendo si esta o no, imprimiremos un mensaje u otro. 
                    */
                    if(matriculaMatcher.matches()){
                        for (int i = 0; i< davidConcesionario.checkLenghtVehiculos(); i++){
                            if(davidConcesionario.buscarMatricula(matricula)){
                                //System.out.println("La matricula ya ha sido insertada");
                                estaMatricula = true;
                                break;
                            }
                            
                            
                            /**if(davidConcesionario.isNull(i)){
                                continue;
                            }
                            else if (davidConcesionario.buscarMatricula(matricula)){
                                System.out.println("La matricula ya ha sido insertada");
                                break;
                                
                            }
                            if (davidConcesionario.isNull(i)== false && davidConcesionario.buscarMatricula(matricula) == false){
                                System.out.println("La matricula es correcta y no esta actualmente registrada");
                                break;*/
                            }
                        if(estaMatricula){
                            System.out.println("La matricula ya ha sido insertada, volvamos a empezar");
                            
                        }
                        else {
                            System.out.println("La matricula es correcta y no esta insertada, podemos continuar");
                            }
                                                                        
                    }
                    
                    
                    }
                    while(!matriculaMatcher.matches() | estaMatricula == true);
                    

                     System.out.println("Cual es el numero de kilometros?\nNo puede ser menor que 0");
                    numeroDeKm = scan.nextInt();
                    scan.nextLine();
                    /**
                     * Aqui se usa el metodo estatico de validacion para los kilometros, si estos son menos que 0, el programa vuelve al menu. 
                     * Al metodo le mandamos el numerDeKm insertado. 
                     */
                    if(!validaciones.validarKM(numeroDeKm)){
                        //dataOk = false;
                        System.out.println("Los km no puede ser menores que 0.\n Volvamos a empezar");
                        break;
                    }
                                  
                  /*
                    Aqui hemos utilizado lo mismo que en la practica numero 5. Comprobara el anio que se introduce. 
                    */
                    System.out.println("Cual es la fecha de matriculacion?"+"\nIntroduce primero el anio: ");
                    anioMatriculacion = scan.nextInt();
                    scan.nextLine();
                    
                    System.out.println("Introduce el mes en numero: ");
                    mesMatriculacion = scan.nextInt();
                    scan.nextLine();
                    
                    System.out.println("Introduce el dia: ");
                    diaMatriculacion = scan.nextInt();
                    scan.nextLine();
                    
                    LocalDate fechaMatriculacion = LocalDate.of(anioMatriculacion, mesMatriculacion, diaMatriculacion);
                    System.out.println("La fecha de matriculacion es: " + fechaMatriculacion); //prints "2017-11-06"      
                    
                    /**
                     * Aqui volvemos a hacer uso de un metodo statico de clase validacion, pasamos el anio mes y dia de matriculacion, 
                     * si es correcto, significa que la fecha actual es superior a la fecha de matriculacion. 
                     * De lo contrario, el programa hace uso del boolean dataOk como en otras ocasiones y vuelve al menu principal. 
                     */
                    if (validarFechaMatriculacion(anioMatriculacion, mesMatriculacion, diaMatriculacion) == true){
                    System.out.println("La fecha actual es superior a la fecha registrada, todo ok");
                    }   
                    else{
                     System.out.println("Parece que algo fue mal, volvamos a empezar: ");
                            //dataOk=false;
                            break;
                    }
                    
                    System.out.println("Introduce la descripcion: ");
                    descripcion = scan.nextLine();
                    try{
                    System.out.println("Cual es el precio?");
                    precio = scan.nextDouble();
                    scan.nextLine();
                    }
                    catch (Exception generic){
                        System.out.println("Parece que algo fue mal, volvamos a empezar");
                        break;
                    }
                    /*
                    He probado muchas cosas aqui y no he sido capaz de ejecutar esta parte del codigo como se espera. Seguire trabajando en ello.
                    */
                    try{
                    do{
                    System.out.println("Cual es tu nombre?\nDebe tener un nombre y minimo dos apellidos\nFormato asi: \"Nombre Apellido Apellido2\"");
                    propietario = scan.nextLine();
                    
                    
                    int lastIdx = propietario.lastIndexOf(' ');
                    int idx = propietario.indexOf(' ');
                    String firstname, middlename, lastname = null;
                                                        
                    
                    firstname = propietario.substring(0, idx);
                    middlename = propietario.substring(idx+1, lastIdx);
                    lastname = propietario.substring(lastIdx+1, propietario.length());
                    System.out.println("Tu nombre es: "+ firstname +" "+ middlename +" "+ lastname);
                    }
                    
                    while(propietario.lastIndexOf(propietario)>40);
                    
                    }
                    
                    catch (Exception generic){
                        System.out.println("El nombre debe tener menos de 40 caracteres y al menos dos apellidos no compuestos. ");
                        break;
                    }
                    
                    
                    /*
                    Del mismo modo hemos utilizado aqui la validacion del ejercicio anterior. 
                    */
                    do{
                    System.out.println("Cual es tu DNI?\nIntroduce el numero y la letra mayuscula sin guion");
                    dni = scan.nextLine();
                    dniPropietarioMatcher = dniPropietarioPattern.matcher(dni);
                    
                        if(dniPropietarioMatcher.matches()){
                            System.out.println("Se ha introducido el DNI de manera correcta. "); 
                            break;
                        }
                    }
                    while (!dniPropietarioMatcher.matches());
                    
                    System.out.println(davidConcesionario.insertarVehiculo(marca, matricula, numeroDeKm, diaMatriculacion, mesMatriculacion, anioMatriculacion, descripcion, precio, propietario, dni));
                    System.out.println("Enhorabuena, tu vehiculo ha sido creado");
                    break;
                   /*
                           Lista los vehiculos si los hay. si no vuelve al menu. 
                           */
               case 2:
                   if(!davidConcesionario.isEmpty())
                   davidConcesionario.listaVehiculos();
                   else{
                       System.out.println("El concesionario esta vacio. Volvemos al menu.");
                   }
                   break;
                       
                 /*
                   busca la matricula y la devuelve, si no hay vehiculo lo indica tambien por medio de la funcion de la clase concesionario. 
                   */  
                  
               case 3:
                   String matriculabuscar = JOptionPane.showInputDialog("Introduce la matricula");
                   System.out.println(davidConcesionario.buscarVehiculo(matriculabuscar));
                   
                   break;
                   
                   /*
                   actualiza el numero de km.
                   */
               case 4:
                   
                   matriculabuscar = JOptionPane.showInputDialog("Introduce la matricula");
                   nuevoNumeroDeKm = Integer.parseInt(JOptionPane.showInputDialog("Por favor introduce los nuevos KM, no puede ser inferiores a los actuales"));

                   if(davidConcesionario.buscarMatricula(matriculabuscar)){
                            System.out.println(davidConcesionario.actualizarKms(matriculabuscar, nuevoNumeroDeKm));
                       
                   }
                   else {
                       System.out.println("El numero de matricula no ha sido encontrado");
                   }
                   
                   break;
                   
                   /*
                   Sale del programa indicando exito. 
                   */
               case 5:
                   
                   System.exit(0);
                   menu = false;
                   break;
                   
           }
       
       
       
       
       
       
    }
       while (menu == true);
        
    }

    private static String JOptionPane(String introduce_la_matricula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
