import javafx.scene.paint.Color;

/**
 * Complete the following base Function class.
 *
 */


public abstract class Function 
{
	protected double x1;
	protected double x2;
	protected Color col;
	protected String name;
	
	// Constructor method for the Function class.  The parameters represent the domain of the function.
	public Function(double x1, double x2) {
		this.x1 = x1;
		this.x2 = x2;
	}
	
	// Returns a String containing the actual function.  For example, if the function was an object of the Parabola class, 
	// this method might return 2.0*(x - 4.0)^2 + 5.0.  There are spaces before and after the +, - operators only.  For any
	// decimal numbers you should round to one decimal place.  For the square root symbol you may use the notation sqrt(x).
	public abstract String toString();

	
	// Complete the following methods
	
	// Sets the domain of this function to be between [x1, x2] where x2 > x1.
	public void setDomain(double x1, double x2)
	{
		
	}
	
	// Returns the starting value of the domain.
	public double getStartDomain()
	{
		
	}
	
	// Returns the ending value of the domain.
	public double getEndDomain()
	{
		
	}
	
	// Sets the drawing colour for this function.  The Color class is from JavaFX.
	public void setColour(Color col)
	{
		
	}
	
	// Returns the colour of this function.
	public Color getColour()
	{
		
	}
	
	// Sets the name of this function type.
	public void setName(String name)
	{
		
	}
	
	// Returns the name of this function type as a String.
	public String getName()
	{
		
	}
}