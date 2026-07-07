class Solution {
    public String intToRoman(int num) {
        String[] rom = new String[] {
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };

        int[] nom = new int[] {
                1000,
                900,
                500,
                400,
                100,
                90,
                50,
                40,
                10,
                9,
                5,
                4,
                1
        };

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 13; i++) {
            while (num >= nom[i]) {
                sb.append(rom[i]);
                num -= nom[i];
            }
        }

        return sb.toString();
    }
}