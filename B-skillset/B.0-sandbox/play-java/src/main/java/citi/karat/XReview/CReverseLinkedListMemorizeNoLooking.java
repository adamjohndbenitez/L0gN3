package citi.karat.XReview;

public class CReverseLinkedListMemorizeNoLooking {
    public static void main(String[] argv) {
        System.out.println("Hello, world!");
        System.out.println("This is a fully functioning Java environment.");

        Integer[][] input = {
                {3, 4, 5},
                {10, 20, 30, 40, 50},
                {-1, -2, -3, -4, -5, -6},
                {3, 2, 1},
                {12},
                {1, 2}
        };

        for (int i = 0; i < input.length; i++) {
            LinkedListNode<Integer> head = createLinkedList(input[i]);
            System.out.print((i + 1) + ".\tInput linked list: ");
            printListWithForwardArrow(head);
            System.out.print("\n\tReverse linked list: ");
            printListWithForwardArrow(reverse(head));
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static <T> void printListWithForwardArrow(LinkedListNode<T> head) {
        LinkedListNode<T> curr = head;
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

    private static <T> LinkedListNode<T> createLinkedList(T[] values) {
        LinkedListNode<T> dummy = new LinkedListNode<>(null);
        LinkedListNode<T> tail = dummy;
        for (T value : values) {
            tail.next = new LinkedListNode<>(value);
            tail = tail.next;
        }
        return dummy.next;
    }

    private static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> previous = null;
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> nextNode = null;
        while (current != null) {
            nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
    }
}

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }
}
