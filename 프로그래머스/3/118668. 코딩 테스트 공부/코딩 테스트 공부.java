import java.util.*;
import java.awt.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int alT = 0;
        int coT = 0;
        
        for(int i=0; i<problems.length; i++){
            alT = Math.max(alT, problems[i][0]);
            coT = Math.max(coT, problems[i][1]);
        }
        
        if(alp >= alT && cop >= coT) return 0;
        if(alp >= alT) alp = alT;
        if(cop >= coT) cop = coT;
        
        int[][] dp = new int[alT+2][coT+2];
        for(int i=alp; i<=alT;i++){
            for(int j=cop; j<=coT;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dp[alp][cop] = 0;
        
        for(int i=alp; i<=alT; i++){
            for(int j=cop; j<=coT; j++){
                dp[i+1][j] = Math.min(dp[i+1][j],dp[i][j]+1);
                dp[i][j+1] = Math.min(dp[i][j+1],dp[i][j]+1);
                
                for(int p=0; p<problems.length;p++){
                    if(i >= problems[p][0] && j >= problems[p][1]){
                        if(i+problems[p][2] > alT && j+problems[p][3] > coT){
                            dp[alT][coT] = Math.min(dp[alT][coT],dp[i][j]+problems[p][4]);
                        }
                        else if(i+problems[p][2] > alT){
                            dp[alT][j+problems[p][3]] = Math.min(dp[alT][j+problems[p][3]],dp[i][j]+problems[p][4]);
                        }
                        else if(j+problems[p][3] > coT){
                            dp[i+problems[p][2]][coT] = Math.min(dp[i+problems[p][2]][coT],dp[i][j]+problems[p][4]);
                        }
                        else if(i+problems[p][2] <= alT && j+problems[p][3] <= coT){
                            dp[i+problems[p][2]][j+problems[p][3]] 
                                = Math.min(dp[i+problems[p][2]][j+problems[p][3]],dp[i][j]+problems[p][4]);
                        }
                    }
                }
            }
        }
        answer = dp[alT][coT];
        
        return answer;
    }
}