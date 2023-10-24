import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        int count = 0;
        HashSet<String> word = new HashSet<>();
        boolean flag = true;
        char[] nowCharArr = words[0].toCharArray();
        char lastSpell = nowCharArr[0];
        
        while(flag && words.length > count*n){
            for(int i=0; i<n && words.length > count*n+i; i++){
                String nowWord = words[count*n+i];
                
                if(word.contains(nowWord)){
                    flag = false;
                    answer[0] = i+1;
                    answer[1] = count+1;
                    break;
                }
                else{
                    nowCharArr = nowWord.toCharArray();
                    if(lastSpell == nowCharArr[0]){
                        word.add(nowWord);
                        lastSpell = nowCharArr[nowCharArr.length-1];
                    } else{
                        flag = false;
                        answer[0] = i+1;
                        answer[1] = count+1;
                        break;
                    }
                    
                }
            }
            
            count++;
        }

        return answer;
    }
}