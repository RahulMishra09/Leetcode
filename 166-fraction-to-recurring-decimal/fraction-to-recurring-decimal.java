class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder res = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) res.append("-");
        long n = Math.abs((long) numerator), d = Math.abs((long) denominator);
        res.append(n / d);
        long r = n % d;
        if (r == 0) return res.toString();
        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (r != 0) {
            if (map.containsKey(r)) {
                res.insert(map.get(r), "(").append(")");
                break;
            }
            map.put(r, res.length());
            r *= 10;
            res.append(r / d);
            r %= d;
        }
        return res.toString();
    }
}