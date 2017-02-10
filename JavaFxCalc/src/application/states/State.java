package application.states;

import application.operations.BinaryOperation;
import application.operations.UnaryOperation;

public abstract class State
{
    protected Params params;

    protected State(final Params params)
    {
        this.params = params;
    }

    public abstract State append(Character c);

    public abstract String getText();

    abstract State getNext(UnaryOperation operation);

    abstract State getNext(BinaryOperation operation);

    public State setDecimalPoint()
    {
        params.appendToRightOperand('.');
        return new InsertOperandState(params);
    }
}