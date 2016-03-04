package graphics;

import java.awt.Color;
import java.awt.Graphics;

/**
 * The GameGraphic is the parent of all graphics in the game.
 * @author Tim V�gtli
 * @version 0.1
 */
public abstract class GameGraphic {
	
	/**
	 * x is the position on the x-axis.
	 * y is the position on the y-axis.
	 * width is the width from the graphic.
	 * height is the height form the graphic.
	 */
	private int
		x = 0,
		y = 0,
		width = 0,
		height = 0;
	
	/**
	 * the border be drawn or not.
	 */
	private boolean
		border = false;
	
	/**
	 * The current background color.
	 */
	private Color backgroundColor = new Color( 0, 0, 0 );
	
	/**
	 * The current border color.
	 */
	private Color borderColor = new Color( 0, 0, 0 );
	
	/**
	 * Constructor without any parameters.
	 */
	public GameGraphic(){};
	
	/**
	 * Constructor with parameters for set the position on the x and y axis.
	 * @param x - position on the x-axis.
	 * @param y - position on the y-axis.
	 */
	public GameGraphic( int x, int y ){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Constructor with parameters for set the position on the x and y axis with double.
	 * @param x - position on the x-axis.
	 * @param y - position on the y-axis.
	 */
	public GameGraphic( double x, double y ){
		this.x = ( int ) x;
		this.y = ( int ) y;
	}
	
	/**
	 * Constructor with parameters for set the position and dimensions.
	 * @param x - position on the x-axis.
	 * @param y - position on the y-axis.
	 * @param width - width of the graphic.
	 * @param height - height of the graphic.
	 */
	public GameGraphic( int x, int y, int width, int height ){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Constructor with parameter for set the position and dimensions with double.
	 * @param x - position on the x-axis.
	 * @param y - position on the y-axis.
	 * @param width - with of the graphic.
	 * @param height - height of the graphic.
	 */
	public GameGraphic( double x, double y, double width, double height ){
		this.x = ( int ) x;
		this.y = ( int ) y;
		this.width = ( int ) width;
		this.height = ( int ) height;
	}
	
	/**
	 * Set a border to draw it.
	 * @param hasBorder - sit it to true for draw the border.
	 */
	public void setBorder( boolean hasBorder ){
		this.border = hasBorder;
	}
	
	/**
	 * Set the position on the x-axis.
	 * @param x - new position on the x-axis.
	 */
	public void setX( int x ){
		this.x = x;
	}
	
	/**
	 * Set the position on the y-axis.
	 * @param y - new position on the y-axis.
	 */
	public void setY( int y ){
		this.y = y;
	}
	
	/**
	 * Set the with of the graphic.
	 * @param width -  new with from the graphic.
	 */
	public void setWidth( int width ){
		this.width = width;
	}
	
	/**
	 * Set the height of the graphic.
	 * @param height - new height from the graphic.
	 */
	public void setHeight( int height ){
		this.height = height;
	}
	
	/**
	 * Set a new background color to the graphic.
	 * @param backgroundColor - new background color from the graphic.
	 */
	public void setBackgroundColor( Color backgroundColor ){
		this.backgroundColor = backgroundColor;
	}
	
	
	/**
	 * Set a new border color to the graphic.
	 * @param borderColor - new border color from the graphic.
	 */
	public void setBorderColor( Color borderColor ){
		this.borderColor = borderColor;
	}
	
	/**
	 * Return the status of the border.
	 * @return <strong>true</strong> if it has a border.
	 */
	public boolean hasBoder(){
		return this.border;
	}
	
	/**
	 * Return the current position on the x-axis.
	 * @return The position on the x-axis.
	 */
	public int getX(){
		return this.x;
	}
	
	/**
	 * Return the current position on the y-axis.
	 * @return The position on the y-axis.
	 */
	public int getY(){
		return this.y;
	}
	
	/**
	 * Return the current width of the graphic. 
	 * @return The width of the graphic.
	 */
	public int getWidth(){
		return this.width;
	}
	
	/**
	 * Return the current height of the graphic.
	 * @return The height of the graphic.
	 */
	public int getHeight(){
		return this.height;
	}
	
	/**
	 * Return the background color of the graphic.
	 * @return The background color of the graphic.
	 */
	public Color getBackgroundColor(){
		return backgroundColor;
	}
	
	/**
	 * Return the border color of the graphic.
	 * @return The border color of the graphic.
	 */
	public Color getBorderColor(){
		return borderColor;
	}
	
	/**
	 * It is for override in a new graphic so that you can
	 * draw anything in a new object.
	 * @see gui.GamePanel
	 * @see objects.World
	 * @see graphics.GameGraphicRectangle
	 * @param g - The Graphics from a GamePanel.
	 */
	public abstract void paint( Graphics g );
	
	/**
	 * It is for override in a new graphic so that you can
	 * drew anything in a new object dependent on the position
	 * from the WorldObject. 
	 * @param g - The Graphics from a GamePanel.
	 * @param x - The position on the x-axis from a WorldObject.
	 * @param y - The position on the y-axis from a WorldObject.
	 */
	public abstract void paint( Graphics g, int x, int y );

}
