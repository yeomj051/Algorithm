import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n, k;
    public static int[] weight;
    public static boolean[] visited;
    public static int result=0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());

        weight = new int[n];
        visited = new boolean[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        bfs(0, 500);

        StringBuilder stringBuilder = new StringBuilder().append(result);
        System.out.println(stringBuilder);
    }

    private static void bfs(int count, int nowWeight) {
        if(count == n){
            result++;
            return;
        }

        nowWeight -= k;
        for (int i = 0; i < n; i++) {
            if(!visited[i] && nowWeight+weight[i] >= 500){
                nowWeight += weight[i];
                visited[i] = true;
                bfs(count+1,nowWeight);
                visited[i] = false;
                nowWeight -= weight[i];
            }
        }

    }
}
