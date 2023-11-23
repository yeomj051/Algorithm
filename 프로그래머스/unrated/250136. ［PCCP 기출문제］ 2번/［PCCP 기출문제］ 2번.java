import java.util.*;
import java.awt.*;

class Solution {
    //상 우 하 좌
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static ArrayList<Integer> oilList;
    
    public int solution(int[][] land) {
        int answer = 0;
        oilList = new ArrayList<>();
        oilList.add(0);
        oilList.add(0);
        
        //가로
        for(int i=0; i<land[0].length;i++){
            int oil=0;
            ArrayList<Boolean> visited = new ArrayList<>();
            for(int k=0; k<oilList.size(); k++){
                visited.add(false);
            }
            
            //세로
            for(int j=0; j<land.length; j++){
                if(land[j][i] == 0) continue
                    ;
                if(land[j][i] > 1 && !visited.get(land[j][i])){
                    oil += oilList.get(land[j][i]);
                    visited.set(land[j][i],true);
                } 
                
                else if(land[j][i] == 1){
                    int getOil = bfs(land,j,i);
                    oilList.add(getOil);
                    visited.add(true);
                    oil += getOil;
                }
            }
            answer = Math.max(oil,answer);
        }
        
        return answer;
    }
    
    public static int bfs(int[][] land, int sx, int sy){
        Queue<Point> q = new LinkedList<>();
        land[sx][sy] = oilList.size();
        q.add(new Point(sx,sy));
        int count = 1; 
        
        while(!q.isEmpty()){
            Point now = q.poll();
            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx < 0 || nx == land.length || ny < 0 || ny == land[0].length || land[nx][ny] != 1) continue;
                
                land[nx][ny] = oilList.size();
                q.add(new Point(nx,ny));
                count++;
            }
        }
        
        return count;
    }
}