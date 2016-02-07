package graphics;

import java.awt.Graphics;

public class GameGraphicRectangle extends GameGraphic {

	public GameGraphicRectangle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GameGraphicRectangle(double x, double y, double width, double height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public GameGraphicRectangle(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public GameGraphicRectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public GameGraphicRectangle(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
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
