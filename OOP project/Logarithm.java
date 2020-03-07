// Arsen Cui
// ICS4U1-01
// October 20, 2019
// Mr. Radulovic
// ICS4U1 Functions Inheritance Assignment

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Logarithm extends Function {
	
	// Variables representing the corresponding variables in the equation of the logarithm function
	
	protected double a, b, x1;
	protected String name = "Logarithm";
	
	public Logarithm(double a, double b, double x1) {
		
		super(0, 0);// Sets a random initial value for the domain. Will soon be overwritten
		
		// Initializes the variable values based on the values set by the object
		this.a = a;
		this.b = b;
		this.x1 = x1;
		
	}
	
	// Method used to draw the function on the screen
	@Override
	public void draw(Canvas c)
	{
		GraphicsContext gc = c.getGraphicsContext2D();
		double start_x = getStartDomain();
		double end_x = getEndDomain();
		double origin_x = c.getWidth()/2;
		double origin_y = c.getHeight()/2;
		double largest_y = -Double.MAX_VALUE; // Variable used to track the largest value of y
		double smallest_y = Double.MAX_VALUE; // Variable used to track the smallest value of y
		
		
		for (double x = start_x; x < end_x; x =  Math.round((x + deltaX) * 10) / 10.0) {
			if (undefined(x) == true|| x == 0)
				continue;
			
			if (val(x) < smallest_y)
				smallest_y = val(x);
			
			if (val(x) > largest_y)
				largest_y = val(x);
		}
		double range_size = Math.abs(largest_y-smallest_y);
		double domain_size = Math.abs(end_x - start_x); // size of the domain by calculate different of them.
		double ratio_x = c.getWidth() / domain_size;
		double ratio_y = c.getHeight() / range_size;
		double graph_centerX = (start_x + end_x) / 2;
		double graph_centerY = (largest_y + smallest_y) / 2;
		double past_x = start_x; // The previous x value
		double current_x = start_x;
		while (current_x < end_x) {

			past_x = current_x; // updates the previous x value

			current_x = Math.round((current_x + deltaX) * 10) / 10.0; // moves to next x value

			/* If the start or end y values are undefined,
			 * don't include them in the function */
			if (undefined(past_x) || undefined(current_x) == true)
				continue;

			/* Draws the line segment of the function with scaling
			 * and shifting to fit function on the screen */
			
			gc.setStroke(getColour());
			gc.strokeLine((past_x - graph_centerX) * ratio_x + origin_x, 
					(origin_y - (val(past_x) - graph_centerY) * ratio_y), 
					(current_x - graph_centerX) * ratio_x + origin_x, 
					(origin_y - (val(current_x) - graph_centerY) * ratio_y));

		}
	}


	// Method used to return the value of y at a specific value of x
	@Override
	public double val(double x) {
		
		return (a*Math.log(x - x1) + b);
		
	}

	// Method used to determine whether the function is defined at a specific value of x
	@Override
	public boolean undefined(double x) {
		
		if (Double.isNaN(val(x)) == true)
			return true;
		else
			return false;
	}

	// Method used to return the area underneath the function
	@Override
	public double getArea(double x_start, double x_end) {
		double area = 0;
		for(double i = x_start;i< x_end;i=  Math.round((i + deltaX) * 10) / 10.0) {
			area += val(i)*deltaX;
			
		}
		return area;
	}
	
	// Method used to return the slope of the function at a given point
	@Override
	public double getSlope(double x) {

		return (val(x+deltaX)- val(x-deltaX))/(2*deltaX);
	}

	// Method used to return the equation of the function as a string
	@Override
	public String toString() {
		
		String s = "";
		
		// Handles a
		
		if (a == 1.0)
			s += "log(x";
		else if (a == -1.0)
			s += "-log(x";
		else if (a == 0)
		{
			s += b;
			return s;
		}
		else 
			s += a + "*log(x";
		
		// Handles x1
		
		if (x1 > 0)
			s += "-" + x1 + ")";
		else if (x1 == 0) 
			s += ")";
		else if (x1 < 0)
			s += "+" + -x1 + ")";
		
		// Handles b
		
		if (a != 0)
		{
			if (b > 0)
	        	s += "+" + b;
	    	else if (b < 0)
	        	s += "-" + -b;
		}
		
		return s;
		
		
	}

}