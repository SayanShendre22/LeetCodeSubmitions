class ProductOfNumbers {
    ArrayList<Integer> stream;
    int idx;
    int zero = -1;

    public ProductOfNumbers() {
        stream = new ArrayList<>();
        stream.add(1);
        idx = 1;
    }

    public void add(int num) {
        if (num == 0)
            zero = idx;
        int prev = stream.get(idx - 1);
        stream.add(num * (prev != 0 ? prev : 1));
        idx++;
        // System.out.println(stream + " " + idx);
    }

    public int getProduct(int k) {
        int n = stream.size();
        int pre = stream.get(n - k - 1);
        // System.out.println(stream + " pre = " + pre);
        if ((n - k - 1) < zero)
            return 0;
        return stream.get(n - 1) / (pre != 0 ? pre : 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */