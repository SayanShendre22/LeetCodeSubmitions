class NumArray {
    int seg[];
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        seg = new int[4 * n];
        createSegtree(0, 0, n - 1, nums);
    }

    public void update(int index, int val) {
        updateSeg(0, 0, n - 1, index, val);
    }

    public int sumRange(int left, int right) {
        return sumSeg(0, 0, n - 1, left, right);
    }

    public void updateSeg(int i, int l, int r, int idx, int val) {
        if (l == r) {
            seg[i] = val;
            return;
        }

        int mid = l + (r - l) / 2;

        if (idx <= mid) {
            updateSeg(2 * i + 1, l, mid, idx, val);
        } else {
            updateSeg(2 * i + 2, mid + 1, r, idx, val);
        }

        seg[i] = seg[2 * i + 1] + seg[2 * i + 2];
    }

    public int sumSeg(int i, int l, int r, int start, int end) {
        if (r < start || l > end) {
            return 0;
        }

        if (l >= start && r <= end)
            return seg[i];

        int mid = l + (r - l) / 2;
        int left = sumSeg(2 * i + 1, l, mid, start, end);
        int right = sumSeg(2 * i + 2, mid + 1, r, start, end);

        return left + right;
    }

    public void createSegtree(int i, int l, int r, int nums[]) {
        if (l == r) {
            seg[i] = nums[l];
            return;
        }

        int mid = l + (r - l) / 2;

        createSegtree(2 * i + 1, l, mid, nums);
        createSegtree(2 * i + 2, mid + 1, r, nums);

        seg[i] = seg[2 * i + 1] + seg[2 * i + 2];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */