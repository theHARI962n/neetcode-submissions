class Solution {
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // skip non-alphanumeric from left
            while (left < right && 
                  !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // skip non-alphanumeric from right
            while (left < right && 
                  !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            char l = Character.toLowerCase(s.charAt(left));
            char r = Character.toLowerCase(s.charAt(right));

            if (l != r) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

// class Solution {
//     public boolean isPalindrome(String s) {
//         int n = s.length();
//         int left = 0;
//         int right = n-1;

//         while(left<right){

//             if( !isalphanum){
//                 return false; 
//             }


//             if(s.charAt(left) != s.charAt(right)){
//                 return false;
//             }

//             left++;
//             right--;
//         }
//         return true;
//     }
// }
