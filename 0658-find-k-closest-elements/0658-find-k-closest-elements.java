class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;

        List<Integer> res = new ArrayList<>();
        if (n == k) {
            res.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
            return res;
        }

        int s = 0, e = n - k;
        int mid = 0;
        while (s < e) {
            mid = (s + e) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }

        for (int i = s; i < s + k; i++) {
            res.add(arr[i]);
        }

        return res;
    }
}