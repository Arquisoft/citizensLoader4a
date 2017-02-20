package es.uniovi.asw.util;

import es.uniovi.asw.util.exception.CitizenException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


/**
 * Created by Pelayo García Lartategui on 04/02/2017.
 * Gestion de salidas por pantalla
 */
public class Console{

    protected static BufferedReader kbd = new BufferedReader(
            new InputStreamReader(System.in));

    public static void println(Object obj){
        System.out.println(obj.toString());
    }

    public static void println(String string){
        System.out.println(string);

    }
    public static void print(String string) {
        System.out.print(string);
    }

    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

        public static String readString() throws CitizenException {
        try {
            return kbd.readLine();
        } catch (IOException e) {
            throw new CitizenException("Error de lectura de String");
        }
    }
    public static String readString(String msg) throws CitizenException {
        print(msg + ": ");
        return readString();
    }
}
