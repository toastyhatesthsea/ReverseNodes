package Reverse;


public class KNodes
{

    public ListNode reverseKGroup(ListNode head, int k)
    {
        ListNode answer = head;
        ListNode current = head;
        ListNode previous = head;
        ListNode end, beginning;

        while (current != null)
        {
            beginning = current;

            for(int i=0; i<k && current != null; i++)
            {
                end = current.next;
            }

            //Must keep track of next node

        }


        return answer;
    }

    public void reverse(ListNode beg, ListNode end)
    {
        if (beg.next == end)
        {
            ListNode endNext = end.next;
            end.next = beg;
            beg.next = endNext;
        }
        else
        {
            ListNode endNext = end.next;
            ListNode newBeg = beg.next;

            end.next = beg;
            beg.next = endNext;

            reverse(newBeg, end);
        }
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x)
    {
        val = x;
    }
}

class KNodesTesters
{


    public static void main(String[] agsg)
    {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        KNodes aK = new KNodes();

        aK.reverse(l1, l1.next.next.next.next);

    }
}
