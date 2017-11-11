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
public class Update {

    private int coordenadasXYZ;
    private int valorCoordenadas;
    private String nombre;

    public Update(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCoordenadasXYZ() {
        return coordenadasXYZ;
    }

    public void setCoordenadasXYZ(int coordenadasXYZ) {
        this.coordenadasXYZ = coordenadasXYZ;
    }

    public int getValorCoordenadas() {
        return valorCoordenadas;
    }

    public void setValorCoordenadas(int valorCoordenadas) {
        this.valorCoordenadas = valorCoordenadas;
    }

    public String getEntrada() {
        return coordenadasXYZ + " " + coordenadasXYZ
                + " " + coordenadasXYZ + " " + valorCoordenadas;
    }

    public void actualizarCoordenada(int[][][] matriz) {
        matriz[coordenadasXYZ - 1][coordenadasXYZ - 1][coordenadasXYZ - 1] = valorCoordenadas;
    }
}
