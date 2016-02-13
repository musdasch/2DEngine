package objects;

import java.awt.Color;
import java.awt.Graphics;

import physics.Vector2D;

public class WorldObjectBall extends WorldObject {

	public WorldObjectBall( double x, double y ) {
		super( x, y );
		// TODO Auto-generated constructor stub
	}
	
	public WorldObjectBall( double x, double y, double width, double height ) {
		super( x, y, width, height );
		// TODO Auto-generated constructor stub
	}
	
	public WorldObjectBall( double x, double y, double height, double width, Vector2D vector ) {
		super( x, y, width, height, vector );
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getRadius(){
		return super.getWidth() + super.getHeight() / 2;
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
