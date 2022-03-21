package com.ejerciciosesiones78y9;

import java.util.ArrayList;


public class Cadenadelreves {

    public static void main(String[] args) {

        String texto = "Hoy no me puedo levantar";

        reverse(texto);


    }
    public static String reverse (String texto) {
        for (int i =texto.length()-1;i>=0;i--) {
            System.out.print(texto.charAt(i));
                    }
        return texto;
    }

    }

