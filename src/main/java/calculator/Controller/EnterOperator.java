package calculator.Controller;
import calculator.EErrorType;
import calculator.Operator;
import calculator.State;

/**
 * Représente l'opération d'entrée (Enter) dans la calculatrice.
 * Hérite de {@link Operator}.
 */
public class EnterOperator extends Operator {
    /**
     * Constructeur pour initialiser l'opération d'entrée avec l'état de la calculatrice.
     * @param state l'état de la calculatrice
     */
    public EnterOperator(State state) {
        super(state);
    }

    /**
     * Exécute l'opération d'entrée.
     * Ajoute la valeur courante à la pile si aucune erreur n'est affichée ou détectée.
     */
    @Override
    public void execute() {
        if(state.isErrorDisplayed() || state.checkSyntaxError()) return;
        state.addToStack();
    }
}
