package Punto_1_1.Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class torneo {
    


   
    public static void main(String[] args) throws FileNotFoundException {
        File Caballos = new File("Caballos.txt");
        File Ganadores = new File("Ganadores.txt");
        String Num_Caballo= "", Peso="", Nombre="", Raza="";

        
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
                
                i++;

            }
            Ca.close();
            String aux;
            for (int k=0 ; k <= i; k++){
                for (int j=0; j <= k; j++){
                    if (Integer.parseInt(Mat[j+1][1]) > Integer.parseInt(Mat[j][1])) {
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


            FileWriter fw = new FileWriter(Caballos);
            BufferedWriter bw = new BufferedWriter(fw);
            FileReader fr = new FileReader(Caballos);
            BufferedReader br = new BufferedReader(fr);


            
            while((bfread = br.readLine())!=null) {
                for (int  k=1 ; k <= i; k++){
                    for (int j=1; j <= 4; j++){
                       
                        switch(j) {
                            case 1:
                                Num_Caballo = Mat[ i ][ 0 ] ;
                            case 2:
                                Nombre = Mat[ i ][ 1 ] ;
                            case 3:
                                Peso = Mat[ i ][ 2 ] ;
                            case 4:
                               Raza = Mat[ i ][ 3 ] ;
                        }
                    }
                   
                }
                
                 
            }
            br.close();
            fr.close();
            fw.close();
            bw.close();
            
            FileReader fr1 = new FileReader(Caballos);
            BufferedReader br1 = new BufferedReader(fr1);

            String velocidades [] = new String[50];
            int sizeVel = 0;
            int sizeNum = 0;
            int sw = 0;
            int c=0;
            int numCab []= new int[50];
            int vecVel [] = new int[50];

            while((bfread = br1.readLine())!=null) {
                FileReader ga = new FileReader(Ganadores);
                BufferedReader gan = new BufferedReader(ga);
                
                String Gan[][] = new String[6][5];
                



                String bgread = null;
                while((bgread = br.readLine())!=null) {
                    String ganadores[] = bgread.split("\t");
                    
                    Gan[c][0]= ganadores[0];
                    Gan[c][1]= ganadores[1];
                    Gan[c][2]= ganadores[2];
                    Gan[c][3]= ganadores[3];
                    c=c++;
                    if (Integer.parseInt(Gan[c][2]) == Integer.parseInt(Mat[c][0])) {
                        velocidades[sizeNum]=velocidades[sizeNum] + (Integer.parseInt((Gan[c][3]))) / (Integer.parseInt((Gan[c][4])));
                        sizeNum++;
                    }
                    gan.readLine();
                }
                br1.readLine();
                gan.close();
                ga.close();   
                     
            }

            int menorVel = Integer.parseInt(velocidades[0]);
            int posicionMenor = 0;
            
            for (int a=1 ; a<velocidades.length ; a++) {
                if (menorVel > Integer.parseInt(velocidades[a])) {
                    menorVel = Integer.parseInt(velocidades[a]);
                    posicionMenor = a;
                }
            }

            FileReader fr2 = new FileReader(Caballos);
            BufferedReader br2 = new BufferedReader(fr2);


            String data = null;
            int j = 0;
            while((data = br2.readLine())!=null) {
                if(posicionMenor == j){
                    System.out.println("la velocidad de: " + Num_Caballo+ " es de: " + velocidades[j]);
                }
                j++;
            }








            br2.close();
            fr2.close();

                
                 
            







            
            

            br1.close();
            fr1.close();
        } catch (Exception e) {
            // TODO: handle exception
        }




    }
}
