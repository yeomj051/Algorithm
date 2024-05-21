import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int num1 = N/H;
            int num2 = N%H;
            if(num2 > 0) num1++;
            else num2 = H;

            sb.append(num2);
            if(num1 < 10) sb.append(0);
            sb.append(num1);

            sb.append("\n");
        }
        System.out.println(sb);
    }
}