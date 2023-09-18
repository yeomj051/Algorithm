import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] numberList = new int[n];
        st = new StringTokenizer(br.readLine());

        Queue<Integer>[] queueList = new LinkedList[100001];
        int max = 0;
        int count = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            numberList[i] = number;
            if(queueList[number] == null) queueList[number] = new LinkedList<>();
            queueList[number].add(i);

            if(queueList[number].size() > k) {
                max = Math.max(count, max);
                int restart = queueList[number].poll();
                for (int j = start; j < restart; j++) {
                    queueList[numberList[j]].poll();
                    count--;
                }
                start = restart+1;
            }
            else count++;
        }

        max = Math.max(count, max);
        System.out.println(max);
    }
}