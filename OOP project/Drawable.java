import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public interface Drawable 
{
	/**
	 * Draws the given function to the JavaFX graphics context (screen)
	 * @param gc -  the JavaFX Graphics Context to be drawn into
	 * @param f - function to be drawn
	 */
	public void draw(Canvas c);

}