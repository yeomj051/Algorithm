import java.util.*;

class Solution
{
    public int solution(int[] A, int[] B)
    {
        int answer = 0;
        
        Arrays.sort(A);
        PriorityQueue<Integer> bPQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<A.length;i++){
            bPQ.add(B[i]);
        }
        
        for(int i=0; i<A.length;i++){
            answer += A[i]*bPQ.poll();
        }

        return answer;
    }
}