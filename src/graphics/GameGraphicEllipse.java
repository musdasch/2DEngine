package graphics;

import java.awt.Graphics;

public class GameGraphicEllipse extends GameGraphic {
	
	public GameGraphicEllipse(double x, double y, double diameter) {
		super(x, y);
		this.setWidth( ( int ) diameter );
		this.setHeight( ( int ) diameter );
	}
	
	public GameGraphicEllipse(int x, int y, int diameter) {
		super(x, y);
		this.setWidth( diameter );
		this.setHeight( diameter );
	}
	
	@Override
	public void paint( Graphics g ){
		g.setColor( this.getBackgroundColor() );
		g.fillOval(
        		this.getX(),
        		this.getY(),
        		this.getWidth(),
        		this.getHeight()
        );
        g.setColor( this.getBorderColor() );
        g.drawOval(
        		this.getX(),
        		this.getY(),
        		this.getWidth(),
        		this.getHeight()
        );
	}
	
	@Override
	public void paint( Graphics g, int x, int y ){
		g.setColor( this.getBackgroundColor() );
        g.fillOval(
        		this.getX() + x,
        		this.getY() + y,
        		this.getWidth(),
        		this.getHeight()
        );
        g.setColor( this.getBorderColor() );
        g.drawOval(
        		this.getX() + x,
        		this.getY() + y,
        		this.getWidth(),
        		this.getHeight()
        );
	}

}
