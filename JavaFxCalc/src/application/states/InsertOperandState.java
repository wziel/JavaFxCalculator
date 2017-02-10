package application.states;

import application.operations.BinaryOperation;
import application.operations.UnaryOperation;

class InsertOperandState extends State
{
    public InsertOperandState()
    {
        super(new Params(null, 0.0, ""));
    }

    protected InsertOperandState(final Params params)
    {
        super(params);
    }

    @Override
    public State append(final Character c)
    {
        params.appendToRightOperand(c);
        return this;
    }

    @Override
    public String getText()
    {
        return params.getRightOperand();
    }

    private void performPendingOperation()
    {
        final Double newValue = params.getPendingOperation() == null ? params.getRightOperandAsDouble()
                : params.getPendingOperation().perform(params.getLeftOperand(), params.getRightOperandAsDouble());
        params.setLeftOperand(newValue);
        params.setRightOperand("");
        params.setPendingOperation(null);
    }

    @Override
    State getNext(final UnaryOperation operation)
    {
        performPendingOperation();
        final Double newValue = operation.perform(params.getLeftOperand());
        params.setLeftOperand(newValue);
        return new ShowResultState(params);
    }

    @Override
    State getNext(final BinaryOperation operation)
    {
        performPendingOperation();
        params.setPendingOperation(operation);
        return new WaitForSecondOperandState(params);
    }
}