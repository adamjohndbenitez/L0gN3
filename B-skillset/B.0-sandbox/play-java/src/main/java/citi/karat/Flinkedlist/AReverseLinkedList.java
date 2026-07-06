package citi.karat.Flinkedlist;

/**
 * Statement: Given the head of a singly linked list, reverse the linked list and return its updated head.
 * Constraints: Let n be the number of nodes in a linked list.
 * 1 <= n <= 5 x 10^2
 * -5 x 10^3 <= Node.value <= -5 x 10^3
 */
public class AReverseLinkedList {

    public static LinkedListNodeAJKarat<Integer> reverse(LinkedListNodeAJKarat<Integer> head) {
        // To reverse a linked list, we need to keep track of three things
        LinkedListNodeAJKarat<Integer> previous = null; // Maintain track of the previous node - The `previous` and `nextNode` pointers are initialized as NULL
        LinkedListNodeAJKarat<Integer> current = head; // The current node - while the `current` pointer is initialized to the head of the linked list.
        LinkedListNodeAJKarat<Integer> nextNode = null; // The next node in the list - The `previous` and `nextNode` pointers are initialized as NULL

        // Reversal process
        while (current != null) {
            nextNode = current.next; // Update the `nextNode` pointer to the next of `current` to store the next of current.
            current.next = previous; // Update the next of the `current` as `previous` to reverse the pointer of the node.
            // Update `previous` as `current` and `current` as `nextNode` to move to the next node.
            previous = current;
            current = nextNode;
        }
        // The previous tail is now the new head.
        return previous;
    }

    /**
     * Creates a singly linked list from the given array of values.
     *
     * <p>A temporary sentinel node named {@code dummy} is used before the first
     * real node. The {@code tail} variable initially references the same sentinel
     * node. As each value is added, {@code tail.next} is assigned a new node and
     * {@code tail} moves forward to that node.</p>
     *
     * <p>The sentinel node is not part of the returned list. Its {@code next}
     * field points to the first real node, so this method returns
     * {@code dummy.next}. If {@code values} is empty, {@code dummy.next} remains
     * {@code null}.</p>
     *
     * @param values the non-null array of values to add to the list
     * @param <T>    the type of value stored in each node
     * @return the first node of the created list, or {@code null} when the array
     * is empty
     */
    private static <T> LinkedListNodeAJKarat<T> createLinkedList(T[] values) {
        LinkedListNodeAJKarat<T> dummy = new LinkedListNodeAJKarat<>(null);
        LinkedListNodeAJKarat<T> tail = dummy; // This copies the reference stored in dummy into tail. Both variables then point to the same object

        for (T value : values) {
            tail.next = new LinkedListNodeAJKarat<>(value); // assigning the data to the next of the tail
            tail = tail.next; // only the tail variable moves
        }

        return dummy.next; // dummy and tail reference the same node: tail.next == dummy.next
    }

    public static void main(String[] args) {
        Integer[][] input = {
                {3, 4, 5},
                {10, 20, 30, 40, 50},
                {-1, -2, -3, -4, -5, -6},
                {3, 2, 1},
                {12},
                {1, 2},
        };

        for (int i = 0; i < input.length; i++) {
            LinkedListNodeAJKarat<Integer> head = createLinkedList(input[i]);
            System.out.print((i + 1) + ".\tInput linked list: ");
            PrintListAJKarat.printListWithForwardArrow(head);
            System.out.print("\n\tReverse linked list: ");
            PrintListAJKarat.printListWithForwardArrow(reverse(head));
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}


class LinkedListNode<T> {
    T data;
    LinkedListNodeAJKarat<T> next;

    LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }
}

class PrintList<T> {
    public static <T> void printListWithForwardArrow(LinkedListNodeAJKarat<T> head) {
        LinkedListNodeAJKarat<T> curr = head;
        StringBuilder builder = new StringBuilder();
        while (curr != null) {
            builder.append(curr.data);
            if (curr.next != null) {
                builder.append(" -> ");
            }
            curr = curr.next;
        }
        System.out.println(builder);
    }
}
