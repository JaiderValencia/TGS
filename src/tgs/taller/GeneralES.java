
package tgs.taller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GeneralES {
    public static void imp(String men) {
        System.out.println(men);
    }

    public static int leaEntero(String mensaje) {
        int num = 0;
        try {
            num = Integer.parseInt(lea(mensaje));
        } catch (NumberFormatException en) {
            imp("Error, dato no válido" + en.getMessage());
            return leaEntero(mensaje);
        }
        
        return num;
    }

    public static double leaDouble(String mensaje) {
        double num = 0;
        try {
            num = Double.parseDouble(lea(mensaje));
        } catch (NumberFormatException en) {
            imp("Error, dato no válido" + en.getMessage());
            return leaDouble(mensaje);
        }
        return num;
    }

    public static String lea(String mensaje) {

        // Codigo para leer
        String dato = "";
        InputStreamReader objflujo = new InputStreamReader(System.in);
        BufferedReader objleer = new BufferedReader(objflujo);
        try {
            imp(mensaje);
            dato = objleer.readLine();
        } catch (IOException er) {
            imp("Hubo un error en la lectura");
            return lea(mensaje);
        }

        return dato;
    }

}
