package application.operations;

public class SqrtOperation implements UnaryOperation
{

    @Override
    public Double perform(final Double leftArg)
    {
        return Math.sqrt(leftArg);
    }

}
