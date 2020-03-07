import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 * Example of using the Canvas and GraphicsContext class within JavaFX
 *
 */
public class FunctionTester extends Application {
public static void main(String[] args) {
launch(args);
}
@Override
public void start(Stage primaryStage) throws Exception {
primaryStage.setTitle("Drawing Functions Test");
Group root = new Group();
Canvas canvas = new Canvas(300, 250);
GraphicsContext gc = canvas.getGraphicsContext2D();
drawShapes(gc);
root.getChildren().add(canvas);
primaryStage.setScene(new Scene(root));
primaryStage.show();
}
// test method for drawing - you can use this as an example
for drawing various types of lines
private void drawShapes(GraphicsContext gc) {
gc.setFill(Color.GREEN);
gc.setStroke(Color.BLUE);
gc.setLineWidth(5);
gc.strokeLine(40, 10, 10, 40);
gc.strokePolygon(new double[]{60, 90, 60, 90},
new double[]{210, 210, 240, 240}, 4);
gc.strokePolyline(new double[]{110, 140, 110, 140},
new double[]{210, 210, 240, 240}, 4);
}
}