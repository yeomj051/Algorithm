import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        PriorityQueue<int[]> partSequence = new PriorityQueue<>(
            (int[] a, int[] b) -> {
                return (a[1]-a[0])-(b[1]-b[0]);
            });
        
        Queue<Integer> queue = new LinkedList<>();
        int count=0;
        int[] part = new int[2];
        part[0] = 0;
        for(int i=0; i<sequence.length;i++){
            count += sequence[i];
            queue.add(i);
            part[1] = i;
            
            while(count > k){
                int num = queue.poll();
                count -= sequence[num];
                part[0]++;
            }
            
            if(count == k){
                partSequence.add(part.clone());
            }
        }
        
        answer = partSequence.poll();
        return answer;
    }
}