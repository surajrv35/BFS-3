// Time Complexity : exponential
// Space Complexity : exponential
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new LinkedList<>();
        
        //base case
        if(s == null)
            return result;
        
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        boolean shouldExploreNextLevel = true;
        
        q.add(s);
        
        while(!q.isEmpty())
        {
            int levelCount=q.size();
            for(int i=0; i<levelCount; i++) {
                String current=q.poll();
                
                if(!visited.contains(current)) {
                    if(isValid(current)) {
                        shouldExploreNextLevel=false;
                        result.add(current);
                    }
                    
                visited.add(current);
                
                if(shouldExploreNextLevel) {
                    for(int k=0;k<current.length();k++) {
                        if(Character.isLetter(current.charAt(k))) continue;
                        String child=current.substring(0, k)+current.substring(k+1);
                    
                        q.add(child);
                    }
                }
            }
            }
            if(!shouldExploreNextLevel) break;
        }
        return result;
    }
    private boolean isValid(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            
            if(ch == '(') count++;
            if(ch == ')') count--;
            
            if(count < 0) return false;
        }
        return count == 0;
    }
}
