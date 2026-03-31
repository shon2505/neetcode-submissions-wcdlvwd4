class Solution {

    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        int[] freq = new int[128];

        // store frequency of characters in t
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0;
        int right = 0;

        int required = t.length();

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char r = s.charAt(right);

            // if character is needed
            if (freq[r] > 0) {
                required--;
            }

            freq[r]--;
            right++;

            // when window becomes valid
            while (required == 0) {

                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }

                char l = s.charAt(left);

                freq[l]++;

                if (freq[l] > 0) {
                    required++;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) return "";

        return s.substring(start, start + minLength);
    }
}