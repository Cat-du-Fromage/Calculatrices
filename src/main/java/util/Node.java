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

    public boolean isEmpty() {
        return (this.value() == null && this.next() == null);
    }

    // Désempiler un objet du sommet de la pile
    public void pop() {
        if (isEmpty())
            System.err.println("Stack is empty");

        Node nextNode = this;
        while (nextNode.hasNext()) {
            if (!nextNode.next().hasNext()) {
                nextNode.setNext(null);
                return;
            }
            nextNode = nextNode.next();
        }
    }

    // Get the value of the top element of the stack
    public Node top() {
        if (isEmpty()) {
            return null;
        }

        Node nextNode = this;
        while (nextNode.hasNext()) {
            nextNode = nextNode.next();
        }
        return nextNode;
    }
}