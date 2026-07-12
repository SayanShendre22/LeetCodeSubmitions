class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int sarr[] = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sarr);
        Map<Integer,Integer> map = new HashMap<>();

        int rank = 1;

        for (int i : sarr) {
            if (!map.containsKey(i)) {
                map.put(i,  rank);
                rank++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int r = map.get(arr[i]);
            arr[i] = r;
        }
        return arr;
    }
}