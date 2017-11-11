/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rappi.test.hackerrank.negocio.impl;

import com.rappi.test.hackerrank.Matrix;
import com.rappi.test.hackerrank.modelo.Query;
import com.rappi.test.hackerrank.modelo.Update;
import com.rappi.test.hackerrank.negocio.iface.TestMatrixNegocio;
import com.rappi.test.hackerrank.util.VariablesEstaticas;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jose
 */
public class TestMatrixNegocioImpl implements TestMatrixNegocio {

    @Override
    public void ejecutarTestMatrix(int numCases, Scanner sc) {
        if (!isNumCasesValidos(numCases)) {
            System.err.println("El numero de casos a ejecutar supera el maximo");
            return;
        }
        List<Matrix> matrixList = new ArrayList<>();
        for (int i = 0; i < numCases; i++) {
            Matrix matrix = new Matrix();
            if (capturarEntradas(sc, matrix)) {
                matrixList.add(matrix);
            } else {
                i = i - 1;
            }
        }

        for (int i = 0; i < numCases; i++) {
            ejecutarCasos(matrixList.get(i));
        }
    }

    private boolean isNumCasesValidos(int numCases) {
        if (numCases > 0 && numCases <= VariablesEstaticas.getMAX_TEST_CASE()) {
            return true;
        }
        return false;
    }

    private static boolean isTamanioMatrixValido(int tamanio) {
        if (tamanio > 0 && tamanio <= VariablesEstaticas.getMAX_TAM_MATRIX()) {
            return true;
        }
        return false;
    }

    private static boolean isNumOperacionesValido(int num) {
        if (num > 0 && num <= VariablesEstaticas.getMAX_NUM_OPERACIONES()) {
            return true;
        }
        return false;
    }

    private static boolean capturarEntradas(Scanner sc, Matrix matriz) {
        int tamanio;
        int numOperaciones;
        System.out.print("Introduzca un tamaño de la matriz: ");
        tamanio = sc.nextInt();
        if (!isTamanioMatrixValido(tamanio)) {
            System.err.println("El tamanio de la matrix supera el maximo");
            return false;
        }
        matriz.setTamanio(tamanio);
        matriz.setMatriz();
        System.out.print("Introduzca un número de operaciones: ");
        numOperaciones = sc.nextInt();
        if (!isNumOperacionesValido(numOperaciones)) {
            System.err.println("El numero de operaciones a ejecutar supera el maximo");
            return false;
        }
        matriz.setNumOperaciones(numOperaciones);
        matriz.setColaOperaciones();
        for (int i = 0; i < matriz.getNumOperaciones(); i++) {
            System.out.println("Introduzca la operación nro " + (i + 1) + " a ejecutar: ");
            System.out.println("[0] " + VariablesEstaticas.getTipoOperaciones()[0]);
            System.out.println("[1] " + VariablesEstaticas.getTipoOperaciones()[1]);
            int opr = sc.nextInt();
            if (opr != 0 && opr != 1) {
                System.err.println("Error en la selección, debe ser un digito entre 0 y 1");
                i = i - 1;
                continue;
            }
            if (opr == VariablesEstaticas.getOPERACION_UPDATE()) {
                Update update = new Update(VariablesEstaticas.getTipoOperaciones()[opr]);
                int coordenada;
                int valorCoordenada;
                System.out.println("Introduzca la coordenada [x,y,z] comenzando en [1,1,1] a actualizar: ");
                coordenada = sc.nextInt();
                if (coordenada > tamanio) {
                    System.err.println("La posición ingresada supera el tamanio de la matrix");
                    i = i - 1;
                    continue;
                }
                update.setCoordenadasXYZ(coordenada);
                System.out.println("Introduzca el valor de la cordenada [" + coordenada + "," + coordenada + "," + coordenada + "] : ");
                valorCoordenada = sc.nextInt();
                if (valorCoordenada < Math.pow(-10, 9) || valorCoordenada > Math.pow(10, 9)) {
                    System.err.println("La posición ingresada supera el tamanio de la matrix");
                    i = i - 1;
                    continue;
                }
                update.setValorCoordenadas(valorCoordenada);
                matriz.getColaOperaciones()[i] = update;
            } else {
                Query query = new Query(VariablesEstaticas.getTipoOperaciones()[opr]);
                int coordenadaInferior;
                int coordenadaSuperior;
                System.out.println("Introduzca la coordenada [x,y,z] inferior comenzando en [1,1,1] a sumar: ");
                coordenadaInferior = sc.nextInt();
                if (coordenadaInferior > tamanio) {
                    System.err.println("La posición ingresada supera el tamanio de la matrix");
                    i = i - 1;
                    continue;
                }
                query.setCoordenadaInferior(coordenadaInferior);
                System.out.println("Introduzca la coordenada [x,y,z] superior comenzando en [1,1,1] a sumar: ");
                coordenadaSuperior = sc.nextInt();
                if (coordenadaSuperior > tamanio) {
                    System.err.println("La posición ingresada supera el tamanio de la matrix");
                    i = i - 1;
                    continue;
                }
                query.setCoordenadaSuperior(coordenadaSuperior);
                matriz.getColaOperaciones()[i] = query;
            }
        }
        for (int i = 0; i < matriz.getNumOperaciones(); i++) {
            if (matriz.getColaOperaciones()[i] instanceof Update) {
                System.out.println(((Update) matriz.getColaOperaciones()[i]).getNombre() + " "
                        + ((Update) matriz.getColaOperaciones()[i]).getEntrada());
            } else {
                System.out.println(((Query) matriz.getColaOperaciones()[i]).getNombre() + " "
                        + ((Query) matriz.getColaOperaciones()[i]).getEntrada());
            }
        }
        return true;
    }

    private static void ejecutarCasos(Matrix matriz) {
        for (int i = 0; i < matriz.getNumOperaciones(); i++) {
            if (matriz.getColaOperaciones()[i] instanceof Update) {
                Update update = (Update) matriz.getColaOperaciones()[i];
                update.actualizarCoordenada(matriz.getMatriz());
            } else {
                Query query = (Query) matriz.getColaOperaciones()[i];
                System.out.println(query.getSumaCoordenadasSalida(matriz.getMatriz()));
            }
        }
    }

}
