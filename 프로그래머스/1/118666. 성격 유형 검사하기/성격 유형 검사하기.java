import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        HashMap<Character,Integer> typeList = new HashMap<>();
        typeList.put('R',0);
        typeList.put('T',0);
        typeList.put('C',0);
        typeList.put('F',0);
        typeList.put('J',0);
        typeList.put('M',0);
        typeList.put('A',0);
        typeList.put('N',0);
        
        for(int i=0; i < survey.length; i++){
            char[] nowType = survey[i].toCharArray();
            int score = choices[i]%4;
            if(choices[i]/4 == 1){
                typeList.replace(nowType[1],typeList.get(nowType[1])+score);
            }else if(score == 0){}
            else{
                typeList.replace(nowType[0],typeList.get(nowType[0])+(4-score));
            }
        }
        
        int count = 2;
        int beforeScore = 0;
        char beforeType = 0;
        
        int score1 = typeList.get('R');
        int score2 = typeList.get('T');
        if(score1 >= score2) answer += Character.toString('R');
        else answer += Character.toString('T');
        
        score1 = typeList.get('C');
        score2 = typeList.get('F');
        if(score1 >= score2) answer += Character.toString('C');
        else answer += Character.toString('F');
        
        score1 = typeList.get('J');
        score2 = typeList.get('M');
        if(score1 >= score2) answer += Character.toString('J');
        else answer += Character.toString('M');
        
        score1 = typeList.get('A');
        score2 = typeList.get('N');
        if(score1 >= score2) answer += Character.toString('A');
        else answer += Character.toString('N');
        
        
        return answer;
    }
}