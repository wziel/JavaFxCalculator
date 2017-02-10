package application.operations;

public interface BinaryOperation extends Operation
{
    Double perform(final Double leftArg, final Double rightArg);
}