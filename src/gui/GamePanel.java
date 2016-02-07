package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import graphics.GameGraphic;
import graphics.GameGraphicRectangle;
import objects.World;

public class GamePanel extends JPanel {
	
	private World world;
	private GameGraphic clearRectangle;
	
	public GamePanel( int width, int height, World world ){
		this.world = world;
		this.world.addGamePanel( this );
		this.world.start();
		this.setSize( width, height );
		this.clearRectangle = new GameGraphicRectangle( 0, 0,width, height );
	}
	
	@Override
	public void paintComponent( Graphics g ){
		this.clearRectangle.paint(g);
		this.world.paint(g);
	}

}
