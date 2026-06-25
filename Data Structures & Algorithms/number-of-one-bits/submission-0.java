// class Solution {
//     public int hammingWeight(int n) {
//         int l = String.valueOf(n).length(); 
//         int count = 0;
//         for(int i = 0;i <l; i++){
//             if((n & (1 << i) ) != 0){
//                 count++;
//             }
//         }
//         return count;
//     }
// }
class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        for(int i = 0; i < 32; i++) {
            if((n & (1 << i)) != 0) {
                count++;
            }
        }

        return count;
    }
}