import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N,T,S;
    public static int[] room;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        room = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            room[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        long totalT = 0;
        for (int i = 0; i < N; i++) {
            if(T >= S){
                room[i] -= T;
                totalT++;
                if(room[i] > 0){
                    totalT += room[i] / S;
                    if(room[i] % S > 0) totalT++;
                }

            }
            else{
                totalT += room[i] / S;
                if(room[i] % S > 0){
                    if(room[i] % S > T) totalT += 2;
                    else totalT++;
                }else{
                    totalT++;
                }
            }
        }

        System.out.println(totalT);
    }
}