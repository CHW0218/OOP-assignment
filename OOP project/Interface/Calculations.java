/**
 * 
 * Interface for functions
 *
 */
public interface Calculations 
{
	/**
	 * Returns the value of a function f at x
	 * @param x
	 * @return the value of a function f at x
	 */
	public double val(double x);
	
	
	/**
	 * 
	 * @return true if the function is undefined at x.
	 */
	public boolean undefined(double x);
	
	
	/**
	 * Returns the area under a Function
	 * @param f - Function
	 * @param x_start - start of domain
	 * @param x_end - end of upper hand
	 * @return the area under a Function f from x = x_start to x = x_end
	 */
	public double getArea(double x_start, double x_end);
	
	
	/**
	 * Returns the slope of a Function at a certain point
	 * @param f - Function
	 * @param x - x-value at which to evaluate slope
	 * @return - slope of Function f evaluated at x
	 */
	public double getSlope(double x);
	
}