/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rappi.test.hackerrank;

/**
 *
 * @author ASD
 */
public class Matrix {
    
    private int [][][]matriz;
    private int tamanio;
    private int numOperaciones;
    private Object[] colaOperaciones;
    
    public Matrix(){
    }

    public int[][][] getMatriz() {
        return matriz;
    }

    public void setMatriz() {
        this.matriz = new int[tamanio][tamanio][tamanio];
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public int getNumOperaciones() {
        return numOperaciones;
    }

    public void setNumOperaciones(int numOperaciones) {
        this.numOperaciones = numOperaciones;
    }

    public Object[] getColaOperaciones() {
        return colaOperaciones;
    }

    public void setColaOperaciones() {
        this.colaOperaciones = new Object[numOperaciones];
    }
}
