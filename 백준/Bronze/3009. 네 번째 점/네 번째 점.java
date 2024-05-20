import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        
        for(int i=0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer x = Integer.parseInt(st.nextToken());
            Integer y = Integer.parseInt(st.nextToken());
            
            map1.put(x,map1.getOrDefault(x,0)+1);
            map2.put(y,map2.getOrDefault(y,0)+1);
        }
        
        StringBuilder sb = new StringBuilder();
        for(Integer x: map1.keySet()){
            if(map1.get(x) == 1) sb.append(x).append(" ");
        }
        
        for(Integer y: map2.keySet()){
            if(map2.get(y) == 1) sb.append(y).append(" ");
        }
        
        System.out.println(sb);
    }
}