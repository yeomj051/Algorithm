import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        int nowWeight = 0;
        int idx = 0;
        
        while(idx < truck_weights.length){
            if(queue.size() == bridge_length) {
                nowWeight -= queue.poll();
            }else if(nowWeight + truck_weights[idx] <= weight){
                queue.add(truck_weights[idx]);
                nowWeight += truck_weights[idx++];
                answer++;
            }else{
                queue.add(0);
                answer++;
            }
        }
        
        answer += bridge_length;
        
        return answer;
    }
}