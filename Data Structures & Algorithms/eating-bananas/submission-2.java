class Solution {

    public int predicate(int mid ,int[] piles, int h){
        long total_h = 0;

        for(int i = 0 ; i< piles.length; i++){
            total_h += (piles[i]+mid-1)/mid ;
        }

        if(total_h <= h){
           return 1;
        }
        else return 0;
    }



    public int minEatingSpeed(int[] piles, int h) {
      int l = 0;

      int maxPile = 0;
      for(int pile : piles){
        maxPile = Math.max(maxPile, pile);
      }

      int r = maxPile;



      while( r-l>1){
        int mid = l + (r-l)/2;
        if(predicate(mid ,piles ,h) == 0){
            l = mid;
        }
        else {
            r = mid;
        }
      }
        return r;
    }
}