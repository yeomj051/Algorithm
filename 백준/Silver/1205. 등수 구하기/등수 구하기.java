import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Long taeScore = Long.parseLong(st.nextToken());
        int rankSize = Integer.parseInt(st.nextToken());

        ArrayList<Long> ranking = new ArrayList<>();
        int result = 0;

        if(N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                Long score = Long.parseLong(st.nextToken());
                ranking.add(score);

                if (result == 0 && (score.equals(taeScore) || score < taeScore)) result = i + 1;

            }

            if(ranking.size() >= rankSize &&  ranking.get(rankSize - 1) >= taeScore) result = -1;
            if(result == 0) result = N+1;

        }else result = 1;

        System.out.println(result);
    }


}