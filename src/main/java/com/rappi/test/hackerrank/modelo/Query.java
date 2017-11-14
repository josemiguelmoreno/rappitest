/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rappi.test.hackerrank.modelo;

/**
 *
 * @author ASD
 */
public class Query {

    private int coordenadaInferior;
    private int coordenadaSuperior;
    private String nombre;

    public Query(String nombre) {
        this.nombre = nombre;
    }

    public int getCoordenadaInferior() {
        return coordenadaInferior;
    }

    public void setCoordenadaInferior(int coordenadaInferior) {
        this.coordenadaInferior = coordenadaInferior;
    }

    public int getCoordenadaSuperior() {
        return coordenadaSuperior;
    }

    public void setCoordenadaSuperior(int coordenadaSuperior) {
        this.coordenadaSuperior = coordenadaSuperior;
    }

    public String getEntrada() {
        return coordenadaInferior + " " + coordenadaInferior
                + " " + coordenadaInferior + " " + coordenadaSuperior + " " + coordenadaSuperior
                + " " + coordenadaSuperior;
    }

    public int getSumaCoordenadasSalida(int[][][] matriz) {
        int valor = 0;
        for (int i = coordenadaInferior - 1; i <= coordenadaSuperior - 1; i++) {
            valor += matriz[i][i][i];
        }
        return valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
