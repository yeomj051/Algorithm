import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n,m;
    //좌 좌상 상
    public static int[] dx = {0,-1,-1};
    public static int[] dy = {-1,-1,0};
    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                if(arr[j-1] - '0' == 0) continue;

                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    int nx = i+dx[k];
                    int ny = j+dy[k];

                    if(nx<0 || ny<0) continue;
                    min = Math.min(min,dp[nx][ny]);
                }

                dp[i][j] = min+1;
                result = Math.max(result, dp[i][j]);
            }
        }

        System.out.println(result*result);
    }
}