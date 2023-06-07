import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;


public class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            hashSet.add(Integer.parseInt(bufferedReader.readLine())%42);
        }

        System.out.println(hashSet.size());
    }
}
