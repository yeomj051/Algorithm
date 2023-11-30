import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int[] arr = commands[i];
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for(int j=arr[0]-1; j<arr[1]; j++){
                q.add(array[j]);
            }
            
            while(arr[2]-- > 0){
                answer[i] = q.poll();
            }
        }
        
        return answer;
    }
}