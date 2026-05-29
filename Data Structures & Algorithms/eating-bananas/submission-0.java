class Solution {

    public int predicate(int k, int[] piles, int h) {

        long tot_h = 0;

        for (int i = 0; i < piles.length; i++) {

            tot_h += (piles[i] + k - 1) / k;
        }

        if (tot_h <= h) {
            return 1;
        } else {
            return 0;
        }
    }

    public int minEatingSpeed(int[] piles, int h) {

        int l = 0;

        int r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        while (r - l > 1) {

            int mid = l + (r - l) / 2;

            if (predicate(mid, piles, h) == 0) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return r;
    }
}