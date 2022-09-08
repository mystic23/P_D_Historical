package Punto_1_1.Java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


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

            BufferedReader Registro_Ganadores = new BufferedReader(new FileReader("Ganadores.txt"));
            String Linea_Ganadores = Registro_Ganadores.readLine();


            BufferedReader Registro_Caballos = new BufferedReader(new FileReader("Caballos.txt"));
            String Linea_Caballos = Registro_Caballos.readLine();

            float total_velocidades = 0;
            float total_caballo=0;

            float velocidad_minima = Float.POSITIVE_INFINITY;
            String nombre_caballo = " ";

            while (Linea_Caballos!=null) {
                float v_carrera = 0;

                String dataCaballo[] = Linea_Caballos.split(",");
                String dataGanadores[] = Linea_Ganadores.split(",");
            
                String N_caballo_C = dataCaballo[0]; 
                String N_caballo_G = dataGanadores[2];

                if (N_caballo_C.equals(N_caballo_G)) {

                    v_carrera+=(float) (Float.parseFloat(dataGanadores[3])/Float.parseFloat(dataGanadores[4]));
                    total_velocidades+= v_carrera;
                    total_caballo+=v_carrera;
                    //System.out.println("la velocidad de " + dataCaballo[1] + " es de " + v_carrera +" en la carrera " + dataGanadores[0] );
                                   
                }
                Linea_Ganadores = Registro_Ganadores.readLine();
                
                if (Linea_Ganadores == null) {
                    if (total_caballo<velocidad_minima & total_caballo!=0) {
                        if (total_caballo > 0 ) {
                            velocidad_minima = total_caballo;
                            nombre_caballo = dataCaballo[1]; 
                            
                        }
                       
                    }
                    
                    System.out.println("la velocidad total de " + dataCaballo[1] + " es de " + total_caballo);
                    Registro_Ganadores.close();
                    Registro_Ganadores = new BufferedReader(new FileReader("Ganadores.txt"));
                    Linea_Ganadores = Registro_Ganadores.readLine();
                    Linea_Caballos = Registro_Caballos.readLine();
                    total_caballo = 0;
                }
                
               // System.out.println(" La velocidad total es de: " + total_velocidades);
                //System.out.println("El caballo con menor velocidad  es " + dataCaballo[1] );

                
            }
           
            System.out.println("el caballo con menor velocidad es " + nombre_caballo );
            Registro_Caballos.close();   
        } catch (Exception e) {
            System.out.println("El archivo no pudo ser abierto " +  e );
        }

    }


    public static void main(String [] args) {
        //primera parte 
        lectura_mostrar("Ganadores");
        lectura_mostrar("Caballos");

        //mostrar la velocidad del caballo
        velocidad();

        //Ordenar Caballos 

    }

   








}
