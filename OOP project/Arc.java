import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Arc extends Function{
	
	protected double r,center_x,center_y;
	public Arc (double r, double xcenter, double ycenter) {
		
		super(0, 0); // Sets a random initial value for the domain. Will soon be overwritten
		
		// Initializes the variable values based on the values set by the object
		this.r = r;
		this.center_x = xcenter;
		this.center_y = ycenter;
	}
	@Override
	public double val(double x) {
		double val = Math.sqrt(r*r - Math.pow(x - center_x, 2)) + center_y;
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
	public double getArea(double x_start, double x_end) {
		double area = 0;
		for(double i = x_start;i< x_end;i=  Math.round((i + deltaX) * 10) / 10.0) {
			area += val(i)*deltaX;
			
		}
		return area;
	}
	@Override
	public double getSlope(double x) {
		double slope = (val(x+deltaX)- val(x-deltaX))/(2*deltaX);
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
	@Override
	public String toString() {
		String str = "",r = "", x1 = "", y1 = "";
		
		str += "sqrt(";
		
		// Handle r
		
		if (this.r == 0)
			r = "-";
		else 
			r = "(" + this.r + ")^2-";
		
		// Handle x1
		
		if (center_x == 0)
			x1 = "(x)^2)";
		else if (center_x > 0)
			x1 = "(x-" + center_x + ")^2)";
		else if (center_x < 0)
			x1 = "(x+" + -center_x + ")^2)";
		
		// Handle y1
		
	    if (center_y > 0)
			y1 = "+" + center_y;
		else if (center_y < 0)
			y1 = "-" + -center_y;
		
	    str = str + r + x1 + y1;
		return str;
		
	}

}
