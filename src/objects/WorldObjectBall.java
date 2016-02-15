package objects;

import java.awt.Color;
import java.awt.Graphics;

import physics.Vector2D;

/**
 * circle object.
 * @author Tim Vögtli
 * @version 0.1
 */
public class WorldObjectBall extends WorldObject {
	
	/**
	 * Constructor to create a circle shape WorldObject whit a position on the world.
	 * @param x - Position on the x-axis.
	 * @param y - Position on the y-axis.
	 */
	public WorldObjectBall( double x, double y ) {
		super( x, y );
	}
	
	/**
	 * Constructor to create a circle shape WorldObject whit a position and a dimension.
	 * @param x - Position on the x-axis.
	 * @param y - Position on the y-axis.
	 * @param diameter - The diameter of the WorldObject.
	 */
	public WorldObjectBall( double x, double y, double diameter ) {
		super( x, y, diameter, diameter );
	}
	
	/**
	 * Constructor  to create a circle shape WorldObject whit a position dimension and 
	 * a vector.
	 * @param x
	 * @param y
	 * @param diameter
	 * @param vector
	 */
	public WorldObjectBall( double x, double y, double diameter, Vector2D vector ) {
		super( x, y, diameter, diameter,  vector );
	}
	
	/**
	 * Override the get radius so it returns new the radius.
	 * @see objects.WorldObject
	 */
	@Override
	public double getRadius(){
		return ( super.getWidth() + super.getHeight() ) / 4;
	}
	
	/**
	 * Override the setMass for new calculation.
	 * @see objects.WorldObject
	 */
	@Override
	public void setMass( double mass ){
		super.setDensity( mass / ( Math.pow( this.getRadius(), 2) * Math.PI ) );
	}
	
	/**
	 * Override the getMass for new calculation.
	 * @see objects.WorldObject
	 */
	@Override
	public double getMass(){
		return super.getDensity() * Math.pow( this.getRadius(), 2) * Math.PI;
	}
}
