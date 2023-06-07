import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        // Stack<Integer> stack = new Stack<>();
        int stack = 0;
        int remain = 0;
        
        List<Integer> answerList = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++){
            int remainDev = 100-progresses[i];
            int remainDays = remainDev/speeds[i];
            if(remainDev%speeds[i] != 0) remainDays++;
                
            if(remain >= remainDays) stack++;
            else {
                remain = remainDays;
                if(stack == 0){
                    stack++;
                    continue;
                } 
                answerList.add(stack);
                stack = 1;
            }
        }
        answerList.add(stack);
        
        answer = new int[answerList.size()];
        int count=0;
        for(int result: answerList){
            answer[count] = result;
            count++;
        }
        
        return answer;
    }
}