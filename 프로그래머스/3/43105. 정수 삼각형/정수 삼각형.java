import java.util.*;
import java.awt.*;

class Solution {
    
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][];
        dp[0] = new int[1];
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i<triangle.length; i++){
            dp[i] = new int[triangle[i].length];
            
            for(int j=0; j<triangle[i].length; j++){
                if(j==0) dp[i][j] = dp[i-1][j] + triangle[i][j];
                else if(j == triangle[i-1].length) dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                else dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j],dp[i-1][j-1]);
                
                answer = Math.max(answer, dp[i][j]);
            }
        }
        
        return answer;
    }
}