package Reverse;


public class KNodes
{

    public ListNode reverseKGroup(ListNode head, int k)
    {
        ListNode end = head , beginning = head, answer = head, current = head, previous = head;
        boolean first = true;

        while (current != null)
        {
            beginning = current;

            for(int i=1; i<k && current != null; i++)
            {
                current = current.next;
                end = current;
            }

            //TODO Need to change code to make sure nodes are not missing
            //FIXME In the second pass, the last node goes missing
            if (end != null)
            {
                ListNode theEnd = reverse(beginning, end);
                //previous.next = end;
                if (first)
                {
                    answer = end;
                    first = false;
                }
                else
                {
                    previous.next = end;
                }
            }
            else
            {
                break;
            }
            //previous = end;
            //current = current.next;
            current = beginning.next;
            previous = beginning;
            //Must keep track of next node

        }


        return answer;
    }

    public ListNode reverse(ListNode beg, ListNode end)
    {
        if (beg.next == end)
        {
            ListNode endNext = end.next;
            end.next = beg;
            beg.next = endNext;
            return beg;
        }
        else
        {
            ListNode endNext = end.next;
            ListNode newBeg = beg.next;

            end.next = beg;
            beg.next = endNext;

            return reverse(newBeg, end);
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

        ListNode answer = aK.reverseKGroup(l1, 3);


        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(5);
        l2.next.next.next.next = new ListNode(7);
        l2.next.next.next.next.next = new ListNode(9);

        l1.next.next.next.next.next.next = l2;

        KNodes aK = new KNodes();


    }
}
