package util;

public class Stack<T> {
    Node head = new Node();

    public Stack() {
        head = new Node();
        head.setNext(null);
    }

    public Stack(T val) {
        this();
        head.setValue(val);
    }

    // Empiler un objet sur le sommet de la pile
    public void push(T val) {
        Node newNode = new Node(val);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node oldTop = top();
            oldTop.setNext(newNode);
        }
    }

    // Désempiler un objet du sommet de la pile
    public void pop() {
        if (isEmpty())
            System.err.println("Stack is empty");

        Node nextNode = head;
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

        Node nextNode = head;
        while (nextNode.hasNext()) {
            nextNode = nextNode.next();
        }
        return nextNode;
    }

    public boolean isEmpty() {
        return (head.value() == null && head.next() == null);
    }

    public int size() {
        if (this == null)
            return 0;

        int size = 1;
        Node nextNode = head;
        while (nextNode.hasNext()) {
            size++;
            nextNode =  nextNode.next();
        }

        return size;
    }

    //  Obtenir un tableau d’objets représentant l’état actuel de la pile (l’indice 0 contenant l’élément placé au
    // sommet de la pile)
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

    public void clear() {
        while(!isEmpty()) {
            pop();
        }
    }

    // Obtenir un itérateur sur la pile offrant les opérations T next() et boolean hasNext().
    // Obtenir la représentation sous la forme de chaîne de caractères du contenu de la pile
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