import java.util.*;
import java.io.*;
import java.lang.*;


public class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());




        int before = Integer.parseInt(stringTokenizer.nextToken());
        int now = Integer.parseInt(stringTokenizer.nextToken());
        int interval = before - now;
        String result = "";

        while(stringTokenizer.hasMoreTokens()){
            before = now;
            now = Integer.parseInt(stringTokenizer.nextToken());
            if(interval != before - now){
                result = "mixed";
                interval =0;
                break;
            }
            interval = before - now;
        }

        if(interval == 1) System.out.println("descending");
        else if (interval == -1) System.out.println("ascending");
        else System.out.println(result);

    }
}
