//Chapter 16  Exercise 16.17
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class ColorSlider extends Application {

    //main method
    public static void main(String[] args) {
        launch(args);
    }

    //UI elements
    protected Text text = new Text("Show Colors");
    protected Slider redSlider = new Slider();
    protected Slider greenSlider = new Slider();
    protected Slider blueSlider = new Slider();
    protected Slider opacitySlider = new Slider();

    //start Method
    public void start(Stage primaryStage) {
        //creating a stack pane for text
        StackPane paneForText = new StackPane(text);
        paneForText.setPadding(new Insets(20, 10, 5, 10));

        //setting slider properties
        redSlider.setMin(0.0);
        redSlider.setMax(1.0);
        greenSlider.setMin(0.0);
        greenSlider.setMax(1.0);
        blueSlider.setMin(0.0);
        blueSlider.setMax(1.0);
        opacitySlider.setMin(0.0);
        opacitySlider.setMax(1.0);

        //create listeners that are calling setColor()
        redSlider.valueProperty().addListener(ov -> setColor());
        greenSlider.valueProperty().addListener(ov -> setColor());
        blueSlider.valueProperty().addListener(ov -> setColor());
        opacitySlider.valueProperty().addListener(ov -> setColor());
        opacitySlider.setValue(1);

        //grid pane for labeled sliders
        GridPane paneForSliders = new GridPane();

        //setting alignments
        paneForSliders.setAlignment(Pos.CENTER);
        paneForSliders.setVgap(5);
        paneForSliders.setHgap(5);
        paneForSliders.add(new Label("Red"), 0, 0);
        paneForSliders.add(redSlider, 1, 0);
        paneForSliders.add(new Label("Green"), 0, 1);
        paneForSliders.add(greenSlider, 1, 1);
        paneForSliders.add(new Label("Blue"), 0, 2);
        paneForSliders.add(blueSlider, 1, 2);
        paneForSliders.add(new Label("Opacity"), 0, 3);
        paneForSliders.add(opacitySlider, 1, 3);

        //placing nodes in a border pane
        BorderPane pane = new BorderPane();
        pane.setTop(paneForText);
        pane.setCenter(paneForSliders);

        //creating a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("ColorSlider"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    //setting up setColor() method to set the color of text
    private void setColor() {
        text.setFill(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue(), opacitySlider.getValue()));
    }
}
