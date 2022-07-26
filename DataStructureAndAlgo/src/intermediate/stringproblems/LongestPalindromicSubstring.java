package intermediate.stringproblems;

/**
 * Problem Description
 * Given a string A of size N, find and return the longest palindromic substring in A.
 *
 * Substring of string A is A[i...j] where 0 <= i <= j < len(A)
 *
 * Palindrome string:
 * A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
 *
 * Incase of conflict, return the substring which occurs first ( with the least starting index).
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 10000
 *
 *
 *
 * Input Format
 * First and only argument is a string A.
 *
 *
 *
 * Output Format
 * Return a string denoting the longest palindromic substring of string A.
 *
 *
 *
 * Example Input
 * A = "aaaabaaa"
 *
 *
 * Example Output
 * "aaabaaa"
 *
 *
 * Example Explanation
 * We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String A) {
        String longestPalindrome = "";
        for(int i=0;i<A.length();i++){
            // for(int j=i+1;j<=A.length();j++){
            //     String s = A.substring(i,j);
            //     // System.out.println(s);
            //     // System.out.println(isPalindrome(s));
            //     if(isPalindrome(s) && longestPalindrome.length()<s.length()){
            //         longestPalindrome = s;
            //     }
            // }

            String s = getLongestPalindrome(A,i);

            if(longestPalindrome.length()<s.length()){
                longestPalindrome = s;
            }


        }
        return longestPalindrome;
    }

    public boolean isPalindrome(String A){
        int mid1 = 0;
        int mid2 = 0;
        if(A.length()%2 == 0){
            mid1 = A.length()/2 - 1;
            mid2 = mid1 + 1;
        }else {
            mid1 = A.length()/2 - 1;
            mid2 = mid1 + 2;
        }

        while(mid1>=0 && mid2<A.length()){
            if(A.charAt(mid1) != A.charAt(mid2)){
                return false;
            }else{
                mid1--;
                mid2++;
            }
        }
        return true;
    }

    public String getLongestPalindrome(String s,int pos){
        if(pos == 0){
            return s.substring(0,1);
        }
        int left = 0;
        int right = 0;
        int length = 0;

        left = pos - 1;
        right = pos;

        while(left>=0 && right <=s.length()-1){
            if(s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }else{
                break;
            }
        }

        String str1 = s.substring(left+1,right);

        left = pos - 1;
        right = pos + 1;

        while(left>=0 && right <=s.length()-1){
            if(s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }else{
                break;
            }
        }

        String str2 = s.substring(left+1,right);

        return str1.length()>=str2.length() ? str1 : str2;

    }
}
