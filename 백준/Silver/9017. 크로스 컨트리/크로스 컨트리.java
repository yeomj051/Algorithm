import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int rankSize = Integer.parseInt(br.readLine());
            ArrayList<Integer>[] teamList = new ArrayList[201];
            int[] rank = new int[rankSize+1];

            for (int j = 1; j <= 200; j++) {
                teamList[j] = new ArrayList<>();
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= rankSize; j++) {
                int number = Integer.parseInt(st.nextToken());
                rank[j] = number;

                teamList[number].add(j);
                if(teamList[number].size() == 6) teamList[number].add(0);
            }

            int fallCount = 0;
            for (int j = 1; j <= rankSize; j++) {
                int teamNumber = rank[j];
                if(teamList[teamNumber].size() != 7) fallCount++;
                else {
                    int order = teamList[teamNumber].get(6);
                    teamList[teamNumber].set(order,teamList[teamNumber].get(order) - fallCount);
                    teamList[teamNumber].set(6, order+1);
                }
            }

            int min = Integer.MAX_VALUE;
            int win = 0;

            for (int j = 1; j <= 200; j++) {
                if(teamList[j].size() < 6) continue;

                int score = 0;
                for (int k = 0; k < 4; k++) {
                    score += teamList[j].get(k);
                }
                if(min > score){
                    min = score;
                    win = j;
                }else if(min == score && teamList[win].get(4) > teamList[j].get(4)) win = j;
            }

            System.out.println(win);
        }
    }
}
