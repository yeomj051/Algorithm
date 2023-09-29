import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[][] info;
    public static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        info = new int[n][2];
        int max = 0;
        int maxIdx = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(info, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(max <= info[i][1]){
                while(!stack.isEmpty() && stack.peek() != maxIdx){
                    stack.pop();
                }
                max = info[i][1];
                maxIdx = i;
            }else{
                while (!stack.isEmpty() && info[stack.peek()][1] < info[i][1]){
                    stack.pop();
                }
            }

            stack.add(i);
        }

        int total = 0;
        int before = 0;

        Object[] result = stack.toArray();
        for (int i = 0; i < stack.size() && (int)result[i] <= maxIdx ; i++) {
            int idx = (int)result[i];

            if(before == info[idx][1]) continue;
            total += ((info[maxIdx][0]+1) - info[idx][0]) * (info[idx][1] - before);
            before = info[idx][1];
        }

        before = 0;
        for (int i = stack.size()-1;i>=0 && (int)result[i] > maxIdx ; i--) {
            int idx = (int)result[i];

            total += (info[idx][0] - (info[maxIdx][0])) * (info[idx][1] - before);
            before = info[idx][1];
        }

        System.out.println(total);

    }

}