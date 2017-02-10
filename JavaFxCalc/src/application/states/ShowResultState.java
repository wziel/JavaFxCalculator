package application.states;

import application.operations.BinaryOperation;
import application.operations.UnaryOperation;

class ShowResultState extends State
{
    protected ShowResultState(final Params params)
    {
        super(params);
    }

    @Override
    public State append(final Character c)
    {
        params.setLeftOperand(0.0);
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
        return this;
    }

    @Override
    State getNext(final BinaryOperation operation)
    {
        params.setPendingOperation(operation);
        return new InsertOperandState(params);
    }
}