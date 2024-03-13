import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
//    3
//            000
//            010
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        char[] beforeArr = br.readLine().toCharArray();
        char[] afterArr = br.readLine().toCharArray();

        int[] before = new int[size];
        int[] after = new int[size];
        for(int i=0; i<size; i++){
            before[i] = beforeArr[i]-'0';
            after[i] = afterArr[i]-'0';
        }

        int countY = 0;
        int countN = 0;
        int[] beforeY = before.clone();
        change(beforeY,0,size);
        countY++;

        for (int i = 1; i < size; i++) {
            if(beforeY[i-1] != after[i-1]) {
                change(beforeY,i,size);
                countY++;
            }
            if(before[i-1] != after[i-1]) {
                change(before,i,size);
                countN++;
            }
        }

        int last = size-1;
        int result = Integer.MAX_VALUE;

        if(beforeY[last] == after[last]) result = countY;
        if(before[last] == after[last]) result = Math.min(countN,result);
        if(result == Integer.MAX_VALUE) result = -1;

        System.out.println(result);
    }

    public static void change(int[] arr, int now, int size){
        int start = now-1;
        for(int i=0; i<3; i++){
            if(start+i >= 0 && start+i < size){
                arr[start+i] = arr[start+i] == 0? 1:0;
            }
        }
    }
}