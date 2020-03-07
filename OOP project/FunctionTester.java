//James Cai
//ICS4U1-01
//October 25, 2019
//Mr. Radulovic

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FunctionTester extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Functions Tester");
		Group root = new Group();
		Canvas canvas = new Canvas(600, 600);
		
		Cubic cubic = new Cubic(0.35, 0.25, -0.5, -1, 2);
		Quadratic quadratic = new Quadratic(1, 0, 0, 0);
		Parabola parabola = new Parabola(1, 0, 0);
		Linear linear = new Linear(4, 0, 0);
		Arc arc = new Arc(1, 0, 0);
		Logarithm logarithm = new Logarithm(1, 0, 0);

//				cubic.setName("Cubic");
//				cubic.setDomain(-400, 500);
//				cubic.setColour(Color.LIME);
//				cubic.draw(canvas);
//				cubic.getSlope(200);
//				cubic.getArea(-400,500);
//				System.out.println(cubic.toString());
		
//				linear.setName("Linear");
//				linear.setDomain(-300, 300);
//				linear.setColour(Color.BLACK);
//				linear.draw(canvas);
//				linear.getSlope(200);
//				linear.getArea(-300,300);
//				System.out.println(linear.toString());
				
//				arc.setName("Arc");
//				arc.setDomain(-8, 8);
//				arc.setColour(Color.GREEN);
//				arc.draw(canvas);
//				arc.getSlope(5);
//				arc.getArea(-8,8);
//				System.out.println(arc.toString());

//				logarithm.setDomain(0, 200);
//				logarithm.setName("Logarithm");
//				logarithm.setColour(Color.BROWN);
//				logarithm.draw(canvas);
//				logarithm.getSlope(200);
//				logarithm.getArea(0,200);
//				System.out.println(logarithm.toString());

//				quadratic.setName("Quadratic");
//				quadratic.setDomain(-200, 400);
//				quadratic.setColour(Color.RED);
//				quadratic.draw(canvas);
//				quadratic.getSlope(200);
//				quadratic.getArea(-200,400);
//				System.out.println(quadratic.toString());
		
//		
//				parabola.setName("Parabola");
//				parabola.setDomain(-600, 600);
//				parabola.setColour(Color.ORANGE);
//				parabola.draw(canvas);
//				parabola.getSlope(200);
//				parabola.getArea(-600,600);
//				System.out.println(parabola.toString());


		root.getChildren().add(canvas);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();

	}

}