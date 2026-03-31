class Solution {

    public boolean checkInclusion(String s1, String s2) {

        int s1Length = s1.length();
        int s2Length = s2.length();

        // Frequency array for s1
        int[] s1Freq = new int[26];
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        // Frequency array for current window in s2
        int[] windowFreq = new int[26];

        int left = 0;

        for (int right = 0; right < s2Length; right++) {

            // Add current character to window
            char rightChar = s2.charAt(right);
            windowFreq[rightChar - 'a']++;

            // If window size becomes larger than s1, shrink from left
            if (right - left + 1 > s1Length) {
                char leftChar = s2.charAt(left);
                windowFreq[leftChar - 'a']--;
                left++;
            }

            // If window size equals s1 length, compare frequencies
            if (right - left + 1 == s1Length) {
                if (areFrequenciesEqual(s1Freq, windowFreq)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean areFrequenciesEqual(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}