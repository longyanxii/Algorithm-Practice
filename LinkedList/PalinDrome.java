package LinkedList;

import java.util.ListIterator;
import java.util.Scanner;

class ListNode {
    int val ;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(ListNode next) {
        this.next = next;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class PalinDrome {
    public static void main(String[] args) {
        /**Scanner scanner = new Scanner (System.in);
        System.out.println("请输入链表节点，用‘,’分割：");

        String input = scanner.nextLine().trim();
        String [] inputArray = input.substring(input.indexOf("[")+1,input.indexOf("]")).split(",");

        int [] arr = new int [inputArray.length];
        for (int i = 0 ; i < inputArray.length ; i++){
            arr[i] = Integer.parseInt(inputArray[i]);
        }*/

        int [] arr = {1,2,3,5,3,2,1};
        ListNode head = buildList(arr);
        if (head == null || head.next == null) {
            System.out.println("是否为回文链表："+true);
            return ;
        }
        System.out.println("是否为回文链表？"+isPalinDrome(head));

        //scanner.close();
    }

    private static boolean isPalinDrome(ListNode head) {
        ListNode middleHead = middleList(head);
        ListNode reverseHead = reverseMiddleList(middleHead);
        while (reverseHead != null){
            if (reverseHead.val != head.val) {
                return false;
            }
            reverseHead = reverseHead.next;
            head = head.next;
        }
        return true;
    }

    private static ListNode reverseMiddleList(ListNode middleHead) {
        ListNode pre = null;/**ListNode pre = new ListNode(-1),会影响链表反转后的最后一个节点为-1*/
        ListNode cur = middleHead;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre ;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private static ListNode middleList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode buildList(int[] arr) {
        if (arr.length == 1){
            return new ListNode (arr[0]);
        }
        ListNode dummyHead = new ListNode (-1) ;/**不能为null，如果为null，curNode也为null,空指针异常错误！！*/
        ListNode curNode = dummyHead;
        for (int num : arr){
            curNode.next = new ListNode (num);
            curNode = curNode.next;
        }
        return dummyHead.next;
    }
}
