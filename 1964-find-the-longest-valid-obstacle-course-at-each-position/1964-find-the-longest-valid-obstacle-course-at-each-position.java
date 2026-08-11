class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obs) {
        int n = obs.length;

        int[] res = new int[n];
        int[] lis = new int[n];

        int x = 0; 

        for (int i = 0; i < n; i++) {

            int ub = upperBound(lis, 0, x, obs[i]);

            lis[ub] = obs[i];

            res[i] = ub + 1;

            if (ub == x) {
                x++;
            }
        }

        return res;
    }


    public int upperBound(int[] arr, int s, int e, int target) {

        while (s < e) {
            int mid = s + (e - s) / 2;

            if (arr[mid] > target) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }

        return s;
    }
}