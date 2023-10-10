class Solution {
    public static char[][] map;
    
    public int solution(String[] board) {
        int answer = -1;
        map = new char[3][3];
        int OBcnt=0;
        int XBcnt=0;
        int Ocnt=0;
        int Xcnt=0;
        
        for(int i=0; i<3; i++){
            map[i] = board[i].toCharArray();
            for(int j=0; j<3; j++){
                if(map[i][j] == 'O') Ocnt++;
                else if(map[i][j] == 'X') Xcnt++;
            }
        }
        if(Ocnt < Xcnt || Ocnt-Xcnt > 1) return 0;
        
        OBcnt = checkBingo('O');
        XBcnt = checkBingo('X');
        
        if(OBcnt>0&&XBcnt>0) return 0;
        if((OBcnt>0 && Ocnt==Xcnt) || (XBcnt>0 && Ocnt>Xcnt)) return 0;
        
        return 1;
    }
    
    public static int checkBingo(char start){
        int result=0;
        //가로
        for(int x=0; x<3;x++){
            if(map[x][0] == start && map[x][1] == start && map[x][2] == start) result++;
        }
        
        //세로
        for(int y=0; y<3;y++){
            if(map[0][y] == start && map[1][y] == start && map[2][y] == start) result++;
        }
        
        if(map[0][0] == start && map[1][1] == start && map[2][2] == start) result++;
        if(map[0][2] == start && map[1][1] == start && map[2][0] == start) result++;
        
        return result;
    }
}