class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            // putIfAbsent adds the key only if it's not already in the map(For my knowledge)
            mapS.putIfAbsent(s.charAt(i), i);
            mapT.putIfAbsent(t.charAt(i), i);

            // Compare first occurrence indexes
            if (!mapS.get(s.charAt(i)).equals(mapT.get(t.charAt(i)))) {
                return false;
            }
        }

        return true;
    }
}
