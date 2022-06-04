/*
 * en cuantos  a las validaciones, el DNI ha sido adquirido de los ejercicio de ejemplo. Y se han incluido dos metodos mas. 
 */
package prog09x_tarea;
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

    
    //_______________________________________________________________________________________________________________________________________________
    
    private static char extraerLetraNIF(String nif) {
        char letra = nif.charAt(nif.length() - 1);
        //return letra;
        return Character.toUpperCase(letra); //Devolvemos su equivalente en mayúscula para poder comparar con las letras de la cadena LETRAS_DNI
    }
    
    //________________________________________________________________________________________________________________________________________________

    private static int extraerNumeroNIF(String nif) {
        int numero = Integer.parseInt(nif.substring(0, nif.length() - 1));
        return numero;
    }
    
    //________________________________________________________________________________________________________________________________________________
    
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
    
    //________________________________________________________________________________________________________________________________________________
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
    
    //________________________________________________________________________________________________________________________________________________
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
    
    //________________________________________________________________________________________________________________________________________________
    
    private static boolean noDigits(String nombre){
        boolean esLetra=true; //estara en TRUE siempre que el caracter sea una letra
        //Recorrera la cadena buscando digitos
        for(int i=0; i<nombre.length() && esLetra; i++){
            //comprueba que sea una letra o un espacio en blaco
            esLetra = Character.isLetter(nombre.charAt(i)) || Character.isWhitespace(nombre.charAt(i));
            
        }
        return esLetra;
    }
    
    //________________________________________________________________________________________________________________________________________________
    
    private static byte countWords(String nombre){
        byte contador=0; //cuenta las palabras. 
        int indice; //indica donde se encuentra el primer espacio
        do{
            contador++;
            indice =nombre.indexOf(' ');
            if (indice!=-1){
                nombre=nombre.substring(indice); //subcadena desde el primer espacio hasta le final.
                nombre=nombre.trim(); //elimina el espacio al principio de la cadena. 
            }
        }while (indice!=-1 && contador<Byte.MAX_VALUE);
        
        return contador;
    }
    
    //________________________________________________________________________________________________________________________________________________
    
    public static boolean checkName(String nombre){
        final byte MAX_CARACTERES=40;
        final byte NUM_PALABRAS=3;
        boolean nombreValido =false;
        
        if(nombre.length()>=MAX_CARACTERES){
            System.out.println("el nombre excede el numero de caracteres");
            
        }
        else if(countWords(nombre)!=NUM_PALABRAS){
            System.out.println("el nombre es incorrecto, debe contener 1 nombre y dos apellidos");
        }
        else if(!noDigits(nombre)){
            System.out.println("El nombre contiene caracteres no permitidos");
        }
        else {
            nombreValido=true;
        }
        return nombreValido;
}
}
