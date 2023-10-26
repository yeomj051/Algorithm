import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n,w,l;
    public static int[] tList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        tList = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tList[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        int time = 0;
        int weight = 0;
        int doneIdx = 0;
        int[] tChack = new int[n];
        while(idx < n || doneIdx < n){
            for(int i=doneIdx;i<idx;i++){
                tChack[i]++;
                if(tChack[i] > w){
                    weight -= tList[i];
                    doneIdx++;
                }
            }

            if(idx < n && weight+tList[idx] <= l){
                weight += tList[idx];
                tChack[idx++]++;
            }
            time++;
        }

        System.out.println(time);
    }
}
