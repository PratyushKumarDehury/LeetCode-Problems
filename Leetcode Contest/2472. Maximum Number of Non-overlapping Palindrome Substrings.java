You are given a string s and a positive integer k.

Select a set of non-overlapping substrings from the string s that satisfy the following conditions:

The length of each substring is at least k.
Each substring is a palindrome.
Return the maximum number of substrings in an optimal selection.

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: s = "abaccdbbd", k = 3
Output: 2
Explanation: We can select the substrings underlined in s = "abaccdbbd". Both "aba" and "dbbd" are palindromes and have a length of at least k = 3.
It can be shown that we cannot find a selection with more than two valid substrings.
Example 2:

Input: s = "adbcda", k = 2
Output: 0
Explanation: There is no palindrome substring of length at least 2 in the string.
 

Constraints:

1 <= k <= s.length <= 2000
s consists of lowercase English letters.










class Solution {
    public int maxPalindromes(String s, int k) {
        
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                int len = (j-i)+1;

                if(len > k+1) break;
                
                  if (len >= k && isPalindrome(s, i, j)) {
                    ans++;
                    i = j;
                    break;

                }
            }
        }
        return ans;
    }
    boolean isPalindrome(String s ,int l,int r){
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)){
                return false;
            }
        }
        return true;
    }
    
}

