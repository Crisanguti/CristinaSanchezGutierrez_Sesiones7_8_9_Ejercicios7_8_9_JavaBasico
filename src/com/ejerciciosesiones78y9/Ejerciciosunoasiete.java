package com.ejerciciosesiones78y9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Ejerciciosunoasiete {
    public static void main(String[] args) {
        //Ejercicio 1: crear array unidimensional String

        String[] nombres = {"Lía", "Barry", "Watson", "Croqueta"};
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        //Ejercicio 2: crear un array bidimesional de enteros

        int[][] enteros = {{1, 2, 3, 4}, {10, 20, 30, 40}};
        for (int i = 0; i < enteros.length; i++) {
            for (int j = 0; j < enteros[0].length; j++) {
                System.out.println("La posición en i: " + i + " y en j: " + j + " y el valor es: " + enteros[i][j]);
            }
        }

        //Ejercicio 3: crea un vector con cinco elementos

        Vector<String> canciones = new Vector<>();
        canciones.add("Happy");
        canciones.add("Moves Like Jagger");
        canciones.add("Firework");
        canciones.add("Shallow");
        canciones.add("Sugar");

        System.out.println(canciones);

        canciones.remove(1);  //elimina el 2º elemento y el 3º ocupa su lugar
        canciones.remove(1); //para eliminar el 3er elemento, hay que eliminar de nuevo la 2ª posición

        System.out.println(canciones);

        //Ejercicio 4: indicar el problema de usar vector con capacidad por defecto:

        /*
          Al tener 1000 elementos para añadir, se duplicaría la capacidad de este, que implica un mayor consumo de memoria
          a la hora de crear un subarray nuevo, es decir, 2000 posiciones de memoria reservadas para dicho vector.
         */

        //Ejercicio 5; crear arralist y copiar en linkedlist
        ArrayList<String> lista = new ArrayList<>(4);
        lista.add("Bruno Mars");
        lista.add("Maroon 5");
        lista.add("Katy Perry");
        lista.add("Ed Sheeran");

        LinkedList<String> cantantes = new LinkedList<>();
        cantantes.addAll(lista);
        System.out.println(lista);
        System.out.println(cantantes);

        //Ejercicio 6: crear ArrayList con enteros del 1 al 10 usando bucles...

        ArrayList<Integer> decena = new ArrayList<>();
        int i;
        for (i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                decena.add(i);
            }
        }
        System.out.println(decena);

        //Ejercicio 7: crear una función DividePorCero.

        try {
           DividePorCero(5, 0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Demo de código");
        }

    }

    public static void DividePorCero(int a, int b) throws ArithmeticException {
        int resultado = a/b;
        if (b==0){
        throw new ArithmeticException("Esto no puede hacerse");
        }
    }
}
