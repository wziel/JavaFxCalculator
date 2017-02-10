package application.operations;

public class SubtractOperation implements BinaryOperation
{
    @Override
    public Double perform(final Double leftArg, final Double rightArg)
    {
        return leftArg - rightArg;
    }
}
