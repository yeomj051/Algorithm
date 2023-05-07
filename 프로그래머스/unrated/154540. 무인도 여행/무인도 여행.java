import java.util.*;
import java.awt.*;

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        char[][] map = new char[maps.length][];
        for(int i=0;i<maps.length;i++){
            map[i] = maps[i].toCharArray();
        }
        int xSize = map.length;
        int ySize = map[0].length;
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<xSize;i++){
            for(int j=0; j<ySize; j++){
                if(map[i][j] != 'X') pq.add(bfs(new Point(i,j),map));
            }
        }
        
        if(pq.size() == 0){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        answer = new int[pq.size()];
        for(int i=0, size = pq.size(); i< size;i++){
            answer[i] = pq.poll();
        }
        
        return answer;
    }
    
    public int bfs(Point start, char[][] map){
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        int result = (int) (map[start.x][start.y] -'0');
        map[start.x][start.y] = 'X';
        
        while(!queue.isEmpty()){
            Point nowPoint = queue.poll();
            
            for(int i=0; i<4; i++){
                int nx = nowPoint.x + dx[i];
                int ny = nowPoint.y + dy[i];
                
                if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length 
                   && map[nx][ny] != 'X'){
                    result += (int) (map[nx][ny] - '0');
                    map[nx][ny] = 'X';
                    queue.add(new Point(nx,ny));
                }
            }
        }
        System.out.println();
        
        return result;
    }
}