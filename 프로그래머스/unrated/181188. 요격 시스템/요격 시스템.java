import java.util.*;

class Solution {
    
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
            
        int x=0;
        for(int i=0; i<targets.length;i++){
            if(x <= targets[i][0]){
                x = targets[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}