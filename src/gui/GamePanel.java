package gui;

import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.util.Objects;

import javax.swing.JPanel;

import graphics.GameGraphic;
import graphics.GameGraphicRectangle;
import objects.World;

/**
 * The GamePanel hold a World and display the world.
 * @author Tim Vögtli
 * @version 0.1
 * @see objects.World
 *
 */
public class GamePanel extends JPanel {
	
	/**
	 * The serialization runtime associates with each serializable
	 * class a version number
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Holds the world for drawing.
	 */
	private World world;
	
	/**
	 * It is the clear rectangle. with the color of the clearRectangle
	 * reset the Game
	 */
	private GameGraphic clearRectangle;
	
	/**
	 * The constructor of the GamePanel.
	 * @param width - The width of the GamePanel.
	 * @param height - The height of the GamePanel.
	 * @param world - The game World.
	 */
	public GamePanel( int width, int height, World world ){
		this.world = world;
		this.world.setGamePanel( this );
		this.world.start();
		this.setSize( width, height );
		this.clearRectangle = new GameGraphicRectangle( 0, 0,width, height );
	}
	
	/**
	 * Override paintComponent for reset the panel and draw the world new.
	 */
	@Override
	public void paintComponent( Graphics g ){
		this.clearRectangle.setWidth( this.getWidth() );
		this.clearRectangle.setHeight( this.getHeight() );
		this.clearRectangle.paint(g);
		this.world.paint(g);
	}
}
