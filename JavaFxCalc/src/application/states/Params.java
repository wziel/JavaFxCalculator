package application.states;

import application.operations.BinaryOperation;

class Params
{
    private BinaryOperation pendingOperation;
    private Double leftOperand;
    private String rightOperand;

    public Params(final BinaryOperation lastOperation, final Double leftOperand, final String rightOperand)
    {
        this.pendingOperation = lastOperation;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public Double getRightOperandAsDouble()
    {
        return Double.valueOf(rightOperand);
    }

    public String getRightOperand()
    {
        return rightOperand.isEmpty() ? "0" : rightOperand;
    }

    public Double getLeftOperand()
    {
        return leftOperand;
    }

    public String getLeftOperandAsString()
    {
        return toString(leftOperand);
    }

    public BinaryOperation getPendingOperation()
    {
        return pendingOperation;
    }

    public void appendToRightOperand(final Character c)
    {
        rightOperand += c;
    }

    public void setLeftOperand(final Double d)
    {
        leftOperand = d;
    }

    public void setRightOperand(final String d)
    {
        rightOperand = d;
    }

    public void setPendingOperation(final BinaryOperation operation)
    {
        this.pendingOperation = operation;
    }

    private static String toString(final double d)
    {
        if (d == (long) d)
        {
            return String.format("%d", (long) d);
        }
        else
        {
            return String.format("%s", d);
        }
    }
}