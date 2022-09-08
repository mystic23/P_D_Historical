package Punto_1_1.Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class prueba2 {
    static File Caballos = new File("Caballos.txt");
    static File Ganadores = new File("Ganadores.txt");
    

    //esta funcion es para mostrar(generico) lo que hay dentro de cualquiera de los dos archivos
    // a punta de vectores
    public static void lectura_mostrar(String file_name ) { 
        try {
            BufferedReader registro = new BufferedReader(new FileReader( file_name + ".txt"));
            String leerLinea = registro.readLine();

            //esto es para obtener el nombre del archivo
            // final String nameC = Caballos.getName();
            // final String nameG = Ganadores.getName();

            while (leerLinea != null) {
                
                if (file_name == "Caballos") {
                    String vectorc[] = leerLinea.split(",");
                    System.out.println(vectorc[0] + " " + vectorc[1] + " " + vectorc[2] + " " + vectorc[3]);
                    leerLinea = registro.readLine();
                   
                }else{
                    if (file_name =="Ganadores") {
                        String vectorg[] = leerLinea.split(",");
                        System.out.println(vectorg[0] + " " + vectorg[1] + " " + vectorg[2] + " " + vectorg[3]+ " " + vectorg[4]);
                        leerLinea = registro.readLine();    
                    }
                }  
            }
            registro.close();
        } catch (IOException ex) {
            System.out.println("no se encontro ningun archivo re f" + ex);
        }
    }

    public static void velocidad(){
        try {
            //Ganadores
            BufferedReader ganadores = new BufferedReader(new FileReader("Ganadores.txt"));
            String lineas_ganadores = ganadores.readLine();

            //Caballos
            BufferedReader caballos = new BufferedReader(new FileReader("Caballos.txt"));
            String lineas_caballos = caballos.readLine();
            

            //vector velocidades 
            float velocidades [] = new float[50];

            //contador de posicion
            int cont = 0;
            while(lineas_caballos!=null){
                
                String v_caballo[]= lineas_caballos.split(",");
                String v_ganadores[] = lineas_ganadores.split(",");

                //esta comparacion la hago para verificar que el caballo que esta en la lista de caballos
                //esta dentro de la lista de ganadores y que calcule de una vez de acuerdo a su posicion
                //la sumatoria total de sus velocidades durante todo el torneo
                if(v_caballo[0]==v_ganadores[2]){
                    velocidades[cont] = velocidades[cont]+(Float.parseFloat(v_ganadores[3])/ Float.parseFloat(v_ganadores[4]));
                    cont++;
                    System.out.println("la velocidad de " + v_caballo[1] + " es de: " );
                }
                lineas_ganadores = ganadores.readLine();
             
                
            }
            float menorVel = velocidades[0];
            int posicionMenor = 0;

            for (int a=0 ; a<velocidades.length ; a++) {
                if (menorVel > velocidades[a]) {
                    menorVel = velocidades[a];
                    posicionMenor = a;
                }
            }





















        } catch (Exception e) {
            System.out.println(e);
        }



    }

   

    public static void main(String [] args) {
        //primera parte 
        lectura_mostrar("Ganadores");
        lectura_mostrar("Caballos");

       //mostrar la velocidad del caballo
       velocidad();

    }

   








}
