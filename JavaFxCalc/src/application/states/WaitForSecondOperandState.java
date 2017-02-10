package application.states;

import application.operations.BinaryOperation;
import application.operations.UnaryOperation;

class WaitForSecondOperandState extends State
{
    protected WaitForSecondOperandState(final Params params)
    {
        super(params);
    }

    @Override
    public State append(final Character c)
    {
        params.setRightOperand("");
        params.appendToRightOperand(c);
        return new InsertOperandState(params);
    }

    @Override
    public String getText()
    {
        return params.getLeftOperandAsString();
    }

    @Override
    State getNext(final UnaryOperation operation)
    {
        final Double newValue = operation.perform(params.getLeftOperand());
        params.setLeftOperand(newValue);
        return new ShowResultState(params);
    }

    @Override
    State getNext(final BinaryOperation operation)
    {
        params.setPendingOperation(operation);
        return this;
    }
}