 class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];

        // Multiply each digit manually
        for (int i = len1 - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';  // convert char to digit
            for (int j = len2 - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';

                int mul = n1 * n2;
                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = mul + res[p2];

                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }

        
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        return sb.toString();
    }
}
