import java.util.*;
import java.awt.*;

class Solution {
    public static HashMap<String, Integer> mineral;
    public static int answer = Integer.MAX_VALUE;
    
    public int solution(int[] picks, String[] minerals) {
        mineral = new HashMap<>();
        mineral.put("diamond",0);
        mineral.put("iron",1);
        mineral.put("stone",2);
        int totalPick = picks[0]+picks[1]+picks[2];
        
        dfs(picks, minerals,0,totalPick,0);
        
        return answer;
    }
    
    public static void dfs(int[] picks,String[] minerals,int index,int totalPick, int tired){
        if(index >= minerals.length || totalPick == 0){
            // System.out.println(tired);
            answer = Math.min(answer,tired);
            return;
        }
        
        for(int i=0; i<3;i++){
            if(picks[i] > 0){
                picks[i]--;
                int addTired = 0;
                int j;
                for(j=0; j<5 && index+j<minerals.length;j++){
                    int squares = i-mineral.get(minerals[index+j]);
                    if(squares < 0) squares = 0;
                    addTired += (int) Math.pow(5,squares);
                }
                // System.out.println(i + " " + index + " " +addTired);
                dfs(picks, minerals,index+j, totalPick-1, tired+addTired);
                picks[i]++;
            }
        }
    }
}