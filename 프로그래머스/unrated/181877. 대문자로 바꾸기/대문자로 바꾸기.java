import java.util.*;

class Solution {
    public String solution(String myString) {
        String answer = "";
        for(char now: myString.toCharArray()){
            if(now >= 'a') now -= 32;
           
            answer += Character.toString(now);
        }
        
        
        return answer;
    }
}