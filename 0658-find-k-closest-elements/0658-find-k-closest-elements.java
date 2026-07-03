class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        
        List<Integer> res = new ArrayList<>();
        if (n == k) {
            res.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
            return res;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->{
            if(a[0]!=b[0]) return a[0]-b[0];
            return a[1]-b[1];
        });

        for (int i : arr) {
            pq.add(new int[] {Math.abs(i - x), i});
        }

        for (int i = 0; i < k; i++) {
            int cur[] = pq.poll();
            res.add(cur[1]);
        }

        Collections.sort(res);

        return res;
    }
}