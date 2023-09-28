import java.util.*;

class Solution {
    public String solution(String[] str_list, String ex) {
        String answer = "";
        int[] abc = new int[26];
        
        for(int i=0; i<str_list.length; i++){
            boolean flag = true;
            
            for(int j=0; j+ex.length() <= str_list[i].length(); j++){
                if(ex.equals(str_list[i].substring(j,j+ex.length()))) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) answer += str_list[i];
        }
        
        return answer;
    }
}