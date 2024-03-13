import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xSize = Integer.parseInt(st.nextToken());
        int ySize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] block = new int[ySize];
        int biggest = 0;
        int idx = 0;
        for(int i=0; i<ySize; i++){
            block[i] = Integer.parseInt(st.nextToken());
            if(biggest < block[i]){
                biggest = block[i];
                idx = i;
            }
        }

        int big = 0;
        int result = 0;
        for(int i=0; i<=idx; i++){
            int count=0;
            while(i <= idx && big > block[i]){
                count += big - block[i++];
            }

            if(i <= idx && big <= block[i]){
                result += count;
                big = block[i];
            }
        }

        big = 0;
        for(int i=ySize-1; i>=idx; i--){
            int count=0;
            while(i >= idx && big > block[i]){
                count += big - block[i--];
            }

            if(i >= idx && big <= block[i]){
                result += count;
                big = block[i];
            }
        }

        System.out.println(result);
    }
}