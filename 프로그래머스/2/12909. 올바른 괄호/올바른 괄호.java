class Solution {
    boolean solution(String s) {
        boolean answer = true;
        // Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int cnt = 0;
        for(int i=0; i < arr.length; i++){
            if(arr[i] == '(') cnt++;
            else cnt--;
            
            if(cnt < 0) return false;
        }
        
        if(cnt != 0) answer = false;

        return answer;
    }
}