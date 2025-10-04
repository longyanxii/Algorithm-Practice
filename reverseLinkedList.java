import java.util.*;
/*class ListNode {
    int val;
    ListNode next;
    public ListNode (int val ){
        this.val = val;
    }
    public ListNode (int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}*/
public class reverseLinkedList {
    public static void main(String [] args){
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int [] values = new int [n];
        for (int i = 0 ; i < n ; i ++){
            values[i] = scanner.nextInt();
        }
        ListNode head = buildLinkedList(values);
        ListNode reversed = reverseList(head);
        printList(reversed);
    }

    private static void printList(ListNode reversed) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = reversed;
        while(cur != null){
            sb.append(cur.val);
            if (cur.next != null){
                sb.append(" ");
            }
            cur = cur.next;
        }
        System.out.print(sb.toString());
    }

    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private static ListNode buildLinkedList(int [] values) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        for (int val : values){
            //int value = Integer.parseInt(val);
            cur.next = new ListNode(val);
            cur = cur.next;
        }

        return dummyHead.next;
    }
}
