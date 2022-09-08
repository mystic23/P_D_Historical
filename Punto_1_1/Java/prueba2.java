package Punto_1_1.Java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class prueba2 {
 
    public static void main(String [] args) {
        File Caballos = new File("Caballos.txt");
        File Ganadores = new File("Ganadores.txt");

    }

    public static void lectura(String file_name, File Caballos, File Ganadores ) {
        
        try {
            BufferedReader registro = new BufferedReader(new FileReader( file_name + ".txt"));
            String leerLinea = registro.readLine();
            final String nameC = Caballos.getName();
            final String nameG = Ganadores.getName();
            
            while (leerLinea != null) {
                String vector[] = leerLinea.split("\t");
                if (file_name + ".txt" == nameC) {
                    System.out.println(vector[0] + "\t" + vector[1] + "\t" + vector[2] + "\t" + vector[3]);
                    leerLinea = registro.readLine();
                }else{
                    if (file_name + ".txt"== nameG) {
                        System.out.println(vector[0] + "\t" + vector[1] + "\t" + vector[2] + "\t" + vector[3]+ "\t" + vector[4]);
                        leerLinea = registro.readLine();    
                    }
                }
                
                
            }
            registro.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

   








}
