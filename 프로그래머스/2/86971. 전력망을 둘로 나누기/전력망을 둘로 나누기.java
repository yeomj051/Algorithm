import java.util.*;
import java.awt.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 101;
        
        int[][] map = new int[n+1][n+2];
        for(int i=0; i<wires.length; i++){
            map[wires[i][0]][wires[i][1]] = 1;
            map[wires[i][0]][n+1]++;
            map[wires[i][1]][wires[i][0]] = 1;
            map[wires[i][1]][n+1]++;
        }
        
        for(int i=1; i<=n; i++){
            if(map[i][n+1] > 1){
                for(int j=1; j<=n; j++){
                    if(map[i][j] == 1 && map[j][n+1] > 0){
                        map[i][j] = 0;
                        map[j][i] = 0;
                        
                        int area1 = bfs(map,i);
                        int area2 = bfs(map,j);
                        int diff = Math.abs(area1-area2);
                        answer = Math.min(diff,answer);
                        
                        map[i][j] = 2;
                        map[j][i] = 2;
                    }
                }
            }
        }
        
        return answer;
    }
    
    public static int bfs(int[][] map,int start){
        Queue<Integer> q = new LinkedList<>();
        int n = map.length-1;
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        int result = 1;
        q.add(start);
        
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=1; i<=n; i++){
                if(map[now][i] > 0 && !visited[i]){
                    result++;
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        
        return result;
    }
}