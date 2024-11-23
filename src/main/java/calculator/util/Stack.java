package calculator.util;

public class Stack<T> {
    Stack<T> next;
    T value;

    public Stack() {
        next = null;
    }

    public Stack(T val) {
        this.value = val;
        this.next = null;
    }

    // Empiler un objet sur le sommet de la pile
    public void add(T val) {
        Stack<T> newNode = new Stack<>(val), oldTop = top();
        oldTop.next = (Stack<T>) newNode;
    }

    // Désempiler un objet du sommet de la pile
    public void pop() {
        if (isEmpty())
            System.err.println("Stack is empty");

        Stack<T> nextNode = this;
        while (nextNode.hasNext()) {
            if (!nextNode.next.hasNext()) {
                nextNode.next = null;
                return;
            }
            nextNode = nextNode.next;
        }
    }

    // Get the value of the top element of the stack
    public Stack<T> top() {
        if (isEmpty()) {
            return this;
        }

        Stack<T> nextNode = this;
        while (nextNode.hasNext()) {
            nextNode = nextNode.next;
        }
        return nextNode;
    }

    public boolean isEmpty() {
        return (this.value == null && this.next == null);
    }

    public boolean hasNext() {
        return (this.next != null);
    }

    public int size() {
        if (this == null)
            return 0;

        int size = 1;
        Stack<T> nextNode = this;
        while (nextNode.hasNext()) {
            size++;
            nextNode = nextNode.next;
        }

        return size;
    }

    //  Obtenir un tableau d’objets représentant l’état actuel de la pile (l’indice 0 contenant l’élément placé au
    // sommet de la pile)
    public Object[] toArray() {
        if (isEmpty()) {
            return null;
        }

        Object[] res = new Object[size()];
        Stack<T> copy = new Stack<>(); // Créer une copy pour ne pas affecter la pile
        Stack<T> current = this;
        while (current != null) {
            copy.add(current.value);
            current = current.next;
        }

        int i = 0;
        while (!copy.isEmpty()) {
            res[i] = copy.top().value;
            copy.pop();
            i++;
        }
        return res;
    }

    // Obtenir un itérateur sur la pile offrant les opérations T next() et boolean hasNext().
    // Obtenir la représentation sous la forme de chaîne de caractères du contenu de la pile
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack is empty";
        }
        if (size() == 1) {
            return ("[" + this.value + "]");
        }

        String res = new String();
        Stack<T> nextNode = this;
        while (nextNode != null) {
            res += ("["+ nextNode.value + "]") + (nextNode.next == null ? "" : " -> ");
            nextNode = nextNode.next;
        }
        return res;
    }
}