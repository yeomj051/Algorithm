import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] order = new int[n+1];
        int[] input = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            order[i] = i;
        }

        for (int i = n; i > 0; i--) {
            int count = input[order[i]];
            int index = i;
            while(count > 0){
                count -= swip(order, index++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(order[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static int swip(int[] list, int idx){
        int temp = list[idx+1];
        list[idx+1] = list[idx];
        list[idx] = temp;

        if(list[idx] > list[idx+1]) return 1;
        return 0;
    }
}