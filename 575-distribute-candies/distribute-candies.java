import java.util.*;

class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> store = new HashSet<>();
        for (int num : candyType)
            store.add(num);
        return Math.min(store.size(), candyType.length / 2);
    }
}