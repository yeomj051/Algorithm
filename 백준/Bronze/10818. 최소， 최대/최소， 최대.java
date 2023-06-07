import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String size = bufferedReader.readLine();

        int max = -1000001;
        int min = 1000001;
        for (String number : bufferedReader.readLine().split(" ")) {
                int now = Integer.parseInt(number);
                max = Math.max(max,now);
                min = Math.min(min,now);
        }

        System.out.print(min);
        System.out.print(" ");
        System.out.println(max);
    }
}
