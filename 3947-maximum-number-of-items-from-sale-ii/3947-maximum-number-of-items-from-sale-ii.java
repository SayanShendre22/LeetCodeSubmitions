class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        Arrays.sort(items, (a, b) -> a[1] - b[1]);

        int mx = 0;
        for (int[] a : items) {
            mx = Math.max(mx, a[0]);
        }

        int freq[] = new int[mx + 1];
        for (int i = 0; i < items.length; i++) {
            freq[items[i][0]]++;
        }

        for (int i = 1; i <= mx; i++) {
            if (freq[i] > 0) {
                for (int j = i * 2; j <= mx; j += i) {
                    freq[i] += freq[j];
                }
            }
        }

        int min = items[0][1];
        int ans = 0;
        for (int[] a : items) {
            int fact = a[0];
            int price = a[1];

            if (price - min > min)
                break;

            int cnt = freq[fact] - 1;
            int take = Math.min(cnt, budget / price);
            ans += take * 2;
            budget -= take * price;
        }
        ans += budget / min;
        return ans;
    }
}