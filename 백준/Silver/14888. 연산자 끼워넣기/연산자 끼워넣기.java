import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static long[] numberList;
    public static int[] minOrderList,maxOrderList;
    public static long minR,maxR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        numberList = new long[N];
        for (int i = 0; i < N; i++) {
            numberList[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        minOrderList = new int[4];
        maxOrderList = new int[4];
        for (int i = 0; i < 4; i++) {
            int orderCnt = Integer.parseInt(st.nextToken());
            minOrderList[i] = orderCnt;
            maxOrderList[i] = orderCnt;
        }

        long[] minResult = new long[N];
        long[] maxResult = new long[N];
        Arrays.fill(minResult,Long.MAX_VALUE);
        Arrays.fill(maxResult,Long.MIN_VALUE);

        minResult[0] = numberList[0];
        maxResult[0] = numberList[0];
        minR = Long.MAX_VALUE;
        maxR = Long.MIN_VALUE;
        minDfs(1,minResult);
        maxDfs(1,maxResult);

        StringBuilder sb = new StringBuilder().append(maxR).append("\n").append(minR);
        System.out.println(sb);
    }

    private static void minDfs(int idx, long[] Result) {
        if(idx == N){
            minR = Math.min(Result[N-1],minR);
            return;
        }

        long[] resultList = new long[4];
        resultList[0] = Result[idx-1] + numberList[idx];
        resultList[1] = Result[idx-1] - numberList[idx];
        resultList[2] = Result[idx-1] * numberList[idx];
        if(Result[idx-1] != 0) resultList[3] = Result[idx-1] / numberList[idx];

        for (int i = 0; i < 4; i++) {
            if(minOrderList[i]>0 && Result[idx] >= resultList[i]) {
                Result[idx] = resultList[i];
                minOrderList[i]--;
                minDfs(idx+1, Result);
                Result[idx] = Long.MAX_VALUE;
                minOrderList[i]++;
            }
        }
    }

    private static void maxDfs(int idx, long[] Result) {
        if(idx == N){
            maxR = Math.max(Result[N-1],maxR);
            return;
        }

        long[] resultList = new long[4];
        resultList[0] = Result[idx-1] + numberList[idx];
        resultList[1] = Result[idx-1] - numberList[idx];
        resultList[2] = Result[idx-1] * numberList[idx];
        if(Result[idx-1] != 0) resultList[3] = Result[idx-1] / numberList[idx];

        for (int i = 0; i < 4; i++) {
            if(maxOrderList[i]>0 && Result[idx] <= resultList[i]) {
                Result[idx] = resultList[i];
                maxOrderList[i]--;
                maxDfs(idx+1, Result);
                Result[idx] = Long.MIN_VALUE;
                maxOrderList[i]++;
            }
        }
    }
}
