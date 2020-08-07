import java.io.*;

public class FileService {

     public static void readFile(File file) {

        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String line = input.readLine();
            int k =0;
            while(true) {
                if(k == 0 ) {
                    // czytanie 2 linii
                    Main.capacity = Integer.parseInt(line);
                    line = input.readLine();
                    Main.n = Integer.parseInt(line);

                    Main.list = new int[Main.n][2];
                    k++;
                }
                else	{
                    line = input.readLine();
                    String[] seperate=line.split(" ");
                    for(int i=0; i<Main.n; i++){
                        Main.list[i][0] = Integer.parseInt(seperate[i]);
                    }
                    line = input.readLine();
                    seperate=line.split(" ");
                    for(int i=0; i<Main.n; i++){
                        Main.list[i][1] = Integer.parseInt(seperate[i]);
                    }
                    break;
                }
            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
