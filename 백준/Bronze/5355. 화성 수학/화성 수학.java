import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            String sic = bufferedReader.readLine();

            String[] sicArr = sic.split(" ");

            BigDecimal bigDecimal = new BigDecimal(sicArr[0]);

            for (int j = 1; j < sicArr.length; j++) {
                if(sicArr[j].equals("@")) {
                    BigDecimal bigDecimal2 = new BigDecimal("3");
                    bigDecimal = bigDecimal.multiply(bigDecimal2);
                }
                else if(sicArr[j].equals("%")){
                    BigDecimal bigDecimal2 = new BigDecimal("5");
                    bigDecimal = bigDecimal.add(bigDecimal2);
                }
                else if(sicArr[j].equals("#")){
                    BigDecimal bigDecimal2 = new BigDecimal("7");
                    bigDecimal = bigDecimal.subtract(bigDecimal2);
                }
            }

            System.out.println(bigDecimal.setScale(2, BigDecimal.ROUND_DOWN));
        }
        
    }

}
