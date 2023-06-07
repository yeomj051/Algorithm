import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int index = 0;

        for (int i = 1; i < 10; i++) {
            int now = Integer.parseInt(bufferedReader.readLine());
            if(now > max){
                index = i;
                max = now;
            }
        }

        System.out.println(max);
        System.out.println(index);

    }
}
