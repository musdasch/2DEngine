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
 * @author Tim Vögtli
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
	
	public WorldObject( double x, double y, double width, double height){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.initGraphic();
	}
	
	public WorldObject( double x, double y, double height, double width, Vector2D vector ){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.vector = vector;
		this.initGraphic();
	}
	
	public void move(){
		this.x = this.x + this.vector.getX();
		this.y = this.y + this.vector.getY();
		
	}
	
	public void addVector( Vector2D vector ){
		this.vector.add( vector );
	}
	
	public void setVisible( boolean visible ){
		this.visible = visible;
	}
	
	public void setX( double x ){
		this.x = x;
	}
	
	public void setY( double y ){
		this.y = y;
	}
	
	public void setWidth( double width ){
		this.width = width;
	}
	
	public void setHeight( double height ){
		this.height = height;
	}
	
	public void setDensity( double density ){
		this.density = density;
	}
	
	public void setMass( double mass ){
		this.setDensity(mass / ( this.getWidth() * this.getHeight() ) ); 
	}
	
	public void setVector2D( Vector2D vector ){
		this.vector = vector;
	}
	
	public void setGraphic( GameGraphic graphic ){
		this.graphic = graphic;
	}
	
	public boolean isVisible(){
		return this.visible;
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getCenterX(){
		return this.getX() / 2;
	}
	
	public double getY(){
		return this.y;
	}
	
	public double getCenterY(){
		return this.getY() / 2;
	}
	
	public double getWidth(){
		return this.width;
	}
	
	public double getHeight(){
		return this.height;
	}
	
	public double getDensity(){
		return this.density;
	}
	
	public double getMass(){
		return this.getDensity() * this.getWidth() * this.getHeight();
	}
	
	public Vector2D getVector2D(){
		return this.vector;
	}
	
	public GameGraphic getGameGraphic(){
		return this.graphic;
	}
	
	public double getRadius(){
		return ( this.getWidth() / 2 + this.getHeight() / 2 ) / 2;
	}
	
	public void paint(Graphics g){
		if( visible ){
			this.graphic.paint(
					g,
					( int ) this.getX(),
					( int ) this.getY()
			);
		}
	}
	
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
