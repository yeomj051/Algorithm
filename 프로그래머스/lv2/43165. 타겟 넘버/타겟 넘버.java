class Solution {
    public static int count = 0;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int[] orderList = new int[numbers.length];
        
        dfs(0,orderList,numbers,target);
        
        answer = count;
        
        return answer;
    }
    
    public void dfs(int index, int[] orderList,int[] numbers,int target){
        if(index >= orderList.length){
            int total = 0;
            for(int i=0;i<orderList.length;i++){
                total += numbers[i] * orderList[i];
            }
            
            if(total == target) count++;
            return;
        }
        
        orderList[index] = 1;
        dfs(index+1,orderList,numbers,target);
        
        orderList[index] = -1;
        dfs(index+1,orderList,numbers,target);
    }
}