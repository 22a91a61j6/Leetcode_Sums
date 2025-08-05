class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean[] arr = new boolean[baskets.length];
        int count = fruits.length;
        for (int k = 0; k < fruits.length; k++) {
            for (int j = 0; j < baskets.length; j++) {
                if (fruits[k] <= baskets[j] && !arr[j]) {
                    count--;
                    arr[j] = true;
                    break;
                }
            }
        }
        return count;
    }
}