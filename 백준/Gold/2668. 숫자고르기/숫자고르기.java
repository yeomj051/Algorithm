import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static int n;
    public static int[] numberList;
    public static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        numberList = new int[n+1];
        for (int i = 1; i <= n; i++) {
            numberList[i] = Integer.parseInt(br.readLine());
        }

        result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n+1];
            visited[i] = true;
            dfs(visited, i, i);
        }

        StringBuilder sb = new StringBuilder().append(result.size()).append("\n");
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(boolean[] visited,int index, int first) {
        if(visited[numberList[index]] && numberList[index] == first) {
            result.add(first);
        }else if(!visited[numberList[index]]){
            visited[numberList[index]] = true;
            dfs(visited,numberList[index],first);
        }

        return;
    }
}