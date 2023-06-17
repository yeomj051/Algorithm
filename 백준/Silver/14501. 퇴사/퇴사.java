import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int restDay;
    private static int[][] schedule;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        restDay = Integer.parseInt(bufferedReader.readLine());

        schedule = new int[restDay+1][2];
        for (int i = 1; i <= restDay; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            schedule[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            schedule[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] dp = new int[restDay+2];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= restDay; i++) {
            if(i + schedule[i][0] <= restDay+1){
                for (int j = i + schedule[i][0]; j <= restDay+1; j++) {
                    dp[j] = Math.max(dp[i] + schedule[i][1],dp[j]);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder().append(dp[restDay+1]);
        System.out.println(stringBuilder);
    }
}
