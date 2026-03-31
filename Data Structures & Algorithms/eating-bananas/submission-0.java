class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;

        // find max pile
        for (int p : piles) {
            r = Math.max(r, p);
        }

        int result = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int hours = 0;

            for (int p : piles) {
                hours += (p + mid - 1) / mid; // ceil division
            }

            if (hours <= h) {
                result = mid;
                r = mid - 1; // try smaller speed
            } else {
                l = mid + 1; // need bigger speed
            }
        }

        return result;
    }
}