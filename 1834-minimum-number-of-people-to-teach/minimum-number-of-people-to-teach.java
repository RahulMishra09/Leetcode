class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        
        List<Set<Integer>> userLang = new ArrayList<>();
        for (int[] langs : languages) {
            Set<Integer> set = new HashSet<>();
            for (int l : langs) set.add(l);
            userLang.add(set);
        }

        
        Set<Integer> problematicUsers = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1, v = f[1] - 1; 
            Set<Integer> setU = userLang.get(u), setV = userLang.get(v);
            boolean canTalk = false;
            for (int lang : setU) {
                if (setV.contains(lang)) {
                    canTalk = true;
                    break;
                }
            }
            if (!canTalk) {
                problematicUsers.add(u);
                problematicUsers.add(v);
            }
        }

        
        if (problematicUsers.isEmpty()) return 0;

        
        int minTeach = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int count = 0;
            for (int user : problematicUsers) {
                if (!userLang.get(user).contains(lang)) {
                    count++;
                }
            }
            minTeach = Math.min(minTeach, count);
        }

        return minTeach;
    }
}