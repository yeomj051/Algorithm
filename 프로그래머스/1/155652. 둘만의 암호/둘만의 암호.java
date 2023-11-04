import java.util.*;
import java.awt.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        char[] alphaArr = alpha.toCharArray();
        char[] sArr = s.toCharArray();
        char[] skipArr = skip.toCharArray();
        
        for(int i=0; i<alphaArr.length; i++){
            for(int j=0; j<skipArr.length;j++){
                if(alphaArr[i] == skipArr[j]) alphaArr[i] = '1';
            }
        }
        
        for(int i=0; i<sArr.length; i++){
            int count = 0;
            int nowIdx = (int)(sArr[i] - 'a');
            
            while(count < index) {
                nowIdx++;
                if(nowIdx == 26) nowIdx = 0;
                if(alphaArr[nowIdx] != '1') count++;
            }
            
            answer += Character.toString(alphaArr[nowIdx]);
        }
        
        return answer;
    }
}