import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] originWL = new long[1001];
        long[] weightList = new long[4001];
        
        for(int i=0; i<weights.length; i++){
            int w1 = weights[i];
            int w2 = weights[i]*2;
            int w3 = weights[i]*3;
            int w4 = weights[i]*4;
            
            if(originWL[w1] > 0){
                long same = originWL[w1];
                answer += same;
                answer += weightList[w2] - same;
                answer += weightList[w3] - same;
                answer += weightList[w4] - same;
            }else{
                answer += weightList[w2];
                answer += weightList[w3];
                answer += weightList[w4];
            }
            
            originWL[w1]++;
            weightList[w2]++;
            weightList[w3]++;
            weightList[w4]++;
        }
        
        return answer;
    }
}