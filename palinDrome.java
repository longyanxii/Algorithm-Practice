import java.util.*;
class ListNode {
    int val;
    ListNode next;
    public ListNode (int val){
        this.val = val;
    }
    public ListNode (int val ,ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class palinDrome {
    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int [] nums = new int[n];
        for (int i = 0 ; i < n ; i ++){
            nums[i] = scanner.nextInt();
        }
        ListNode head = buildList(nums);
        System.out.print(isPalinDrome(head));
    }

    private static boolean isPalinDrome(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            arr.add(cur.val);
            cur = cur.next;
        }
        int left = 0 ;
        int right = arr.size()- 1;
        while (left < right){
            if (arr.get(left) == arr.get(right)) {
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }

    private static ListNode buildList(int[] nums) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
            for (int val : nums){
                cur.next = new ListNode (val);
                cur = cur.next;
            }
        return dummyHead.next;
    }


}
