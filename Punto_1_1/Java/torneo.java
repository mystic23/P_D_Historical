package Punto_1_1.Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class torneo {
    


   
    public static void main(String[] args) throws FileNotFoundException {
        File Caballos = new File("Caballos.txt");
        File Ganadores = new File("Ganadores.txt");
        // String Num_Caballo= "", Peso="", Nombre="", Raza="";

        
         try {
            BufferedReader Ca = new BufferedReader(new FileReader(Caballos));
            int i=0;

            String Mat[][] = new String[5][4];
            String bfread=null;

            while((bfread = Ca.readLine()) != null){
                String valor[] = bfread.split("\t");

                Mat[i][0]= valor[0];
                Mat[i][1]= valor[1];
                Mat[i][2]= valor[2];
                Mat[i][3]= valor[3];
                
                i =i+1;

            }
            Ca.close();
            String aux;
            for (int k=0 ; k <= i; k++){
                for (int j=0; j <= k; j++){
                    if (Mat[j+1 ][ 1 ]  <  Mat[j][ 1 ]) {
                            aux = Mat[ j+1 ][ 1 ];
                            Mat[ j+1 ][ 1 ] = Mat[ j ][ 1 ];
                            Mat[ j ][ 1 ] = aux;
            
                            aux = Mat[ j+1 ][ 2 ];
                            Mat[ j+1 ][ 2 ] = Mat[ j ][ 2 ];
                            Mat[ j ][ 2 ] = aux;
                            
                            aux = Mat[ j+1 ][ 3 ];
                            Mat[ j+1 ][ 3 ] = Mat[ j ][ 3 ];
                            Mat[ j ][ 3 ] = aux;
                            
                            aux = Mat[ j+1 ][ 4 ];
                            Mat[ j+1 ][ 4 ] = Mat[ j ][ 4 ];
                            Mat[ j ][ 4 ] = aux;
                    }
                }
            }
            
        } catch (Exception e) {
            
        }
        try {
            BufferedWriter Ca = new BufferedWriter(FileWriter(Caballos);





        } catch (Exception e) {
            // TODO: handle exception
        }
       

       
        


    }
}
