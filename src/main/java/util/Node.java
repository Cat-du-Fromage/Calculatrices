// Auteur: Changanaqui Yoann & Duruz Florian
package util;

/*
 * Class Node
 * This class represents a node of a linked list
 * @param <T> the type of the value of the node
 */
public class Node<T> {
    private Node next; // The next node
    private T value; // The value of the current node

    /*
     * Constructor of the class Node
     */
    public Node() {
        next = null;
    }

    /*
     * Constructor of the class Node
     * @param val the value of the current node
     */
    public Node(T val) {
        this.value = val;
    }

    /*
     * Get the value of the current node
     * @return the value of the current node
     */
    public T value() { return this.value; }

    /*
     * Get the next node of the current node
     * @return the next node of the current node
     */
    public Node next() { return next; }

    /*
     * Set the next node of the current node
     * @param n the next node of the current node
     */
    public void setNext(Node n) {
        if(this == null) {
            System.err.println("Node is null");
            return;
        }
        this.next = n;
    }

    /*
     * Set the value of the current node
     * @param val the new value of the current node
     */
    public void setValue(T val) { this.value = val; }

    /*
     * Check if the current node has a next node
     * @return true if the current node has a next node, false otherwise
     */
    public boolean hasNext() {
        return (this.next != null);
    }

    /*
     * Clone the current node and all the next nodes
     * @return the cloned node
     */
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
