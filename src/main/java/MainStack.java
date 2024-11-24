import util.Stack;

public class MainStack {

    public static void main(String[] args) {
        testEmptyStack();
        testPushAndPop();
        testStackOrder();
        testClearStack();
        testToArray();
        System.out.println("\nTous les tests ont été exécutés avec succès.");
    }

    //╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
    //║                                 ◆◆◆◆◆◆ TESTS SUR LA PILE ◆◆◆◆◆◆                                               ║
    //╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝

    /**
     * Test pour vérifier qu'une pile nouvellement créée est vide
     * et que les opérations sur une pile vide se comportent correctement.
     */
    private static void testEmptyStack() {
        Stack<Integer> stack = new Stack<>();
        assert stack.isEmpty() : "Échec: La pile doit être vide après sa création.";
        assert stack.size() == 0 : "Échec: La taille initiale de la pile doit être 0.";
        assert stack.pop() == null : "Échec: Désempiler une pile vide doit retourner null.";
        assert stack.top() == null : "Échec: L'accès au sommet d'une pile vide doit retourner null.";

        System.out.println("[Test Pile Vide] réussi: Comportement correct sur une pile vide.");
    }

    /**
     * Test pour vérifier les opérations de `push` et `pop`, et la mise à jour de la taille.
     */
    private static void testPushAndPop() {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        assert stack.size() == 3 : "Échec: La pile doit contenir 3 éléments après 3 opérations `push`.";
        assert stack.pop().equals("C") : "Échec: `pop` doit renvoyer le dernier élément empilé ('C').";
        assert stack.size() == 2 : "Échec: La taille doit être 2 après une opération `pop`.";
        assert stack.pop().equals("B") : "Échec: `pop` doit renvoyer 'B'.";
        assert stack.pop().equals("A") : "Échec: `pop` doit renvoyer 'A'.";
        assert stack.isEmpty() : "Échec: La pile doit être vide après avoir dépilé tous les éléments.";

        System.out.println("[Test Push/Pop] réussi: Empiler et dépiler fonctionne comme attendu.");
    }

    /**
     * Test pour vérifier que l'ordre des éléments est respecté (LIFO).
     */
    private static void testStackOrder() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assert stack.pop() == 30 : "Échec: L'ordre LIFO n'est pas respecté (dernier entré, premier sorti).";
        assert stack.pop() == 20 : "Échec: L'ordre LIFO n'est pas respecté (dernier entré, premier sorti).";
        assert stack.pop() == 10 : "Échec: L'ordre LIFO n'est pas respecté (dernier entré, premier sorti).";

        System.out.println("[Test Ordre] réussi: Les éléments sont dépilés dans l'ordre LIFO.");
    }

    /**
     * Test pour vérifier que la méthode `clear()` vide complètement la pile.
     */
    private static void testClearStack() {
        Stack<Double> stack = new Stack<>();
        stack.push(1.1);
        stack.push(2.2);
        stack.push(3.3);
        stack.clear();

        assert stack.isEmpty() : "Échec: La pile doit être vide après un appel à `clear`.";
        assert stack.size() == 0 : "Échec: La taille de la pile doit être 0 après un appel à `clear`.";
        assert stack.pop() == null : "Échec: Une pile vidée ne doit rien renvoyer lors d'un `pop`.";

        System.out.println("[Test Clear] réussi: La pile est correctement vidée.");
    }

    /**
     * Test pour vérifier que la méthode `toArray()` retourne les éléments dans l'ordre attendu.
     */
    private static void testToArray() {
        Stack<Character> stack = new Stack<>();
        stack.push('X');
        stack.push('Y');
        stack.push('Z');

        Object[] array = stack.toArray();
        assert array.length == 3 : "Échec: Le tableau doit contenir exactement 3 éléments.";
        assert array[0].equals('Z') : "Échec: L'élément 0 du tableau doit correspondre au sommet ('Z').";
        assert array[1].equals('Y') : "Échec: L'élément 1 du tableau doit être 'Y'.";
        assert array[2].equals('X') : "Échec: L'élément 2 du tableau doit être 'X'.";

        System.out.println("[Test toArray] réussi: Conversion correcte en tableau.");
    }
}
