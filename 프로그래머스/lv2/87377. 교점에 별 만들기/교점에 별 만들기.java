import java.util.*;
import java.lang.*;

class Solution {
    public static long[][] visited;
    public static int xMin,xMax,yMin,yMax;
    public static ArrayList<Integer> list;
    
    public String[] solution(int[][] line) {
        String[] answer;
        visited = new long[2][3];
        list = new ArrayList<>();
        xMin = Integer.MAX_VALUE;
        yMin = Integer.MAX_VALUE;
        xMax = Integer.MIN_VALUE;
        yMax = Integer.MIN_VALUE;
        
        dfs(line,0,0);
        
        String[][] result = new String[yMax - yMin+1][xMax - xMin+1];
        for(int i=0; i<list.size();i=i+2){
            int x = list.get(i)-xMin;
            int y = list.get(i+1)-yMin;
            result[y][x] = "*";
        }
        
        answer = new String[result.length];
        for(int i=0; i<result.length;i++){
            answer[result.length-i-1]="";
            for(int j=0; j<result[0].length; j++){
                if(result[i][j] == null){
                    answer[result.length-i-1] += ".";
                }else{
                    answer[result.length-i-1] += "*";
                }
            }
        }
        
        return answer;
    }
    
    public static void dfs(int[][] line,int count,int index){
        if(count == 2){
            if(((visited[0][0]*visited[1][1])-(visited[0][1]*visited[1][0])) != 0
               && ((visited[0][1]*visited[1][2])-(visited[0][2]*visited[1][1])) 
               % ((visited[0][0]*visited[1][1])-(visited[0][1]*visited[1][0])) == 0
              && ((visited[0][2]*visited[1][0])-(visited[0][0]*visited[1][2])) 
               % ((visited[0][0]*visited[1][1])-(visited[0][1]*visited[1][0])) == 0){
                
                int x = (int)(((visited[0][1]*visited[1][2])-(visited[0][2]*visited[1][1])) 
                / ((visited[0][0]*visited[1][1])-(visited[0][1]*visited[1][0])));
                int y = (int)(((visited[0][2]*visited[1][0])-(visited[0][0]*visited[1][2])) 
                / ((visited[0][0]*visited[1][1])-(visited[0][1]*visited[1][0])));
                
                xMax = Math.max(xMax,x);
                xMin = Math.min(xMin,x);
                yMax = Math.max(yMax,y);
                yMin = Math.min(yMin,y);
                list.add(x);
                list.add(y);
            }
            return;
        }
        
        for(int i=index; i<line.length;i++){
            visited[count][0] = (long)line[i][0];
            visited[count][1] = (long)line[i][1];
            visited[count][2] = (long)line[i][2];
            dfs(line, count+1, i);
        }
    }
}