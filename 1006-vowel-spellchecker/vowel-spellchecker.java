import java.util.*;

class Solution {
    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }

    private String mask(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(isVowel(c) ? 'a' : c);
        }
        return sb.toString();
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));
        Map<String,String> lowerMap = new HashMap<>();
        Map<String,String> vowelMap = new HashMap<>();

        for (String w : wordlist) {
            String low = w.toLowerCase();
            lowerMap.putIfAbsent(low, w);
            vowelMap.putIfAbsent(mask(low), w);
        }

        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) res[i] = q;
            else if (lowerMap.containsKey(q.toLowerCase())) res[i] = lowerMap.get(q.toLowerCase());
            else res[i] = vowelMap.getOrDefault(mask(q.toLowerCase()), "");
        }
        return res;
    }
}