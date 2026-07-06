package citi.karat.Flinkedlist;

public class AReverseLinkedListAJKarat {
    public static void main(String[] argv) {
        System.out.println("Hello, world!");
        System.out.println("This is a fully functioning Java environment.");

        Integer[][] input = {
                {3, 4, 5},
                {10, 20}
        };

        for (int i = 0; i < input.length; i++) {
            LinkedListNodeAJKarat<Integer> head = createLinkedList(input[i]);
            System.out.print((i+1) + ".\tInput linked list: ");
            PrintListAJKarat.printListWithForwardArrow(head);
            System.out.print("\n\tReverse linked list: ");
            PrintListAJKarat.printListWithForwardArrow(reverse(head));

        }
    }

    private static LinkedListNodeAJKarat<Integer> reverse(LinkedListNodeAJKarat<Integer> head) {
        LinkedListNodeAJKarat<Integer> previous = null;
        LinkedListNodeAJKarat<Integer> current = head;
        LinkedListNodeAJKarat<Integer> nextNode = null;
        while (current != null) {
            nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
    }

    private static <T> LinkedListNodeAJKarat<T> createLinkedList(T[] values) {
        LinkedListNodeAJKarat<T> dummy = new LinkedListNodeAJKarat<>(null); // making the first node as null
        LinkedListNodeAJKarat<T> tail = dummy; // copy reference stored in dummy into tail.
        for (T value: values) {
            tail.next = new LinkedListNodeAJKarat<>(value); // move the value to the next of the tail.
            tail = tail.next; // tail only moves the linkedlist
        }
        return dummy.next; // since the first node is null, we return the whole values from dummy the main copy.
    }
}

// non-public (package-private or default access) top-level class.
class LinkedListNodeAJKarat<T> {
    T data;
    LinkedListNodeAJKarat<T> next;
    LinkedListNodeAJKarat(T data) {
        this.data = data;
        this.next = null;
    }
}
class PrintListAJKarat<T> {
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