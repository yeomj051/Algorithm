import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = bufferedReader.readLine().split(" ");
        int result = arr.length;
        if(result != 0 && arr[0].equals("")) result -= 1;
        else if (result != 0 && arr[result-1].equals("")) result -= 1;
        System.out.println(result);
    }
}
