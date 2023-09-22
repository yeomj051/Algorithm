import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static class ShortPath{
        int start;
        int end;
        int cost;

        public ShortPath(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        ArrayList<ShortPath>[] spList = new ArrayList[d+1];
        int[] dp = new int[d+1];
        for (int i = 0; i <= d; i++) {
            spList[i] = new ArrayList<>();
            dp[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(end > d) continue;
            spList[start].add(new ShortPath(start, end, cost));
        }

        for (int j = 0; j < spList[0].size(); j++) {
            ShortPath sp = spList[0].get(j);
            dp[sp.end] = Math.min(dp[sp.end], sp.cost);
        }

        for (int i = 1; i <= d; i++) {
            dp[i] = Math.min(dp[i-1]+1,dp[i]);

            if(spList[i].size() > 0){
                for (int j = 0; j < spList[i].size(); j++) {
                    ShortPath sp = spList[i].get(j);
                    dp[sp.end] = Math.min(dp[sp.end],dp[i]+ sp.cost);
                }
            }
        }

        System.out.println(dp[d]);
    }
}