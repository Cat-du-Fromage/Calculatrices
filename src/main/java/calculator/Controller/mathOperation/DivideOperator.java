package calculator.Controller.mathOperation;

import calculator.EErrorType;
import calculator.Operator;
import calculator.State;

/**
 * Représente l'opération de division dans la calculatrice.
 */
public class DivideOperator extends MathOperator {

    /**
     * Constructeur pour initialiser l'opérateur division.
     * @param state l'état de la calculatrice
     */
    public DivideOperator(State state)
    {
        super(state);
    }

    /**
     * Vérifie si la division est une division par zéro.
     * @return {@code true} si division par zéro, sinon {@code false}
     */
    protected boolean isDivisionByZero() {
        boolean isDivisionByZero = getDisplayOperand() == 0.0;
        if(isDivisionByZero)
        {
            state.setErrorType(EErrorType.DIVIDE_BY_ZERO);
        }
        return isDivisionByZero;
    }

    /**
     * Redéfinition de la classe parente afin d'y ajouter la vérification "Division par zéro"
     * @return {@code true} en cas d'erreur, sinon {@code false}
     */
    @Override
    protected boolean hasError() {
        return super.hasError() || isDivisionByZero();
    }

    /**
     * Effectue la division entre les opérandes.
     * @return le résultat de la division
     */
    @Override
    protected Double calculate() {
        return getStackOperand() / getDisplayOperand();
    }
}
