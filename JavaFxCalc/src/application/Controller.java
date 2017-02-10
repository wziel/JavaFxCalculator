package application;

import java.util.HashMap;
import java.util.Map;

import application.operations.AddOperation;
import application.operations.ChangeSignOperation;
import application.operations.ClearOperation;
import application.operations.DivideOperation;
import application.operations.MultiplyOperation;
import application.operations.NoOperation;
import application.operations.Operation;
import application.operations.PercentageOperation;
import application.operations.SqrtOperation;
import application.operations.SubtractOperation;
import application.states.State;
import application.states.StateResolver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller
{
    @FXML private TextField display;
    @FXML private Button decimalPoint;
    private final Map<String, Operation> operationMap = new HashMap<String, Operation>();
    private final StateResolver stateResolver = new StateResolver();
    private State state = stateResolver.getStartState();

    public Controller()
    {
        operationMap.put("+", new AddOperation());
        operationMap.put("C", new ClearOperation());
        operationMap.put("-", new SubtractOperation());
        operationMap.put("=", new NoOperation());
        operationMap.put("/", new DivideOperation());
        operationMap.put("+/-", new ChangeSignOperation());
        operationMap.put("*", new MultiplyOperation());
        operationMap.put("sqrt", new SqrtOperation());
        operationMap.put("%", new PercentageOperation());
    }

    public void numberClick(final ActionEvent event)
    {
        final Button button = (Button) event.getSource();
        final Character numChar = button.getText().charAt(0);
        state = state.append(numChar);
        display.setText(state.getText());
    }

    public void decimalPointClick(final ActionEvent event)
    {
        state = state.setDecimalPoint();
        display.setText(state.getText());
        decimalPoint.setDisable(true);
    }

    public void operationClick(final ActionEvent event)
    {
        final Button button = (Button) event.getSource();
        final Operation operation = operationMap.get(button.getText());
        state = stateResolver.getNext(state, operation);
        display.setText(state.getText());
        decimalPoint.setDisable(false);
    }
}