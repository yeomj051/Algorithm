import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        label: for(int i=1; i<=yellow; i++){
            if(yellow%i == 0){
                int y = yellow/i;
                if((i+2)*(y+2) - yellow == brown){
                    answer[0] = y+2;
                    answer[1] = i+2;
                    break label;
                }
            }
            
        }
        
        return answer;
    }
}