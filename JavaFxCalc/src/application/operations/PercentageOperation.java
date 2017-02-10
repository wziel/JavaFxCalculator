package application.operations;

public class PercentageOperation implements UnaryOperation
{
    @Override
    public Double perform(final Double leftArg)
    {
        return leftArg / 100.0;
    }
}