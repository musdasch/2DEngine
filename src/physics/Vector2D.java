package physics;

public class Vector2D{

	private double
		x,
		y;
	
	public Vector2D( double x, double y ){
		this.x = x;
		this.y = y;
	}
	
	public void turn( double radians ){
		radians = radians + this.getRadians();
		double scalar = this.getScalar();
		this.x = scalar * Math.cos( radians );
		this.y = scalar * Math.sin( radians );
	}
	
	public void add( Vector2D vector ){
		this.x = this.x + vector.getX();
		this.y = this.y + vector.getY();
	}
	
	public void add( double alpha ){
		this.x = this.x + alpha;
		this.y = this.y + alpha;
	}
	
	public void add( float alpha ){
		this.x = this.x + ( double ) alpha;
		this.y = this.y + ( double ) alpha;
	}
	
	public void add( int alpha ){
		this.x = this.x + ( double ) alpha;
		this.y = this.y + ( double ) alpha;
	}
	
	public void times( Vector2D vector ){
		this.x = this.x * vector.getX();
		this.y = this.y * vector.getY();
	}
	
	public void times( double alpha ){
		this.x = this.x * alpha;
		this.y = this.y * alpha;
	}
	
	public void times( float alpha ){
		this.x = this.x * ( double ) alpha;
		this.y = this.y * ( double ) alpha;
	}
	
	public void times( int alpha ){
		this.x = this.x * ( double ) alpha;
		this.y = this.y * ( double ) alpha;
	}
	
	public void setX( double x ){
		this.x = x;
	}
	
	public void setY( double y ){
		this.y = y;
	}
	
	public double getScalar(){
		return Math.sqrt( Math.pow( this.x, 2 ) + Math.pow( this.y, 2) );
	}
	
	public double getRadians(){
		return Math.atan( this.y / this.x );
	}
	
	public double getDegrees(){
		return Math.toDegrees( this.getRadians() );
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
}
