public class Palindrome_Number {
    
}
class Solution {
    public boolean isPalindrome(int x) {
        if(x>=0){
            int orignal = x;
            int reverse=0;
            while(x!=0){
                int digit=x%10;
                reverse=reverse*10+digit;
                x/=10;
        
            }
            if(orignal==reverse){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
}