package objects;

import java.awt.Color;
import java.awt.Graphics;

import graphics.GameGraphic;
import graphics.GameGraphicRectangle;
import physics.Vector2D;

/**
 * <p>The WorldObject class is for create objects so that you can add
 * them to the world and the world will promote this objects.</p>
 * <p><strong>For example:</strong></p>
 * <pre>
 * World world = new World();
 * 
 * WorldObjectBall ball = new WorldObjectBall(
 * 		0,
 * 		0,
 * 		100,
 * 		100,
 * 		new Vector2D( 0.5, 0 )
 * );
 * 
 * GameGraphicEllipse ellipse = new GameGraphicEllipse(
 * 		0,
 * 		0,
 * 		200
 * );
 * 
 * ellipse.setBackgroundColor( new Color( 255, 255, 255 ) );
 * 
 * ball.setGraphic( ellipse );
 * 
 * world.addWorldObject( ball );
 * </pre> 
 * @see objects.World
 * @see physics.Vector2D
 * @see graphics.GameGraphic
 * @author Tim V�gtli
 * @version 0.1
 *
 */
public class WorldObject {
	
	/**
	 * x is the position on the x-axis.
	 * y is the position on the y-axis.
	 * width is the with of the object.
	 * height is the height of the object.
	 * density of the object.
	 */
	private double
		x = 0,
		y = 0,
		width = 0,
		height = 0,
		density = 0.2;
	
	/**
	 * Saves if it drawable or not.
	 */
	private boolean 
		visible = true;

	/**
	 * The motion vector.
	 */
	private Vector2D vector = new Vector2D( 0, 0 );
	
	/**
	 * graphic for drawing.
	 */
	private GameGraphic graphic;
	
	/**
	 * Constructor for create an object with position.
	 * If you create the object with this, it is by default
	 * hidden.
	 * @param x
	 * @param y
	 */
	public WorldObject( double x, double y ){
		this.x = x;
		this.y = y;
		this.visible = false;
	}
	
	/**
	 * Constructor for crate an object with position and dimension. By default it create
	 * a rectangle as graphic.
	 * @param x - position on the x-axis.
	 * @param y - position on the y-axis.
	 * @param width - the width of the object.
	 * @param height - the height of the object.
	 */
	public WorldObject( double x, double y, double width, double height){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.initGraphic();
	}
	
	/**
	 * Constructor for crate an object with position, dimension and a vector for motion.
	 * By default it create a rectangle as graphic.
	 * @param x - position on the x-axis.
	 * @param y - position on the y-axis.
	 * @param height - the width of the object.
	 * @param width - the height of the object.
	 * @param vector - the vector for motion.
	 */
	public WorldObject( double x, double y, double height, double width, Vector2D vector ){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.vector = vector;
		this.initGraphic();
	}
	
	/**
	 * The method for the motion with a vector.
	 */
	public void move(){
		this.x = this.x + this.vector.getX();
		this.y = this.y + this.vector.getY();
		
	}
	
	/**
	 * Add an vector for collision or gravity.
	 * @param vector - vector the will added to the existing vector.
	 */
	public void addVector( Vector2D vector ){
		this.vector.add( vector );
	}
	
	/**
	 * Set the visibility of the object. If it <strong>false</strong>
	 * it will not logrer drawt to the game panel.
	 * @see gui.GamePanel
	 * @param visible
	 */
	public void setVisible( boolean visible ){
		this.visible = visible;
	}
	
	/**
	 * Set the position on the x-axis.
	 * @param x - The position on the x-axis.
	 */
	public void setX( double x ){
		this.x = x;
	}
	
	/**
	 * Set the position on the y-axis.
	 * @param y - The new position on the y-axis.
	 */
	public void setY( double y ){
		this.y = y;
	}
	
	/**
	 * Set the width of the object.
	 * @param width - New width of the object.
	 */
	public void setWidth( double width ){
		this.width = width;
	}
	
	/**
	 * Set the height of the object.
	 * @param height - New height of the object.
	 */
	public void setHeight( double height ){
		this.height = height;
	}
	
	/**
	 * Set the density of the object.
	 * @param density - New density.
	 */
	public void setDensity( double density ){
		this.density = density;
	}
	
	/**
	 * Set the mass of object it will also change the density.
	 * @param mass - New mass.
	 */
	public void setMass( double mass ){
		this.setDensity( mass / ( this.getWidth() * this.getHeight() ) );
	}
	
	/**
	 * Set a new vector to the object.
	 * @param vector - New vector.
	 */
	public void setVector2D( Vector2D vector ){
		this.vector = vector;
	}
	
	/**
	 * Set a new graphic to the object.
	 * @param graphic - New graphic.
	 */
	public void setGraphic( GameGraphic graphic ){
		this.graphic = graphic;
	}
	
	/**
	 * Return the visibility status of the object.
	 * @return The visibility status.
	 */
	public boolean isVisible(){
		return this.visible;
	}
	
	/**
	 * Return the position on the x-axis.
	 * @return The position on the x-axis.
	 */
	public double getX(){
		return this.x;
	}
	
	/**
	 * Return the center position on the x-axis.
	 * @return The center position on the x-axis.
	 */
	public double getCenterX(){
		return this.getX() + ( this.getWidth() / 2 );
	}
	
	/**
	 * Return the position on the y-axis.
	 * @return The position on the y-axis.
	 */
	public double getY(){
		return this.y + ( this.getHeight() /2 );
	}
	
	/**
	 * Return the center position on the y-axis.
	 * @return The center position on the y-axis.
	 */
	public double getCenterY(){
		return this.getY() / 2;
	}
	
	/**
	 * Return the width of the object.
	 * @return The width of the object.
	 */
	public double getWidth(){
		return this.width;
	}
	
	/**
	 * Return the height of the object.
	 * @return The height of the object.
	 */
	public double getHeight(){
		return this.height;
	}
	
	/**
	 * Return the density of the object.
	 * @return the density of the object.
	 */
	public double getDensity(){
		return this.density;
	}
	
	/**
	 * Return the mass of the object.
	 * @return the mass of the object.
	 */
	public double getMass(){
		return this.getDensity() * this.getWidth() * this.getHeight();
	}
	
	/**
	 * Return the current vector from the object.
	 * @return
	 */
	public Vector2D getVector2D(){
		return this.vector;
	}
	
	/**
	 * Return the graphic from the object.
	 * @return the graphic of the object.
	 */
	public GameGraphic getGameGraphic(){
		return this.graphic;
	}
	
	/**
	 * Return the radius of the object.
	 * @return
	 */
	public double getRadius(){
		return ( this.getWidth() + this.getHeight() ) / 2;
	}
	
	/**
	 * Method for paint on the GamePanel.
	 * @see objects.World
	 * @see gui.GamePanel
	 * @param g - Graphics form the GamePanel.
	 */
	public void paint(Graphics g){
		if( visible ){
			this.graphic.paint(
					g,
					( int ) this.getX(),
					( int ) this.getY()
			);
		}
	}
	
	/**
	 * Method to initialize the background color.
	 */
	private void initGraphic(){
		this.graphic = new GameGraphicRectangle( 
				0,
				0,
				width,
				height
		);
		this.graphic.setBackgroundColor(
				new Color( 255, 255, 255 )
		);
	}
}
