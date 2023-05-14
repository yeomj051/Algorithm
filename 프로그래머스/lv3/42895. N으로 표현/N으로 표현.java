import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        HashSet<Integer>[] hashList = new HashSet[9];
        hashList[0] = new HashSet<>();
        hashList[1] = new HashSet<>();
        hashList[1].add(N);
        int continuity = N;
        if(number==N) return 1;

        for(int i=2; i<9;i++){
            hashList[i] = new HashSet<>();
            HashSet<Integer> now = hashList[i];
            continuity = continuity*10 + N;
            now.add(continuity);
            
            for(int j=1; j<i;j++){
                HashSet<Integer> set1 = hashList[j];
                HashSet<Integer> set2 = hashList[i-j];
                for(int one : set1){
                    for(int two : set2){
                        now.add(one + two);
                        now.add(one - two);
                        now.add(one * two);
                        if(one != 0 && two != 0)
                        now.add(one / two);
                    }
                }
            }
            if(now.contains(number)) return i;
        }
        
        return -1;
    }
}