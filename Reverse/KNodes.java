package Reverse;


public class KNodes
{

    public ListNode reverseKGroup(ListNode head, int k)
    {
        ListNode end = head , beginning = head, answer = head, current = head, previous = head;
        boolean first = true;
        if (k == 1) //returns head since there is nothing to reverse
        {
            return head;
        }

        while (current != null)
        {
            beginning = current; //beginning keeps track of the first node to be swapped

            for(int i=1; i<k && current != null; i++)
            {
                current = current.next;
                end = current;
            }

            if (end != null)
            {
                reverse(beginning, end); //This helper function reverses from Beginning reference node to End reference node
                if (first) //establishes the head of the Answer node to be returned
                {
                    answer = end;
                    first = false;
                }
                else //connects end of the previous reversed list to the beginning of the newly reversed list
                {
                    previous.next = end;
                }
            }
            else //Loop will break if there is not enough nodes to be reversed according to Parameter 'k'
            {
                break;
            }
            current = beginning.next; //Updates the current reference to properly cycle
            previous = beginning; //establishes a node reference for the end of the newly reversed list in order to connection to the beginning of a future reversed list
        }

        return answer;
    }

    /**
     * Reverses from beginning of node reference to the end (inclusive) node reference
     * @param beg ListNode
     * @param end ListNode
     */
    public void reverse(ListNode beg, ListNode end)
    {
        if (beg.next == end) //Will reverse list by 2 nodes
        {                   //Connects the end node to the beginning node and has the beginning node connect to the node previously in front of the previous End node
            ListNode endNext = end.next;
            end.next = beg;
            beg.next = endNext;
        }
        else //Swaps the end node and connects it to the beginning of the Beginning reference
            //Then calls the function again and moves the beginning node over one
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
        KNodes aK = new KNodes();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode answer = aK.reverseKGroup(l1, 3);

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



    }
}
