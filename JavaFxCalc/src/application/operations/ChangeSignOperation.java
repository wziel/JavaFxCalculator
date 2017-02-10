package application.operations;

public class ChangeSignOperation implements UnaryOperation
{
    @Override
    public Double perform(final Double leftArg)
    {
        return -leftArg;
    }
}