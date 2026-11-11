// class Solution {
//     public boolean isHappy(int n) {
//         int len = n.length;

//         int sum = 0;
//         while(sum != 1 ){
//             for(int i = 0 ; i <len;i++){
//                 sum = sum + i*i ; 
//             }
//             if (sum == 1) break;
//             else {
//                 len = sum.length;
//             }
//         }
        
//         return true;
//     }
// }




class Solution {
    public boolean isHappy(int n) {

        Set<Integer> seen = new HashSet<>();

        while (n != 1) {

            if (seen.contains(n)) {
                return false;
            }

            seen.add(n);

            int sum = 0;

            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }

            n = sum;
        }

        return true;
    }
}
