import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

//    5 2
//    map
//    set
//    dijkstra
//    floyd
//    os
//    map,dijkstra
//    map,floyd
    public static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashSet<String> keyWord = new HashSet<>();
        for (int i = 0; i < N; i++) {
            keyWord.add(br.readLine());
        }

        HashSet<String> assey = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(",");
            for (String word : line) {
                if(keyWord.contains(word)){
                    keyWord.remove(word);
                }
            }

            sb.append(keyWord.size()).append("\n");
        }

        System.out.println(sb);
    }
}