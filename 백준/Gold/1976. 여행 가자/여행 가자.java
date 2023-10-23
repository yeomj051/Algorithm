import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N,M;
    public static int[][] map;
    public static int[] plan;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        plan = new int[M];
        plan[0] = Integer.parseInt(st.nextToken())-1;
        visited = new boolean[N];
        bfs(plan[0]);

        String result = "YES";
        for (int i = 1; i < M; i++) {
            if(!visited[Integer.parseInt(st.nextToken())-1]){
                result = "NO";
                break;
            }
        }

        System.out.println(result);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for (int i = 0; i <N; i++) {
                if(!visited[i] && map[now][i] == 1){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }


}