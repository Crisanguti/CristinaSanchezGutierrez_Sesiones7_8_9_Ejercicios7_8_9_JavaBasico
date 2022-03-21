package com.ejerciciosesiones78y9;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static java.nio.charset.StandardCharsets.UTF_8;

public class EjercicioNueve {

    public static void main(String[] args) {

        ArrayList<String> razasPeligrosasAndalucia = new ArrayList<>();

        razasPeligrosasAndalucia.add("Pitbull");   //Añadimos la lista de perros PPP en Andalucía
        razasPeligrosasAndalucia.add("Bull Terrier");
        razasPeligrosasAndalucia.add("American Stafford");
        razasPeligrosasAndalucia.add("Rottweiler");
        razasPeligrosasAndalucia.add("Dogo Argentino");
        razasPeligrosasAndalucia.add("Fila Brasileiro");
        razasPeligrosasAndalucia.add("Tosa Inu");
        razasPeligrosasAndalucia.add("Akita Inu");
        razasPeligrosasAndalucia.add("Doberman");
        razasPeligrosasAndalucia.add("Mestizo PPP");

        ArrayList<String> tuteladosConLicencia = new ArrayList<>();

        HashMap<String, String> razastutelados = new HashMap<>();

        try {
            InputStream tutelados = new FileInputStream("D:\\Open Bootcamp\\perrostutelados.csv");
            byte[] datas = tutelados.readAllBytes();
            String s = new String(datas);
            System.out.println("Este es el archivo CSV leido:\n" + s);
            String prueba1 = s.replaceAll("\r\n", ";");
            System.out.println("La cadena total es: " + prueba1);
            String[] prueba2 = prueba1.split(";");
            System.out.println("El número de variables total es: " + prueba2.length);
            int contador = 0;
            while (contador < prueba2.length) {          //Bucle while para añadir clave y valor al HashMap
                razastutelados.put(prueba2[contador], prueba2[contador + 1]);
                contador = contador + 2;
            }
            System.out.println(razastutelados); //Comprobamos que el HashMap se ha creado correctamente

            for (Map.Entry<String, String> pair : razastutelados.entrySet()) {  // Recorremos el HashMap
                System.out.println(pair.getKey() + " / " + pair.getValue());
                for (int i = 0; i < razasPeligrosasAndalucia.size(); i++) {    //Recorremos la lista de razas PPP en Andalucía
                    boolean necesitaLicecncia = pair.getValue().equals(razasPeligrosasAndalucia.get(i));
                    if (necesitaLicecncia) {                                //Si coinciden razas de tutelados con razas de la lista de Andalucía, se añade a una nueva lista
                        tuteladosConLicencia.add(pair.getKey());
                    }
                }
            }

            System.out.println("Estos son los tutelados que necesitan licencia PPP en Andalucía: " + tuteladosConLicencia);

            PrintStream tuteladosQueNecesitanLicenciaCSV = new PrintStream("D:\\Open Bootcamp\\tuteladosconlicencia.csv", UTF_8);   //Añadimos los nombres al fichero nuevo
            PrintStream tuteladosQueNecesitanLicenciaTxt = new PrintStream("D:\\Open Bootcamp\\tuteladosconlicencia.txt", UTF_8);   //Añadimos los nombres al fichero nuevo

            for (String cadenaTutelados : tuteladosConLicencia) {           //Creamos un bucle para añadir nombre a nombre al archivo
                tuteladosQueNecesitanLicenciaCSV.println(cadenaTutelados);
                tuteladosQueNecesitanLicenciaTxt.println(cadenaTutelados);
            }
            //Si la extensión del archivo es .csv, aparecen los caracteres ï>>¿, en .txt no se da el caso, pendiente de revisar.
            tuteladosQueNecesitanLicenciaCSV.close();
            tuteladosQueNecesitanLicenciaTxt.close();

        } catch (Exception e) {
            System.out.println("No se puede leer el archivo " + e.getMessage());
        }

    }

}