import java.util.*;
import java.awt.*;

class Solution {
    //상 우 하 좌
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int xSize, ySize;
    
    public int solution(String[] maps) {
        int answer = -1;
        xSize = maps.length;
        ySize = maps[0].toCharArray().length;
        int[][] dpL = new int[xSize][ySize];
        int[][] dpE = new int[xSize][ySize];
        Point pointL = new Point();
        Point pointE = new Point();

        
        for(int i=0; i<xSize; i++){
            char[] arr = maps[i].toCharArray();
            
            for(int j=0; j<ySize; j++){
                if(arr[j] == 'O') {
                    dpL[i][j] = Integer.MAX_VALUE;
                    dpE[i][j] = Integer.MAX_VALUE;
                }
                else if(arr[j] == 'S'){
                    dpL[i][j] = 0;
                    dpE[i][j] = Integer.MAX_VALUE;
                    pointL.x = i;
                    pointL.y = j;
                } 
                else if(arr[j] == 'L') {
                    dpL[i][j] = -1;
                    dpE[i][j] = 0;
                    pointE.x = i;
                    pointE.y = j;
                }
                else if(arr[j] == 'E'){
                    dpL[i][j] = Integer.MAX_VALUE;
                    dpE[i][j] = -1;
                }
                else {
                    dpL[i][j] = -2;
                    dpE[i][j] = -2;
                }
            }
        }
        
        answer = bfs(dpL, pointL);
        if(answer != -1){
            int result = bfs(dpE, pointE);
            if(result != -1) answer += result;
            else answer = -1;
        }
        
        return answer;
    }
    
    public static int bfs(int[][] dp, Point start){
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        
        while(!queue.isEmpty()){
            Point now = queue.poll();
            
            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx<0 || nx >=xSize || ny<0 || ny>=ySize || dp[nx][ny] == -2) continue;
                else if(dp[nx][ny] == -1){
                    return dp[now.x][now.y]+1;
                }
                else if(dp[nx][ny] > dp[now.x][now.y]+1){
                    dp[nx][ny] = dp[now.x][now.y]+1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        
        return -1;
    }
    
}