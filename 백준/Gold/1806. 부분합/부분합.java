import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] arr = new long[size];
        for(int i=0; i<size; i++){
            arr[i] = Long.parseLong(st.nextToken());
            if(arr[i] >= num){
                System.out.println(1);
                return;
            }
        }
        int start = 0;
        int end = 1;
        long sum = arr[start] + arr[end];
        int min = Integer.MAX_VALUE;

        while(end < size-1 || sum >= num){
            if(sum >= num) {
                min = Math.min(end-start+1,min);
                if(end-start>1){
                    sum -= arr[start];
                    start++;
                }else break;
            }else if(end < size-1){
                end++;
                sum += arr[end];
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}