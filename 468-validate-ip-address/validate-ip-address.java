class Solution {
    public Boolean isNumber(String num, boolean isIPv4) {
        if (isIPv4) {
            if (num.length() == 0 || num.length() > 3) return false;
            if (num.length() > 1 && num.charAt(0) == '0') return false;
            try {
                int val = Integer.parseInt(num);
                return val >= 0 && val <= 255;
            } catch (NumberFormatException e) {
                return false;
            }
        } else {
            if (num.length() == 0 || num.length() > 4) return false;
            for (char c : num.toCharArray()) {
                if (!Character.isDigit(c) && !(c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F')) {
                    return false;
                }
            }
            return true;
        }
    }
    public String validIPAddress(String queryIP) {
        boolean isIPv4 = queryIP.contains(".");
        String[] vParts = isIPv4 ? queryIP.split("\\.", -1) : queryIP.split(":", -1);
        if ((isIPv4 && vParts.length != 4) || (!isIPv4 && vParts.length != 8)) {
            return "Neither";
        }
        boolean[] arr = new boolean[vParts.length];
        for (int i = 0; i < vParts.length; i++) {
            arr[i] = isNumber(vParts[i], isIPv4);
        }
        for (boolean val : arr) {
            if (!val) {
                return "Neither";
            }
        }
        return isIPv4 ? "IPv4" : "IPv6";
    }
}