package calculator;

/**
 * Représente une opération abstraite dans la calculatrice.
 * Toutes les opérations spécifiques héritent de cette classe.
 */
public abstract class Operator {

    /** L'état actuel de la calculatrice. */
    protected State state;

    /**
     * Constructeur pour initialiser une opération avec l'état de la calculatrice.
     * @param state l'état de la calculatrice
     */
    protected Operator(State state) {
        this.state = state;
    }

    /**
     * Exécute l'opération définie par les sous-classes.
     */
    public abstract void execute();
}
