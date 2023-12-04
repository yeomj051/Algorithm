import java.util.*;
import java.awt.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer=0;
        int[] status = new int[n+1];
        Arrays.fill(status, 1);
        for(int i=0; i<reserve.length; i++){
            status[reserve[i]] = 2;
        }
        for(int i=0; i<lost.length; i++){
            if(status[lost[i]] == 2) ;
            status[lost[i]]--;
        }
        
        for(int i=1; i<=n; i++){
            if(status[i] == 0){
                if(i>0 && status[i-1] == 2){
                    status[i]++;
                    status[i-1]--;
                }
                else if(i<n && status[i+1] == 2){
                    status[i]++;
                    status[i+1]--;
                }
            }
            
            if(status[i] > 0) answer++;
        }
        
        return answer;
    }
}