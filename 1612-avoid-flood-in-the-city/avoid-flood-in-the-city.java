class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        TreeSet<Integer> dryDays = new TreeSet<>();
        Map<Integer, Integer> full = new HashMap<>();
        int[] floodPlan = new int[n];

        for (int i = 0; i < n; i++) {
            int lake = rains[i];

            if (lake == 0) {
                dryDays.add(i);      
                floodPlan[i] = 1;          
            } else {
                floodPlan[i] = -1;         
                if (full.containsKey(lake)) {
                    int lastRain = full.get(lake);
                    Integer dryDay = dryDays.ceiling(lastRain);
                    if (dryDay == null) {
                        return new int[0]; 
                    }
                    floodPlan[dryDay] = lake;   
                    dryDays.remove(dryDay);
                }
                full.put(lake, i); 
            }
        }
        return floodPlan;
    }
}