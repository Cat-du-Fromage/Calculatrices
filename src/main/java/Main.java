import calculator.JCalculator;

import calculator.State;
import calculator.EErrorType;
import calculator.Controller.*;
import calculator.Controller.mathOperation.*;
import calculator.Controller.digitOperator.*;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello, World!");
        testZeroBeforeDecimal();
        testMultiplePointsTriggerSyntaxError();
        testDivisionByZeroError();
        testSquareRootDomainError();
        new JCalculator();
    }

//╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
//║                                             ◆◆◆◆◆◆ TEST DIGITS ◆◆◆◆◆◆                                              ║
//╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝

    /**
     * Test pour vérifier qu'une suite de zéros n'est pas ajoutée avant un chiffre.
     * Par exemple, "03" ne doit pas être accepté.
     */
    public static void testZeroBeforeDecimal() {
        State state = new State();

        // Ajout d'un premier zéro.
        ZeroOperator zeroOperator = new ZeroOperator(state);
        zeroOperator.execute();
        assert state.getCurrentDisplay().equals("0") : "Échec: Un seul zéro doit être affiché.";

        // Tentative d'ajout d'un second zéro.
        zeroOperator.execute();
        assert state.getCurrentDisplay().equals("0") : "Échec: Un second zéro en début de valeur est invalide.";

        // Ajout d'un chiffre (exemple: 3).
        NumberOperator numberOperator = new NumberOperator(state, 3);
        numberOperator.execute();
        assert state.getCurrentDisplay().equals("3") : "Échec: La valeur après un zéro doit remplacer le zéro.";

        System.out.println("[Test Suite zéro] réussi: Une suite de zéros avant un chiffre impossible.");
    }

    /**
     * Test pour vérifier qu'ajouter plusieurs points déclenche une erreur "Syntax_Error"
     * lorsqu'on tente de mettre la valeur en stack via EnterOperator.
     */
    public static void testMultiplePointsTriggerSyntaxError() {
        State state = new State();

        // Ajout d'un chiffre initial (exemple : 1).
        NumberOperator numberOperator = new NumberOperator(state, 1);
        numberOperator.execute();
        assert state.getCurrentDisplay().equals("1") : "Échec: Le chiffre initial doit être affiché.";

        // Ajout d'un premier point.
        PointOperator pointOperator = new PointOperator(state);
        pointOperator.execute();
        assert state.getCurrentDisplay().equals("1.") : "Échec: Le premier point doit être accepté.";

        // Ajout d'un second point.(ne doit pas encore afficher d'erreur)
        pointOperator.execute();
        assert state.isErrorDisplayed() : "Échec: L'ajout d'un second point doit déclencher une erreur de syntaxe.";
        assert state.getCurrentDisplay().equals(EErrorType.SYNTAX_ERROR.name()) : "Échec: L'erreur affichée doit être 'Syntax_Error'.";

        // Tentative de mettre la valeur en stack via EnterOperator.
        EnterOperator enterOperator = new EnterOperator(state);
        enterOperator.execute();
        assert state.getStack().isEmpty() : "Échec: La pile doit rester vide après une erreur de syntaxe.";

        System.out.println("[Test Syntax_Error] réussi: Plusieurs points déclenchent une erreur de syntaxe et empêchent l'entrée dans la pile.");
    }

//╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
//║                                              ◆◆◆◆◆◆ TEST MATH ◆◆◆◆◆◆                                               ║
//╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝

    /**
     * Test pour vérifier que les divisions et l'opération réciproque déclenchent une erreur "DIVIDE_BY_ZERO"
     * lorsque le dénominateur est égal à 0.
     */
    public static void testDivisionByZeroError() {
        State state = new State();

        // Ajout d'une valeur au numérateur (exemple : 10).
        NumberOperator numberOperator = new NumberOperator(state, 1);
        numberOperator.execute();
        new NumberOperator(state, 0).execute(); // Résultat : 10
        EnterOperator enterOperator = new EnterOperator(state);
        enterOperator.execute();
        assert state.getStack().size() == 1 : "Échec: La pile doit contenir une valeur valide.";

        // Ajout du dénominateur (0).
        new ZeroOperator(state).execute(); // Résultat : 0

        // Test de l'opérateur de division.
        DivideOperator divideOperator = new DivideOperator(state);
        divideOperator.execute();
        assert state.isErrorDisplayed() : "Échec: Une division par zéro doit déclencher une erreur.";
        assert state.getCurrentDisplay().equals(EErrorType.DIVIDE_BY_ZERO.name()) : "Échec: L'erreur affichée doit être 'DIVIDE_BY_ZERO'.";
        assert state.getStack().size() == 1 : "Échec: La pile ne doit pas être modifiée après une erreur.";

        // Réinitialisation pour tester l'opération réciproque.
        state.resetDisplay();
        state.resetStack();
        new ZeroOperator(state).execute(); // Résultat : 0

        // Test de l'opérateur réciproque.
        ReciprocalOperator reciprocalOperator = new ReciprocalOperator(state);
        reciprocalOperator.execute();
        assert state.isErrorDisplayed() : "Échec: L'opération réciproque sur zéro doit déclencher une erreur.";
        assert state.getCurrentDisplay().equals(EErrorType.DIVIDE_BY_ZERO.name()) : "Échec: L'erreur affichée doit être 'DIVIDE_BY_ZERO'.";
        assert state.getStack().isEmpty() : "Échec: La pile doit rester vide après une erreur.";

        System.out.println("[Test Division par 0] réussi: Les divisions et l'opération réciproque sur zéro déclenchent une erreur 'DIVIDE_BY_ZERO'.");
    }

    /**
     * Test pour vérifier que l'opération racine carrée (SquareRootOperator) déclenche une erreur "DOMAIN_ERROR"
     * lorsque l'entrée est une valeur négative.
     */
    public static void testSquareRootDomainError() {
        State state = new State();

        // Ajout d'une valeur négative.
        NumberOperator numberOperator = new NumberOperator(state, 5);
        numberOperator.execute(); // Résultat : 5
        SignOperator signOperator = new SignOperator(state);
        signOperator.execute(); // Résultat : -5

        // Test de l'opérateur racine carrée.
        SquareRootOperator squareRootOperator = new SquareRootOperator(state);
        squareRootOperator.execute();

        // Vérification de l'erreur.
        assert state.isErrorDisplayed() : "Échec: Une racine carrée d'une valeur négative doit déclencher une erreur.";
        assert state.getCurrentDisplay().equals(EErrorType.DOMAIN_ERROR.name()) : "Échec: L'erreur affichée doit être 'DOMAIN_ERROR'.";
        assert state.getStack().isEmpty() : "Échec: La pile doit rester vide après une erreur.";

        System.out.println("[Test Erreur Domaine] réussi: La racine carrée d'une valeur négative déclenche une erreur 'DOMAIN_ERROR'.");
    }
}