/**
 * @autor David 
 * A continuacion se han importado todos las apis que utilizaremos en nuestra aventura. 
 * JOptionPane para el menu principal. 
 * LocalDate para trabajar con las fechas. 
 * Scanner, un clasido. 
 * Asi como la clase vehiculo. 
 * Tambien la clase validaciones. 
 */
package com.mycompany.prog05_ejerc01;
import PROG05_Ejerc1_util.validaciones;
import static PROG05_Ejerc1_util.validaciones.validarFechaMatriculacion;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.Scanner;
import com.mycompany.prog05_ejerc01.vehiculo;

/**
 *
 * @author David Alvarez
 * el programa principal, se hace las opciones descritas en la tarea del ejercicio.
 * Algunas son, crear el objeto, indicar el propietario, fecha de matriculacion... etc. 
 */
public class PROG05_Ejerc1 {

    /**
     * el metodo main del programa. 
     */
    public static void main(String[] args) {
        /**Los atritutos del programa
         * No requieren de mucha explicacion. 
         * Para trabajar con las fechas y preguntar por el anio mes y dia hemos creado 3 int. 
         * el boolean dataOk nos ayuda a verificar KM, Fecha y DNI son correctos, de lo contrario cambia a false y el proceso empieza de nuevo.
         * Tambien hemos creado la variable coche de la clase vehiculo como null, de modo que si todo se cumple sea el objeto creado. 
         */
        String marca;
        String matricula;
        int numeroDeKm;
        
        int opcion;
        LocalDate dateNow = LocalDate.now();
        int diaMatriculacion;
        int mesMatriculacion;
        int anioMatriculacion;
        int antiguedad;
        String descripcion;
        double precio;
        String propietario;
        boolean dataOk = true;
        vehiculo coche = null;
        int nuevoNumeroDeKm;
        Scanner scan = new Scanner (System.in);
        
        
        /**
         * el programa esta metido en un loop Do-while, de modo que si la informacion que hemos comentado no es correcta
         * El programa volvera al menu principal. 
         */
        do{
            /**
             * este do while no deja en el menu si no indicamos la opcion correcta. 
             */
            do{
                    opcion = Integer.parseInt(JOptionPane.showInputDialog("Hola, este es el menu de la aplicacion.\nPor favor, selecciona una opcion:\n1.Nuevo Vehiculo\n2.Ver Matricula\n3.Ver Numero de Kilometros\n4.Actualizar kilometros\n5.Ver anos de antiguedad\n6.mostrar propietario\n7.Mostrar descripcion\n8.Mostrar Precio\n9.Salir"));
            }
            while (opcion <1 || opcion >9);


            /**
             * A continuacion se ha usado un swith, dependiendo de la opcion seleccionada, se llevara a cabo una accion. 
             * Pasamos a explicar las opciones "complicadas"
             */    
            switch (opcion){
                case 1:
                                                            
                    System.out.println("Que marca es el vehiculo?");
                    marca  = scan.nextLine();
                    
                    System.out.println("Cual es la matricula?");
                    matricula = scan.nextLine();

                    System.out.println("Cual es el numero de kilometros?\nNo puede ser menor que 0");
                    numeroDeKm = scan.nextInt();
                    scan.nextLine();
                    /**
                     * Aqui se usa el metodo estatico de validacion para los kilometros, si estos son menos que 0, el programa vuelve al menu. 
                     * Al metodo le mandamos el numerDeKm insertado. 
                     */
                    if(!validaciones.validarKM(numeroDeKm)){
                        dataOk = false;
                        break;
                    }
                                  
                  
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
                            dataOk=false;
                            break;
                    }
                    
                    System.out.println("Introduce la descripcion: ");
                    descripcion = scan.nextLine();
                   
                    System.out.println("Cual es el precio?");
                    precio = scan.nextDouble();
                    scan.nextLine();
                    
                    System.out.println("Cual es tu nombre?");
                    propietario = scan.nextLine();
                    
                    System.out.println("Cual es tu DNI?\nIntroduce el numero y la letra sin guion");
                    String dni = scan.nextLine();
                    
                    /**
                     * Aqui utilizamos el metodo para validar del NIF que nos ha facilitado el temario. 
                     * Ademas utilizamos una trycatch. Si sale true, el programa sigue, si sale false, se capta el error y volvemos a empezar.
                     */
                    try{
                    validaciones.validarNIF(dni);
                    }
                    catch (Exception generic){
                        System.out.println("El DNI es erroneo, ahora tenemos que volver a empezar...");
                        dataOk=false;
                        break;
                    }
                                             
                    /**
                     * Aqui comprobamos que efectivamente no hay coche y por lo tanto creamos el vehiculo. 
                     * Si hubiera vehiculo, la informacion seria actualizada. 
                     */
                    if (coche == null){
                    
                        coche = new vehiculo (marca, matricula, numeroDeKm, diaMatriculacion, mesMatriculacion, anioMatriculacion, descripcion, precio, propietario, dni);
                        System.out.println("El vehiculo ha sido creado.\nQue te gustaria hacer ahora?");
                        dataOk=false;
                        break;
                    }
                    else if (coche != null){
                        System.out.println("Ya has creado un coche. \nLa informacion facilitada sera actualizada.");
                        coche.actualizarMarca(marca);
                        coche.actualizarMatricula(matricula);
                        coche.actualizarKm(numeroDeKm);
                        coche.actualizarAnioMatriculacion(anioMatriculacion);
                        coche.actualizarMesMatriculacion(mesMatriculacion);
                        coche.actualizarDiaMatriculacion(diaMatriculacion);
                        coche.actualizarDescripcion(descripcion);
                        coche.actualizarPrecio(precio);
                        coche.actualizarPropietario(propietario);
                        coche.actualizarDni(dni);
                        
                        dataOk=false;
                        break;
                     
        
                        
                    }
                    break;
                  /**
                   * Los siguientes casos siguent todos la misma logica, si no hay vehiculo, lanza mensaje y vuelve a empezar, 
                   * Si hay vehiculo realiza la accion. 
                   */
                case 2:
                    if (coche == null){
                        System.out.println("El vehiculo no ha sido creado");
                        dataOk=false;
                        break;
                    }
                    else {
                        System.out.println("La matricula de tu vehiculo es: " + coche.verMatricula());
                    }
                    break;
                    
                case 3:
                    if (coche ==null){
                        System.out.println("el vehiculo no ha sido creado");
                        dataOk=false;
                        break;
                    }
                    else{
                        System.out.println("El vehiculo tiene: " + coche.verNumeroDeKm());
                    }
                    break;
                    /**
                     * En el caso inferior si al actualizar los km no son correctos, volvemos a empezar. 
                     * Otra opcion hubiera sido utilizar un metood en validaciones. 
                     */
                case 4:
                    if (coche == null){
                        System.out.println("El vehiculo no ha sido creado");
                        dataOk=false;
                        break;
                    }
                    else{
                        System.out.println("A continuacion vas a modificar los datos de tu vehiculo\nPor favor, inserta el numero actual y recuerda, no puede ser menor que el anterior:");
                        nuevoNumeroDeKm = scan.nextInt();
                        
                        if (nuevoNumeroDeKm < coche.verNumeroDeKm()){
                            System.out.println("El numero de KM introducido es menor que el actual.");
                            dataOk = false;
                            break;
                        }
                        else if (nuevoNumeroDeKm == coche.verNumeroDeKm()){
                        System.out.println("el numero de KM es el mismo.\n No hace falta actualizar ");
                        dataOk = false;
                        break;
                        
                        }
                        else {
                            System.out.println("El numero de KM ha sido actualizado");
                            coche.actualizarKm(nuevoNumeroDeKm);
                            System.out.println("El numero de KM actual es: " + coche.verNumeroDeKm());
                        }
                    }
                    break;
                    
                case 5:
                    if (coche == null){
                        System.out.println("El vehiculo no ha sido creado");
                        dataOk=false;
                        break;
                    }
                    else{
                        System.out.println(" tu coche tiene " + coche.get_Anios(dateNow.getYear()) + " de antiguedad");
                        
                        //antiguedad = (dateNow.getYear()-coche.verAnioMatriculacion());
                        //System.out.println("Tu vehiculo tiene " + antiguedad + " de antiguedad" );
                                                
                    }
                    break;
                    
                case 6:
                    if (coche == null){
                        System.out.println("El vehiculo no ha sido creado");
                        dataOk=false;
                        break;
                    }
                    else {
                        System.out.println("El propietario del vehiculo es: " + coche.verPropietario());
                    }
                    break;
                    
                case 7:
                    if (coche == null){
                        System.out.println("El vehiculo no ha sido creado");
                        dataOk=false;
                        break;
                    }
                    else {
                        System.out.println("La descripcion del vehiculo es la siguiente:\n" + coche.verDescripcion());
                    }
                    break;
                    
                case 8:
                    if (coche == null){
                        System.out.println("El vehiculo no ha sido creado");
                        dataOk=false;
                        break;
                    }
                    else {
                        System.out.println("El precio del vehiculo es: " + coche.verPrecio());
                    }
                    break; 
                    
                case 9:
                    dataOk = true;
                    System.runFinalization();
                    break;
            }
        }
        while (dataOk == false);
        /**
         * Si en alguno de los casos la informacion facilitada no funcionara, volveriamos a empezar y solo si se selecciona 9 el programa para. 
         */
    }
 }
   
 /**
                     * Esta parte del codigo es la realizacion inicial de este apartado 4 si nel uso de un metodo. 
                     * Esta aqui como referencia
                    if (dateNow.compareTo(fechaMatriculacion) > 0) {
                            System.out.println("La fecha actual es superior a la fecha registrada, todo ok");
                    } 
                    else if (dateNow.compareTo(fechaMatriculacion) < 0) {
                            System.out.println("La fecha de matriculacion es posterior a la actual");
                            dataOk=false;
                            break;     
                    } 
                    else if (dateNow.comp areTo(fechaMatriculacion) == 0) {
                            System.out.println("Coche nuevo nuevecito");
                    }
                    else {
                            System.out.println("Parece que algo fue mal, volvamos a empezar: ");
                            dataOk=false;
                            break;
                    }
                   */

