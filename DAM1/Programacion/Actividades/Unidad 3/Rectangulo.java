package com.prog03.figuras;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */
/**
 *
 * @author David
 */
public class Rectangulo {
    private double base;
    private double altura;
    
    public Rectangulo(){};
    public Rectangulo(double base, double altura){
            this.base = base;
            this.altura = altura;
    //en esta practica hemos utilizado this, de modo que la variable local no es confundida con la variable parametro. 
    };
    public void actualizarBase (double base){
        this.base = base;
    }
    public void actualizarAltura (double altura) {
        this.altura = altura;
    }
    public double obtenerBase (){
        return base;
    }
    public double obtenerAltura (){
        return altura;
    }
    public float getArea(){
    return (float)((base*altura)/2);
    
    }
    public String ToString(){
        return "La altura del rectangulo es " + altura + "\n El area del rectangulo es " + getArea();
    } 
    public boolean isCuadrado(){
        return base==altura;
    }
}
