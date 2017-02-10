package application;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxCalc extends Application
{
    private final DoubleProperty fontSize = new SimpleDoubleProperty(10);

    @Override
    public void start(final Stage primaryStage)
    {
        try
        {
            final Parent root = FXMLLoader.load(getClass().getResource("fxcalc.fxml"));
            final Scene scene = new Scene(root, 400, 400);
            scene.getStylesheets().add(getClass().getResource("fxcalc.css").toExternalForm());
            bindFontSizes(scene);
            setUpStage(primaryStage, scene);
            primaryStage.show();
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }
    }

    private void setUpStage(final Stage primaryStage, final Scene scene)
    {
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fx calculator");
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(500);
    }

    private void bindFontSizes(final Scene scene)
    {
        fontSize.bind(scene.widthProperty().add(scene.heightProperty()).divide(50));
        for (final Node child : scene.getRoot().getChildrenUnmodifiable())
        {
            child.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize.asString(), ";"));
        }
    }

    public static void main(final String[] args)
    {
        launch(args);
    }
}