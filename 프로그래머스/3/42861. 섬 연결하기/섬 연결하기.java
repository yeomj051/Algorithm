import java.util.*;

class Solution {
    public static int[] parents;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs,(a,b) -> a[2]-b[2]);
        parents = new int[n];
        for(int i=0; i<n;i++){
            parents[i] = i;
        }
        
        for(int i=0; i<costs.length;i++){
            int start = costs[i][0];
            int end = costs[i][1];
            int cost = costs[i][2];
            
            int startP = getParent(start);
            int endP = getParent(end);
            
            if(startP == endP) continue;
            answer += cost;
            parents[endP] = startP;
        }
        
        return answer;
    }
    
    public static int getParent(int i){
        if(parents[i] == i) return i;
        
        return getParent(parents[i]);
    }
}