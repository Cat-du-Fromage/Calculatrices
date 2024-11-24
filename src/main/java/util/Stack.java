// Auteur: Changanaqui Yoann & Duruz Florian
package util;

public class Stack<T> {
    Node<T> head = new Node(); // The head of the stack

    /*
     * Constructor of the class Stack
     */
    public Stack() {
        head = null;
    }

    /*
     * Constructor of the class Stack
     * @param val the value of the first node of the stack
     */
    public Stack(T val) {
        head = new Node();
        head.setValue(val);
    }

    
    /* 
     * Empiler un objet dans la pile
     * @param val l’objet à empiler
    */
    public void push(T val) {
         Node newNode = new Node(val);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node oldTop = top();
            oldTop.setNext(newNode);
        }
    }

    /*
     * Dépiler l’objet situé au sommet de la pile
     * @return la valeur de l’objet situé au sommet de la pile
     */
    public T pop() {
        if (isEmpty()) {
            return null;
        }

        Node nextNode = head;
        Node previousNode = null;
        while (nextNode.hasNext()) {
            previousNode = nextNode;
            nextNode = nextNode.next();
        }

        if (previousNode == null) {
            head = null;
        } else {
            previousNode.setNext(null);
        }
        return (T)nextNode.value();
    }

    /*
     * Obtenir l’objet situé au sommet de la pile
     * @return l’objet situé au sommet de la pile
     */
    public Node top() {
        if (isEmpty()) {
            return null;
        }

        Node nextNode = head;
        while (nextNode.hasNext()) {
            nextNode = nextNode.next();
        }
        return nextNode;
    }

    public boolean isEmpty() {
        return (head == null || head.value() == null);
    }

    /*
     * Get the size of the stack
     * @return the size of the stack
     */
    public int size() {
        if (this == null || head == null)
            return 0;

        int size = 1;
        Node nextNode = head;
        while (nextNode.hasNext()) {
            size++;
            nextNode =  nextNode.next();
        }

        return size;
    }

    /*
     * Get an array of objects representing the current state of the stack
     * @return un tableau d’objets représentant l’état actuel de la pile (l’indice 0 contenant l’élément placé au sommet de la pile)
     */
    public Object[] toArray() {
        if (isEmpty()) {
            return new Object[0];
        }

        Object[] res = new Object[size()];
        Node current = head;

        for (int i = size() - 1; i >= 0; i--) {
            res[i] = current.value();
            current = current.next();
        }
        return res;
    }

    /*
     * Vider la pile
     * @return void
     */
    public void clear() {
        head = null;
    }

    /*
     * Représentation sous forme de chaîne de caractères du contenu de la pile
     * @return la représentation sous la forme de chaîne de caractères du contenu de la pile
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack is empty";
        }
        if (size() == 1) {
            return ("[" + head.value() + "]");
        }

        String res = new String();
        Node nextNode = head;
        while (nextNode != null) {
            res += ("["+ nextNode.value() + "]") + (nextNode.next() == null ? "" : " -> ");
            nextNode = nextNode.next();
        }
        return res;
    }
}