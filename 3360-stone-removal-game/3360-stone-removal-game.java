class Solution {
    public boolean canAliceWin(int n) {
        int canPick = 10;
        int k = 0;
        while (n >= canPick) {
            n -= canPick;
            canPick--;
            k++;
        }
        return k % 2 == 1;
    }
}