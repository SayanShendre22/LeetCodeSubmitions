class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        for (int a : arr1) {
            boolean clear = true;
            for (int b : arr2) {
                clear &= Math.abs(a - b) > d;
            }
            res += clear ? 1 : 0;
        }
        return res;
    }
}