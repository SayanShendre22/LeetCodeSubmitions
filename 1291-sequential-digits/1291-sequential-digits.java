class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String num = "123456789";
        int lowl = String.valueOf(low).length();
        int hightl = String.valueOf(high).length();
        List<Integer> res = new ArrayList<>();

        for (int k = lowl; k <= hightl; k++) {
            for (int i = 0; i <= num.length() - k; i++) {
                int cur = Integer.parseInt(num.substring(i, i + k));
                if ( cur>= low && cur <= high) {
                    res.add(cur);
                }

                if( cur>high){
                    break;
                }
            }
        }
        return res;
    }
}