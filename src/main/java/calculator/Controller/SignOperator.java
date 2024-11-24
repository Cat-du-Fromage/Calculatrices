package calculator.Controller;
import calculator.Operator;
import calculator.State;

/**
 * Représente l'opération de changement de signe (+/-) dans la calculatrice.
 * Hérite de {@link Operator}.
 */
public class SignOperator extends Operator {

    /**
     * Constructeur pour initialiser l'opération de changement de signe avec l'état de la calculatrice.
     * @param state l'état de la calculatrice
     */
    public SignOperator(State state) {
        super(state);
    }

    /**
     * Exécute l'opération de changement de signe.
     * Ne fait rien si une erreur est affichée.
     */
    @Override
    public void execute() {
        if(state.isErrorDisplayed() || state.isIntermediateValue()) return;
        state.toggleSign();
        state.updateDisplay();
    }
}
