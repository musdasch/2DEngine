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

	public WorldObjectBall( double x, double y ) {
		super( x, y );
		// TODO Auto-generated constructor stub
	}
	
	public WorldObjectBall( double x, double y, double diameter ) {
		super( x, y, diameter, diameter );
		// TODO Auto-generated constructor stub
	}
	
	public WorldObjectBall( double x, double y, double diameter, Vector2D vector ) {
		
		super( x, y, diameter, diameter,  vector );
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getRadius(){
		return ( super.getWidth() + super.getHeight() ) / 4;
	}
	
	@Override
	public void setMass( double mass ){
		super.setDensity( mass / ( Math.pow( this.getRadius(), 2) * Math.PI ) );
	}
	
	@Override
	public double getMass(){
		return super.getDensity() * Math.pow( this.getRadius(), 2) * Math.PI;
	}
}
