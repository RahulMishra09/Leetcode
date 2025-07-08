import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert to String[]
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        //Sort with custom comparator
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // Edge case - all zeros
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Step 4: Build the result
        StringBuilder result = new StringBuilder();
        for (String s : strNums) {
            result.append(s);
        }

        return result.toString();
    }
}
