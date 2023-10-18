import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length;i++){
            pq.add(works[i]);
        }
        
        for(int i=0; i<n;i++){
            int num = pq.poll();
            pq.add(--num);
        }
        
        for(int i=0; i<works.length;i++){
            int num = pq.poll();
            if(num < 0) continue;
            answer += num*num;
        }
        
        return answer;
    }
}