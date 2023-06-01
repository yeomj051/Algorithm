import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        char[] result = new char[26];
        for(char spell : input.toCharArray()){
            int index = spell - 65;
            if((spell - 65) > 26) index -= 32;
            result[index]++;
        }

        char resultSpell = ' ';
        int max=0;
        for (int i = 0; i < 26; i++) {
            if(max < result[i]){
                max = result[i];
                resultSpell = (char) (i+65);
            }
            else if (max == result[i]) {
                resultSpell = '?';
            }
        }

        System.out.println(resultSpell);
    }
}
