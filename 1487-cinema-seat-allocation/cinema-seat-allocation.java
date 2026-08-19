import java.util.*;

class Solution {

    public int check(int totalSeats[])
    {
        int count = 0;

        
        if(totalSeats[1] == 0 && totalSeats[2] == 0 && totalSeats[3] == 0 && totalSeats[4] == 0)
        {
            totalSeats[1] = 1;
            totalSeats[2] = 1;
            totalSeats[3] = 1;
            totalSeats[4] = 1;

            count++;
        }

        
        if(totalSeats[3] == 0 && totalSeats[4] == 0 && totalSeats[5] == 0 && totalSeats[6] == 0)
        {
            totalSeats[3] = 1;
            totalSeats[4] = 1;
            totalSeats[5] = 1;
            totalSeats[6] = 1;

            count++;
        }

       
        if(totalSeats[5] == 0 && totalSeats[6] == 0 && totalSeats[7] == 0 && totalSeats[8] == 0)
        {
            totalSeats[5] = 1;
            totalSeats[6] = 1;
            totalSeats[7] = 1;
            totalSeats[8] = 1;

            count++;
        }

        return count;
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, int[]> map = new HashMap<>();
        for(int[] val : reservedSeats)
        {
            map.putIfAbsent(val[0], new int[10]);

            int[] seats = map.get(val[0]);

            seats[val[1] - 1] = 1;
        }
        int count = 2 * (n - map.size());
        for(int row : map.keySet())
        {
            count += check(map.get(row));
        }

        return count;
    }
}