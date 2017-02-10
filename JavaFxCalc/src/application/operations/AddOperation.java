package application.operations;

public class AddOperation implements BinaryOperation
{
    @Override
    public Double perform(final Double leftArg, final Double rightArg)
    {
        return leftArg + rightArg;
    }
}