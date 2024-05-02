import java.util.*;
import java.awt.*;

class Solution {
    public static int[] choosed;
    public static HashMap<String, HashMap> map;
    public static int[] result;
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        map = new HashMap<>();
        for(int i=0; i<friends.length; i++){
            map.put(friends[i], new HashMap<String, Integer>());
            map.get(friends[i]).put("index",0);
        }
        
        for(int i=0; i<gifts.length; i++){
            String[] arr = gifts[i].split(" ");
            HashMap<String, Integer> from = map.get(arr[0]);
            from.put(arr[1], from.getOrDefault(arr[1],0) + 1);
            from.put("index", from.get("index")+1);
            
            HashMap<String, Integer> to = map.get(arr[1]);
            to.put("index", to.get("index")-1);
        }
        
        choosed = new int[2];
        result = new int[friends.length];
        dfs(friends, 0, 0);
        
        for(int i=0; i<result.length; i++){
            answer = Math.max(answer, result[i]);
        }
        
        return answer;
    }
    
    public static void dfs(String[] friends, int cnt, int idx){
        if(cnt == 2){
            // System.out.println(friends[choosed[0]] + " " + friends[choosed[1]] + " " + map.get(friends[choosed[0]]).get(friends[choosed[1]]));
            int a = 0;
            if(map.get(friends[choosed[0]]).containsKey(friends[choosed[1]])){
                a = (int) (map.get(friends[choosed[0]]).get(friends[choosed[1]]));
            }
            
            int b = 0;
            if(map.get(friends[choosed[1]]).containsKey(friends[choosed[0]])){
                b = (int) (map.get(friends[choosed[1]]).get(friends[choosed[0]]));
            }
            
            if(a > b) result[choosed[0]]++;
            else if(a < b) result[choosed[1]]++;
            else {
                a = (int) (map.get(friends[choosed[0]]).get("index"));
                b = (int) (map.get(friends[choosed[1]]).get("index"));
                if(a > b) result[choosed[0]]++;
                else if(a < b) result[choosed[1]]++;
            }
            
            return;
        }
        
        for(int i=idx; i<friends.length; i++){
            choosed[cnt] = i;
            dfs(friends, cnt+1, i+1);
        }
    }
}