import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class NumInfo{
        int number;
        int count;
        public NumInfo(int number, int count){
            this.number = number;
            this.count = count;
        }
    }
    public static int r,c,k;
    public static int xSize,ySize;
    public static int[][] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        array = new int[101][101];
        xSize = ySize = 3;
        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while(count <= 100 && array[r][c] != k){
            if(xSize >= ySize){
                xOrder();
            }else{
                yOrder();
            }
            count++;
        }
        if(count == 101) System.out.println(-1);
        else System.out.println(count);
    }
    private static void xOrder() {
        PriorityQueue<NumInfo> queue = new PriorityQueue<>((NumInfo a,NumInfo b) -> {
            if(a.count == b.count) return a.number - b.number;
            return a.count - b.count;
        });

        for (int i = 1; i <= xSize; i++) {
            HashMap<Integer,Integer> hash = new HashMap<>();
            for (int j = 1; j <= ySize; j++) {
                int number = array[i][j];
                if(number > 0){
                    if(!hash.containsKey(number)) hash.put(number,0);
                    hash.replace(number,hash.get(number)+1);
                }
            }

            int index = 1;
            for (Integer number : hash.keySet()) {
                queue.add(new NumInfo(number,hash.get(number)));
            }
            Arrays.fill(array[i],0);
            while(!queue.isEmpty() && index <= 100){
                NumInfo now = queue.poll();
                array[i][index++] = now.number;
                array[i][index++] = now.count;
            }

            ySize = Math.max(ySize,index);
        }
    }

    private static void yOrder() {
        PriorityQueue<NumInfo> queue = new PriorityQueue<>((NumInfo a,NumInfo b) -> {
            if(a.count == b.count) return a.number - b.number;
            return a.count - b.count;
        });

        for (int i = 1; i <= ySize; i++) {
            HashMap<Integer,Integer> hash = new HashMap<>();
            for (int j = 1; j <= xSize; j++) {
                int number = array[j][i];
                if(number > 0){
                    if(!hash.containsKey(number)) hash.put(number,0);
                    hash.replace(number,hash.get(number)+1);
                }
            }

            int index = 1;
            for (Integer number : hash.keySet()) {
                queue.add(new NumInfo(number,hash.get(number)));
            }

            for (int k=1;k<=100;k++){
                array[k][i] = 0;
            }
            while(!queue.isEmpty() && index <= 100){
                NumInfo now = queue.poll();
                array[index++][i] = now.number;
                array[index++][i] = now.count;
            }

            xSize = Math.max(xSize,index);
        }
    }
}