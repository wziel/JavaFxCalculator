package application.operations;

public class DivideOperation implements BinaryOperation
{
    @Override
    public Double perform(final Double leftArg, final Double rightArg)
    {
        return leftArg / rightArg;
    }
}