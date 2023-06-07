import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String size = bufferedReader.readLine();
        int result =0;
        for (char number : bufferedReader.readLine().toCharArray()) {
                result += number-'0';
        }

        System.out.println(result);
    }
}
