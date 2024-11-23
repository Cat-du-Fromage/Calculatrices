package util;

public class Node<T> {
    private Node next;
    private T value;

    public Node() {
        next = null;
    }

    public Node(T val) {
        this.value = val;
    }

    public T value() { return this.value; }
    public Node next() { return next; }

    public void setNext(Node n) {
        if(this == null) {
            System.err.println("Node is null");
            return;
        }
        this.next = n;
    }
    public void setValue(T val) { this.value = val; }

    public boolean hasNext() {
        return (this.next != null);
    }

    public Node clone() { Node clonedNode = new Node(this.value);
        Node current = clonedNode;
        Node originalCurrent = this.next;
        while (originalCurrent != null) {
            Node newNode = new Node(originalCurrent.value);
            current.setNext(newNode);
            current = newNode;
            originalCurrent = originalCurrent.next();
        }
        return clonedNode;
    }
}
