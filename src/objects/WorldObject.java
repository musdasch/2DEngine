package objects;

import java.awt.Color;
import java.awt.Graphics;

import graphics.GameGraphic;
import graphics.GameGraphicRectangle;
import physics.Vector2D;

public class WorldObject {
	
	private double
		x = 0,
		y = 0,
		height = 0,
		width = 0;
	
	private boolean 
		isVisible = true;

	private Vector2D vector = new Vector2D( 0, 0 );
	
	private GameGraphic graphic;
	
	public WorldObject( double x, double y ){
		this.x = x;
		this.y = y;
		this.isVisible = false;
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
	
	public void setVector2D( Vector2D vector ){
		this.vector = vector;
	}
	
	public void setGraphic( GameGraphic graphic ){
		this.graphic = graphic;
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public double getWidth(){
		return this.width;
	}
	
	public double getHeight(){
		return this.height;
	}
	
	public Vector2D getVector2D(){
		return this.vector;
	}
	
	public GameGraphic getGameGraphic(){
		return this.graphic;
	}
	
	public void paint(Graphics g){
		if( isVisible ){
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
