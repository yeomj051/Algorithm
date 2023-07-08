import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] sChar = s.toCharArray();
        boolean flag = true;
        char first = sChar[0];
        int firstCount = 0;
        int anotherCount = 0;
        
        for(int i=0; i<sChar.length;i++){
            if(flag){
                first = sChar[i];
                firstCount=1;
                flag = false;
            }
            else{
                if(first != sChar[i]) anotherCount++;
                else firstCount++;
                
                if(anotherCount == firstCount){
                    anotherCount = 0;
                    flag = true;
                    answer++;
                }
            }
        }
        if(!flag) answer++;
        
        return answer;
    }
}