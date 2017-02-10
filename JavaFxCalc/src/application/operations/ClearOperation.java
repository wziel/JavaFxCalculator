package application.operations;

public class ClearOperation implements UnaryOperation
{
    @Override
    public Double perform(final Double leftArg)
    {
        return 0.0;
    }
}