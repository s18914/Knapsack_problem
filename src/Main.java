import java.io.File;

public class Main {


    static int capacity;
    static int n;
    static int[][] list;
    static int bestSoFar;
    static int bestKSoFar;
    public static int maxBin ;


    public static void main(String[] args)  {

        //czytanie pliku
        File infoData = new File(System.getProperty("user.home")+"/"+"plecak.txt");
        FileService fs = new FileService();


        fs.readFile(infoData);

        //tworze maksymalny wektor
        maxBin=1;
        for(int i=0; i<n-1; i++){
            maxBin*=2;
            maxBin++;
        }
        

        bruteForce();

        System.out.println("RESPONSE: " + response());
        System.out.println(bestKSoFar + " " + bestSoFar);
    }



    private static void bruteForce() {

        bestSoFar = 0;
        solve(maxBin);

    }


    private static void solve(int k) {

        while(k>0){                                                       //przechodze po kolei po liczbach od max do 0
           System.out.println("\n" +"== [ "+ k+ " ] ==" );
            char[] tab = Integer.toBinaryString(k).toCharArray();
            int s= sum(tab);
            if(s>bestSoFar){                                               
                bestSoFar=s;
                bestKSoFar=k;
                System.out.println("BEST VECTOR IS NOW: " + bestKSoFar);
            }
            k--;
        }
    }

    public static int sum(char[] c){                                        //zwraca sume wartości - jeśli wagi są za duże to -1

        int sumOfValue = 0;
        int sumOfWeight = 0;
        int indexC=c.length-n;                                               

        for(int i=0; i<n; i++){

            if(indexC>=0){                                                    
                if(c[indexC]=='1'){
                    sumOfValue+=list[i][0];
                    //System.out.println("value: "+ list[i][0]);
                    sumOfWeight+=list[i][1];
                    //System.out.println("weight: "+ list[i][1]);
                }

            }
            if(sumOfWeight>capacity){                                         // sprawdzam czy przekraczam limit
                //System.out.println("Przekroczono limit");
                return -1;
            }
            indexC++;
        }
       // System.out.println("sumy wag i wartości to: " + sumOfWeight + "  " + sumOfValue);
        return sumOfValue;
    }


    public static String response(){

        String response="";

        int p = Integer.toBinaryString(maxBin).toCharArray().length - Integer.toBinaryString(n).toCharArray().length ;

        for(int i=0; i<=p ;i++){                                                                                          //dodaje brakujące zera do odp
            response+="0";
        }

        response+=Integer.toBinaryString(bestKSoFar);
        return response;
    }



}
