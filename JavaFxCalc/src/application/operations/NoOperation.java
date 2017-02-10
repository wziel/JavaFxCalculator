package application.operations;

public class NoOperation implements UnaryOperation
{
    @Override
    public Double perform(final Double leftArg)
    {
        return leftArg;
    }
}