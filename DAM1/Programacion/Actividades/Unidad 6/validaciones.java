/*
 * en cuantos  a las validaciones, el DNI ha sido adquirido de los ejercicio de ejemplo. Y se han incluido dos metodos mas. 
 */
package com.mycompany.prog06_tarea;
import java.time.LocalDate;

/**
 *
 * @author David
 */
public class validaciones { 
    private int numDNI;
    private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
    private static char calcularLetraNIF(int dni) {
        char letra;
        // Cálculo de la letra NIF
        letra = LETRAS_DNI.charAt(dni % 23);
        // Devolución de la letra NIF
        return letra;
    }

    private static char extraerLetraNIF(String nif) {
        char letra = nif.charAt(nif.length() - 1);
        //return letra;
        return Character.toUpperCase(letra); //Devolvemos su equivalente en mayúscula para poder comparar con las letras de la cadena LETRAS_DNI
    }

    private static int extraerNumeroNIF(String nif) {
        int numero = Integer.parseInt(nif.substring(0, nif.length() - 1));
        return numero;
    }

    public static boolean validarNIF(String nif) throws Exception  {
        boolean valido = true;   // Suponemos el NIF válido mientras no se encuentre algún fallo
        char letra_calculada;
        char letra_leida;
        int dni_leido;

        if (nif == null) {  // El parámetro debe ser un objeto no vacío
            valido = false;

        } else if (nif.length() < 8 || nif.length() > 9) {    // La cadena debe estar entre 8(7+1) y 9(8+1) caracteres
            valido = false;
            throw new Exception ();

        } else {
            letra_leida = validaciones.extraerLetraNIF(nif);    // Extraemos la letra de NIF (letra)
            dni_leido = validaciones.extraerNumeroNIF(nif);  // Extraemos el número de DNI (int)
            letra_calculada = validaciones.calcularLetraNIF(dni_leido);  // Calculamos la letra de NIF a partir del número extraído
            if (letra_leida != letra_calculada) {   // Comparamos la letra extraída con la calculada
                throw new Exception ();
            }
        }
        return valido;
    }
    /**
     * el siguiente metodo valida que los KM insertados sean positivos. 
     * @param numeroKM Que ha insertado el usuario
     * @return True si es positivo y false si es negativo
     */
    public static boolean validarKM (int numeroKM){
        if(numeroKM>=0){
            return true;            
        }
        return false;
        
    }
    /**
     * Calcula si la fecha de matriculacion es posterio a la actual. 
     * @param x es el anio de matriculacion
     * @param y es el mes de matriculacion
     * @param z es el dia de matriculacion
     * @return devuelve True si la fecha es anterior o igual, false si la fecha es menor.
     */
    public static boolean validarFechaMatriculacion(int x, int y, int z){
        LocalDate dateNow = LocalDate.now(); 
        LocalDate fechaMatriculacion = LocalDate.of(x, y, z);
                                        
                    if (dateNow.compareTo(fechaMatriculacion) >= 0) {
                            return true;
                    } 
                    else {
                            return false;  
                    }            
    }
}
