class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = Integer.MAX_VALUE;
        
        long[] totalList = new long[queue1.length + queue2.length+1];
        long totalScore = 0;
        
        for(int i=0; i<queue1.length;i++){
            totalList[i] = (long) queue1[i];
            totalScore += totalList[i];
        }
        for(int i=queue1.length;i<totalList.length-1;i++){
            totalList[i] = (long) queue2[i-queue1.length];
            totalScore += totalList[i];
        }
        long half = totalScore/2;
        
        long score = totalList[0];
        int startIdx = 0;
        int endIdx = 1;
        while(startIdx < totalList.length && endIdx < totalList.length){
            if(score < half) score += totalList[endIdx++];
            else if(score > half) score -= totalList[startIdx++];
            
            if(score == half){
                int count = 0;
                if(startIdx < queue1.length && endIdx < queue1.length){
                    count += endIdx + queue2.length;
                }
                else if(startIdx > queue1.length && endIdx > queue1.length){
                    count += endIdx + (startIdx-queue1.length);
                }else{
                    count += startIdx + (endIdx - queue1.length);
                }
                
                answer = Math.min(answer,count);
                score += totalList[endIdx++];
            }
            
        }
        
        if(answer == Integer.MAX_VALUE) answer = -1;
        
        return answer;
    }
}