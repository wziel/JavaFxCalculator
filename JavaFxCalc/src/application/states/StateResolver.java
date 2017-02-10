package application.states;

import application.operations.BinaryOperation;
import application.operations.Operation;
import application.operations.UnaryOperation;

public class StateResolver
{
    public State getNext(final State current, final Operation operation)
    {
        if (operation instanceof UnaryOperation)
        {
            final UnaryOperation unaryOperation = (UnaryOperation) operation;
            return current.getNext(unaryOperation);
        }
        else if (operation instanceof BinaryOperation)
        {
            final BinaryOperation binaryOperation = (BinaryOperation) operation;
            return current.getNext(binaryOperation);
        }
        throw new IllegalStateException("Operation type not recognized.");
    }

    public State getStartState()
    {
        return new InsertOperandState();
    }
}
