class Solution {
    public int maxArea(int[] hgt) {
        int n = hgt.length;
        int l = 0, r = n - 1;
        int res = 0;

        while (l < r) {
            int minHt = Math.min(hgt[l], hgt[r]);
            res = Math.max(res, (minHt * (r - l)));

            if (hgt[l] < hgt[r]) {
                l++;
            }else{
                r--;
            }
        }

        return res;
    }
}