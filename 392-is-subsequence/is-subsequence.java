class Solution {
    public boolean isSubsequence(String s, String t) {
        int s_length = 0;
        int t_length = 0;

        while (s_length < s.length() && t_length < t.length()) {
            if (s.charAt(s_length) == t.charAt(t_length)) {
                s_length++;
            }
            t_length++;
        }

        return s_length == s.length();
    }
}
