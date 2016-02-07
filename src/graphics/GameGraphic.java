package graphics;

import java.awt.Color;
import java.awt.Graphics;

public class GameGraphic {
	
	private int
		x = 0,
		y = 0,
		width = 0,
		height = 0;
	
	private boolean
		hasBorder = false;
	
	private Color backgroundColor = new Color( 0, 0, 0 );
	private Color borderColor = new Color( 0, 0, 0 );
	
	public GameGraphic(){};
	
	public GameGraphic( int x, int y ){
		this.x = x;
		this.y = y;
	}
	
	public GameGraphic( double x, double y ){
		this.x = ( int ) x;
		this.y = ( int ) y;
	}
	
	public GameGraphic( int x, int y, int width, int height ){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public GameGraphic( double x, double y, double width, double height ){
		this.x = ( int ) x;
		this.y = ( int ) y;
		this.width = ( int ) width;
		this.height = ( int ) height;
	}
	
	public void setHasBorder( boolean hasBorder ){
		this.hasBorder = hasBorder;
	}
	
	public void setX( int x ){
		this.x = x;
	}
	
	public void setY( int y ){
		this.y = y;
	}
	
	public void setWidth( int width ){
		this.width = width;
	}
	
	public void setHeight( int height ){
		this.height = height;
	}
	
	public void setBackgroundColor( Color backgroundColor ){
		this.backgroundColor = backgroundColor;
	}
	
	public void setBorderColor( Color borderColor ){
		this.borderColor = borderColor;
	}
	
	public boolean getHasBoder(){
		return this.hasBorder;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public Color getBackgroundColor(){
		return backgroundColor;
	}
	
	public Color getBorderColor(){
		return borderColor;
	}
	
	public void paint( Graphics g ){
		// TODO Paint
	}
	
	public void paint( Graphics g, int x, int y ){
		// TODO Paint
	}

}
