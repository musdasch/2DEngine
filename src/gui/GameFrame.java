package gui;

import java.awt.Graphics;

import javax.swing.JFrame;

import listeners.GameWindowListener;
import objects.World;

/**
 * The GameFrame is a easy way to crate a window for the game.
 * @author Tim Vögtli
 * @version 0.1
 * @see GamePanel
 */
public class GameFrame extends JFrame {
	
	/**
	 * Holds the GamePanel for drawing the world.
	 */
	private GamePanel gamePanel;
	
	/**
	 * Constructor for the GameFrame.
	 * @param title - The title for the Frame.
	 * @param width - Frame width.
	 * @param height - Frame height.
	 * @param world - The game world
	 */
	public GameFrame( String title, int width, int height, World world ){
		gamePanel = new GamePanel( width, height, world );
		this.setTitle( title );
		this.setSize( width, height );
		this.addWindowListener( new GameWindowListener() );
		this.add( gamePanel );
		this.setVisible( true );
	}
}
