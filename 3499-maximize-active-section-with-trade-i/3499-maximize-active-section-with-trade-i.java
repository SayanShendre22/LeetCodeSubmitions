class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int active = 0;
        List<Integer> zeroLst = new ArrayList<>();

        int i = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                i++;
            } else {
                if (i > 0) {
                    zeroLst.add(i);
                    i = 0;
                }
                active++;
            }
        }
        if (i > 0) {
            zeroLst.add(i);
        }

        int maxTrade = 0;
        for (int x = 1; x < zeroLst.size(); x++) {
            maxTrade = Math.max(maxTrade, zeroLst.get(x) + zeroLst.get(x - 1));
        }

        return active + maxTrade;

    }
}