import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String S = bufferedReader.readLine();
        int[] result = new int[26];
        Arrays.fill(result,-1);
        int count = 0;

        for(char character : S.toCharArray()){
            int index = character-'a';
            if(result[index] == -1) result[index] = count;
            count++;
        }

        for (int index :
                result) {
            System.out.print(index + " ");
        }
    }
}
