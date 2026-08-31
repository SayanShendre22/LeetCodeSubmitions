/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int res[] = new int[2];
        res[0] = -1;
        res[1] = -1;
        ListNode prev = null;

        List<Integer> lis = new ArrayList<>();

        int i = 1;
        ListNode cur = head;

        while (cur.next != null) {
            if (prev != null) {
                if (prev.val < cur.val && cur.val > cur.next.val) {
                    lis.add(i);
                }
                if (prev.val > cur.val && cur.val < cur.next.val) {
                    lis.add(i);
                }
            }
            prev = cur;
            cur = cur.next;
            i++;
        }

        // System.out.println(lis);

        if (lis.size() == 2) {
            res[0] = res[1] = Math.abs(lis.get(0) - lis.get(1));
        }

        if (lis.size() > 2) {
            // Collections.sort(lis);
            res[1] = Math.abs(lis.get(0) - lis.get(lis.size() - 1));
            int min = Integer.MAX_VALUE;

            for (i = 1; i < lis.size(); i++) {
                min = Math.min(min, lis.get(i) - lis.get(i - 1));
            }

            res[0] = min;
        }

        return res;
    }
}