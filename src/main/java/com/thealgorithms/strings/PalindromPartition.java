class Solution {
    boolean isPalindrome(String str , int s , int e)
    {

        while(s < e)
        {
           if(str.charAt(s) != str.charAt(e))
           {
               return false;
           } 
           s++;
           e--;
        }
        return true;
    }
     void solve(String s , int index ,List<List<String>> result , List<String> path )
    {
        
        if(index == s.length())
        {
            result.add(new ArrayList<>(path));
        }
        
        for(int i = index ; i < s.length() ; i++)
        {
            if(isPalindrome(s ,index ,i)){
                path.add(s.substring(index , i+1));
                solve(s  , i+1 , result , path);
                path.remove(path.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) 
    {
        List<List<String>> result = new ArrayList<>();
       List<String> path = new ArrayList<>();
       solve(s , 0 , result , path);
       return result; 
    }
}
