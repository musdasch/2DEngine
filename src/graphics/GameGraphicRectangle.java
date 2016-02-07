package graphics;

import java.awt.Graphics;

public class GameGraphicRectangle extends GameGraphic {

	public GameGraphicRectangle( int x, int y, int diameter ) {
		super(x, y);
		this.setWidth( diameter );
		this.setHeight( diameter );
	}

	public GameGraphicRectangle( double x, double y, double diameter ) {
		super(x, y);
		this.setWidth( ( int ) diameter );
		this.setHeight( ( int ) diameter );
	}
	
	public GameGraphicRectangle( int x, int y, int width, int height ) {
		super(x, y, width, height);
	}

	public GameGraphicRectangle( double x, double y, double width, double height ) {
		super(x, y, width, height );
	}
	
	
	@Override
	public void paint( Graphics g ){
		g.setColor( this.getBackgroundColor() );
        g.fillRect(
        		this.getX(),
        		this.getY(),
        		this.getWidth(),
        		this.getHeight()
        );
        g.setColor( this.getBorderColor() );
        g.drawRect(
        		this.getX(),
        		this.getY(),
        		this.getWidth(),
        		this.getHeight()
        );
	}
	
	@Override
	public void paint( Graphics g, int x, int y ){
		g.setColor( this.getBackgroundColor() );
        g.fillRect(
        		this.getX() + x,
        		this.getY() + y,
        		this.getWidth(),
        		this.getHeight()
        );
        g.setColor( this.getBorderColor() );
        g.drawRect(
        		this.getX() + x,
        		this.getY() + y,
        		this.getWidth(),
        		this.getHeight()
        );
	}
}
