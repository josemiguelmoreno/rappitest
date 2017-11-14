/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rappi.test.hackerrank.util;

/**
 *
 * @author Jose
 */
public class VariablesEstaticas {
    
    private static final int OPERACION_UPDATE = 0;
    private static final int OPERACION_QUERY = 1;
    private static final int MAX_TEST_CASE = 50;
    private static final int MAX_TAM_MATRIX = 100;
    private static final int MAX_NUM_OPERACIONES = 1000;
    private static final String NOMBRE_OPERACION_UPDATE = "UPDATE";
    private static final String NOMBRE_OPERACION_QUERY = "QUERY";
    private static String[] tipoOperaciones;

    public static String[] getTipoOperaciones() {
        return tipoOperaciones;
    }

    public static void iniciarTipoOperaciones() {
        tipoOperaciones = new String[2];
        tipoOperaciones[0] = NOMBRE_OPERACION_UPDATE;
        tipoOperaciones[1] = NOMBRE_OPERACION_QUERY;
    }

    public static int getOPERACION_UPDATE() {
        return OPERACION_UPDATE;
    }

    public static int getOPERACION_QUERY() {
        return OPERACION_QUERY;
    }

    public static String getNOMBRE_OPERACION_UPDATE() {
        return NOMBRE_OPERACION_UPDATE;
    }

    public static String getNOMBRE_OPERACION_QUERY() {
        return NOMBRE_OPERACION_QUERY;
    }

    public static int getMAX_TEST_CASE() {
        return MAX_TEST_CASE;
    }

    public static int getMAX_TAM_MATRIX() {
        return MAX_TAM_MATRIX;
    }

    public static int getMAX_NUM_OPERACIONES() {
        return MAX_NUM_OPERACIONES;
    }
    
    
    
}
