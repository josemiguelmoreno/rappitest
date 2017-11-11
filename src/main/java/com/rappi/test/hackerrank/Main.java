/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rappi.test.hackerrank;

import com.rappi.test.hackerrank.negocio.iface.TestMatrixNegocio;
import com.rappi.test.hackerrank.negocio.impl.TestMatrixNegocioImpl;
import com.rappi.test.hackerrank.util.VariablesEstaticas;
import java.util.Scanner;

/**
 *
 * @author ASD
 */
public class Main {

    public static TestMatrixNegocio negocio;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VariablesEstaticas.iniciarTipoOperaciones();
        negocio = new TestMatrixNegocioImpl();
        System.out.print("Introduzca un número casos de prueba: ");
        int numCases = sc.nextInt();
        negocio.ejecutarTestMatrix(numCases, sc);
    }
}
