import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Complete the following base Function class.
 *
 */


public class Cubic extends Function{
	protected double a, b, c, d, x1;
	protected String name = "Cubic";
	
	// Constructor method for the Function class.  The parameters represent the domain of the function.
	public Cubic(double a, double b, double c, double d, double x1) {
		super(x1, x1);
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.x1 = x1;
	}
	
	// Returns a String containing the actual function.  For example, if the function was an object of the Parabola class, 
	// this method might return 2.0*(x - 4.0)^2 + 5.0.  There are spaces before and after the +, - operators only.
	@Override
	public String toString()
	{
		String str = "",a = "", b = "", c = "", d = "";
		/*
		 * a is the term a(x-x1)^3
		 * b is the term b(b-b1)^2
		 * c is the term c(x-x1)
		 * d is the constant
		 * x1 is the horizontal translation x1
		 */
		// Handles a
		
		if (this.a == 1.0)
			a += "(x";
		else if (this.a == -1.0)
			a += "-(x";
		else if (this.a  != 0)
			a += this.a + "*(x";

		// Handles x1
		
		if (this.a != 0) {
			if (x1 > 0)
				a += "-" + x1 + ")^3";
			else if (x1 == 0)
				a += ")^3";
			else if (x1 < 0)
				a += "+" + -x1 + ")^3";

			if (this.b > 0 || this.c > 0 || this.d > 0)
				a += "+";
		}

		// Handles b
		
		if (this.b == 1.0)
			b += "(x";
		else if (this.b == -1.0)
			b += "-(x";
		else if (this.b != 0)
			b += this.b + "*(x";

				// Handles x1
				
				if (this.b != 0) {
					if (x1 > 0)
						b += "-" + x1 + ")^2";
					else if (x1 == 0)
						b += ")^2";
					else if (x1 < 0)
						b += "+" + -x1 + ")^2";

					if (this.c > 0 || this.d > 0)
						b += "+";
				}

				// Handles c
				
				if (this.c == 1.0)
					c += "(x";
				else if (this.c == -1.0)
					c += "-(x";
				else if (this.c != 0)
					c += this.c + "*(x";

				// Handles x1
				
				if (this.c != 0) {
					if (x1 > 0)
						c += "-" + x1 + ")";
					else if (x1 == 0)
						c += ")";
					else if (x1 < 0)
						c += "+" + -x1 + ")";

					if (this.d > 0)
						c += "+";
				}

				// Handles d
				
				if (this.d != 0)
					d += this.d;
				else if(this.d == 0&&this.a == 0&&this.b == 0&&this.c == 0)
					d += this.d;
				str = a + b + c + d;
		return str;
			
	}
	
	@Override
	public double val (double x) {
		double val = a*Math.pow((x-x1),3.0)+b*Math.pow((x-x1),2.0)+c*(x-x1)+d;
		return val;
		
	}
	
	@Override
	public boolean undefined(double x) {
		if (Double.isNaN(val(x)) == true)
			return true;
		else
			return false;
	}
	
	@Override
	public double getArea(double x_start, double x_end){
		double area = 0;
		for(double i = x_start;i< x_end;i=  Math.round((i + deltaX) * 10) / 10.0) {
			area += val(i)*deltaX;
			
		}
		return area;
	}
	
	@Override
	public double getSlope(double x) {
		double slope = 0;
		slope = (val(x+deltaX)- val(x-deltaX))/(2*deltaX);
		return slope;
		
	}
	
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
			if (undefined(x) == true)
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
		double graph_centerY = (largest_y + smallest_y) / 2;
		double graph_centerX = (start_x + end_x) / 2;
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

}