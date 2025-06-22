import java.util.*;

class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int totalGroups = (n + k - 1) / k; // ceiling division
        String[] result = new String[totalGroups];
        int index = 0;

        for (int i = 0; i < totalGroups; i++) {
            StringBuilder group = new StringBuilder();
            for (int j = 0; j < k; j++) {
                if (index < n) {
                    group.append(s.charAt(index++));
                } else {
                    group.append(fill);
                }
            }
            result[i] = group.toString();
        }

        return result;
    }
}
