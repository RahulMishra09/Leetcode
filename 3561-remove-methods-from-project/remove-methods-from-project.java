import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : invocations) {
            graph.get(edge[0]).add(edge[1]);
        }
        
        
        boolean[] suspicious = new boolean[n];
        suspicious[k] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int nei : graph.get(node)) {
                if (!suspicious[nei]) {
                    suspicious[nei] = true;
                    queue.add(nei);
                }
            }
        }
        

        for (int[] edge : invocations) {
            int a = edge[0], b = edge[1];
            if (suspicious[b] && !suspicious[a]) {

                List<Integer> all = new ArrayList<>();
                for (int i = 0; i < n; i++) all.add(i);
                return all;
            }
        }
        
    
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) result.add(i);
        }
        return result;
    }
}