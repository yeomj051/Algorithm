import java.lang.*;
import java.util.*;

class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        HashSet<Integer> hash = new HashSet<>();
        hash.add(a);
        hash.add(b);
        hash.add(c);
        
        answer += (a + b + c);
        if(hash.size() == 1){
            answer = answer * ((int)Math.pow(a,2)*3) * ((int)Math.pow(a,3)*3);
        }else if(hash.size() == 2){
            answer = answer * ((int)Math.pow(a,2)+(int)Math.pow(b,2)+(int)Math.pow(c,2));
        }
        
        return answer;
    }
}