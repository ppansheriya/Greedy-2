Time Complexity = O(n)
Space Complexity = O(1)

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        
        int maxFreq = 0;
        int maxOcc = 0;
        
        for(char task: tasks){
            freq[task - 'A']++;
            
            if(freq[task - 'A'] > maxFreq){
                maxFreq = freq[task - 'A'];
                maxOcc = 1;
            }else if(freq[task- 'A'] == maxFreq){
                maxOcc++;
            }
            
        }
        
        int partition = maxFreq - 1;
        int empty_slots = partition * (n-(maxOcc -1));
        int pending_tasks = tasks.length - maxFreq *maxOcc;
        int idle_slots = Math.max(0,empty_slots - pending_tasks);
        return tasks.length + idle_slots;
    }
}