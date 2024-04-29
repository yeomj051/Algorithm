import java.util.*;

import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] tmp = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Collections.reverseOrder());
        
        for(int i = m-1; i < score.length; i += m){
            answer += tmp[i]*m;
        }
        
        return answer;
    }
}