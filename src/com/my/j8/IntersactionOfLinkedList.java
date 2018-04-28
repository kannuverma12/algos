package com.my.j8;

import java.util.Optional;

public class IntersactionOfLinkedList {


	 
    static Node head1, head2;
 
    static class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }
 
    /*function to get the intersection point of two linked
    lists head1 and head2 */
    int getNode() {
        int c1 = getCount(head1);
        int c2 = getCount(head2);
        int d;
 
        if (c1 > c2) {
            d = c1 - c2;
            return _getIntesectionNode(d, head1, head2);
        } else {
            d = c2 - c1;
            return _getIntesectionNode(d, head2, head1);
        }
    }
 
    /* function to get the intersection point of two linked
     lists head1 and head2 where head1 has d more nodes than
     head2 */
    int _getIntesectionNode(int d, Node node1, Node node2) {
        int i;
        Node current1 = node1;
        Node current2 = node2;
        for (i = 0; i < d; i++) {
            if (current1 == null) {
                return -1;
            }
            current1 = current1.next;
        }
        while (current1 != null && current2 != null) {
            if (current1.data == current2.data) {
                return current1.data;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
 
        return -1;
    }
 
    /*Takes head pointer of the linked list and
    returns the count of nodes in the list */
    int getCount(Node node) {
        Node current = node;
        int count = 0;
 
        while (current != null) {
            count++;
            current = current.next;
        }
 
        return count;
    }
 
    public static void main(String[] args) {
    	IntersactionOfLinkedList list = new IntersactionOfLinkedList();
 
        // creating first linked list
        list.head1 = new Node(3);
        list.head1.next = new Node(15);
        list.head1.next.next = new Node(6);
        list.head1.next.next.next = new Node(15);
        list.head1.next.next.next.next = new Node(30);
 
        // creating second linked list
        list.head2 = new Node(10);
        list.head2.next = new Node(15);
        list.head2.next.next = new Node(30);
 
        System.out.println("The node of intersection is " + list.getNode());
        
        
 
    }
    
    
    /*
     * Using sorting
     * 
     * Take first list node pointers and keep them in some array and sort them.
		• Take second list node pointers and keep them in some array and sort them.
		• After sorting, use two indexes: one for the first sorted array and the other for the
		second sorted array.
		• Start comparing values at the indexes and increment the index according to
		whichever has the lower value (increment only if the values are not equal).
		• At any point, if we are able to find two indexes whose values are the same, then that
		indicates that those two nodes are pointing to the same node and we return that
		node.
		Time Complexity: Time for sorting lists + Time for scanning (for comparing)
		= O(mlogm) +O(nlogn) +O(m + n) We need to consider the one that gives the
		maximum value.
     * 
     */
    
    
    
    
    /*
     * Using hashtables
     * 
     * Select a list which has less number of nodes (If we do not know the lengths
beforehand then select one list randomly).
• Now, traverse the other list and for each node pointer of this list check whether the
same node pointer exists in the hash table.
• If there is a merge point for the given lists then we will definitely encounter the node
pointer in the hash table.
Time Complexity: Time for creating the hash table + Time for scanning the second list = O(m) +
O(n) (or O(n) + O(m), depending on which list we select for creating the hash table. But in both
cases the time complexity is the same. Space Complexity: O(n) or O(m).
     * 
     * 
     * 
     */
    
    
    /*
     * Using stack
     * 
     * Create two stacks: one for the first list and one for the second list.
• Traverse the first list and push all the node addresses onto the first stack.
• Traverse the second list and push all the node addresses onto the second stack.
• Now both stacks contain the node address of the corresponding lists.
• Now compare the top node address of both stacks.
• If they are the same, take the top elements from both the stacks and keep them in
some temporary variable (since both node addresses are node, it is enough if we
use one temporary variable).
• Continue this process until the top node addresses of the stacks are not the same.
• This point is the one where the lists merge into a single list.
• Return the value of the temporary variable.
Time Complexity: O(m + n), for scanning both the lists.
Space Complexity: O(m + n), for creating two stacks for both the lists.
     * 
     * 
     */
    
    
    /*
     * 
     * 
     * Take the difference d of the lengths -- O(1).
• Make d steps in longer list -- O(d).
• Step in both lists in parallel until links to next node match -- O(min(m, n)).
• Total time complexity = O(max(m, n)).
• Space Complexity = O(1).
     * 
     */
}
 
