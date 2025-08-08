class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length(), symbol = 1, result = 0;
        while (i < n && s.charAt(i) == ' ') i++;
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            symbol = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (result > (Integer.MAX_VALUE - digit) / 10)
                return symbol == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            result = result * 10 + digit;
            i++;
        }
        return result * symbol;
    }
}