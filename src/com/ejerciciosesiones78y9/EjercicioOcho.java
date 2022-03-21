package com.ejerciciosesiones78y9;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class EjercicioOcho {
    public static void main(String[] args) {
        try {
            InputStream fileIn = new FileInputStream("D:\\Open Bootcamp\\TextoEjercicioOcho.txt");
            byte[] numeros = fileIn.readAllBytes();
            fileIn.close();
            System.out.println("Hemos creado el fichero con números");
            PrintStream fileOut = new PrintStream("D:\\Open Bootcamp\\TextoEjercicioOchoOut.txt");
            fileOut.write(numeros);
            fileOut.close();
            System.out.println("Le hemos pasado los números del primer fichero a este segundo");

        } catch (IOException e) {
            System.out.println("Este es el error: " + e.getMessage()); //si hay algún error como no encontrar algún fichero
        }
    }
}

