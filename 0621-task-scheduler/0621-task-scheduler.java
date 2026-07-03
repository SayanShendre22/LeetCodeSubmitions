class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char c : tasks) {
            int idx = c - 'A';
            freq[idx]++;
        }

        Arrays.sort(freq);
        int gap = freq[25] - 1;
        int avaSlots = gap * n;

        for (int i = 0; i < 25; i++) {
            if (freq[i] != 0) {
                avaSlots -= Math.min(gap, freq[i]);
            }
        }

        if (avaSlots > 0) {
            return tasks.length + avaSlots;
        }

        return tasks.length;
    }
}